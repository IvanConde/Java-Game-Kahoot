package edu.fiuba.algo3.modelo;
import java.util.ArrayList;

public abstract class Pregunta {
    protected String pregunta;
    protected ArrayList<String> opcionesCorrectas;
    protected ArrayList<String> opcionesTodas;
    public Pregunta(String pregunta, ArrayList<String> todas, ArrayList<String> correcta){
        this.opcionesTodas = todas;
        this.opcionesCorrectas = correcta;
        this.pregunta = pregunta;
    }
    public void responderPregunta(ArrayList<Respuesta> respuestas) {
        for (Respuesta i : respuestas)
            comprobarRespuesta(i);
    }

    protected abstract void comprobarRespuesta(Respuesta respuesta);
    public String verPregunta(){ return pregunta;}
    public ArrayList<String> verBotones(){
        return opcionesTodas;
    }
}

