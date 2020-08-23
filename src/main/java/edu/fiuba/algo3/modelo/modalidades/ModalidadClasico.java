package edu.fiuba.algo3.modelo.modalidades;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;

//Asigna un punto a cada jugador que acierte TODAS las opciones
//correctas.

public class ModalidadClasico extends Modalidad {
    static final int PUNTO = 1;

    public ModalidadClasico(){}

    @Override
    public void calcularPuntaje(Respuesta respuesta, boolean tieneExclusividad){
        respuesta.contarOpciones();
        if(respuesta.opcionesIncorrectas() > 0){
            return;
        }
        this.intentarAplicarExclusividad(respuesta, tieneExclusividad, PUNTO);
    }

    @Override
    public boolean esPenalidad() {
        return false;
    }
}