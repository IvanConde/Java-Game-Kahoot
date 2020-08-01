package edu.fiuba.algo3.modelo;
import java.util.ArrayList;

public abstract class Pregunta {
    protected String pregunta;
    protected ArrayList<Opcion> opcionesTodas;
    public Pregunta(String pregunta, ArrayList<Opcion> todas){
        this.opcionesTodas = todas;
        this.pregunta = pregunta;
    }
    public void responderPregunta(ArrayList<Respuesta> respuestas) {
        for (Respuesta i : respuestas)
            comprobarRespuesta(i);
    }

    protected abstract void comprobarRespuesta(Respuesta respuesta);
    public String verPregunta(){ return pregunta;}

    public ArrayList<Opcion> verBotones(){
        return opcionesTodas;
    }


}

