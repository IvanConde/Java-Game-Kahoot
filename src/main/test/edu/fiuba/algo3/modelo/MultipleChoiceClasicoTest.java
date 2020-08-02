package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
public class MultipleChoiceClasicoTest {
    /*
    @Test
    public void test03_1CrearMultipleChoiceClasico() {
        ArrayList<String> todas = new ArrayList<String>();
        todas.add("si");
        todas.add("totalmente");
        todas.add("no");
        todas.add("para nada");
        todas.add("nunca");
        //Lista de las opciones correctas
        ArrayList<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add("si");
        opcionesCorrectas.add("totalmente");

        //Se crea la pregunta con la lista de opciones y la modalidad elegida.
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, opcionesCorrectas, new Clasico());

        assertEquals(opcionesCorrectas, preguntaTest.verRespuestaCorrecta());
    }
    @Test
    public void test03_2ResponderMultipleChoiceyAsignarPuntajesCorrectamente(){
        ArrayList<String> todas = new ArrayList<String>();
        todas.add("si");
        todas.add("totalmente");
        todas.add("no");
        todas.add("para nada");
        todas.add("nunca");
        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Sofia");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        //Lista de las opciones correctas.
        ArrayList<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add("si");
        opcionesCorrectas.add("totalmente");

        //Opciones elegidas por el Jugador 1.
        ArrayList<String> opcionesJugador1 = new ArrayList<String>();
        opcionesJugador1.add("si");
        opcionesJugador1.add("totalmente");

        //Opciones elegidas por el Jugador 2.
        ArrayList<String> opcionesJugador2 = new ArrayList<String>();
        opcionesJugador2.add("no");
        opcionesJugador2.add("para nada");

        //Se instancian las respuestas con la lista de opciones elegidas y el puntaje del jugador.
        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2, jugador2.puntaje());

        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        Clasico sinPenalidad = new Clasico(); //Modalidad de la pregunta

        //Se crea la pregunta con la lista de opciones y la modalidad elegida.
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, opcionesCorrectas, sinPenalidad);

        //Se pasan las respuestas de los jugadores a la pregunta.
        preguntaTest.responderPregunta(respuestas);

        assertEquals(1, jugador1.puntaje().getPuntaje());
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test03_3ResponderMultipleChoiceyAsignarPuntajesCorrectamenteConUnaDeDosBien(){
        ArrayList<String> todas = new ArrayList<String>();
        todas.add("si");
        todas.add("totalmente");
        todas.add("no");
        todas.add("para nada");
        todas.add("nunca");
        ArrayList<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add("si");
        opcionesCorrectas.add("totalmente");

        Jugador jugador1 = new Jugador("Federico");
        ArrayList<String> opcionesJugador1 = new ArrayList<String>();
        opcionesJugador1.add("si");

        Respuesta respuestaIncorrecta = new Respuesta(opcionesJugador1, jugador1.puntaje());

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaIncorrecta);
        Clasico sinPenalidad = new Clasico();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, opcionesCorrectas, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0, jugador1.puntaje().getPuntaje());
    }
    @Test
    public void test03_4ResponderMultipleChoiceyAsignarPuntajesCorrectamenteConUnaTodasBienYUnaMal(){
        ArrayList<String> todas = new ArrayList<String>();
        todas.add("si");
        todas.add("totalmente");
        todas.add("no");
        todas.add("para nada");
        todas.add("nunca");
        Jugador jugador2 = new Jugador("Sofia");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add("si");
        opcionesCorrectas.add("totalmente");
        ArrayList<String> opcionesJugador2 = new ArrayList<String>();
        opcionesJugador2.add("si");
        opcionesJugador2.add("totalmente");
        opcionesJugador2.add("no");
        Respuesta respuestaIncorrecta = new Respuesta(opcionesJugador2, jugador2.puntaje());
        respuestas.add(respuestaIncorrecta);
        Clasico sinPenalidad = new Clasico();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, opcionesCorrectas, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }
    */
}