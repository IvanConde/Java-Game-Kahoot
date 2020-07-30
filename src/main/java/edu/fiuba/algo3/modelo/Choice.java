package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class Choice extends Pregunta {
    protected String pregunta;
    Modalidad penalidad;
    public Choice(String pregun, ArrayList<Integer> correcta, Modalidad penalidad) {
        this.opcionesCorrectas = correcta;
        this.pregunta = pregun;
        this.penalidad = penalidad;
    }
    public ArrayList<Integer> verRespuestaCorrecta(){
        return opcionesCorrectas;
    }
    @Override
    public void comprobarRespuesta(Respuesta respuesta){
        penalidad.calcularPuntaje(respuesta, opcionesCorrectas);
    }

    /*
    @Override
    public void verPreguntayBotones() {
    }

     */
}