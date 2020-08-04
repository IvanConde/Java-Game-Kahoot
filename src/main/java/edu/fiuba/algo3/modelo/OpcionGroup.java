package edu.fiuba.algo3.modelo;

public class OpcionGroup extends Opcion {

    private int grupoOriginal;
    private int grupoJugador;

    public OpcionGroup(String stringOpcion, int grupoOriginal){
        this.stringOpcion = stringOpcion;
        this.grupoOriginal = grupoOriginal;
    }

    public OpcionGroup(String stringOpcion, int grupoOriginal, int grupoJugador){
        this(stringOpcion, grupoOriginal);
        this.grupoJugador = grupoJugador;
    }

    @Override
    public boolean esCorrecto(){
        return (grupoJugador == grupoOriginal);
    }

    public int getGrupoOriginal() {
        return grupoOriginal;
    }

}