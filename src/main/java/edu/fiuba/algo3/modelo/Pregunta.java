package edu.fiuba.algo3.modelo;
import java.util.ArrayList;

public abstract class Pregunta {

    protected String pregunta;
    protected ArrayList<Opcion> todasLasOpciones;
    protected Modalidad modalidad;

    /*
    public Pregunta(String pregunta, ArrayList<Opcion> todasLasOpciones){
        this.todasLasOpciones = todasLasOpciones;
        this.pregunta = pregunta;
    }
     */

    protected Pregunta(String pregunta, ArrayList<Opcion> todasLasOpciones, Modalidad modalidad) {
        this.todasLasOpciones = todasLasOpciones;
        this.pregunta = pregunta;
        this.modalidad = modalidad;
    }

    public void responderPregunta(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas)
            comprobarRespuesta(respuesta);
    }

    public boolean sePuedeUsarMultiplicador(){
        if(modalidad instanceof Penalidad){
            return true;
        }
        return false;
    }

    //protected abstract void comprobarRespuesta(Respuesta respuesta);

    public void comprobarRespuesta(Respuesta respuesta){
        modalidad.calcularPuntaje(respuesta);
    }
    public String verPregunta(){
        return pregunta;
    }

    public ArrayList<Opcion> verBotones(){
        return todasLasOpciones;
    }

}