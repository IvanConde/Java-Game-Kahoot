package edu.fiuba.algo3;

import java.util.ArrayList;

public class VerdaderoFalso extends Pregunta {
    String pregunta;
    ArrayList<Integer> respuestasCorrectas;
    TipoPenalidad penalidad;
    public VerdaderoFalso(String pregun, ArrayList<Integer> correcta, TipoPenalidad pena) {
        respuestasCorrectas = correcta;
        pregunta = pregun;

    }
    @Override
    public void comprobarrespuesta(Respuesta respuesta){
        penalidad.calcularpuntaje(respuesta, respuestasCorrectas);
    }

    @Override
    public void verPreguntayBotones() {

    }
}
