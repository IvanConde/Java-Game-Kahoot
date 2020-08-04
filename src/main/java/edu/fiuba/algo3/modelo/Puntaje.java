package edu.fiuba.algo3.modelo;

public class Puntaje {

    private int puntaje;
    private int multiplicador;

    public Puntaje(){
        this.puntaje = 0;
        this.multiplicador = 1;
    }

    public void calcularPuntaje(int puntos){
        puntaje += (puntos * multiplicador);
        multiplicador = 1;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setMultiplicador(int multiplicador){
        this.multiplicador = multiplicador;
    }

}