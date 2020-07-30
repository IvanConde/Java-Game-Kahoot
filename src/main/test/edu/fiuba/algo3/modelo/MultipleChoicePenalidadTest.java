
package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
public class MultipleChoicePenalidadTest {
    @Test
    public void test05_1CrearMultipleChoiceConPenalidad() {
        ArrayList<Integer> opcionesCorrectas = new ArrayList<Integer>();
        opcionesCorrectas.add(1);
        opcionesCorrectas.add(2);
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", opcionesCorrectas, new Penalidad());
        assertEquals(opcionesCorrectas, preguntaTest.verRespuestaCorrecta());
    }
    @Test
    public void test05_2ResponderMultipleChoiceConPenalidadCorrectamenteUnJugadorTodoBienYOtroTodoMal(){
        Jugador jugador1 = new Jugador("");
        Jugador jugador2 = new Jugador("");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> opcionesCorrectas = new ArrayList<Integer>();
        opcionesCorrectas.add(1);
        opcionesCorrectas.add(2);

        ArrayList<Integer> opcionesJugador1 = new ArrayList<Integer>();
        opcionesJugador1.add(2);
        opcionesJugador1.add(1);

        ArrayList<Integer> opcionesJugador2 = new ArrayList<Integer>();
        opcionesJugador2.add(3);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2, jugador2.puntaje());
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        Penalidad conPenalidad = new Penalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", opcionesCorrectas, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(2, jugador1.puntaje().getPuntaje());
        assertEquals(-1, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test05_3ResponderMultipleChoiceConPenalidadUnaRespuestaCorrectaDeDos(){

        Jugador jugador1 = new Jugador("");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> opcionesCorrectas = new ArrayList<Integer>();
        opcionesCorrectas.add(1);
        opcionesCorrectas.add(2);
        ArrayList<Integer> opcionesJugador1 = new ArrayList<Integer>();
        opcionesJugador1.add(1);
        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        Penalidad conPenalidad = new Penalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", opcionesCorrectas, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
    }
    @Test
    public void test05_4ResponderMultipleChoiceConPenalidadUnaCorrectaYUnaErroneaDeDos(){

        Jugador jugador2 = new Jugador("Sofia");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> opcionesCorrectas = new ArrayList<Integer>();
        opcionesCorrectas.add(1);
        opcionesCorrectas.add(2);
        ArrayList<Integer> opcionesJugador2 = new ArrayList<Integer>();
        opcionesJugador2.add(1);
        opcionesJugador2.add(0);
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2, jugador2.puntaje());
        respuestas.add(respuestaJugador2);
        Penalidad conPenalidad = new Penalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", opcionesCorrectas, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test05_5ResponderMultipleChoiceConPenalidadConDosJugadores(){
        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Sofia");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> opcionesCorrectas = new ArrayList<Integer>();
        opcionesCorrectas.add(1);
        opcionesCorrectas.add(2);
        opcionesCorrectas.add(3);

        ArrayList<Integer> opcionesJugador1 = new ArrayList<Integer>();
        opcionesJugador1.add(1);
        opcionesJugador1.add(2);
        opcionesJugador1.add(0);

        ArrayList<Integer> opcionesJugador2 = new ArrayList<Integer>();
        opcionesJugador2.add(4);
        opcionesJugador2.add(1);
        opcionesJugador2.add(5);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2, jugador2.puntaje());
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        Penalidad conPenalidad = new Penalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", opcionesCorrectas, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
        assertEquals(-1, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test05_6ResponderMultipleChoiceConPenalidadUnaCorrectaYDosErroneasDeTres(){

        Jugador jugador1 = new Jugador("Federico");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> opcionesCorrectas = new ArrayList<Integer>();
        opcionesCorrectas.add(1);
        opcionesCorrectas.add(2);
        opcionesCorrectas.add(3);
        ArrayList<Integer> opcionesJugador1 = new ArrayList<Integer>();
        opcionesJugador1.add(1);
        opcionesJugador1.add(4);
        opcionesJugador1.add(0);
        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        Penalidad conPenalidad = new Penalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", opcionesCorrectas, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(-1, jugador1.puntaje().getPuntaje());
    }

}