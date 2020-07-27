package edu.fiuba.algo3.modelo;

public class Puntaje {
    private int puntaje = 0;
    public void calcularPuntaje(int puntos){
        puntaje += puntos;
    }

    public int getPuntaje() {
        return puntaje;
    }
}
