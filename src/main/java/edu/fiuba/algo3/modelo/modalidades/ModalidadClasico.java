package edu.fiuba.algo3.modelo.modalidades;
import edu.fiuba.algo3.modelo.Respuesta;

//Asigna un punto a cada jugador que acierte TODAS las opciones
//correctas.

public class ModalidadClasico extends Modalidad {
    static final int PUNTO = 1;

    public ModalidadClasico(){}

    @Override
    public int calcularPuntaje(Respuesta respuesta){
        int[] opciones = respuesta.contarOpciones();
        int puntos;

        if(opciones[OPCIONESINCORRECTAS] > 0){
            puntos = 0;
        } else {
            puntos = PUNTO;
        }
        return puntos;
    }
}