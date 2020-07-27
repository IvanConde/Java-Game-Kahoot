package edu.fiuba.algo3.modelo;
import java.util.ArrayList;

public abstract class Pregunta {
    protected String pregunta;
    protected ArrayList<Integer> respuestasCorrectas;
    protected Modalidad penalidad;

    public void Responderpregunta(ArrayList<Respuesta> respuestas) {
        for (Respuesta i : respuestas)
            comprobarRespuesta(i);
    }

    protected abstract void comprobarRespuesta(Respuesta respuesta);

    //public abstract void verPreguntayBotones();
}

