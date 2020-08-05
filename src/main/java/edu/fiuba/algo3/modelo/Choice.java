package edu.fiuba.algo3.modelo;
import java.util.ArrayList;

public abstract class Choice extends Pregunta {


    protected Choice(String pregunta, ArrayList<Opcion> todasLasOpciones, Modalidad modalidad) {
        super(pregunta, todasLasOpciones, modalidad);
    }

    @Override
    public void comprobarRespuesta(Respuesta respuesta){
        modalidad.calcularPuntaje(respuesta);
    }

    /*
    @Override
    public void verPreguntayBotones() {
    }
     */

}