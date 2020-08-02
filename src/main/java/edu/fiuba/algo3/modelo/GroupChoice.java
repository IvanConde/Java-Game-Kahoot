package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class GroupChoice extends Pregunta{
    private int modificadorPuntaje = 1;
    public GroupChoice(String pregunta, ArrayList<Opcion> todas) {
        super(pregunta, todas);
    }

    @Override
    protected void comprobarRespuesta(Respuesta respuesta) {
        ArrayList<Opcion> respuestasJugador = respuesta.verRespuestaJugador();
        for (Opcion opcion : respuestasJugador){
            if(opcion.getRespondio() != respuestasJugador.getPerteneceA()){
                return;
            }
        }
        respuesta.modificarPuntaje(modificadorPuntaje);
    }
}
