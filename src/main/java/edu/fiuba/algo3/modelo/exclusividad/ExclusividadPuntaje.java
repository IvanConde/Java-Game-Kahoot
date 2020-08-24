package edu.fiuba.algo3.modelo.exclusividad;

import edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public class ExclusividadPuntaje implements Exclusividad {

    private int magnitud = 2;
    private Exclusividad concreto;

    public ExclusividadPuntaje(Exclusividad concreto){
        this.concreto= concreto;
    }


    @Override
    public boolean verEstado() {
        return true;
    }

    @Override
    public void aplicarExclusividad(ArrayList<Respuesta> respuestas) {
        Respuesta respuesta1 = respuestas.get(0);
        Respuesta respuesta2 = respuestas.get(1);
        if(respuesta1.puntajeTemporal() > respuesta2.puntajeTemporal()){
            respuesta1.modificarPuntaje(respuesta1.puntajeTemporal() * this.magnitud);
        }
        else if(respuesta1.puntajeTemporal() < respuesta2.puntajeTemporal()){
            respuesta2.modificarPuntaje(respuesta2.puntajeTemporal() * this.magnitud);
        }
        concreto.aplicarExclusividad(respuestas);
    }

    @Override
    public int verMagnitud() {
        return concreto.verMagnitud() * magnitud;
    }

    @Override
    public void aplicarPuntos(Respuesta respuesta, int puntos) {
        respuesta.agregarPuntajeTemporal(puntos);
    }
}
