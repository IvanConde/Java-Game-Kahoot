package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

//Asigna un punto a cada jugador que acierte TODAS las opciones
//correctas.
public class Clasico extends Modalidad {
    private int modificadorCorrecto;
    public Clasico(){
        modificadorCorrecto = 1;
    }
    @Override
    public void calcularPuntaje(Respuesta respuesta, ArrayList<String> correctas){
        if(respuesta.verRespuestaJugador().size() != correctas.size()){ return;}
        for (String i : respuesta.verRespuestaJugador()) {
            if (!(correctas.contains(i))) {
                return; //si hay una respuesta incorrecta no se asignan puntos.
            }
        }
        respuesta.modificarPuntaje(modificadorCorrecto); //se asigna 1 punto en el modo clasico cuando todas las respuestas son correctas.
    }
}
