
package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
public class MultipleChoicePenalidadTest {

    @Test
    public void test05_1ResponderMultipleChoiceConPenalidadCorrectamenteUnJugadorTodoBienYOtroTodoMal(){
        Opcion opcion1 = new Opcion("Si",true);
        Opcion opcion2 = new Opcion("Totalmente",true);
        Opcion opcion3 = new Opcion("quizas",true);
        Opcion opcion4 = new Opcion("para nada",false);
        Opcion opcion5 = new Opcion("nunca",false);

        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        todas.add(opcion1);
        todas.add(opcion2);
        todas.add(opcion3);
        todas.add(opcion4);
        todas.add(opcion5);

        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Sofia");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        //Opciones elegidas por el Jugador 1.
        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion1);
        opcionesJugador1.add(opcion2);

        //Opciones elegidas por el Jugador 2.
        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        opcionesJugador2.add(opcion5);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2, jugador2.puntaje());
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        Penalidad conPenalidad = new Penalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(2, jugador1.puntaje().getPuntaje());
        assertEquals(-1, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test05_3ResponderMultipleChoiceConPenalidadUnaRespuestaCorrectaDeDos(){
        Opcion opcion1 = new Opcion("Si",true);
        Opcion opcion2 = new Opcion("Totalmente",true);
        Opcion opcion3 = new Opcion("quizas",true);
        Opcion opcion4 = new Opcion("para nada",false);
        Opcion opcion5 = new Opcion("nunca",false);

        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        todas.add(opcion1);
        todas.add(opcion2);
        todas.add(opcion3);
        todas.add(opcion4);
        todas.add(opcion5);

        Jugador jugador1 = new Jugador("Federico");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        //Opciones elegidas por el Jugador 1.
        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion1);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        Penalidad conPenalidad = new Penalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
    }
    @Test
    public void test05_4ResponderMultipleChoiceConPenalidadUnaCorrectaYUnaErroneaDeDos(){
         Opcion opcion1 = new Opcion("Si",true);
        Opcion opcion2 = new Opcion("Totalmente",true);
        Opcion opcion3 = new Opcion("quizas",true);
        Opcion opcion4 = new Opcion("para nada",false);
        Opcion opcion5 = new Opcion("nunca",false);

        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        todas.add(opcion1);
        todas.add(opcion2);
        todas.add(opcion3);
        todas.add(opcion4);
        todas.add(opcion5);

        Jugador jugador1 = new Jugador("Federico");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        //Opciones elegidas por el Jugador 1.
        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion1);
        opcionesJugador1.add(opcion4);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        Penalidad conPenalidad = new Penalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(0, jugador1.puntaje().getPuntaje());
    }
    @Test
    public void test05_5ResponderMultipleChoiceConPenalidadConDosJugadores(){
        Opcion opcion1 = new Opcion("Si",true);
        Opcion opcion2 = new Opcion("Totalmente",true);
        Opcion opcion3 = new Opcion("quizas",true);
        Opcion opcion4 = new Opcion("para nada",false);
        Opcion opcion5 = new Opcion("nunca",false);

        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        todas.add(opcion1);
        todas.add(opcion2);
        todas.add(opcion3);
        todas.add(opcion4);
        todas.add(opcion5);

        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Sofia");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        //Opciones elegidas por el Jugador 1.
        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion1);
        opcionesJugador1.add(opcion2);
        opcionesJugador1.add(opcion4);

        //Opciones elegidas por el Jugador 2.
        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        opcionesJugador2.add(opcion1);
        opcionesJugador2.add(opcion4);
        opcionesJugador2.add(opcion5);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2, jugador2.puntaje());
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        Penalidad conPenalidad = new Penalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
        assertEquals(-1, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test05_6ResponderMultipleChoiceConPenalidadUnaCorrectaYDosErroneasDeTres(){
        Opcion opcion1 = new Opcion("Si",true);
        Opcion opcion2 = new Opcion("Totalmente",true);
        Opcion opcion3 = new Opcion("quizas",true);
        Opcion opcion4 = new Opcion("para nada",false);
        Opcion opcion5 = new Opcion("nunca",false);

        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        todas.add(opcion1);
        todas.add(opcion2);
        todas.add(opcion3);
        todas.add(opcion4);
        todas.add(opcion5);

        Jugador jugador1 = new Jugador("Federico");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        //Opciones elegidas por el Jugador 1.
        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion1);
        opcionesJugador1.add(opcion4);
        opcionesJugador1.add(opcion5);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        Penalidad conPenalidad = new Penalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(-1, jugador1.puntaje().getPuntaje());
    }
}
