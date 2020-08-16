package edu.fiuba.algo3.modelo;

public class Puntaje {

    private int puntaje;
    //private Multiplicador multiplicador;

    public Puntaje() {
        this.puntaje = 0;
    }

    public void modificarPuntaje(int puntos) {
            puntaje += puntos;
    }

    public int getPuntaje() {
        return puntaje;
    }

    /*public void setMultiplicador(Multiplicador multiplicador) {
        this.multiplicador = multiplicador;
    }*/
}
