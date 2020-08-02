package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class Choice extends Pregunta {
    protected Modalidad penalidad;
    protected Choice(String pregunta,  ArrayList<Opcion> todas, Modalidad penalidad) {
        super(pregunta, todas);
        this.penalidad = penalidad;
    }

    @Override
    public void comprobarRespuesta(Respuesta respuesta){
        penalidad.calcularPuntaje(respuesta);
    }

    /*
    @Override
    public void verPreguntayBotones() {
    }

     */
}