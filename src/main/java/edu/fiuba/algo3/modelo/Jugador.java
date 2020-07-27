package edu.fiuba.algo3.modelo;

public class Jugador {
    private Puntaje puntaje;
    private String nombre;

    public Jugador(){
        puntaje = new Puntaje();
    }

    public Puntaje puntaje(){
        return puntaje;
    }
}
