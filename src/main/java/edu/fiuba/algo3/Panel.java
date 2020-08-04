package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import java.util.ArrayList;

public class Panel { // Panel es el modelo de un MVC
    Jugador jugador1;
    Jugador jugador2;
    Pregunta preguntaActual;
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

    public void tienePenalidad(){
        //si tiene penalidad
       // if(jugador.getTieneMultiplicadorx2){
            //mostrarBoton
        }
        //si tiene mostrar MultiplicadorX3





    public Pregunta crearPregunta(){
        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        Opcion verdadero = new OpcionChoice("verdadero", true);
        Opcion verdader = new OpcionChoice("ya te dije verdadero flaco", true);
        Opcion falso = new OpcionChoice("falso", false);
        Opcion fals = new OpcionChoice("cuantas veces te tengo que decir que no te voy a ********", false);
        todas.add(verdadero);
        todas.add(verdader);
        todas.add(falso);
        todas.add(fals);
        Pregunta vyf = new MultipleChoice("El mate es rico?", todas, new Clasico());
        this.preguntaActual = vyf;
        return vyf;
    }
    public String nombreJugador(int cualJugador){
        if(cualJugador == 1){
            return jugador1.verNombre();
        }
        return jugador2.verNombre();
    }
}