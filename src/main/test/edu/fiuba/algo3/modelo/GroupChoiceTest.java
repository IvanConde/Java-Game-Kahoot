package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.excepciones.GroupChoiceModalidadInvalidaException;
import edu.fiuba.algo3.modelo.modalidades.Clasico;
import edu.fiuba.algo3.modelo.modalidades.Parcial;
import edu.fiuba.algo3.modelo.modalidades.Penalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionEstructurada;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GroupChoiceTest {

    @Test
    public void test06_1SeCreaGroupChoiceConOpcionesEnGruposCorrectos() {

        //Ordenar en los grupos:
        //Grupo 0 = numeros primos
        //Grupo 1 = numeros no primos
        OpcionEstructurada opcion1 = new OpcionEstructurada("2", 0);
        OpcionEstructurada opcion2 = new OpcionEstructurada("8", 1);
        OpcionEstructurada opcion3 = new OpcionEstructurada("13", 0);
        OpcionEstructurada opcion4 = new OpcionEstructurada("12", 1);
        OpcionEstructurada opcion5 = new OpcionEstructurada("17", 0);

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
        opcion3.elegir(0, opcionesJugador);
        opcion4.elegir(1, opcionesJugador);
        opcion5.elegir(0, opcionesJugador);

        Respuesta respuesta = new Respuesta(opcionesJugador, jugador.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        GroupChoice preguntaTest = new GroupChoice("Colocar en el grupo 0 los numeros primos y en el grupo 1 los no-primos", opciones, new Clasico());
        preguntaTest.responderPregunta(respuestas);

        assertEquals(1, jugador.puntaje().getPuntaje());

    }

    @Test
    public void test06_2GroupChoiceConAlgunasOrdenadasCorrectamente() {

        //Ordenar en los grupos:
        //Grupo 0 = numeros primos
        //Grupo 1 = numeros no primos
        OpcionEstructurada opcion1 = new OpcionEstructurada("2", 0);
        OpcionEstructurada opcion2 = new OpcionEstructurada("8", 1);
        OpcionEstructurada opcion3 = new OpcionEstructurada("13", 0);
        OpcionEstructurada opcion4 = new OpcionEstructurada("12", 1);
        OpcionEstructurada opcion5 = new OpcionEstructurada("17", 0);

        Jugador jugador = new Jugador("Ivan");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        ArrayList<Opcion> opcionesJugador = new ArrayList<Opcion>();
        opcion1.elegir(1, opcionesJugador);
        opcion2.elegir(0, opcionesJugador);
        opcion3.elegir(0, opcionesJugador);
        opcion4.elegir(1, opcionesJugador);
        opcion5.elegir(0, opcionesJugador);

        Respuesta respuesta = new Respuesta(opcionesJugador, jugador.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        GroupChoice preguntaTest = new GroupChoice("Colocar en el grupo 0 los numeros primos y en el grupo 1 los no-primos", opciones, new Clasico());
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0, jugador.puntaje().getPuntaje());
    }

    @Test
    public void test06_3GroupChoiceConDosJugadoresConUnoTodasCorrectasYOtrasTodasIncorrectas() {

        //Ordenar en los grupos:
        //Grupo 0 = numeros primos
        //Grupo 1 = numeros no primos
        OpcionEstructurada opcion1 = new OpcionEstructurada("2", 0);
        OpcionEstructurada opcion2 = new OpcionEstructurada("8", 1);
        OpcionEstructurada opcion3 = new OpcionEstructurada("13", 0);
        OpcionEstructurada opcion4 = new OpcionEstructurada("12", 1);
        OpcionEstructurada opcion5 = new OpcionEstructurada("17", 0);

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
        opcion3.elegir(0, opcionesJugador1);
        opcion4.elegir(1, opcionesJugador1);
        opcion5.elegir(0, opcionesJugador1);

        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        opcion1.elegir(1, opcionesJugador1);
        opcion2.elegir(0, opcionesJugador1);
        opcion3.elegir(1, opcionesJugador1);
        opcion4.elegir(0, opcionesJugador1);
        opcion5.elegir(1, opcionesJugador1);

        Respuesta respuesta1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuesta2 = new Respuesta(opcionesJugador2, jugador2.puntaje());

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        GroupChoice preguntaTest = new GroupChoice("Colocar en el grupo 0 los numeros primos y en el grupo 1 los no-primos", opciones, new Clasico());
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0, jugador1.puntaje().getPuntaje());
        assertEquals(1, jugador2.puntaje().getPuntaje());

    }
}
/*
    @Test
    public void test06_4GroupChoiceConPenalidadLanzaExcepcion(){
        ArrayList <Opcion> opciones = new ArrayList<Opcion>();

        assertThrows(GroupChoiceModalidadInvalidaException.class,() -> {
            GroupChoice preguntaTest = new GroupChoice("Ordenar de menor a mayor", opciones, new Penalidad());
        });
    }


    @Test
    public void test06_5GroupChoiceConModalidadpParcialLanzaExcepcion(){
        ArrayList <Opcion> opciones = new ArrayList<Opcion>();

        assertThrows(GroupChoiceModalidadInvalidaException.class,() -> {
            GroupChoice preguntaTest = new GroupChoice("Ordenar de menor a mayor", opciones, new Parcial());
        });
    }

}
 */