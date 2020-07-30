package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Penalidad extends Modalidad {
    private int modificadorCorrecto;
    private int modificadorIncorrecto;
    public Penalidad(){
        modificadorCorrecto = 1;
        modificadorIncorrecto = -1;
    }
    @Override
    public void calcularPuntaje(Respuesta respuesta, ArrayList<String> correctas){
        int puntos = 0;
        for (String i : respuesta.verRespuestaJugador()) {
            if (correctas.contains(i)) {
                puntos += modificadorCorrecto;
            } else {
                puntos += modificadorIncorrecto;
            }
        }
        respuesta.modificarPuntaje(puntos);
    }
}