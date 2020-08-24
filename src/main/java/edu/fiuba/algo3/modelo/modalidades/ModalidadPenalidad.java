package edu.fiuba.algo3.modelo.modalidades;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;

public class ModalidadPenalidad extends Modalidad {
    public ModalidadPenalidad(){}


    @Override
    public int calcularPuntaje(Respuesta respuesta){
         int[] opciones = respuesta.contarOpciones();
        int puntos = opciones[OPCIONESCORRECTAS] - opciones[OPCIONESINCORRECTAS];
        return puntos;
    }

    @Override
    public boolean esPenalidad() {
        return true;
    }

    @Override
    public void intentarAplicarExclusividad(Respuesta respuesta, Exclusividad exclusividad, int puntos) {
            respuesta.modificarPuntaje(puntos);
    }

}