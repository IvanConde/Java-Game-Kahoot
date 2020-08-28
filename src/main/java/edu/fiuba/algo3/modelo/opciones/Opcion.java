package edu.fiuba.algo3.modelo.opciones;

public abstract class Opcion {

    protected String stringOpcion;

    public String getStringOpcion() {
        return stringOpcion;
    }

    public abstract boolean esCorrecto();

}