
package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
public class MultipleChoiceParcialTest {
    @Test
    public void test04_1ResponderMultipleChoiceConParcialUnJugadorTodoCorrectoYOtroTodoIncorrecto(){
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
        opcionesJugador1.add(opcion3);

        //Opciones elegidas por el Jugador 2.
        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        opcionesJugador2.add(opcion3);
        opcionesJugador2.add(opcion4);
        opcionesJugador2.add(opcion5);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2, jugador2.puntaje());
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        Parcial conPenalidadParcial = new Parcial();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, conPenalidadParcial);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(3, jugador1.puntaje().getPuntaje());
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test04_2ResponderMultipleChoiceConParcialUnJugadorParcialmenteCorrecto(){
        Opcion opcion1 = new Opcion("Si",true);
        Opcion opcion2 = new Opcion("Totalmente",true);
        Opcion opcion3 = new Opcion("quizas",false);
        Opcion opcion4 = new Opcion("no",false);
        Opcion opcion5 = new Opcion("nunca",false);

        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        todas.add(opcion1);
        todas.add(opcion2);
        todas.add(opcion3);
        todas.add(opcion4);
        todas.add(opcion5);

        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Sofia");

        //Opciones elegidas por el Jugador 1.
        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion1);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);

        Parcial conPenalidadParcial = new Parcial();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, conPenalidadParcial);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
    }
    @Test
    public void test04_3ResponderMultipleChoiceConParcialConDosJugadores(){
        Opcion opcion1 = new Opcion("Si",true);
        Opcion opcion2 = new Opcion("Totalmente",true);
        Opcion opcion3 = new Opcion("quizas",false);
        Opcion opcion4 = new Opcion("no",false);
        Opcion opcion5 = new Opcion("nunca",false);

        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        todas.add(opcion1);
        todas.add(opcion2);
        todas.add(opcion3);
        todas.add(opcion4);
        todas.add(opcion5);

        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Sofia");

        //Opciones elegidas por el Jugador 1.
        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion3);

        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        opcionesJugador2.add(opcion1);
        opcionesJugador2.add(opcion2);


        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2, jugador2.puntaje());

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        Parcial conPenalidadParcial = new Parcial();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, conPenalidadParcial);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(0, jugador1.puntaje().getPuntaje());
        assertEquals(2, jugador2.puntaje().getPuntaje());
    }

}