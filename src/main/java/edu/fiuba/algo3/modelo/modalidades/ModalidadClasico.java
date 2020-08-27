package edu.fiuba.algo3.modelo.modalidades;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;

//Asigna un punto a cada jugador que acierte TODAS las opciones
//correctas.

public class ModalidadClasico extends Modalidad {
    static final int PUNTO = 1;

    public ModalidadClasico(){}

    @Override
    public void calcularPuntaje(Respuesta respuesta, Exclusividad exclusividad){
        int puntos;

        if(respuesta.opcionesIncorrectas() > 0){
            puntos = 0;
        } else {
            puntos = PUNTO;
        }
        exclusividad.aplicarPuntos(respuesta, puntos);
    }
}