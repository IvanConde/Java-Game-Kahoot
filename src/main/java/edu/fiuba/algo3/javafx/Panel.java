package edu.fiuba.algo3.javafx;

import edu.fiuba.algo3.javafx.datos.CrearPreguntas;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.LinkedList;
import java.util.Random;

public class Panel { // Panel es el modelo de un MVC
    Jugador jugador1;
    Jugador jugador2;
    Pregunta preguntaActual;
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


    //public void tienePenalidad(){
        //si tiene penalidad
       // if(jugador.getTieneMultiplicadorx2){
            //mostrarBoton
        //}
        //si tiene mostrar MultiplicadorX3


    public Pregunta obtenerPreguntaAleatoria(){
        int tamaño = this.queue.size();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(tamaño);
        return (Pregunta) this.queue.get(randomInt);
        /*
        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        Opcion verdadero1 = new OpcionBooleana("verdadero", true);
        Opcion verdadero2 = new OpcionBooleana("ya te dije verdadero", true);
        Opcion falso1 = new OpcionBooleana("falso", false);
        Opcion falso2 = new OpcionBooleana("A veces", false);
        todas.add(verdadero1);
        todas.add(verdadero2);
        todas.add(falso1);
        todas.add(falso2);
        Pregunta vyf = new MultipleChoice("El mate es rico?", todas, new Clasico());
        this.preguntaActual = vyf;
        return vyf;
        */
    }
    public String nombreJugador(int cualJugador){
        if(cualJugador == 1){
            return jugador1.verNombre();
        }
        return jugador2.verNombre();
    }
}
