package edu.fiuba.algo3.modelo.preguntas;
import edu.fiuba.algo3.modelo.modalidades.Clasico;
import edu.fiuba.algo3.modelo.modalidades.Modalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;

import java.util.ArrayList;

public class OrderedChoice extends Pregunta {

    private int modificadorPuntajeExito = 1;
    private int modificadorPuntajeFracaso = 0;

    public OrderedChoice(String pregunta, ArrayList<Opcion> todasLasOpciones, Modalidad modalidad) {
        super(pregunta, todasLasOpciones,new Clasico());
        //if(!(modalidad instanceof Clasico)){
        //    throw new OrderedChoiceModalidadInvalidaException("[Error]: la pregunta 'OrderedChoice' solo se puede crear con modalidad clasica");
        //}
    }
/*

    @Override
    protected void comprobarRespuesta(Respuesta respuesta) {
        for (Opcion opcionElegida : respuesta.verRespuestaJugador()) {
            if (!opcionElegida.esCorrecto()) {
                respuesta.modificarPuntaje(modificadorPuntajeFracaso);
                return;
            }
        }
        respuesta.modificarPuntaje(modificadorPuntajeExito);
    }
 */
}