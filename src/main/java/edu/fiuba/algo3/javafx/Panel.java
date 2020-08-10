package edu.fiuba.algo3.javafx;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.modalidades.Clasico;
import edu.fiuba.algo3.modelo.modalidades.Penalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionBooleana;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;

import java.util.ArrayList;

public class Panel { // Panel es el modelo de un MVC
    Jugador jugador1;
    Jugador jugador2;
    Pregunta preguntaActual;
    ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
    ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
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
            opcionesJugador1.add(opcion);
        }else{
            opcionesJugador2.add(opcion);
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

    //public void tienePenalidad(){
        //si tiene penalidad
       // if(jugador.getTieneMultiplicadorx2){
            //mostrarBoton
        //}
        //si tiene mostrar MultiplicadorX3


    public Pregunta crearPregunta(){
        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        Opcion verdadero1 = new OpcionBooleana("verdadero", true);
        Opcion verdadero2 = new OpcionBooleana("ya te dije verdadero", true);
        Opcion falso1 = new OpcionBooleana("falso", false);
        Opcion falso2 = new OpcionBooleana("A veces", false);
        todas.add(verdadero1);
        // todas.add(verdadero2);
        todas.add(falso1);
       // todas.add(falso2);
        Pregunta vyf = new VerdaderoFalso("El mate es rico?", todas, new Penalidad());
        this.preguntaActual = vyf;
        return vyf;
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
}
