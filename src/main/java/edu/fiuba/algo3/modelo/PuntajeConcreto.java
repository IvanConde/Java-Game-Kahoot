package edu.fiuba.algo3.modelo;

public class PuntajeConcreto implements Puntaje{

    private int puntaje;
    private Multiplicador multiplicador;

    public PuntajeConcreto() {
        this.puntaje = 0;
    }

    public void calcularPuntaje(int puntos) {
            puntaje += puntos;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setMultiplicador(Multiplicador multiplicador) {
        this.multiplicador = multiplicador;
    }
}
