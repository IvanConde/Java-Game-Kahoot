package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
public class MultipleChoiceClasicoTest {
    @Test
    public void test03_1CrearMultipleChoiceClasico() {
        //Lista de las opciones correctas.
        ArrayList<Integer> opcionesCorrectas = new ArrayList<Integer>();
        opcionesCorrectas.add(1);
        opcionesCorrectas.add(2);

        //Se crea la pregunta con la lista de opciones y la modalidad elegida.
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", opcionesCorrectas, new Clasico());

        assertEquals(opcionesCorrectas, preguntaTest.verRespuestaCorrecta());
    }

    @Test
    public void test03_2ResponderMultipleChoiceyAsignarPuntajesCorrectamente(){
        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Sofia");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        //Lista de las opciones correctas.
        ArrayList<Integer> opcionesCorrectas = new ArrayList<Integer>();
        opcionesCorrectas.add(1);
        opcionesCorrectas.add(2);

        //Opciones elegidas por el Jugador 1.
        ArrayList<Integer> opcionesJugador1 = new ArrayList<Integer>();
        opcionesJugador1.add(1);
        opcionesJugador1.add(2);

        //Opciones elegidas por el Jugador 2.
        ArrayList<Integer> opcionesJugador2 = new ArrayList<Integer>();
        opcionesJugador2.add(0);
        opcionesJugador2.add(3);

        //Se instancian las respuestas con la lista de opciones elegidas y el puntaje del jugador.
        Respuesta respuestaCorrecta = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuestaIncorrecta = new Respuesta(opcionesJugador2, jugador2.puntaje());

        respuestas.add(respuestaCorrecta);
        respuestas.add(respuestaIncorrecta);
        Clasico sinPenalidad = new Clasico(); //Modalidad de la pregunta

        //Se crea la pregunta con la lista de opciones y la modalidad elegida.
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", opcionesCorrectas, sinPenalidad);

        //Se pasan las respuestas de los jugadores a la pregunta.
        preguntaTest.responderPregunta(respuestas);

        assertEquals(1, jugador1.puntaje().getPuntaje());
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test03_3ResponderMultipleChoiceyAsignarPuntajesCorrectamenteConUnaDeDosBien(){
        ArrayList<Integer> opcionesCorrectas = new ArrayList<Integer>();
        opcionesCorrectas.add(1);
        opcionesCorrectas.add(2);

        Jugador jugador1 = new Jugador("Federico");
        ArrayList<Integer> opcionesJugador1 = new ArrayList<Integer>();
        opcionesJugador1.add(1);

        Respuesta respuestaIncorrecta = new Respuesta(opcionesJugador1, jugador1.puntaje());

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaIncorrecta);
        Clasico sinPenalidad = new Clasico();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", opcionesCorrectas, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0, jugador1.puntaje().getPuntaje());
    }
    @Test
    public void test03_4ResponderMultipleChoiceyAsignarPuntajesCorrectamenteConUnaTodasBienYUnaMal(){

        Jugador jugador2 = new Jugador("Sofia");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> opcionesCorrectas = new ArrayList<Integer>();
        opcionesCorrectas.add(1);
        opcionesCorrectas.add(2);
        ArrayList<Integer> opcionesJugador2 = new ArrayList<Integer>();
        opcionesJugador2.add(1);
        opcionesJugador2.add(2);
        opcionesJugador2.add(3);
        Respuesta respuestaIncorrecta = new Respuesta(opcionesJugador2, jugador2.puntaje());
        respuestas.add(respuestaIncorrecta);
        Clasico sinPenalidad = new Clasico();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", opcionesCorrectas, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }
}