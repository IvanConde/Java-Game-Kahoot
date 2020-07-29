package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.util.ArrayList;
public class VyFSinPenalidadTest {
    @Test
    public void test01_1CrearVyFSinPenalidad() {
        ArrayList<Integer> respuestaCorrecta = new ArrayList<Integer>();
        respuestaCorrecta.add(1);
        VerdaderoFalso preguntaTest =new VerdaderoFalso("Es Tomas su primer nombre?", respuestaCorrecta, new Clasico());
        assertEquals(respuestaCorrecta, preguntaTest.verRespuestaCorrecta());
    }

    @Test
    public void test01_2ResponderVerdaderoYFlasoyAsignarPuntajesCorrectamente(){
        Jugador jugador1 = new Jugador("");


        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> respuestaCorrecta = new ArrayList<Integer>();
        respuestaCorrecta.add(1);
        Respuesta respuestacorrecta = new Respuesta(respuestaCorrecta, jugador1.puntaje());
        respuestas.add(respuestacorrecta);
        Clasico sinPenalidad = new Clasico();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", respuestaCorrecta, sinPenalidad);
        preguntaTest.Responderpregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
    }
    @Test
    public void test01_3ResponderVerdaderoYFlasoyAsignarPuntajesIncorrectamente(){

        Jugador jugador2 = new Jugador("");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> respuestaCorrecta = new ArrayList<Integer>();
        respuestaCorrecta.add(1);
        ArrayList<Integer> respuestaIncorrecta = new ArrayList<Integer>();
        respuestaIncorrecta.add(0);
        Respuesta respuestaincorrecta = new Respuesta(respuestaIncorrecta, jugador2.puntaje());
        respuestas.add(respuestaincorrecta);
        Clasico sinPenalidad = new Clasico();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", respuestaCorrecta, sinPenalidad);
        preguntaTest.Responderpregunta(respuestas);
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test01_4ResponderVerdaderoYFlasoyAsignarPuntajesDosJugadoresCorrectamenteEIncorrectamente(){
        Jugador jugador1 = new Jugador("");

        Jugador jugador2 = new Jugador("");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> respuestaCorrecta = new ArrayList<Integer>();
        respuestaCorrecta.add(1);
        ArrayList<Integer> respuestaIncorrecta = new ArrayList<Integer>();
        respuestaIncorrecta.add(0);
        Respuesta respuestacorrecta = new Respuesta(respuestaCorrecta, jugador1.puntaje());
        Respuesta respuestaincorrecta = new Respuesta(respuestaIncorrecta, jugador2.puntaje());
        respuestas.add(respuestacorrecta);
        respuestas.add(respuestaincorrecta);
        Clasico sinPenalidad = new Clasico();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", respuestaCorrecta, sinPenalidad);
        preguntaTest.Responderpregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test01_5CrearVyFLanzaErrorPorCorrectasMultiples() {
        ArrayList<Integer> respuestaCorrecta = new ArrayList<Integer>();
        respuestaCorrecta.add(1);
        respuestaCorrecta.add(2);
        assertThrows(VyFMasDeDosOpcionesException.class, () ->
            {new VerdaderoFalso("Es Tomas su primer nombre?", respuestaCorrecta, new Clasico());
        });
    }
}