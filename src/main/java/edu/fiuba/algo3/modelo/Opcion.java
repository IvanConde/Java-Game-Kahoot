package edu.fiuba.algo3.modelo;

public class Opcion {
    private String stringOpcion;
    private boolean esCorrecto;
    private int posicionOriginal;
    private int posicionJugador;

    public Opcion(String stringOpcion, boolean esCorrecto){
        this.stringOpcion = stringOpcion;
    }

    public boolean getEsCorrecto() {
        return esCorrecto;
    }

    public String getStringOpcion() {
        return stringOpcion;
    }

    public boolean estaOrdenado(){
        return (posicionOriginal == posicionJugador);
    }

    public void setEsCorrecto(boolean esCorrecto) {
        this.esCorrecto = esCorrecto;
    }

    public void setPosicionOriginal(int posicionOriginal) {
        this.posicionOriginal = posicionOriginal;
    }

    public void setPosicionJugador(int posicionJugador) {
        this.posicionJugador = posicionJugador;
    }
    public int getposicionOriginal(){
        return posicionOriginal;
    }
}
