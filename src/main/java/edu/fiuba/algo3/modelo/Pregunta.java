package edu.fiuba.algo3.modelo;
import java.util.ArrayList;

public abstract class Pregunta {
    public void Responderpregunta(ArrayList<Respuesta> respuestas) {
        for (Respuesta i : respuestas)
        comprobarrespuesta(i);
    }
    public abstract void verPreguntayBotones();
    public abstract void comprobarrespuesta(Respuesta respuesta);
}

