package edu.fiuba.algo3.modelo;

public abstract class Opcion {
    protected String stringOpcion;

    public String getStringOpcion() {
        return stringOpcion;
    }

    public abstract boolean chequearOpcion();

}
