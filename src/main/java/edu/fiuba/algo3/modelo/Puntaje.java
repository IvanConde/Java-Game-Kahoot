package edu.fiuba.algo3.modelo;

public class Puntaje {
    int puntaje = 0;
    public void calcularpuntaje(int puntos){
        puntaje += puntos;
    }

    public int getPuntaje() {
        return puntaje;
    }
}
