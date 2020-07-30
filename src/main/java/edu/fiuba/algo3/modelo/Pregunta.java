package edu.fiuba.algo3.modelo;
import java.util.ArrayList;

public abstract class Pregunta {
    protected String pregunta;
    protected ArrayList<Integer> opcionesCorrectas;

    public void responderPregunta(ArrayList<Respuesta> respuestas) {
        for (Respuesta i : respuestas)
            comprobarRespuesta(i);
    }

    protected abstract void comprobarRespuesta(Respuesta respuesta);
    public String verPregunta(){ return pregunta;}
    public ArrayList<String> verPreguntayBotones(){
        ArrayList<String> strings = new ArrayList<String>();
        return strings;
    }
}

