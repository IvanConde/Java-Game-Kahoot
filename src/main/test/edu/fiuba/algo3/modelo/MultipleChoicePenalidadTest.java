
package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
public class MultipleChoicePenalidadTest {
    @Test
    public void test05_1CrearMultipleChoiceConPenalidad() {
        ArrayList<Integer> respuestaCorrecta = new ArrayList<Integer>();
        respuestaCorrecta.add(1);
        respuestaCorrecta.add(2);
        MultipleChoice preguntaTest =new MultipleChoice("Es Tomas su primer nombre?", respuestaCorrecta, new Penalidad());
        assertEquals(respuestaCorrecta, preguntaTest.verRespuestaCorrecta());
    }
    @Test
    public void test05_2ResponderMultipleChoiceConPenalidadCorrectamenteUnJugadorTodoBienYOtroTodoMal(){
        Jugador jugador1 = new Jugador("");

        Jugador jugador2 = new Jugador("");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> respuestaCorrecta = new ArrayList<Integer>();
        respuestaCorrecta.add(1);
        respuestaCorrecta.add(2);
        ArrayList<Integer> respuestaIncorrecta = new ArrayList<Integer>();
        respuestaIncorrecta.add(0);
        Respuesta respuestacorrecta = new Respuesta(respuestaCorrecta, jugador1.puntaje());
        Respuesta respuestaincorrecta = new Respuesta(respuestaIncorrecta, jugador2.puntaje());
        respuestas.add(respuestacorrecta);
        respuestas.add(respuestaincorrecta);
        Penalidad conPenalidad = new Penalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", respuestaCorrecta, conPenalidad);
        preguntaTest.Responderpregunta(respuestas);
        assertEquals(2, jugador1.puntaje().getPuntaje());
        assertEquals(-1, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test05_3ResponderMultipleChoiceConPenalidadUnaRespuestaCorrectaDeDos(){

        Jugador jugadorParcial = new Jugador("");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> respuestaCorrecta = new ArrayList<Integer>();
        respuestaCorrecta.add(1);
        respuestaCorrecta.add(2);
        ArrayList<Integer> respuestaParcial = new ArrayList<Integer>();
        respuestaParcial.add(1);
        Respuesta respuestaincorrecta = new Respuesta(respuestaParcial, jugadorParcial.puntaje());
        respuestas.add(respuestaincorrecta);
        Penalidad conPenalidad = new Penalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", respuestaCorrecta, conPenalidad);
        preguntaTest.Responderpregunta(respuestas);
        assertEquals(1, jugadorParcial.puntaje().getPuntaje());
    }
    @Test
    public void test05_4ResponderMultipleChoiceConPenalidadUnaCorrectaYUnaErroneaDeDos(){

        Jugador jugadorParcial = new Jugador("");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> respuestaCorrecta = new ArrayList<Integer>();
        respuestaCorrecta.add(1);
        respuestaCorrecta.add(2);
        ArrayList<Integer> respuestaParcial = new ArrayList<Integer>();
        respuestaParcial.add(1);
        respuestaParcial.add(0);
        Respuesta respuestaincorrecta = new Respuesta(respuestaParcial, jugadorParcial.puntaje());
        respuestas.add(respuestaincorrecta);
        Penalidad conPenalidad = new Penalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", respuestaCorrecta, conPenalidad);
        preguntaTest.Responderpregunta(respuestas);
        assertEquals(0, jugadorParcial.puntaje().getPuntaje());
    }
    @Test
    public void test05_5ResponderMultipleChoiceConPenalidadDosCorrectasYUnaErroneaDeTres(){

        Jugador jugadorParcial = new Jugador("");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> respuestaCorrecta = new ArrayList<Integer>();
        respuestaCorrecta.add(1);
        respuestaCorrecta.add(2);
        respuestaCorrecta.add(3);
        ArrayList<Integer> respuestaParcial = new ArrayList<Integer>();
        respuestaParcial.add(1);
        respuestaParcial.add(2);
        respuestaParcial.add(0);
        Respuesta respuestaincorrecta = new Respuesta(respuestaParcial, jugadorParcial.puntaje());
        respuestas.add(respuestaincorrecta);
        Penalidad conPenalidad = new Penalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", respuestaCorrecta, conPenalidad);
        preguntaTest.Responderpregunta(respuestas);
        assertEquals(1, jugadorParcial.puntaje().getPuntaje());
    }
    @Test
    public void test05_6ResponderMultipleChoiceConPenalidadUnaCorrectaYDosErroneasDeTres(){

        Jugador jugadorParcial = new Jugador("");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> respuestaCorrecta = new ArrayList<Integer>();
        respuestaCorrecta.add(1);
        respuestaCorrecta.add(2);
        respuestaCorrecta.add(3);
        ArrayList<Integer> respuestaParcial = new ArrayList<Integer>();
        respuestaParcial.add(1);
        respuestaParcial.add(4);
        respuestaParcial.add(0);
        Respuesta respuestaincorrecta = new Respuesta(respuestaParcial, jugadorParcial.puntaje());
        respuestas.add(respuestaincorrecta);
        Penalidad conPenalidad = new Penalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", respuestaCorrecta, conPenalidad);
        preguntaTest.Responderpregunta(respuestas);
        assertEquals(-1, jugadorParcial.puntaje().getPuntaje());
    }

}