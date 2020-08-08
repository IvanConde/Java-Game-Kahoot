package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Vista {
    Stage window;
    Controlador control;
    Scene sceneIngresoNombres, sceneJuego;
    public Vista(Stage stage, Controlador controlador){
        this.window = stage;
        this.control = controlador;
        stage.setTitle("Kahoot2.0");
    }
    public void inicialJuego(){
        Label textoInfo = new Label("Inserte nombre del primer jugador y presione ENTER");
        TextField textField = new TextField();
        control.agregarAccionEnter(textField, textoInfo);
        VBox layoutInicial = new VBox();
        layoutInicial.getChildren().add(textoInfo);
        layoutInicial.getChildren().add(textField);
        sceneIngresoNombres = new Scene(layoutInicial, 1280, 720); //640x480
        this.window.setScene(sceneIngresoNombres);
        this.window.show();
    }
    public void juego(){
            control.controlarPreguntas();
    }
    public void mostrarPregunta(Pregunta pregunta, String nombreJugador){
        Label nombreJugadorLabel = new Label("Responde " + nombreJugador);
        Label preguntaUsuario = new Label(pregunta.verPregunta());
        ArrayList<Opcion> opciones = pregunta.verBotones();
        VBox layoutJuego = new VBox();
        layoutJuego.getChildren().add(nombreJugadorLabel);
        layoutJuego.getChildren().add(preguntaUsuario);
        for(Opcion i : opciones){
            Button botonOpcion = new Button(i.getStringOpcion());
            control.agregarAccionBotonOpcion(botonOpcion, i.getStringOpcion());
            layoutJuego.getChildren().add(botonOpcion);
        }
        Button botonContestar = new Button("[Enviar respuesta]");
        control.argregarABotonDetenerTimer(botonContestar);
        layoutJuego.getChildren().add(botonContestar);
        sceneJuego = new Scene(layoutJuego, 640, 480);
        window.setScene(sceneJuego);
    }

    public void pantallaFinal(){
        Label gracias = new Label("gracias");
        VBox layoutJuego = new VBox();
        layoutJuego.getChildren().add(gracias);
        sceneJuego = new Scene(layoutJuego, 640, 480);
        window.setScene(sceneJuego);
    }
}

