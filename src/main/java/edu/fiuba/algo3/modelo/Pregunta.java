package edu.fiuba.algo3.modelo;
import java.util.ArrayList;

public abstract class Pregunta {

    protected String pregunta;
    protected ArrayList<Opcion> todasLasOpciones;

    public Pregunta(String pregunta, ArrayList<Opcion> todasLasOpciones){
        this.todasLasOpciones = todasLasOpciones;
        this.pregunta = pregunta;
    }
    public void responderPregunta(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas)
            comprobarRespuesta(respuesta);
    }

    protected abstract void comprobarRespuesta(Respuesta respuesta);

    public String verPregunta(){
        return pregunta;
    }

    public ArrayList<Opcion> verBotones(){
        return todasLasOpciones;
    }

}