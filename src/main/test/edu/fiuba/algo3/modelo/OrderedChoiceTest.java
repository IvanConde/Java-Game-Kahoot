package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderedChoiceTest {
    @Test
    public void test06_1SeCreaOrderedChoiceConOpcionesOrdenadasCorrectamente(){
        //Ordenar de mayor a menor
        OpcionOrdered opcion1 = new OpcionOrdered("4",0);
        OpcionOrdered opcion2 = new OpcionOrdered("7",1);
        OpcionOrdered opcion3 = new OpcionOrdered("9",2);
        OpcionOrdered opcion4 = new OpcionOrdered("10",3);
        OpcionOrdered opcion5 = new OpcionOrdered("25",4);

        Jugador jugador = new Jugador("Ivan");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        opcion1.setPosicionJugador(0);
        opcion2.setPosicionJugador(1);
        opcion3.setPosicionJugador(2);
        opcion4.setPosicionJugador(3);
        opcion5.setPosicionJugador(4);

        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        OpcionOrdered opcion1Jugador1 = new OpcionOrdered(opcion1.getStringOpcion(), opcion1.getPosicionOriginal(), 0);
        OpcionOrdered opcion2Jugador1 = new OpcionOrdered(opcion2.getStringOpcion(), opcion2.getPosicionOriginal(), 1);
        OpcionOrdered opcion3Jugador1 = new OpcionOrdered(opcion3.getStringOpcion(), opcion3.getPosicionOriginal(), 2);
        OpcionOrdered opcion4Jugador1 = new OpcionOrdered(opcion4.getStringOpcion(), opcion4.getPosicionOriginal(), 3);
        OpcionOrdered opcion5Jugador1 = new OpcionOrdered(opcion5.getStringOpcion(), opcion5.getPosicionOriginal(), 4);

        Respuesta respuesta = new Respuesta(opcionesJugador1,jugador.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        OrderedChoice preguntaTest = new OrderedChoice("Ordenar de menor a mayor", opciones);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(1,jugador.puntaje().getPuntaje());
    }
/*
    @Test
    public void test06_2OrderedChoiceConAlgunasOrdenadasCorrectamente(){
        //Ordenar de mayor a menor
        Opcion opcion1 = new Opcion("4",0);
        Opcion opcion2 = new Opcion("7",1);
        Opcion opcion3 = new Opcion("9",2);
        Opcion opcion4 = new Opcion("10",3);
        Opcion opcion5 = new Opcion("25",4);

        Jugador jugador = new Jugador("Ivan");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        opcion1.setPosicionJugador(0);
        opcion2.setPosicionJugador(1);
        opcion3.setPosicionJugador(3);
        opcion4.setPosicionJugador(2);
        opcion5.setPosicionJugador(4);

        Respuesta respuesta = new Respuesta(opciones,jugador.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        OrderedChoice preguntaTest = new OrderedChoice("Ordenar de menor a mayor", opciones);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0,jugador.puntaje().getPuntaje());
    }

    @Test
    public void test06_3OrderedChoiceConDosJugadoresConUnoTodasCorrectasYOtrasTodasIncorrectas(){
        //Ordenar de mayor a menor
        Opcion opcion1 = new Opcion("4",0);
        Opcion opcion2 = new Opcion("7",1);
        Opcion opcion3 = new Opcion("9",2);
        Opcion opcion4 = new Opcion("10",3);
        Opcion opcion5 = new Opcion("25",4);

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);



        Jugador jugador1 = new Jugador("Ivan");
        Jugador jugador2 = new Jugador("Enrique");

        opcion1.setPosicionJugador(0);
        opcion2.setPosicionJugador(1);
        opcion3.setPosicionJugador(3);
        opcion4.setPosicionJugador(2);
        opcion5.setPosicionJugador(4);

        Respuesta respuesta1 = new Respuesta(opciones,jugador1.puntaje());
        Respuesta respuesta2 = new Respuesta(opciones,jugador2.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        OrderedChoice preguntaTest = new OrderedChoice("Ordenar de menor a mayor", opciones);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0,jugador1.puntaje().getPuntaje());
    }

 */
}
