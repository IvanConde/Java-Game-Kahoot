package edu.fiuba.algo3.javafx.vistas;
import edu.fiuba.algo3.javafx.datos.CrearPreguntas;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

import javafx.scene.layout.BackgroundFill;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class VistaJuego {
    static final int CANTIDADPREGUNTAS = 10;
    private int cantidadPreguntas = 10;
    private Stage window;
    private ArrayList<Jugador> jugadores;
    private VistaPregunta vistaPregunta;
    private Partida partida;

    public VistaJuego(Stage stage, ArrayList<Jugador> jugadores){
        this.window = stage;
        this.jugadores = jugadores;
        this.partida = new Partida(jugadores);
        this.vistaPregunta = new VistaPregunta(stage, partida, this);
    }

    public void mostrar(){
        CrearPreguntas crearPreguntas = new CrearPreguntas();
        LinkedList preguntas = crearPreguntas.parsear();
        Collections.shuffle(preguntas);
            if(cantidadPreguntas > 0) {
                vistaPregunta.construirPantallas((Pregunta) preguntas.remove(0));
                cantidadPreguntas--;
            }else{
                this.mostrarPantallaFinal();
        }
    }

    public void mostrarPantallaFinal(){
        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);
        Label gracias = new Label("¡Gracias por jugar!");
        Label puntajeJugador1 = new Label("Puntos de " + jugador1.verNombre() + ": " + jugador1.puntaje().getPuntaje());
        Label puntajeJugador2 = new Label("Puntos de " + jugador2.verNombre() + ": " + jugador2.puntaje().getPuntaje());
        gracias.setFont(new Font("Arial", 24));
        puntajeJugador1.setFont(new Font("Arial", 16));
        puntajeJugador2.setFont(new Font("Arial", 16));
        Label ganador;
        if(jugador1.puntaje().getPuntaje() > jugador2.puntaje().getPuntaje()){
            ganador = new Label("Felicitaciones " + jugador1.verNombre() + "! Ganaste!");
        }else if(jugador1.puntaje().getPuntaje() == jugador2.puntaje().getPuntaje()){
            ganador = new Label("¡Los dos jugadores empataron con " + jugador1.puntaje().getPuntaje() + " puntos!");
        }else{
            ganador = new Label("Felicitaciones " + jugador2.verNombre() + "! Ganaste!");
        }
        ganador.setFont(new Font("Arial", 16));
        VBox layoutJuego = new VBox();
        layoutJuego.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        layoutJuego.setAlignment(Pos.CENTER);
        layoutJuego.setSpacing(10);
        layoutJuego.getChildren().add(gracias);
        layoutJuego.getChildren().add(puntajeJugador1);
        layoutJuego.getChildren().add(puntajeJugador2);
        layoutJuego.getChildren().add(ganador);
        window.getScene().setRoot(layoutJuego);
        window.sizeToScene();
        window.show();
    }

}