package edu.fiuba.algo3.modelo.opciones;

import java.util.ArrayList;

public class OpcionGroup extends Opcion {

    private String grupoOriginal;
    private String grupoJugador;

    public OpcionGroup(String stringOpcion, String grupoOriginal){
        this.stringOpcion = stringOpcion;
        this.grupoOriginal = grupoOriginal;
    }

    public OpcionGroup(String stringOpcion, String grupoOriginal, String grupoJugador){
        this(stringOpcion, grupoOriginal);
        this.grupoJugador = grupoJugador;
    }

    public void elegirGrupo(String grupoJugador, ArrayList<Opcion> opcionesJugador) {
        opcionesJugador.add(new OpcionGroup(this.stringOpcion, this.grupoOriginal, grupoJugador));
    }

    @Override
    public boolean esCorrecto(){
        return (grupoJugador == grupoOriginal);
    }

    public String getGrupoOriginal() {
        return grupoOriginal;
    }

}