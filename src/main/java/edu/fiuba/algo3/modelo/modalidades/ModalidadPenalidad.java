package edu.fiuba.algo3.modelo.modalidades;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;

public class ModalidadPenalidad extends Modalidad {
    public ModalidadPenalidad(){}

    @Override
    public void calcularPuntaje(Respuesta respuesta, boolean tieneExclusividad){
        respuesta.contarOpciones();
        int puntos = respuesta.opcionesCorrectas() + respuesta.opcionesIncorrectas();
        this.intentarAplicarExclusividad(respuesta, tieneExclusividad, puntos);
    }

    @Override
    public boolean esPenalidad() {
        return true;
    }

}