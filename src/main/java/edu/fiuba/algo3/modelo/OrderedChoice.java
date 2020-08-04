package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class OrderedChoice extends Pregunta{
    private int modificadorPuntajeExito = 1;
    private int modificadorPuntajeFracaso = 0;
    public OrderedChoice(String pregunta, ArrayList<Opcion> todasLasOpciones) {
        super(pregunta, todasLasOpciones);
    }

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
}
