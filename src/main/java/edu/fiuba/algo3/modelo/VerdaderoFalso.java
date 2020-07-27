package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoFalso extends Choice {
    public VerdaderoFalso(String pregunta, ArrayList<Integer> correcta, Modalidad penalidad) throws VyFMasDeDosOpcionesException {
        super(pregunta, correcta, penalidad);
        if (correcta.size()>1) {
            throw new VyFMasDeDosOpcionesException("no es posible más de una opcion correcta en VerdaderoYFalso");
        }
    }
    /*
    public VerdaderoFalso(String pregunta, ArrayList<Integer> correcta, Modalidad penalidad) {
        this.respuestasCorrectas = correcta;
        this.pregunta = pregunta;
        this.penalidad = penalidad;
    }
    public ArrayList<Integer> verRespuestaCorrecta(){
        return respuestasCorrectas;
    }
    @Override
    public void comprobarrespuesta(Respuesta respuesta){
        penalidad.calcularPuntaje(respuesta, respuestasCorrectas);
    }

    @Override
    public void verPreguntayBotones() {
    }

 */
}
