package edu.fiuba.algo3.javafx.vistas;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.controladores.AccionBotonOpcion;
import edu.fiuba.algo3.javafx.controladores.AccionBotonTerminarTurno;
import edu.fiuba.algo3.javafx.controladores.CicloPreguntas;
import edu.fiuba.algo3.javafx.controladores.Contestar;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class VistaJuego {
    Stage window;
    Scene sceneJuego;
    Panel panel;
    int contestateActual;
    public VistaJuego(Stage stage, Panel panel){
        this.window = stage;
        this.panel = panel;
        this.juego();
    }
    public int getContestateActual(){
        return contestateActual;
    }
    public void juego(){
        CicloPreguntas preguntas = new CicloPreguntas(panel, this);
    }
    public void construirPantallas(Pregunta pregunta, int cualJugador){
        if(pregunta.tienePenalidad()){
            mostrarMultiplicadores(pregunta, cualJugador);
        }else {
            mostrarPregunta(pregunta, cualJugador);
        }
    }
    public void mostrarPregunta(Pregunta pregunta, int cualJugador){
        contestateActual = cualJugador;
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), new AccionBotonTerminarTurno( this, pregunta, panel)));
        Label nombreJugadorLabel = new Label("Responde " + panel.nombreJugador(cualJugador) + ":");
        Label preguntaUsuario = new Label(pregunta.verPregunta());
        ArrayList<Opcion> opciones = pregunta.verBotones();
        VBox layoutJuego = new VBox();
        layoutJuego.getChildren().add(nombreJugadorLabel);
        layoutJuego.getChildren().add(preguntaUsuario);
        for(Opcion i : opciones){
            Button botonOpcion = new Button(i.getStringOpcion());
            botonOpcion.setOnAction(new AccionBotonOpcion(i, botonOpcion, panel));
            layoutJuego.getChildren().add(botonOpcion);
        }
        Button botonContestar = new Button("[Enviar respuesta]");
        botonContestar.setOnAction(new Contestar(timeline, this));
        layoutJuego.getChildren().add(botonContestar);
        sceneJuego = new Scene(layoutJuego, 1280, 720); //640x480
        window.setScene(sceneJuego);
        timeline.setCycleCount(1);
        timeline.play();
    }
    public void mostrarMultiplicadores(Pregunta pregunta, int cualJugador){
        Label nombreJugadorLabel = new Label(panel.nombreJugador(cualJugador) + "elige un multiplicador para esta pregunta");

    }

    public void pantallaFinal(){
        Label gracias = new Label("gracias");
        VBox layoutJuego = new VBox();
        layoutJuego.getChildren().add(gracias);
        sceneJuego = new Scene(layoutJuego, 1280, 720);
        window.setScene(sceneJuego);
    }
}
