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
        if(opciones[OPCIONESINCORRECTAS] > 0){
            return 0;
        }
        return PUNTO;
    }

    @Override
    public boolean esPenalidad() {
        return false;
    }
}