package edu.fiuba.algo3.modelo;

public class OpcionChoice extends Opcion{

    private boolean esCorrecto;

    public OpcionChoice(String stringOpcion, boolean esCorrecto){
        this.stringOpcion = stringOpcion;
        this.esCorrecto = esCorrecto;
    }

    public boolean esCorrecto(){
        return esCorrecto;
    }

}