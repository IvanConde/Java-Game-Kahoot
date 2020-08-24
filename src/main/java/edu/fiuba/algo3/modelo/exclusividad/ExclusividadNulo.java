package edu.fiuba.algo3.modelo.exclusividad;

import edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public class ExclusividadNulo implements Exclusividad {


    @Override
    public boolean verEstado() {
        return false;
    }

    @Override
    public void aplicarExclusividad(ArrayList<Respuesta> respuestas){}

    @Override
    public int verMagnitud() {
        return 0;
    }

    @Override
    public void aplicarPuntos(Respuesta respuesta, int puntos) {
        respuesta.modificarPuntaje(puntos);
    }
}
