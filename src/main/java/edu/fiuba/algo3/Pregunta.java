package edu.fiuba.algo3;
import java.util.ArrayList;
import java.lang.String;
public abstract class Pregunta {
    public void Responderpregunta(ArrayList<Respuesta> respuestas) {
        for (Respuesta i : respuestas)
        comprobarrespuesta(i);
    }
    public abstract void verPreguntayBotones();
    public abstract void comprobarrespuesta(Respuesta respuesta);
}

