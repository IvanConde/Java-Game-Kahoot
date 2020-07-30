package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.util.ArrayList;
public class VyFSinPenalidadTest {
    @Test
    public void test01_1CrearVyFSinPenalidad() {
        ArrayList<String> todas = new ArrayList<String>();
        todas.add("verdadero");
        todas.add("falso");
        ArrayList<String> opcionCorrecta = new ArrayList<String>();
        opcionCorrecta.add("verdadero");
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todas, opcionCorrecta, new Clasico());
        assertEquals(opcionCorrecta, preguntaTest.verRespuestaCorrecta());
    }

    @Test
    public void test01_2ResponderVerdaderoYFlasoyAsignarPuntajesCorrectamente(){
        Jugador jugador1 = new Jugador("Federico");
        ArrayList<String> todas = new ArrayList<String>();
        todas.add("verdadero");
        todas.add("falso");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<String> opcionCorrecta = new ArrayList<String>();
        opcionCorrecta.add("verdadero");

        ArrayList<String> opcionJugador1 = new ArrayList<String>();
        opcionJugador1.add("verdadero");

        Respuesta respuestaJugador1 = new Respuesta(opcionJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        Clasico sinPenalidad = new Clasico();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todas, opcionCorrecta, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
    }
    @Test
    public void test01_3ResponderVerdaderoYFlasoyAsignarPuntajesIncorrectamente(){
        ArrayList<String> todas = new ArrayList<String>();
        todas.add("verdadero");
        todas.add("falso");
        Jugador jugador2 = new Jugador("Sofia");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<String> opcionCorrecta = new ArrayList<String>();
        opcionCorrecta.add("verdadero");

        ArrayList<String> opcionJugador2 = new ArrayList<String>();
        opcionJugador2.add("falso");

        Respuesta respuestaJugador2 = new Respuesta(opcionJugador2, jugador2.puntaje());
        respuestas.add(respuestaJugador2);
        Clasico sinPenalidad = new Clasico();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todas, opcionCorrecta, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test01_4ResponderVerdaderoYFlasoyAsignarPuntajesDosJugadoresCorrectamenteEIncorrectamente(){
        ArrayList<String> todas = new ArrayList<String>();
        todas.add("verdadero");
        todas.add("falso");
        Jugador jugador1 = new Jugador("Federico");

        Jugador jugador2 = new Jugador("Sofia");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<String> opcionCorrecta = new ArrayList<String>();
        opcionCorrecta.add("verdadero");

        ArrayList<String> opcionJugador1 = new ArrayList<String>();
        opcionJugador1.add("verdadero");

        ArrayList<String> opcionJugador2 = new ArrayList<String>();
        opcionJugador2.add("falso");

        Respuesta respuestaJugador1 = new Respuesta(opcionJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionJugador2, jugador2.puntaje());
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        Clasico sinPenalidad = new Clasico();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todas, opcionCorrecta, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test01_5CrearVyFLanzaErrorPorCorrectasMultiples() {
        ArrayList<String> todas = new ArrayList<String>();
        todas.add("verdadero");
        todas.add("falso");
        ArrayList<String> opcionCorrecta = new ArrayList<String>();
        opcionCorrecta.add("verdadero");
        opcionCorrecta.add("falso");
        assertThrows(VyFMasDeDosOpcionesException.class, () ->
            {new VerdaderoFalso("Es Tomas su primer nombre?", todas, opcionCorrecta, new Clasico());
        });
    }
}