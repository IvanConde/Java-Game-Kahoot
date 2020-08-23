package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Turno {
    static final int JUGADOR1 = 0;
    static final int JUGADOR2 = 1;
    private ArrayList<Jugador> jugadores;
    private int indiceJugadorActual;
    private boolean cambiarPregunta;

    public Turno(ArrayList<Jugador> jugadores){
        this.jugadores = jugadores;
        this.cambiarPregunta = false;
    }

    public boolean finPregunta() {
        if (cambiarPregunta) {
            this.cambiarPregunta = false;
            this.indiceJugadorActual = JUGADOR1;
            return true;
        }
        this.cambiarPregunta = true;
        indiceJugadorActual++;
        return false;
    }

    public Jugador getJugadorActual(){
        return jugadores.get(this.indiceJugadorActual);
    }

    public boolean esJugador1(Jugador jugador){
        if(jugadores.lastIndexOf(jugador) == JUGADOR1){
            return true;
        }
        return false;
    }

    public Jugador getJugador(int indiceJugador) {
        return jugadores.get(indiceJugador);
    }
}
