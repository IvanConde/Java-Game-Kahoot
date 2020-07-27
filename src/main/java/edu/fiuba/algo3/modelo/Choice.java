package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class Choice extends Pregunta {
    protected String pregunta;
    ArrayList<Integer> respuestasCorrectas;
    Modalidad penalidad;
    public Choice(String pregun, ArrayList<Integer> correcta, Modalidad penalidad) {
        this.respuestasCorrectas = correcta;
        this.pregunta = pregun;
        this.penalidad = penalidad;
    }
    public ArrayList<Integer> verRespuestaCorrecta(){
        return respuestasCorrectas;
    }
    @Override
    public void comprobarRespuesta(Respuesta respuesta){
        penalidad.calcularPuntaje(respuesta, respuestasCorrectas);
    }

    /*
    @Override
    public void verPreguntayBotones() {
    }

     */
}