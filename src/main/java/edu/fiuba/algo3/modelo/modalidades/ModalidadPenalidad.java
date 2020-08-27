package edu.fiuba.algo3.modelo.modalidades;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;

public class ModalidadPenalidad extends Modalidad {
    public ModalidadPenalidad(){}


    @Override
    public void calcularPuntaje(Respuesta respuesta, Exclusividad exclusividad){
        respuesta.contarOpciones();
        respuesta.modificarPuntaje(respuesta.opcionesCorrectas() -respuesta.opcionesIncorrectas());
    }

    @Override
    public boolean esPenalidad() {
        return true;
    }


}