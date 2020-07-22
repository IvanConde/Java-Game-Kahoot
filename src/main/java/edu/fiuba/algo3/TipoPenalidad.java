package edu.fiuba.algo3;

import java.util.ArrayList;

class TipoPenalidad {
    int modificadorcorrecto;
    int modificadorincorrecto;
    public void calcularpuntaje(Respuesta respuesta, ArrayList<Integer> correctas){
        int puntos = 0;
        for (int i : respuesta.verRespuestaJugador()) {
            if (correctas.contains(i)) {
                puntos += modificadorcorrecto;
            } else {
                puntos += modificadorincorrecto;
            }
        }
        respuesta.modificarpuntaje(puntos);
    }
}

class Penalidad extends TipoPenalidad {
    public Penalidad(){
        modificadorcorrecto = 1;
        modificadorincorrecto = -1;
    }
}

class NoPenalidad extends TipoPenalidad {
    public NoPenalidad(){
        modificadorcorrecto = 1;
        modificadorincorrecto = 0;
    }
}
