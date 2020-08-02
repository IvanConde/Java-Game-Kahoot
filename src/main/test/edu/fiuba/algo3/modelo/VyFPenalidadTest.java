
package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
public class VyFPenalidadTest {
    /*
    @Test
    public void test02_1CrearVyFConPenalidad() {
        ArrayList<String> todas = new ArrayList<String>();
        todas.add("verdadero");
        todas.add("falso");
        ArrayList<String> opcionCorrecta = new ArrayList<String>();
        opcionCorrecta.add("verdadero");
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todas, opcionCorrecta, new Penalidad());
        assertEquals(opcionCorrecta, preguntaTest.verRespuestaCorrecta());
    }
    @Test
    public void test02_2ResponderVerdaderoYFlasoConPenalidadyAsignarPuntajesCorrectamente(){
        ArrayList<String> todas = new ArrayList<String>();
        todas.add("verdadero");
        todas.add("falso");
        Jugador jugador1 = new Jugador("");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<String> opcionCorrecta = new ArrayList<String>();
        opcionCorrecta.add("verdadero");

        ArrayList<String> opcionJugador1 = new ArrayList<String>();
        opcionJugador1.add("verdadero");

        Respuesta respuestacorrecta = new Respuesta(opcionJugador1, jugador1.puntaje());
        respuestas.add(respuestacorrecta);
        Penalidad conPenalidad = new Penalidad();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todas, opcionCorrecta, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
    }
    @Test
    public void test02_3ResponderVerdaderoYFlasoConPenalidadyAsignarPuntajesIncorrectamente(){
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
        Penalidad conPenalidad = new Penalidad();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todas, opcionCorrecta, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(-1, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test02_4ResponderVerdaderoYFlasoConPenalidadDosJugadoresCorrectamenteEIncorrectamente(){
        ArrayList<String> todas = new ArrayList<String>();
        todas.add("verdadero");
        todas.add("falso");
        Jugador jugador1 = new Jugador("");

        Jugador jugador2 = new Jugador("");
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
        Penalidad sinPenalidad = new Penalidad();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todas, opcionCorrecta, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
        assertEquals(-1, jugador2.puntaje().getPuntaje());
    }


     */
}