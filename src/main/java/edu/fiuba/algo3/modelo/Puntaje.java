package edu.fiuba.algo3.modelo;

public class Puntaje {

    private int valor;

    public Puntaje() {
        this.valor = 0;
    }

    public int getValor() {
        return this.valor;
    }

    public void modificar(int modificador) {
        this.valor += modificador;
    }

}
