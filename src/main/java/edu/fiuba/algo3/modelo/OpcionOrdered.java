package edu.fiuba.algo3.modelo;

public class OpcionOrdered extends Opcion {
    private int posicionOriginal;
    private int posicionJugador;

    public OpcionOrdered(String stringOpcion, int posicionOriginal){
        this.stringOpcion = stringOpcion;
        this.posicionOriginal = posicionOriginal;
    }

    public OpcionOrdered(String stringOpcion, int posicionOriginal, int posicionJugador){
        this(stringOpcion, posicionOriginal);
        this.posicionJugador = posicionJugador;
    }

    @Override
    public boolean esCorrecto(){
        return (posicionOriginal == posicionJugador);
    }

    public void setPosicionJugador(int posicionJugador) {
        this.posicionJugador = posicionJugador;
    }

    public int getPosicionOriginal(){
        return posicionOriginal;
    }

    public void elegirPosicion(int posicionJugador){
        this.posicionJugador = posicionJugador;
    }

}
