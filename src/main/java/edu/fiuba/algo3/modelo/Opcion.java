package edu.fiuba.algo3.modelo;

public class Opcion {
    private String stringOpcion;
    private boolean esCorrecto;
    private int ordenOriginal;
    private int ordenJugador;

    private boolean perteneceGrupo1;
    private boolean perteneceGrupo2;

    public Opcion(String stringOpcion, boolean esCorrecto){
        this.esCorrecto = esCorrecto;
        this.stringOpcion = stringOpcion;
    }

    public boolean getEsCorrecto() {
        return esCorrecto;
    }

    public String getStringOpcion() {
        return stringOpcion;
    }
}
