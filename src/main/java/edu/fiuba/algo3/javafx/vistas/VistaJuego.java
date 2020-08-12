package edu.fiuba.algo3.javafx.vistas;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.controladores.*;
import edu.fiuba.algo3.modelo.opciones.Opcion;

import edu.fiuba.algo3.modelo.opciones.OpcionGroup;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.OrderedChoice;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
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
    private Stage window;
    private Scene sceneJuego;
    private Panel panel;
    int contestateActual;
    CicloPreguntas ciclo;
    public VistaJuego(Stage stage, Panel panel){
        this.window = stage;
        this.panel = panel;
        this.juego();
    }
    public int getContestateActual(){
        return contestateActual;
    }
    public void juego(){
        this.ciclo = new CicloPreguntas(panel, this);
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
        Button botonContestar = new Button("[Enviar respuesta]");
        if(pregunta instanceof VerdaderoFalso){
            this.settiarBotonesVerdaderoyFalso(layoutJuego, opciones, botonContestar, cualJugador);
        }else if(pregunta instanceof GroupChoice){
            settiarBotonesGroupChoice(layoutJuego, opciones, (GroupChoice)pregunta);
        } else {
            this.settiarBotonesMultiplesRespuestas(layoutJuego, opciones, cualJugador);
        }

        botonContestar.setOnAction(new Contestar(timeline, this));
        layoutJuego.getChildren().add(botonContestar);
        sceneJuego = new Scene(layoutJuego, 1280, 720); //640x480
        window.setScene(sceneJuego);
        timeline.setCycleCount(1);
        timeline.play();
    }
    public void settiarBotonesGroupChoice(VBox layoutJuego, ArrayList<Opcion> opciones, GroupChoice pregunta){
        for(Opcion i : opciones){
            if(!(i instanceof OpcionGroup)){
                //TODO: agregar excepcion
            }
            Label opcionTexto = new Label(i.getStringOpcion()+ ":");
            ArrayList<String> grupos = pregunta.devolverGrupos();
            ToggleSwitch botonOpcion = new ToggleSwitch((OpcionGroup) i, grupos.get(0), grupos.get(1));
            panel.agregarRespuestaJugadorGroup(botonOpcion);
            botonOpcion.setMaxWidth(300);
            layoutJuego.getChildren().add(opcionTexto);
            layoutJuego.getChildren().add(botonOpcion);
        }
    }
    public void settiarBotonesVerdaderoyFalso(VBox layoutJuego, ArrayList<Opcion> opciones, Button contestar, int cualJugador){
        Button verdadero = new Button("Verdadero");
        Button falso = new Button("Falso");
        verdadero.setOnAction(new AccionBotonOpcionVyF(opciones.get(1), verdadero, panel, cualJugador, contestar));
        falso.setOnAction(new AccionBotonOpcionVyF(opciones.get(0), falso, panel, cualJugador, contestar));
        layoutJuego.getChildren().add(verdadero);
        layoutJuego.getChildren().add(falso);
    }
    public void settiarBotonesMultiplesRespuestas(VBox layoutJuego, ArrayList<Opcion> opciones, int cualJugador){
        for(Opcion i : opciones){
            Button botonOpcion = new Button(i.getStringOpcion());
            botonOpcion.setOnAction(new AccionBotonOpcion(i, botonOpcion, panel, cualJugador));
            layoutJuego.getChildren().add(botonOpcion);
        }
    }
    public void mostrarMultiplicadores(Pregunta pregunta, int cualJugador){
        if(!panel.jugadorTieneMultiplicadorx2(cualJugador) && !panel.jugadorTieneMultiplicadorx3(cualJugador)){
            this.mostrarPregunta(pregunta,  cualJugador);
            return;
        }
        Label nombreJugadorLabel = new Label(panel.nombreJugador(cualJugador) + " elige un multiplicador para esta pregunta");
        Button ninguno = new Button("ninguno");
        ninguno.setOnAction(new AccionMultiplicadorNinguno(pregunta, cualJugador, this));
        Button multiplicadorX2 = new Button("multiplicar x2");
        multiplicadorX2.setOnAction(new AccionMultiplicadorX2(pregunta, cualJugador, this, panel));
        Button multiplicadorX3 = new Button("multiplicar x3");
        multiplicadorX3.setOnAction(new AccionMultiplicadorX3(pregunta, cualJugador, this, panel));
        if(!panel.jugadorTieneMultiplicadorx2(cualJugador)){
            multiplicadorX2.setDisable(true);
        }else if(!panel.jugadorTieneMultiplicadorx3(cualJugador)){
            multiplicadorX3.setDisable(true);
        }
        VBox layoutMultiplicador = new VBox();
        layoutMultiplicador.getChildren().add(nombreJugadorLabel);
        layoutMultiplicador.getChildren().add(multiplicadorX2);
        layoutMultiplicador.getChildren().add(multiplicadorX3);
        layoutMultiplicador.getChildren().add(ninguno);
        sceneJuego = new Scene(layoutMultiplicador, 640, 480); //640x480
        window.setScene(sceneJuego);

    }

    public void pantallaFinal(){
        Label gracias = new Label("gracias por jugar");
        Label puntajeJugador1 = new Label("puntos de " + panel.nombreJugador(1)+ ": " + panel.puntajeJugador(1));
        Label puntajeJugador2 = new Label("puntos de " + panel.nombreJugador(2)+ ": " + panel.puntajeJugador(2));
        Label ganador;
        if(panel.puntajeJugador(1)<panel.puntajeJugador(2)){
            ganador = new Label("Felicitaciones " + panel.nombreJugador(2) + "! Ganaste!");
        }else{
            ganador = new Label("Felicitaciones " + panel.nombreJugador(1) + "! Ganaste!");
        }
        VBox layoutJuego = new VBox();
        layoutJuego.getChildren().add(gracias);
        layoutJuego.getChildren().add(puntajeJugador1);
        layoutJuego.getChildren().add(puntajeJugador2);
        layoutJuego.getChildren().add(ganador);
        sceneJuego = new Scene(layoutJuego, 640, 480);
        window.setScene(sceneJuego);
    }
    public void proximaPregunta(){
        ciclo.correrPregunta();
    }
}
