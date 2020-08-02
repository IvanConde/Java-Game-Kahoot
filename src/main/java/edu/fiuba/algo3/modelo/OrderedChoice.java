package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class OrderedChoice extends Pregunta{
    private int modificadorPuntaje = 1;
    public OrderedChoice(String pregunta, ArrayList<Opcion> todas) {
        super(pregunta, todas);
    }

    @Override
    protected void comprobarRespuesta(Respuesta respuesta) {
        ArrayList<Opcion> respuestasJugador = respuesta.verRespuestaJugador();
        for (int orden = 0; orden <respuestasJugador.size(); orden++){
            if(orden != respuestasJugador.getPerteneceA()){
                return;
            }
        }
        respuesta.modificarPuntaje(modificadorPuntaje);
    }
}
