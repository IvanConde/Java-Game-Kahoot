package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
public class MultipleChoiceClasicoTest {
    @Test
    public void test03_1CrearMultipleChoiceClasico() {
        ArrayList<Integer> respuestaCorrecta = new ArrayList<Integer>();
        respuestaCorrecta.add(1);
        respuestaCorrecta.add(2);
        MultipleChoice preguntaTest =new MultipleChoice("Es Tomas su primer nombre?", respuestaCorrecta, new Clasico());
        assertEquals(respuestaCorrecta, preguntaTest.verRespuestaCorrecta());
    }

    @Test
    public void test03_2ResponderMultipleChoiceyAsignarPuntajesCorrectamente(){
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
        Clasico sinPenalidad = new Clasico();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", respuestaCorrecta, sinPenalidad);
        preguntaTest.Responderpregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test03_3ResponderMultipleChoiceyAsignarPuntajesCorrectamenteConUnaDeDosBien(){

        Jugador jugador2 = new Jugador("");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> respuestaCorrecta = new ArrayList<Integer>();
        respuestaCorrecta.add(1);
        respuestaCorrecta.add(2);
        ArrayList<Integer> respuestaIncorrecta = new ArrayList<Integer>();
        respuestaIncorrecta.add(1);
        Respuesta respuestaincorrecta = new Respuesta(respuestaIncorrecta, jugador2.puntaje());
        respuestas.add(respuestaincorrecta);
        Clasico sinPenalidad = new Clasico();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", respuestaCorrecta, sinPenalidad);
        preguntaTest.Responderpregunta(respuestas);
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test03_4ResponderMultipleChoiceyAsignarPuntajesCorrectamenteConUnaTodasBienYUnaMal(){

        Jugador jugador2 = new Jugador("");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> respuestaCorrecta = new ArrayList<Integer>();
        respuestaCorrecta.add(1);
        respuestaCorrecta.add(2);
        ArrayList<Integer> respuestaIncorrecta = new ArrayList<Integer>();
        respuestaIncorrecta.add(1);
        respuestaIncorrecta.add(2);
        respuestaIncorrecta.add(3);
        Respuesta respuestaincorrecta = new Respuesta(respuestaIncorrecta, jugador2.puntaje());
        respuestas.add(respuestaincorrecta);
        Clasico sinPenalidad = new Clasico();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", respuestaCorrecta, sinPenalidad);
        preguntaTest.Responderpregunta(respuestas);
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }
}