package edu.fiuba.algo3.modelo.preguntas;
import edu.fiuba.algo3.modelo.ExclusividadDePuntaje;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modalidades.ModalidadPenalidad;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.modalidades.Modalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;

import java.util.ArrayList;

public abstract class Pregunta {
    protected String pregunta;
    protected ArrayList<Opcion> todasLasOpciones;
    protected Modalidad modalidad;

    protected ExclusividadDePuntaje exclusividad;
    protected boolean exclusividadesActivada;

    protected Pregunta(String pregunta, ArrayList<Opcion> todasLasOpciones, Modalidad modalidad) {
        this.todasLasOpciones = todasLasOpciones;
        this.pregunta = pregunta;
        this.modalidad = modalidad;
        this.exclusividadesActivada = false;
        this.exclusividad = new ExclusividadDePuntaje();
    }

    public void responderPregunta(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas)
            comprobarRespuesta(respuesta);
        exclusividad.aplicarExclusividad(respuestas);
    }

    public boolean tienePenalidad(){
        if(modalidad instanceof ModalidadPenalidad){
            return true;
        }
        return false;
    }

    public void comprobarRespuesta(Respuesta respuesta){
        modalidad.calcularPuntaje(respuesta,exclusividad.verEstado());
    }

    public String verPregunta(){
        return pregunta;
    }

    public ArrayList<Opcion> verBotones(){
        return todasLasOpciones;
    }

    public void usarExclusividad(Jugador jugador){
        exclusividad.activarExclusividad(jugador);
    }
}