package edu.fiuba.algo3.javafx;

import edu.fiuba.algo3.javafx.controladores.ToggleSwitch;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.ArrayList;

public class Partida {
    static final int JUGADOR1 = 0;
    static final int JUGADOR2 = 1;
    private Pregunta preguntaActual;
    private ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
    private ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
    private ArrayList<ToggleSwitch> respuestasJugadorGroup = new ArrayList<ToggleSwitch>();
    private ArrayList<Jugador> jugadores;
    private int indiceJugadorActual = 0;

    public Partida(ArrayList<Jugador> jugadores){
        this.jugadores = jugadores;
    }

    public boolean seContestoPregunta(){
        if(indiceJugadorActual == JUGADOR2){
            indiceJugadorActual = 0;
            return true;
        }
        return false;
    }

    public Jugador obtenerJugadorActual(){
        return jugadores.get(indiceJugadorActual);
    }

    public void contestar(Pregunta pregunta){
        //pregunta.agregarRespuesta(jugadorActual)
        //haces algo con el jugador
        Jugador jugadorActual = jugadores.get(indiceJugadorActual);
        indiceJugadorActual += 1;
    }

    public void responderPregunta(){}
}
