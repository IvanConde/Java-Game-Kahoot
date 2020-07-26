package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PuntajeParcial extends TipoPenalidad {
    int modificadorCorrecto;
    public PuntajeParcial(){
        modificadorCorrecto = 1;
    }
    @Override
    public void calcularpuntaje(Respuesta respuesta, ArrayList<Integer> correctas) {
        int puntos = 0;
        for (int i : respuesta.verRespuestaJugador()) {
            if (correctas.contains(i)) {
                puntos += modificadorCorrecto;
            } else {
                return;
            }
        }
        respuesta.modificarpuntaje(puntos);
    }
}
