package edu.fiuba.algo3.modelo.modalidades;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;

//Asigna un punto a cada jugador que acierte TODAS las opciones
//correctas.

public class ModalidadClasico extends Modalidad {

    private int modificadorCorrecto;

    public ModalidadClasico(){
        modificadorCorrecto = 1;
    }

    @Override
    public void calcularPuntaje(Respuesta respuesta, boolean tieneExclusividad){
        for (Opcion opcionElegida : respuesta.verRespuestaJugador()) {
            if (!(opcionElegida.esCorrecto())) {
                return; //si hay una respuesta incorrecta no se asignan puntos.
            }
        }
        if(tieneExclusividad){
            respuesta.agregarPuntajeTemporal(modificadorCorrecto);
        }else{
            respuesta.modificarPuntaje(modificadorCorrecto); //se asigna 1 punto en el modo clasico cuando todas las respuestas son correctas.
        }
    }

    @Override
    public boolean esPenalidad() {
        return false;
    }

}