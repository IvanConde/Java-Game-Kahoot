package edu.fiuba.algo3.modelo.modalidades;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;

//Asigna un punto a cada jugador por cada opción correcta que
//seleccione (aunque no seleccione todas las correctas), siempre y
//cuando no haya seleccionado ninguna de las opciones
//incorrectas.

public class ModalidadParcial extends Modalidad {
    public ModalidadParcial() {}

    @Override
    public void calcularPuntaje(Respuesta respuesta, boolean tieneExclusividad){
        respuesta.contarOpciones();
        if(respuesta.opcionesIncorrectas() > 0){
            return;
        }
        int puntos = respuesta.opcionesCorrectas();
        this.intentarAplicarExclusividad(respuesta, tieneExclusividad, puntos);
    }

    @Override
    public boolean esPenalidad() {
        return false;
    }

}