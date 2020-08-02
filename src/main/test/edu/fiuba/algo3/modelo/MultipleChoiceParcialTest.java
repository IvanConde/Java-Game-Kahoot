
package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
public class MultipleChoiceParcialTest {
    /*
    @Test
    public void test04_1CrearMultipleChoiceParcial() {
        ArrayList<String> todas = new ArrayList<String>();
        todas.add("si");
        todas.add("totalmente");
        todas.add("no");
        todas.add("para nada");
        ArrayList<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add("si");
        opcionesCorrectas.add("totalmente");
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, opcionesCorrectas, new Parcial());
        assertEquals(opcionesCorrectas, preguntaTest.verRespuestaCorrecta());
    }
    @Test
    public void test04_2ResponderMultipleChoiceConParcialUnJugadorTodoCorrectoYOtroTodoIncorrecto(){
        ArrayList<String> todas = new ArrayList<String>();
        todas.add("si");
        todas.add("totalmente");
        todas.add("obvio");
        todas.add("no");
        todas.add("para nada");
        todas.add("nunca");
        Jugador jugador1 = new Jugador("Federico");

        Jugador jugador2 = new Jugador("Sofia");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add("si");
        opcionesCorrectas.add("totalmente");
        opcionesCorrectas.add("obvio");

        //Opciones elegidas por el Jugador 1.
        ArrayList<String> opcionesJugador1 = new ArrayList<String>();
        opcionesJugador1.add("si");
        opcionesJugador1.add("totalmente");
        opcionesJugador1.add("obvio");

        //Opciones elegidas por el Jugador 2.
        ArrayList<String> opcionesJugador2 = new ArrayList<String>();
        opcionesJugador2.add("no");
        opcionesJugador2.add("para nada");
        opcionesJugador2.add("nunca");

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2, jugador2.puntaje());
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        Parcial conPenalidadParcial = new Parcial();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, opcionesCorrectas, conPenalidadParcial);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(3, jugador1.puntaje().getPuntaje());
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test04_3ResponderMultipleChoiceConParcialUnJugadorParcialmenteCorrecto(){
        ArrayList<String> todas = new ArrayList<String>();
        todas.add("si");
        todas.add("totalmente");
        todas.add("obvio");
        todas.add("no");
        todas.add("para nada");
        todas.add("nunca");
        Jugador jugadorParcial = new Jugador("Lucas");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add("si");
        opcionesCorrectas.add("totalmente");
        opcionesCorrectas.add("obvio");
        ArrayList<String> opcionesJugadorParcial = new ArrayList<String>();
        opcionesJugadorParcial.add("si");
        Respuesta respuestaParcial = new Respuesta(opcionesJugadorParcial, jugadorParcial.puntaje());
        respuestas.add(respuestaParcial);
        Parcial conPenalidadParcial = new Parcial();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, opcionesCorrectas, conPenalidadParcial);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugadorParcial.puntaje().getPuntaje());
    }
    @Test
    public void test04_4ResponderMultipleChoiceConParcialConDosJugadores(){
        ArrayList<String> todas = new ArrayList<String>();
        todas.add("si");
        todas.add("totalmente");
        todas.add("obvio");
        todas.add("no");
        todas.add("para nada");
        todas.add("nunca");
        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Sofia");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add("si");
        opcionesCorrectas.add("totalmente");
        opcionesCorrectas.add("obvio");

        //Jugador1 selecciona algunas opciones correctas y una opción incorrecta, no se le asignan puntos
        ArrayList<String> opcionesJugador1 = new ArrayList<String>();
        opcionesJugador1.add("si");
        opcionesJugador1.add("obvio");
        opcionesJugador1.add("no");

        //Jugador2 selecciona dos opciones correctas y se le asignan dos puntos.
        ArrayList<String> opcionesJugador2 = new ArrayList<String>();
        opcionesJugador2.add("si");
        opcionesJugador2.add("obvio");

        Respuesta respuestaParcial1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuestaParcial2 = new Respuesta(opcionesJugador2, jugador2.puntaje());
        respuestas.add(respuestaParcial1);
        respuestas.add(respuestaParcial2);
        Parcial conPenalidadParcial = new Parcial();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, opcionesCorrectas, conPenalidadParcial);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(0, jugador1.puntaje().getPuntaje());
        assertEquals(2, jugador2.puntaje().getPuntaje());
    }


     */
}