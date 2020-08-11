package edu.fiuba.algo3.modelo.modalidades;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.modalidades.Modalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;

//Asigna un punto a cada jugador por cada opción correcta que
//seleccione (aunque no seleccione todas las correctas), siempre y
//cuando no haya seleccionado ninguna de las opciones
//incorrectas.

public class ModalidadParcial extends Modalidad {

    private int modificadorCorrecto;

    public ModalidadParcial() {
        modificadorCorrecto = 1;
    }

    @Override
    public void calcularPuntaje(Respuesta respuesta, boolean tieneExclusividad){
        int puntos = 0;
        for (Opcion opcionElegida : respuesta.verRespuestaJugador()) {
            if (!opcionElegida.esCorrecto()){
                return; //cuando se encuentra una respuesta incorrecta no se agregan puntos.
            }
            puntos += modificadorCorrecto;
        }
        if(tieneExclusividad){
            respuesta.agregarPuntajeTemporal(puntos);
        }else{
            respuesta.modificarPuntaje(puntos);
        }
    }

}