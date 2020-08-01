package edu.fiuba.algo3.modelo;

public class Jugador {
    private Puntaje puntaje;
    private String nombre;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntaje = new Puntaje();
    }
    public Puntaje puntaje(){
        return puntaje;
    }
}
