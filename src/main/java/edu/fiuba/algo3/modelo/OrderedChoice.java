package edu.fiuba.algo3.modelo;
import java.util.ArrayList;

public class OrderedChoice extends Pregunta{

    private int modificadorPuntajeExito = 1;
    private int modificadorPuntajeFracaso = 0;

    public OrderedChoice(String pregunta, ArrayList<Opcion> todasLasOpciones,Modalidad modalidad) {
        super(pregunta, todasLasOpciones,modalidad);
        if(!(modalidad instanceof Clasico)){
            throw new OrderedChoiceModalidadInvalidaException("[Error]: la pregunta 'OrderedChoice' solo se puede crear con modalidad clasica");
        }
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