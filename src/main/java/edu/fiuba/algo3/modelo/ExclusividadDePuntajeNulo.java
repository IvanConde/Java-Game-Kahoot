package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ExclusividadDePuntajeNulo implements ExclusividadDePuntaje{


    @Override
    public boolean verEstado() {
        return false;
    }

    @Override
    public void aplicarExclusividad(ArrayList<Respuesta> respuestas) {

    }

    @Override
    public int verMagnitud() {
        return 0;
    }
}
