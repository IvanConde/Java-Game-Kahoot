package edu.fiuba.algo3.modelo;

public class Jugador {

    private Puntaje puntaje;
    private String nombre;
    private Multiplicador multiplicadorX2;
    private Multiplicador multiplicadorX3;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntaje = new Puntaje();
        this.multiplicadorX2 = new Multiplicador(2);
        this.multiplicadorX3 = new Multiplicador(3);
    }

    public Puntaje puntaje(){
        return puntaje;
    }

    public void usarMultiplicadorX2(){
        puntaje.setMultiplicador(multiplicadorX2);
    }

    public void usarMultiplicadorX3(){
        puntaje.setMultiplicador(multiplicadorX3);
    }

}