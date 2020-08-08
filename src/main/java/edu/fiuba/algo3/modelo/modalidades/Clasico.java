package edu.fiuba.algo3.modelo.modalidades;

//Asigna un punto a cada jugador que acierte TODAS las opciones
//correctas.

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;

public class Clasico extends Modalidad {

    private int modificadorCorrecto;

    public Clasico(){
        modificadorCorrecto = 1;
    }

    @Override
    public void calcularPuntaje(Respuesta respuesta){
        for (Opcion opcionElegida : respuesta.verRespuestaJugador()) {
            if (!(opcionElegida.esCorrecto())) {
                return; //si hay una respuesta incorrecta no se asignan puntos.
            }
        }
        respuesta.modificarPuntaje(modificadorCorrecto); //se asigna 1 punto en el modo clasico cuando todas las respuestas son correctas.
    }

}