package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.util.ArrayList;
public class VyFSinPenalidadTest {
    @Test
    public void test01_1CrearVyFSinPenalidad() {
        ArrayList<Integer> opcionCorrecta = new ArrayList<Integer>();
        opcionCorrecta.add(1);
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", opcionCorrecta, new Clasico());
        assertEquals(opcionCorrecta, preguntaTest.verRespuestaCorrecta());
    }

    @Test
    public void test01_2ResponderVerdaderoYFlasoyAsignarPuntajesCorrectamente(){
        Jugador jugador1 = new Jugador("Federico");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> opcionCorrecta = new ArrayList<Integer>();
        opcionCorrecta.add(1);

        ArrayList<Integer> opcionJugador1 = new ArrayList<Integer>();
        opcionJugador1.add(1);

        Respuesta respuestaJugador1 = new Respuesta(opcionJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        Clasico sinPenalidad = new Clasico();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", opcionCorrecta, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
    }
    @Test
    public void test01_3ResponderVerdaderoYFlasoyAsignarPuntajesIncorrectamente(){

        Jugador jugador2 = new Jugador("Sofia");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> opcionCorrecta = new ArrayList<Integer>();
        opcionCorrecta.add(1);

        ArrayList<Integer> opcionJugador2 = new ArrayList<Integer>();
        opcionJugador2.add(0);

        Respuesta respuestaJugador2 = new Respuesta(opcionJugador2, jugador2.puntaje());
        respuestas.add(respuestaJugador2);
        Clasico sinPenalidad = new Clasico();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", opcionCorrecta, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test01_4ResponderVerdaderoYFlasoyAsignarPuntajesDosJugadoresCorrectamenteEIncorrectamente(){
        Jugador jugador1 = new Jugador("Federico");

        Jugador jugador2 = new Jugador("Sofia");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> opcionCorrecta = new ArrayList<Integer>();
        opcionCorrecta.add(1);

        ArrayList<Integer> opcionJugador1 = new ArrayList<Integer>();
        opcionJugador1.add(1);

        ArrayList<Integer> opcionJugador2 = new ArrayList<Integer>();
        opcionJugador2.add(0);

        Respuesta respuestaJugador1 = new Respuesta(opcionJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionJugador2, jugador2.puntaje());
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        Clasico sinPenalidad = new Clasico();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", opcionCorrecta, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test01_5CrearVyFLanzaErrorPorCorrectasMultiples() {
        ArrayList<Integer> opcionCorrecta = new ArrayList<Integer>();
        opcionCorrecta.add(1);
        opcionCorrecta.add(2);
        assertThrows(VyFMasDeDosOpcionesException.class, () ->
            {new VerdaderoFalso("Es Tomas su primer nombre?", opcionCorrecta, new Clasico());
        });
    }
}