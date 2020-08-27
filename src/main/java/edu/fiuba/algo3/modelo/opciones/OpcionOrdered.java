package edu.fiuba.algo3.modelo.opciones;
import java.util.ArrayList;

public class OpcionOrdered extends Opcion {

    private int posicionOriginal;
    private int posicionJugador;

    public OpcionOrdered(String stringOpcion, int posicionOriginal){
        this.stringOpcion = stringOpcion;
        this.posicionOriginal = posicionOriginal;
    }

    public OpcionOrdered(String stringOpcion, int posicionOriginal, int posicionJugador){
        this(stringOpcion, posicionOriginal);
        this.posicionJugador = posicionJugador;
    }

    public void elegirPosicion(int posicionJugador, ArrayList<Opcion> opcionesJugador) {
        opcionesJugador.add(new OpcionOrdered(this.stringOpcion, this.posicionOriginal, posicionJugador));
    }

    @Override
    public boolean esCorrecto(){
        return (posicionOriginal == posicionJugador);
    }

    public int getPosicionOriginal(){
        return posicionOriginal;
    }

}