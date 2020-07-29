
package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
public class VyFPenalidadTest {
    @Test
    public void test02_1CrearVyFConPenalidad() {
        ArrayList<Integer> respuestaCorrecta = new ArrayList<Integer>();
        respuestaCorrecta.add(1);
        VerdaderoFalso preguntaTest =new VerdaderoFalso("Es Tomas su primer nombre?", respuestaCorrecta, new Penalidad());
        assertEquals(respuestaCorrecta, preguntaTest.verRespuestaCorrecta());
    }
    @Test
    public void test02_2ResponderVerdaderoYFlasoConPenalidadyAsignarPuntajesCorrectamente(){
        Jugador jugador1 = new Jugador("");


        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> respuestaCorrecta = new ArrayList<Integer>();
        respuestaCorrecta.add(1);
        Respuesta respuestacorrecta = new Respuesta(respuestaCorrecta, jugador1.puntaje());
        respuestas.add(respuestacorrecta);
        Penalidad conPenalidad = new Penalidad();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", respuestaCorrecta, conPenalidad);
        preguntaTest.Responderpregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
    }
    @Test
    public void test02_3ResponderVerdaderoYFlasoConPenalidadyAsignarPuntajesIncorrectamente(){

        Jugador jugador2 = new Jugador("");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> respuestaCorrecta = new ArrayList<Integer>();
        respuestaCorrecta.add(1);
        ArrayList<Integer> respuestaIncorrecta = new ArrayList<Integer>();
        respuestaIncorrecta.add(0);
        Respuesta respuestaincorrecta = new Respuesta(respuestaIncorrecta, jugador2.puntaje());
        respuestas.add(respuestaincorrecta);
        Penalidad conPenalidad = new Penalidad();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", respuestaCorrecta, conPenalidad);
        preguntaTest.Responderpregunta(respuestas);
        assertEquals(-1, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test02_4ResponderVerdaderoYFlasoConPenalidadDosJugadoresCorrectamenteEIncorrectamente(){
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
        Penalidad sinPenalidad = new Penalidad();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", respuestaCorrecta, sinPenalidad);
        preguntaTest.Responderpregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
        assertEquals(-1, jugador2.puntaje().getPuntaje());
    }

}