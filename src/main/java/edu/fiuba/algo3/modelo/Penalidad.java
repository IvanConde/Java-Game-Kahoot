package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Penalidad extends Modalidad {

    public Penalidad(){
        modificadorCorrecto = 1;
        modificadorIncorrecto = -1;
    }
    @Override
    public void calcularPuntaje(Respuesta respuesta, ArrayList<Integer> correctas){
        int puntos = 0;
        for (int i : respuesta.verRespuestaJugador()) {
            if (correctas.contains(i)) {
                puntos += modificadorCorrecto;
            } else {
                puntos += modificadorIncorrecto;
            }
        }
        respuesta.modificarPuntaje(puntos);
    }
}