package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Turno {
    static final int JUGADOR1 = 0;
    static final int JUGADOR2 = 1;
    private ArrayList<Jugador> jugadores;
    private int indiceJugadorActual;
    private boolean contestaronTodos;

    public Turno(ArrayList<Jugador> jugadores){
        this.jugadores = jugadores;
        this.contestaronTodos = false;
    }

    public boolean seCambiaJugador() {
        if (contestaronTodos) {
            this.contestaronTodos = false;
            this.indiceJugadorActual = JUGADOR1;
            return false;
        }
        this.contestaronTodos = true;
        indiceJugadorActual++;
        return true;
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

    public Jugador getJugadorConIndice(int indiceJugador) {
        return jugadores.get(indiceJugador);
    }
}
