package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class NoPenalidad extends TipoPenalidad {
    @Override
    public void calcularpuntaje(Respuesta respuesta, ArrayList<Integer> correctas){
        int puntos = 1;
        for (int i : respuesta.verRespuestaJugador()) {
            if (!correctas.contains(i)) {
                return;
            }
        }
        respuesta.modificarpuntaje(puntos);
    }
}
