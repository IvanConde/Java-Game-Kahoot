package edu.fiuba.algo3.modelo;

public class OpcionGroup extends Opcion {
    private int grupoOriginal;
    private int grupoJugador;

    public OpcionGroup(String stringOpcion, int grupoOriginal){
        this.stringOpcion = stringOpcion;
        this.grupoOriginal = grupoOriginal;
    }

    @Override
    public boolean esCorrecto(){
        return (grupoJugador == grupoOriginal);
    }

    public int getGrupoOriginal() {
        return grupoOriginal;
    }

    public void elegirGrupo(int grupoJugador){
        this.grupoJugador = grupoJugador;
    }

}
