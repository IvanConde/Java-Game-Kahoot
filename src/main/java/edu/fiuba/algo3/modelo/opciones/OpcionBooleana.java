package edu.fiuba.algo3.modelo.opciones;

public class OpcionBooleana extends Opcion{

    private boolean esCorrecto;

    public OpcionBooleana(String stringOpcion, boolean esCorrecto){
        this.stringOpcion = stringOpcion;
        this.esCorrecto = esCorrecto;
    }

    public boolean esCorrecto(){
        return esCorrecto;
    }

}