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

        ArrayList<Opcion> opcionesJugador = new ArrayList<Opcion>();
        OpcionOrdered opcion1Jugador = new OpcionOrdered(opcion1.getStringOpcion(), opcion1.getPosicionOriginal(), 0);
        OpcionOrdered opcion2Jugador = new OpcionOrdered(opcion2.getStringOpcion(), opcion2.getPosicionOriginal(), 1);
        OpcionOrdered opcion3Jugador = new OpcionOrdered(opcion3.getStringOpcion(), opcion3.getPosicionOriginal(), 2);
        OpcionOrdered opcion4Jugador = new OpcionOrdered(opcion4.getStringOpcion(), opcion4.getPosicionOriginal(), 3);
        OpcionOrdered opcion5Jugador = new OpcionOrdered(opcion5.getStringOpcion(), opcion5.getPosicionOriginal(), 4);

        opcionesJugador.add(opcion1Jugador);
        opcionesJugador.add(opcion2Jugador);
        opcionesJugador.add(opcion3Jugador);
        opcionesJugador.add(opcion4Jugador);
        opcionesJugador.add(opcion5Jugador);

        Respuesta respuesta = new Respuesta(opcionesJugador,jugador.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        OrderedChoice preguntaTest = new OrderedChoice("Ordenar de menor a mayor", opciones);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(1,jugador.puntaje().getPuntaje());

    }

    @Test
    public void test06_2OrderedChoiceConAlgunasOrdenadasCorrectamente(){

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

        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        OpcionOrdered opcion1Jugador = new OpcionOrdered(opcion1.getStringOpcion(), opcion1.getPosicionOriginal(), 0);
        OpcionOrdered opcion2Jugador = new OpcionOrdered(opcion2.getStringOpcion(), opcion2.getPosicionOriginal(), 1);
        OpcionOrdered opcion3Jugador = new OpcionOrdered(opcion3.getStringOpcion(), opcion3.getPosicionOriginal(), 3);
        OpcionOrdered opcion4Jugador = new OpcionOrdered(opcion4.getStringOpcion(), opcion4.getPosicionOriginal(), 2);
        OpcionOrdered opcion5Jugador = new OpcionOrdered(opcion5.getStringOpcion(), opcion5.getPosicionOriginal(), 4);

        opcionesJugador1.add(opcion1Jugador);
        opcionesJugador1.add(opcion2Jugador);
        opcionesJugador1.add(opcion3Jugador);
        opcionesJugador1.add(opcion4Jugador);
        opcionesJugador1.add(opcion5Jugador);

        Respuesta respuesta = new Respuesta(opcionesJugador1,jugador.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        OrderedChoice preguntaTest = new OrderedChoice("Ordenar de menor a mayor", opciones);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0,jugador.puntaje().getPuntaje());

    }

    @Test
    public void test06_3OrderedChoiceConDosJugadoresConUnoTodasCorrectasYOtrasTodasIncorrectas(){

        //Ordenar de mayor a menor
        OpcionOrdered opcion1 = new OpcionOrdered("4",0);
        OpcionOrdered opcion2 = new OpcionOrdered("7",1);
        OpcionOrdered opcion3 = new OpcionOrdered("9",2);
        OpcionOrdered opcion4 = new OpcionOrdered("10",3);
        OpcionOrdered opcion5 = new OpcionOrdered("25",4);

        Jugador jugador1 = new Jugador("Ivan");
        Jugador jugador2 = new Jugador("Enrique");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        OpcionOrdered opcion1Jugador1 = new OpcionOrdered(opcion1.getStringOpcion(), opcion1.getPosicionOriginal(), 0);
        OpcionOrdered opcion2Jugador1 = new OpcionOrdered(opcion2.getStringOpcion(), opcion2.getPosicionOriginal(), 1);
        OpcionOrdered opcion3Jugador1 = new OpcionOrdered(opcion3.getStringOpcion(), opcion3.getPosicionOriginal(), 3);
        OpcionOrdered opcion4Jugador1 = new OpcionOrdered(opcion4.getStringOpcion(), opcion4.getPosicionOriginal(), 2);
        OpcionOrdered opcion5Jugador1 = new OpcionOrdered(opcion5.getStringOpcion(), opcion5.getPosicionOriginal(), 4);

        opcionesJugador1.add(opcion1Jugador1);
        opcionesJugador1.add(opcion2Jugador1);
        opcionesJugador1.add(opcion3Jugador1);
        opcionesJugador1.add(opcion4Jugador1);
        opcionesJugador1.add(opcion5Jugador1);

        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        OpcionOrdered opcion1Jugador2 = new OpcionOrdered(opcion1.getStringOpcion(), opcion1.getPosicionOriginal(), 0);
        OpcionOrdered opcion2Jugador2 = new OpcionOrdered(opcion2.getStringOpcion(), opcion2.getPosicionOriginal(), 1);
        OpcionOrdered opcion3Jugador2 = new OpcionOrdered(opcion3.getStringOpcion(), opcion3.getPosicionOriginal(), 3);
        OpcionOrdered opcion4Jugador2 = new OpcionOrdered(opcion4.getStringOpcion(), opcion4.getPosicionOriginal(), 2);
        OpcionOrdered opcion5Jugador2 = new OpcionOrdered(opcion5.getStringOpcion(), opcion5.getPosicionOriginal(), 4);

        opcionesJugador1.add(opcion1Jugador2);
        opcionesJugador1.add(opcion2Jugador2);
        opcionesJugador1.add(opcion3Jugador2);
        opcionesJugador1.add(opcion4Jugador2);
        opcionesJugador1.add(opcion5Jugador2);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1,jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2,jugador2.puntaje());

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        OrderedChoice preguntaTest = new OrderedChoice("Ordenar de menor a mayor", opciones);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0,jugador1.puntaje().getPuntaje());

    }

}