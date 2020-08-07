package edu.fiuba.algo3.modelo.opciones;

import java.util.ArrayList;

public class OpcionEstructurada extends Opcion {
    private int original;
    private int eleccionJugador;

    public OpcionEstructurada(String stringOpcion, int original){
        this.stringOpcion = stringOpcion;
        this.original = original;
    }

    public OpcionEstructurada(String stringOpcion, int original, int eleccionJugador){
        this(stringOpcion, original);
        this.eleccionJugador = eleccionJugador;
    }

    public void elegir(int eleccionJugador, ArrayList<Opcion> opcionesJugador) {
        opcionesJugador.add(new OpcionEstructurada(this.stringOpcion, this.original, eleccionJugador));
    }

    @Override
    public boolean esCorrecto(){
        return (eleccionJugador == original);
    }

    public int getOriginal() {
        return original;
    }

}
