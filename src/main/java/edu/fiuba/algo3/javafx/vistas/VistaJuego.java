package edu.fiuba.algo3.javafx.vistas;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.Partida;
import edu.fiuba.algo3.javafx.controladores.*;
import edu.fiuba.algo3.modelo.Jugador;
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
import java.util.LinkedList;

public class VistaJuego {
    private Stage window;
    private Scene sceneJuego;
    private ArrayList<Jugador> jugadores;
    private CicloPreguntas cicloPreguntas;
    private VistaPregunta vistaPregunta;
    private Partida partida;

    public VistaJuego(Stage stage, ArrayList<Jugador> jugadores){
        this.window = stage;
        this.jugadores = jugadores;
        this.partida = new Partida(jugadores);
        this.cicloPreguntas = new CicloPreguntas();
        this.vistaPregunta = new VistaPregunta(jugadores, stage, partida, this);
    }

    public void mostrar(){
        if(cicloPreguntas.getCantPreguntas() > 0) {
            cicloPreguntas.correrPregunta(vistaPregunta);
        }else{
            this.mostrarPantallaFinal();
        }
    }

    public void mostrarPantallaFinal(){
        System.out.println("Se construyo ventana final");
        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);
        Label gracias = new Label("¡Gracias por jugar!");
        Label puntajeJugador1 = new Label("puntos de " + jugador1.verNombre() + ": " + jugador1.puntaje().getPuntaje());
        Label puntajeJugador2 = new Label("puntos de " + jugador2.verNombre() + ": " + jugador2.puntaje().getPuntaje());
        Label ganador;
        if(jugador1.puntaje().getPuntaje() < jugador2.puntaje().getPuntaje()){
            ganador = new Label("Felicitaciones " + jugador1.verNombre() + "! Ganaste!");
        }else if(jugador1.puntaje().getPuntaje() == jugador2.puntaje().getPuntaje()){
            ganador = new Label("¡Los dos jugadores empataron con " + jugador1.puntaje().getPuntaje() + " puntos!");
        }else{
            ganador = new Label("Felicitaciones " + jugador2.verNombre() + "! Ganaste!");
        }

        VBox layoutJuego = new VBox();
        layoutJuego.getChildren().add(gracias);
        layoutJuego.getChildren().add(puntajeJugador1);
        layoutJuego.getChildren().add(puntajeJugador2);
        layoutJuego.getChildren().add(ganador);
        //sceneJuego = new Scene(layoutJuego, 640, 480);
        //window.setScene(sceneJuego);
        window.getScene().setRoot(layoutJuego);
        window.sizeToScene();
        window.show();
    }


    /*
    public void mostrarPregunta(Pregunta pregunta, int cualJugador){
        contestateActual = cualJugador;
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(30), new AccionBotonTerminarTurno( this, pregunta, panel)));
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
        sceneJuego = new Scene(layoutJuego, 640, 480); //640x480
        window.setScene(sceneJuego);
        timeline.setCycleCount(1);
        timeline.play();
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

    public void proximaPregunta(){
        ciclo.correrPregunta();
    }

     */
}
