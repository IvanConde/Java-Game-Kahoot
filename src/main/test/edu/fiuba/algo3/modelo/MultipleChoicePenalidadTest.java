
package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
public class MultipleChoicePenalidadTest {
    @Test
    public void test05_1CrearMultipleChoiceConPenalidad() {
        ArrayList<String> todas = new ArrayList<String>();
        todas.add("si");
        todas.add("totalmente");
        todas.add("no");
        todas.add("para nada");
        ArrayList<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add("si");
        opcionesCorrectas.add("totalmente");
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, opcionesCorrectas, new Penalidad());
        assertEquals(opcionesCorrectas, preguntaTest.verRespuestaCorrecta());
    }
    @Test
    public void test05_2ResponderMultipleChoiceConPenalidadCorrectamenteUnJugadorTodoBienYOtroTodoMal(){
        ArrayList<String> todas = new ArrayList<String>();
        todas.add("si");
        todas.add("totalmente");
        todas.add("no");
        todas.add("para nada");
        Jugador jugador1 = new Jugador("");
        Jugador jugador2 = new Jugador("");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add("si");
        opcionesCorrectas.add("totalmente");

        ArrayList<String> opcionesJugador1 = new ArrayList<String>();
        opcionesJugador1.add("totalmente");
        opcionesJugador1.add("si");

        ArrayList<String> opcionesJugador2 = new ArrayList<String>();
        opcionesJugador2.add("no");

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2, jugador2.puntaje());
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        Penalidad conPenalidad = new Penalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, opcionesCorrectas, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(2, jugador1.puntaje().getPuntaje());
        assertEquals(-1, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test05_3ResponderMultipleChoiceConPenalidadUnaRespuestaCorrectaDeDos(){
        ArrayList<String> todas = new ArrayList<String>();
        todas.add("si");
        todas.add("totalmente");
        todas.add("no");
        todas.add("para nada");
        Jugador jugador1 = new Jugador("");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add("si");
        opcionesCorrectas.add("totalmente");
        ArrayList<String> opcionesJugador1 = new ArrayList<String>();
        opcionesJugador1.add("si");
        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        Penalidad conPenalidad = new Penalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, opcionesCorrectas, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
    }
    @Test
    public void test05_4ResponderMultipleChoiceConPenalidadUnaCorrectaYUnaErroneaDeDos(){
        ArrayList<String> todas = new ArrayList<String>();
        todas.add("si");
        todas.add("totalmente");
        todas.add("no");
        todas.add("para nada");
        Jugador jugador2 = new Jugador("Sofia");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add("si");
        opcionesCorrectas.add("totalmente");
        ArrayList<String> opcionesJugador2 = new ArrayList<String>();
        opcionesJugador2.add("si");
        opcionesJugador2.add("no");
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2, jugador2.puntaje());
        respuestas.add(respuestaJugador2);
        Penalidad conPenalidad = new Penalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, opcionesCorrectas, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test05_5ResponderMultipleChoiceConPenalidadConDosJugadores(){
        ArrayList<String> todas = new ArrayList<String>();
        todas.add("si");
        todas.add("totalmente");
        todas.add("obvio");
        todas.add("para nada");
        todas.add("no");
        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Sofia");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add("si");
        opcionesCorrectas.add("totalmente");
        opcionesCorrectas.add("obvio");

        ArrayList<String> opcionesJugador1 = new ArrayList<String>();
        opcionesJugador1.add("si");
        opcionesJugador1.add("totalmente");
        opcionesJugador1.add("para nada");

        ArrayList<String> opcionesJugador2 = new ArrayList<String>();
        opcionesJugador2.add("si");
        opcionesJugador2.add("no");
        opcionesJugador2.add("para nada");

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2, jugador2.puntaje());
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        Penalidad conPenalidad = new Penalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, opcionesCorrectas, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
        assertEquals(-1, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test05_6ResponderMultipleChoiceConPenalidadUnaCorrectaYDosErroneasDeTres(){
        ArrayList<String> todas = new ArrayList<String>();
        todas.add("si");
        todas.add("totalmente");
        todas.add("obvio");
        todas.add("para nada");
        todas.add("no");
        Jugador jugador1 = new Jugador("Federico");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add("si");
        opcionesCorrectas.add("totalmente");
        opcionesCorrectas.add("obvio");
        ArrayList<String> opcionesJugador1 = new ArrayList<String>();
        opcionesJugador1.add("si");
        opcionesJugador1.add("para nada");
        opcionesJugador1.add("no");
        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        Penalidad conPenalidad = new Penalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, opcionesCorrectas, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(-1, jugador1.puntaje().getPuntaje());
    }

}