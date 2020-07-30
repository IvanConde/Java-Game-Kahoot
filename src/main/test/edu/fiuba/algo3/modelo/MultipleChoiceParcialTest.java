
package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
public class MultipleChoiceParcialTest {
    @Test
    public void test04_1CrearMultipleChoiceParcial() {
        ArrayList<Integer> opcionesCorrectas = new ArrayList<Integer>();
        opcionesCorrectas.add(1);
        opcionesCorrectas.add(2);
        MultipleChoice preguntaTest =new MultipleChoice("Es Tomas su primer nombre?", opcionesCorrectas, new Parcial());
        assertEquals(opcionesCorrectas, preguntaTest.verRespuestaCorrecta());
    }
    @Test
    public void test04_2ResponderMultipleChoiceConParcialUnJugadorTodoCorrectoYOtroTodoIncorrecto(){
        Jugador jugador1 = new Jugador("");

        Jugador jugador2 = new Jugador("");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> opcionesCorrectas = new ArrayList<Integer>();
        opcionesCorrectas.add(1);
        opcionesCorrectas.add(2);
        opcionesCorrectas.add(3);
        ArrayList<Integer> respuestaIncorrecta = new ArrayList<Integer>();
        respuestaIncorrecta.add(0);
        Respuesta respuestacorrecta = new Respuesta(opcionesCorrectas, jugador1.puntaje());
        Respuesta respuestaincorrecta = new Respuesta(respuestaIncorrecta, jugador2.puntaje());
        respuestas.add(respuestacorrecta);
        respuestas.add(respuestaincorrecta);
        Parcial conPenalidadParcial = new Parcial();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", opcionesCorrectas, conPenalidadParcial);
        preguntaTest.Responderpregunta(respuestas);
        assertEquals(3, jugador1.puntaje().getPuntaje());
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test04_3ResponderMultipleChoiceConParcialUnJugadorParcialmenteCorrecto(){

        Jugador jugadorParcial = new Jugador("");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> opcionesCorrectas = new ArrayList<Integer>();
        opcionesCorrectas.add(1);
        opcionesCorrectas.add(2);
        opcionesCorrectas.add(3);
        ArrayList<Integer> respuestaParcial = new ArrayList<Integer>();
        respuestaParcial.add(1);
        Respuesta respuestaparcial = new Respuesta(respuestaParcial, jugadorParcial.puntaje());
        respuestas.add(respuestaparcial);
        Parcial conPenalidadParcial = new Parcial();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", opcionesCorrectas, conPenalidadParcial);
        preguntaTest.Responderpregunta(respuestas);
        assertEquals(1, jugadorParcial.puntaje().getPuntaje());
    }
    @Test
    public void test04_4ResponderMultipleChoiceConParcialUnJugadorParcialmenteInorrecto(){

        Jugador jugadorParcial = new Jugador("");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> opcionesCorrectas = new ArrayList<Integer>();
        opcionesCorrectas.add(1);
        opcionesCorrectas.add(2);
        opcionesCorrectas.add(3);
        ArrayList<Integer> respuestaParcial = new ArrayList<Integer>();
        respuestaParcial.add(1);
        respuestaParcial.add(2);
        respuestaParcial.add(0);
        Respuesta respuestaparcial = new Respuesta(respuestaParcial, jugadorParcial.puntaje());
        respuestas.add(respuestaparcial);
        Parcial conPenalidadParcial = new Parcial();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", opcionesCorrectas, conPenalidadParcial);
        preguntaTest.Responderpregunta(respuestas);
        assertEquals(0, jugadorParcial.puntaje().getPuntaje());
    }

}