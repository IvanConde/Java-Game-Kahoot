package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

//Asigna un punto a cada jugador por cada opción correcta que
//seleccione (aunque no seleccione todas las correctas), siempre y
//cuando no haya seleccionado ninguna de las opciones
//incorrectas.
public class Parcial extends Modalidad {
    private int modificadorCorrecto;
    public Parcial() {
        modificadorCorrecto = 1;
    }

    @Override
    public void calcularPuntaje(Respuesta respuesta, ArrayList<String> correctas) {
        int puntos = 0;
        for (String i : respuesta.verRespuestaJugador()) {
            if (!(correctas.contains(i))) {
                return; //cuando se encuentra una respuesta incorrecta no se agregan puntos.
            }
            puntos += modificadorCorrecto;
        }
        respuesta.modificarPuntaje(puntos);
    }
}
