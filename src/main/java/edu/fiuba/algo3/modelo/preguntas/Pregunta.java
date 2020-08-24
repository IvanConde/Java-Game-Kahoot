package edu.fiuba.algo3.modelo.preguntas;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.exclusividad.ExclusividadPuntaje;
import edu.fiuba.algo3.modelo.exclusividad.ExclusividadNulo;
import edu.fiuba.algo3.modelo.modalidades.Modalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import java.util.ArrayList;

public abstract class Pregunta {

    protected String pregunta;
    protected ArrayList<Opcion> todasLasOpciones;
    protected Modalidad modalidad;
    protected Exclusividad exclusividad;

    protected Pregunta(String pregunta, ArrayList<Opcion> todasLasOpciones, Modalidad modalidad) {
        this.todasLasOpciones = todasLasOpciones;
        this.pregunta = pregunta;
        this.modalidad = modalidad;
        this.exclusividad = new ExclusividadNulo();
    }

    public void responderPregunta(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas)
            comprobarRespuesta(respuesta);
        exclusividad.aplicarExclusividad(respuestas);
    }

    public boolean tienePenalidad(){
        return modalidad.esPenalidad();
    }

    public void comprobarRespuesta(Respuesta respuesta){
        int puntos = modalidad.calcularPuntaje(respuesta);
        modalidad.intentarAplicarExclusividad(respuesta, exclusividad.verEstado(), puntos);
    }

    public String verPregunta(){
        return pregunta;
    }

    public ArrayList<Opcion> verBotones(){
        return todasLasOpciones;
    }

    public void usarExclusividad(Jugador jugador){
        jugador.activarExclusividad();
        this.exclusividad = new ExclusividadPuntaje(exclusividad);
    }

}