package edu.fiuba.algo3.javafx.vistas;

import edu.fiuba.algo3.javafx.Partida;
import edu.fiuba.algo3.javafx.controladores.*;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class VistaJuego {
    private Stage window;
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
        if(jugador1.puntaje().getPuntaje() > jugador2.puntaje().getPuntaje()){
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
        window.getScene().setRoot(layoutJuego);
        window.sizeToScene();
        window.show();
    }
}
