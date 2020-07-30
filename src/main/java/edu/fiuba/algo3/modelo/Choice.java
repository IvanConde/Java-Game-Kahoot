package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class Choice extends Pregunta {
    Modalidad penalidad;
    public Choice(String pregunta,  ArrayList<String> todas, ArrayList<String> correcta, Modalidad penalidad) {
        super(pregunta, todas, correcta);
        this.penalidad = penalidad;
    }
    public ArrayList<String> verRespuestaCorrecta(){
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