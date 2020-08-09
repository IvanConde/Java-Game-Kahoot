package edu.fiuba.algo3.modelo.opciones;

public class OpcionChoice extends Opcion {

    private boolean esCorrecto;

    public OpcionChoice(String stringOpcion, boolean esCorrecto){
        this.stringOpcion = stringOpcion;
        this.esCorrecto = esCorrecto;
    }

    public boolean esCorrecto(){
        return esCorrecto;
    }

}