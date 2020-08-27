package edu.fiuba.algo3.modelo.modalidades;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;

//Asigna un punto a cada jugador por cada opción correcta que
//seleccione (aunque no seleccione todas las correctas), siempre y
//cuando no haya seleccionado ninguna de las opciones
//incorrectas.

public class ModalidadParcial extends Modalidad {
    public ModalidadParcial() {}

    @Override
    public void calcularPuntaje(Respuesta respuesta, Exclusividad exclusividad){
        respuesta.contarOpciones();
        int puntos;

        if(respuesta.opcionesIncorrectas() > 0){
            puntos = 0;
        } else {
            puntos = respuesta.opcionesCorrectas();
        }
        exclusividad.aplicarPuntos(respuesta, puntos);
    }
}