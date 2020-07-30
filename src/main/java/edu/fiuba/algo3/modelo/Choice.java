package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class Choice extends Pregunta {
    Modalidad penalidad;
    public Choice(String pregunta, ArrayList<Integer> correcta, Modalidad penalidad) {
        this.opcionesCorrectas = correcta;
        this.pregunta = pregunta;
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