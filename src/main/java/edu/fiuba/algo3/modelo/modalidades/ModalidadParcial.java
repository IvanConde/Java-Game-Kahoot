package edu.fiuba.algo3.modelo.modalidades;
import edu.fiuba.algo3.modelo.Respuesta;

//Asigna un punto a cada jugador por cada opción correcta que
//seleccione (aunque no seleccione todas las correctas), siempre y
//cuando no haya seleccionado ninguna de las opciones
//incorrectas.

public class ModalidadParcial extends Modalidad {
    public ModalidadParcial() {}

    @Override
    public int calcularPuntaje(Respuesta respuesta){
        int[] opciones = respuesta.contarOpciones();
        int puntos;

        if(opciones[OPCIONESINCORRECTAS] > 0){
            puntos = 0;
        } else {
            puntos = opciones[OPCIONESCORRECTAS];
        }

        return puntos;
    }
}