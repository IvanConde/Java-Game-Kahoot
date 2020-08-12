package edu.fiuba.algo3.javafx;

import edu.fiuba.algo3.javafx.controladores.ToggleSwitch;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.modalidades.Clasico;
import edu.fiuba.algo3.modelo.modalidades.Penalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionBooleana;
import edu.fiuba.algo3.modelo.opciones.OpcionEstructurada;
import edu.fiuba.algo3.modelo.preguntas.*;

import java.util.ArrayList;

public class Panel { // Panel es el modelo de un MVC
    Jugador jugador1;
    Jugador jugador2;
    Pregunta preguntaActual;
    ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
    ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
    ArrayList<ToggleSwitch> respuestasJugadorGroup = new ArrayList<ToggleSwitch>();
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
            if(opcion instanceof OpcionEstructurada){
                OpcionEstructurada opcionEstructurada = (OpcionEstructurada)opcion;
                opcionEstructurada.elegir(opcionesJugador.size(), opcionesJugador);
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


    public Pregunta crearPregunta(){
        //OpcionEstructurada opcion1 = new OpcionEstructurada("2", 0);
        //OpcionEstructurada opcion2 = new OpcionEstructurada("8", 1);
        //OpcionEstructurada opcion3 = new OpcionEstructurada("13", 0);
        //OpcionEstructurada opcion4 = new OpcionEstructurada("12", 1);
        //OpcionEstructurada opcion5 = new OpcionEstructurada("17", 0);

       // GroupChoice vyf = new GroupChoice("Colocar en el grupo 0 los numeros primos y en el grupo 1 los no-primos", opciones, new Clasico());

        OpcionEstructurada opcion1 = new OpcionEstructurada("4",0);
        OpcionEstructurada opcion2 = new OpcionEstructurada("7",1);
        OpcionEstructurada opcion3 = new OpcionEstructurada("9",2);
        OpcionEstructurada opcion4 = new OpcionEstructurada("10",3);
        OpcionEstructurada opcion5 = new OpcionEstructurada("25",4);

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        OrderedChoice vyf = new OrderedChoice("Ordenar de menor a mayor", opciones, new Clasico());

        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        Opcion verdadero1 = new OpcionBooleana("verdadero", true);
        Opcion verdadero2 = new OpcionBooleana("ya te dije verdadero", true);
        Opcion falso1 = new OpcionBooleana("falso", false);
        Opcion falso2 = new OpcionBooleana("A veces", false);
        todas.add(verdadero1);
        // todas.add(verdadero2);
        todas.add(falso1);
       // todas.add(falso2);
        //Pregunta vyf = new VerdaderoFalso("El mate es rico?", todas, new Penalidad());
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
