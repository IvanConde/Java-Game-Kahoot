
package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
public class MultipleChoiceParcialTest {
    @Test
    public void test04_1CrearMultipleChoiceParcial() {
        ArrayList<Integer> opcionesCorrectas = new ArrayList<Integer>();
        opcionesCorrectas.add(1);
        opcionesCorrectas.add(2);
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", opcionesCorrectas, new Parcial());
        assertEquals(opcionesCorrectas, preguntaTest.verRespuestaCorrecta());
    }
    @Test
    public void test04_2ResponderMultipleChoiceConParcialUnJugadorTodoCorrectoYOtroTodoIncorrecto(){
        Jugador jugador1 = new Jugador("Federico");

        Jugador jugador2 = new Jugador("Sofia");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> opcionesCorrectas = new ArrayList<Integer>();
        opcionesCorrectas.add(1);
        opcionesCorrectas.add(2);
        opcionesCorrectas.add(3);

        //Opciones elegidas por el Jugador 1.
        ArrayList<Integer> opcionesJugador1 = new ArrayList<Integer>();
        opcionesJugador1.add(2);
        opcionesJugador1.add(1);
        opcionesJugador1.add(3);

        //Opciones elegidas por el Jugador 2.
        ArrayList<Integer> opcionesJugador2 = new ArrayList<Integer>();
        opcionesJugador2.add(4);
        opcionesJugador2.add(5);
        opcionesJugador2.add(6);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2, jugador2.puntaje());
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        Parcial conPenalidadParcial = new Parcial();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", opcionesCorrectas, conPenalidadParcial);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(3, jugador1.puntaje().getPuntaje());
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test04_3ResponderMultipleChoiceConParcialUnJugadorParcialmenteCorrecto(){

        Jugador jugadorParcial = new Jugador("Lucas");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> opcionesCorrectas = new ArrayList<Integer>();
        opcionesCorrectas.add(1);
        opcionesCorrectas.add(2);
        opcionesCorrectas.add(3);
        ArrayList<Integer> opcionesJugadorParcial = new ArrayList<Integer>();
        opcionesJugadorParcial.add(1);
        Respuesta respuestaParcial = new Respuesta(opcionesJugadorParcial, jugadorParcial.puntaje());
        respuestas.add(respuestaParcial);
        Parcial conPenalidadParcial = new Parcial();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", opcionesCorrectas, conPenalidadParcial);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugadorParcial.puntaje().getPuntaje());
    }
    @Test
    public void test04_4ResponderMultipleChoiceConParcialConDosJugadores(){

        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Sofia");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> opcionesCorrectas = new ArrayList<Integer>();
        opcionesCorrectas.add(1);
        opcionesCorrectas.add(2);
        opcionesCorrectas.add(3);

        //Jugador1 selecciona algunas opciones correctas y una opción incorrecta, no se le asignan puntos
        ArrayList<Integer> opcionesJugador1 = new ArrayList<Integer>();
        opcionesJugador1.add(1);
        opcionesJugador1.add(2);
        opcionesJugador1.add(0);

        //Jugador2 selecciona dos opciones correctas y se le asignan dos puntos.
        ArrayList<Integer> opcionesJugador2 = new ArrayList<Integer>();
        opcionesJugador2.add(3);
        opcionesJugador2.add(1);

        Respuesta respuestaParcial1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuestaParcial2 = new Respuesta(opcionesJugador2, jugador2.puntaje());
        respuestas.add(respuestaParcial1);
        respuestas.add(respuestaParcial2);
        Parcial conPenalidadParcial = new Parcial();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", opcionesCorrectas, conPenalidadParcial);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(0, jugador1.puntaje().getPuntaje());
        assertEquals(2, jugador2.puntaje().getPuntaje());
    }

}