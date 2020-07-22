package edu.fiuba.algo3;
import java.util.ArrayList;
import java.lang.String;
abstract class Pregunta {
    public void Responderpregunta(ArrayList<Respuesta> respuestas) {
        for (Respuesta i : respuestas)
        comprobarrespuesta(i);
    }
    public abstract void verPreguntayBotones();
    public abstract void comprobarrespuesta(Respuesta respuesta);
}

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