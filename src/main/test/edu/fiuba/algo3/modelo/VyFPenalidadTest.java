
package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
public class VyFPenalidadTest {
    @Test
    public void test02_1CrearVyFConPenalidad() {
        ArrayList<Integer> opcionCorrecta = new ArrayList<Integer>();
        opcionCorrecta.add(1);
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", opcionCorrecta, new Penalidad());
        assertEquals(opcionCorrecta, preguntaTest.verRespuestaCorrecta());
    }
    @Test
    public void test02_2ResponderVerdaderoYFlasoConPenalidadyAsignarPuntajesCorrectamente(){
        Jugador jugador1 = new Jugador("");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> opcionCorrecta = new ArrayList<Integer>();
        opcionCorrecta.add(1);

        ArrayList<Integer> opcionJugador1 = new ArrayList<Integer>();
        opcionJugador1.add(1);

        Respuesta respuestacorrecta = new Respuesta(opcionJugador1, jugador1.puntaje());
        respuestas.add(respuestacorrecta);
        Penalidad conPenalidad = new Penalidad();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", opcionCorrecta, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
    }
    @Test
    public void test02_3ResponderVerdaderoYFlasoConPenalidadyAsignarPuntajesIncorrectamente(){

        Jugador jugador2 = new Jugador("Sofia");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> opcionCorrecta = new ArrayList<Integer>();
        opcionCorrecta.add(1);

        ArrayList<Integer> opcionJugador2 = new ArrayList<Integer>();
        opcionJugador2.add(0);

        Respuesta respuestaJugador2 = new Respuesta(opcionJugador2, jugador2.puntaje());
        respuestas.add(respuestaJugador2);
        Penalidad conPenalidad = new Penalidad();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", opcionCorrecta, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(-1, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test02_4ResponderVerdaderoYFlasoConPenalidadDosJugadoresCorrectamenteEIncorrectamente(){
        Jugador jugador1 = new Jugador("");

        Jugador jugador2 = new Jugador("");
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
        Penalidad sinPenalidad = new Penalidad();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", opcionCorrecta, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
        assertEquals(-1, jugador2.puntaje().getPuntaje());
    }

}