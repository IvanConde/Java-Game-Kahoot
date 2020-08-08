package edu.fiuba.algo3.modelo.modalidades;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.modalidades.Modalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;

public class Penalidad extends Modalidad {

    private int modificadorCorrecto;
    private int modificadorIncorrecto;

    public Penalidad(){
        modificadorCorrecto = 1;
        modificadorIncorrecto = -1;
    }
    @Override
    public void calcularPuntaje(Respuesta respuesta){
        int puntos = 0;
        for (Opcion opcionElegida : respuesta.verRespuestaJugador()) {
            if (opcionElegida.esCorrecto()) {
                puntos += modificadorCorrecto;
            } else {
                puntos += modificadorIncorrecto;
            }
        }
        respuesta.modificarPuntaje(puntos);
    }

}