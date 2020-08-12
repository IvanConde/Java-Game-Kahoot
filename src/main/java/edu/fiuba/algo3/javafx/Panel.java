package edu.fiuba.algo3.javafx;


import edu.fiuba.algo3.javafx.controladores.ToggleSwitch;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionBooleana;
import edu.fiuba.algo3.modelo.opciones.OpcionGroup;
import edu.fiuba.algo3.modelo.opciones.OpcionOrdered;
import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.javafx.datos.CrearPreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Panel { // Panel es el modelo de un MVC
    Jugador jugador1;
    Jugador jugador2;
    Pregunta preguntaActual;
    ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
    ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
    ArrayList<ToggleSwitch> respuestasJugadorGroup = new ArrayList<ToggleSwitch>();
    LinkedList queue;
    public Panel(){
        CrearPreguntas pregunta = new CrearPreguntas();
         this.queue = pregunta.parsear();
    }

    public boolean juegoPuedeComenzar(){
        if(jugador2 != null){ return true;}
        return false;
    }
    public void agregarJugador(String nombre){
        if (this.jugador1 == null){
            this.jugador1 = new Jugador(nombre);
            return;
        }
        this.jugador2 = new Jugador(nombre);
    }

    public void agregarRespuestaJugador(Opcion opcion, int cualJugador){
        System.out.println(opcion.getStringOpcion());
        if(cualJugador == 1){
            agregarRespuesta(opcionesJugador1, opcion);
        }else{
            agregarRespuesta(opcionesJugador2, opcion);
        }
    }
    public void agregarRespuesta(ArrayList<Opcion> opcionesJugador, Opcion opcion){
        if(preguntaActual instanceof OrderedChoice){
            if(opcion instanceof OpcionOrdered){
                OpcionOrdered opcionEstructurada = (OpcionOrdered) opcion;
                opcionEstructurada.elegirPosicion(opcionesJugador.size() + 1, opcionesJugador);
            }else{
                //TODO: misma excepcion que con group
            }
        }else {
            opcionesJugador.add(opcion);
        }
    }
    public void responderPregunta(){
        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2, jugador2.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        preguntaActual.responderPregunta(respuestas);
        opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador2 = new ArrayList<Opcion>();
        System.out.println(jugador1.puntaje().getPuntaje());
        System.out.println(jugador2.puntaje().getPuntaje());
    }



    public Pregunta obtenerPreguntaAleatoria(){
        int tamaño = this.queue.size();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(tamaño);
        Pregunta pregunta = (Pregunta) this.queue.remove(randomInt);
        this.preguntaActual = pregunta;
        return pregunta;
    }
    public String nombreJugador(int cualJugador){
        if(cualJugador == 1){
            return jugador1.verNombre();
        }
        return jugador2.verNombre();
    }
    public Boolean jugadorTieneMultiplicadorx2(int cualJugador){
        if(cualJugador == 1){
            return jugador1.tieneMultiplicadorx2();
        }
        return jugador2.tieneMultiplicadorx2();
    }
    public Boolean jugadorTieneMultiplicadorx3(int cualJugador){
        if(cualJugador == 1){
            return jugador1.tieneMultiplicadorx3();
        }
        return jugador2.tieneMultiplicadorx3();
    }
    public void usarMultiplicadorJugadorX2(Pregunta pregunta, int cualJugador){
        if(cualJugador == 1){
            jugador1.usarMultiplicadorX2(pregunta);
        }else{
            jugador2.usarMultiplicadorX2(pregunta);
        }
    }
    public void usarMultiplicadorJugadorX3(Pregunta pregunta, int cualJugador){
        if(cualJugador == 1){
            jugador1.usarMultiplicadorX3(pregunta);
        }else{
            jugador2.usarMultiplicadorX3(pregunta);
        }
    }
    public int puntajeJugador(int cualJugador){
        if(cualJugador == 1){
            return jugador1.puntaje().getPuntaje();
        }
        return jugador2.puntaje().getPuntaje();
    }
    public void agregarRespuestaJugadorGroup(ToggleSwitch interruptor){
        respuestasJugadorGroup.add(interruptor);
    }
    public void recolectarRespuestasGroup(int cualJugador){
        for(ToggleSwitch interruptor : respuestasJugadorGroup){
            if(cualJugador == 1){
                interruptor.respuestaJugador(opcionesJugador1);
            }else {
                interruptor.respuestaJugador(opcionesJugador2);
            }
        }
        respuestasJugadorGroup = new ArrayList<ToggleSwitch>();
    }
}
