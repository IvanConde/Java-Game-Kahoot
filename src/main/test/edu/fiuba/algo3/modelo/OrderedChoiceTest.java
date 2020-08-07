package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.excepciones.OrderedChoiceModalidadInvalidaException;
import edu.fiuba.algo3.modelo.modalidades.Clasico;
import edu.fiuba.algo3.modelo.modalidades.Parcial;
import edu.fiuba.algo3.modelo.modalidades.Penalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionEstructurada;
import edu.fiuba.algo3.modelo.preguntas.OrderedChoice;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderedChoiceTest {

    @Test
    public void test06_1SeCreaOrderedChoiceConOpcionesOrdenadasCorrectamente(){

        //Ordenar de mayor a menor
        OpcionEstructurada opcion1 = new OpcionEstructurada("4",0);
        OpcionEstructurada opcion2 = new OpcionEstructurada("7",1);
        OpcionEstructurada opcion3 = new OpcionEstructurada("9",2);
        OpcionEstructurada opcion4 = new OpcionEstructurada("10",3);
        OpcionEstructurada opcion5 = new OpcionEstructurada("25",4);

        Jugador jugador = new Jugador("Ivan");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        ArrayList<Opcion> opcionesJugador = new ArrayList<Opcion>();
        opcion1.elegir(0, opcionesJugador);
        opcion2.elegir(1, opcionesJugador);
        opcion3.elegir(2, opcionesJugador);
        opcion4.elegir(3, opcionesJugador);
        opcion5.elegir(4, opcionesJugador);

        Respuesta respuesta = new Respuesta(opcionesJugador,jugador.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        OrderedChoice preguntaTest = new OrderedChoice("Ordenar de menor a mayor", opciones, new Clasico());
        preguntaTest.responderPregunta(respuestas);

        assertEquals(1,jugador.puntaje().getPuntaje());

    }

    @Test
    public void test06_2OrderedChoiceConAlgunasOrdenadasCorrectamente(){

        //Ordenar de mayor a menor
        OpcionEstructurada opcion1 = new OpcionEstructurada("4",0);
        OpcionEstructurada opcion2 = new OpcionEstructurada("7",1);
        OpcionEstructurada opcion3 = new OpcionEstructurada("9",2);
        OpcionEstructurada opcion4 = new OpcionEstructurada("10",3);
        OpcionEstructurada opcion5 = new OpcionEstructurada("25",4);

        Jugador jugador = new Jugador("Ivan");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcion1.elegir(0, opcionesJugador1);
        opcion2.elegir(1, opcionesJugador1);
        opcion3.elegir(3, opcionesJugador1);
        opcion4.elegir(2, opcionesJugador1);
        opcion5.elegir(4, opcionesJugador1);

        Respuesta respuesta = new Respuesta(opcionesJugador1,jugador.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        OrderedChoice preguntaTest = new OrderedChoice("Ordenar de menor a mayor", opciones, new Clasico());
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0,jugador.puntaje().getPuntaje());

    }

    @Test
    public void test06_3OrderedChoiceConDosJugadoresConUnoTodasCorrectasYOtrasTodasIncorrectas(){

        //Ordenar de mayor a menor
        OpcionEstructurada opcion1 = new OpcionEstructurada("4",0);
        OpcionEstructurada opcion2 = new OpcionEstructurada("7",1);
        OpcionEstructurada opcion3 = new OpcionEstructurada("9",2);
        OpcionEstructurada opcion4 = new OpcionEstructurada("10",3);
        OpcionEstructurada opcion5 = new OpcionEstructurada("25",4);

        Jugador jugador1 = new Jugador("Ivan");
        Jugador jugador2 = new Jugador("Enrique");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcion1.elegir(0, opcionesJugador1);
        opcion2.elegir(1, opcionesJugador1);
        opcion3.elegir(3, opcionesJugador1);
        opcion4.elegir(2, opcionesJugador1);
        opcion5.elegir(4, opcionesJugador1);

        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        opcion1.elegir(0, opcionesJugador2);
        opcion2.elegir(1, opcionesJugador2);
        opcion3.elegir(2, opcionesJugador2);
        opcion4.elegir(3, opcionesJugador2);
        opcion5.elegir(4, opcionesJugador2);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1,jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2,jugador2.puntaje());

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        OrderedChoice preguntaTest = new OrderedChoice("Ordenar de menor a mayor", opciones,new Clasico());
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0,jugador1.puntaje().getPuntaje());
        assertEquals(1, jugador2.puntaje().getPuntaje());

    }
/*
    @Test
    public void test06_4OrderedChoiceConPenalidadLanzaExcepcion(){
        ArrayList <Opcion> opciones = new ArrayList<Opcion>();

        assertThrows(OrderedChoiceModalidadInvalidaException.class,() -> {
            OrderedChoice preguntaTest = new OrderedChoice("Ordenar de menor a mayor", opciones, new Penalidad());
        });
    }


    @Test
    public void test06_5OrderedChoiceConModalidadpParcialLanzaExcepcion(){
        ArrayList <Opcion> opciones = new ArrayList<Opcion>();

        assertThrows(OrderedChoiceModalidadInvalidaException.class,() -> {
            OrderedChoice preguntaTest = new OrderedChoice("Ordenar de menor a mayor", opciones, new Parcial());
        });
    }
 */

}