package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.excepciones.GroupChoiceCantidadDeOpcionesEsIncorrectaException;
import edu.fiuba.algo3.modelo.excepciones.MultipleChoiceCantidadDeOpcionesEsIncorrectaException;
import edu.fiuba.algo3.modelo.modalidades.ModalidadClasico;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionBooleana;
import edu.fiuba.algo3.modelo.opciones.OpcionGroup;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
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
        OpcionGroup opcion1 = new OpcionGroup("2", "0");
        OpcionGroup opcion2 = new OpcionGroup("8", "1");
        OpcionGroup opcion3 = new OpcionGroup("13", "0");
        OpcionGroup opcion4 = new OpcionGroup("12", "1");
        OpcionGroup opcion5 = new OpcionGroup("17", "0");

        Jugador jugador = new Jugador("Ivan");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        ArrayList<Opcion> opcionesJugador = new ArrayList<Opcion>();
        opcion1.elegirGrupo("0", opcionesJugador);
        opcion2.elegirGrupo("1", opcionesJugador);
        opcion3.elegirGrupo("0", opcionesJugador);
        opcion4.elegirGrupo("1", opcionesJugador);
        opcion5.elegirGrupo("0", opcionesJugador);

        Respuesta respuesta = new Respuesta(opcionesJugador, jugador.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);
        ArrayList<String> grupos = new ArrayList<String>();
        grupos.add("0");
        grupos.add("1");
        GroupChoice preguntaTest = new GroupChoice("Colocar en el grupo 0 los numeros primos y en el grupo 1 los no-primos", opciones, grupos);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(1, jugador.puntaje().getPuntaje());

    }

    @Test
    public void test06_2GroupChoiceConAlgunasOrdenadasCorrectamente() {

        //Ordenar en los grupos:
        //Grupo 0 = numeros primos
        //Grupo 1 = numeros no primos
        OpcionGroup opcion1 = new OpcionGroup("2", "0");
        OpcionGroup opcion2 = new OpcionGroup("8", "1");
        OpcionGroup opcion3 = new OpcionGroup("13", "0");
        OpcionGroup opcion4 = new OpcionGroup("12", "1");
        OpcionGroup opcion5 = new OpcionGroup("17", "0");

        Jugador jugador = new Jugador("Ivan");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        ArrayList<Opcion> opcionesJugador = new ArrayList<Opcion>();
        opcion1.elegirGrupo("1", opcionesJugador);
        opcion2.elegirGrupo("0", opcionesJugador);
        opcion3.elegirGrupo("0", opcionesJugador);
        opcion4.elegirGrupo("1", opcionesJugador);
        opcion5.elegirGrupo("0", opcionesJugador);

        Respuesta respuesta = new Respuesta(opcionesJugador, jugador.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);
        ArrayList<String> grupos = new ArrayList<String>();
        grupos.add("0");
        grupos.add("1");
        GroupChoice preguntaTest = new GroupChoice("Colocar en el grupo 0 los numeros primos y en el grupo 1 los no-primos", opciones,grupos);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0, jugador.puntaje().getPuntaje());
    }

    @Test
    public void test06_3GroupChoiceConDosJugadoresConUnoTodasCorrectasYOtrasTodasIncorrectas() {

        //Ordenar en los grupos:
        //Grupo 0 = numeros primos
        //Grupo 1 = numeros no primos
        OpcionGroup opcion1 = new OpcionGroup("2", "0");
        OpcionGroup opcion2 = new OpcionGroup("8", "1");
        OpcionGroup opcion3 = new OpcionGroup("13", "0");
        OpcionGroup opcion4 = new OpcionGroup("12", "1");
        OpcionGroup opcion5 = new OpcionGroup("17", "0");

        Jugador jugador1 = new Jugador("Ivan");
        Jugador jugador2 = new Jugador("Enrique");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();

        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcion1.elegirGrupo("0", opcionesJugador1);
        opcion2.elegirGrupo("1", opcionesJugador1);
        opcion3.elegirGrupo("0", opcionesJugador1);
        opcion4.elegirGrupo("1", opcionesJugador1);
        opcion5.elegirGrupo("0", opcionesJugador1);

        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        opcion1.elegirGrupo("1", opcionesJugador1);
        opcion2.elegirGrupo("0", opcionesJugador1);
        opcion3.elegirGrupo("1", opcionesJugador1);
        opcion4.elegirGrupo("0", opcionesJugador1);
        opcion5.elegirGrupo("1", opcionesJugador1);

        Respuesta respuesta1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuesta2 = new Respuesta(opcionesJugador2, jugador2.puntaje());

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        ArrayList<String> grupos = new ArrayList<String>();
        grupos.add("0");
        grupos.add("1");
        GroupChoice preguntaTest = new GroupChoice("Colocar en el grupo 0 los numeros primos y en el grupo 1 los no-primos", opciones, grupos);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0, jugador1.puntaje().getPuntaje());
        assertEquals(1, jugador2.puntaje().getPuntaje());

    }

    @Test
    public void test06_5ResponderGroupChoiceyAsignarPuntajesCorrectamenteConExclusividadPuntajeActivadaParaUnJugador() {

        //Ordenar en los grupos:
        //Grupo 0 = numeros primos
        //Grupo 1 = numeros no primos
        OpcionGroup opcion1 = new OpcionGroup("2", "0");
        OpcionGroup opcion2 = new OpcionGroup("8", "1");
        OpcionGroup opcion3 = new OpcionGroup("13", "0");
        OpcionGroup opcion4 = new OpcionGroup("12", "1");
        OpcionGroup opcion5 = new OpcionGroup("17", "0");

        Jugador jugador1 = new Jugador("Ivan");
        Jugador jugador2 = new Jugador("Enrique");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();

        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcion1.elegirGrupo("0", opcionesJugador1);
        opcion2.elegirGrupo("1", opcionesJugador1);
        opcion3.elegirGrupo("0", opcionesJugador1);
        opcion4.elegirGrupo("1", opcionesJugador1);
        opcion5.elegirGrupo("0", opcionesJugador1);

        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        opcion1.elegirGrupo("1", opcionesJugador1);
        opcion2.elegirGrupo("0", opcionesJugador1);
        opcion3.elegirGrupo("1", opcionesJugador1);
        opcion4.elegirGrupo("0", opcionesJugador1);
        opcion5.elegirGrupo("1", opcionesJugador1);

        Respuesta respuesta1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuesta2 = new Respuesta(opcionesJugador2, jugador2.puntaje());

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        ArrayList<String> grupos = new ArrayList<String>();
        grupos.add("0");
        grupos.add("1");
        GroupChoice preguntaTest = new GroupChoice("Colocar en el grupo 0 los numeros primos y en el grupo 1 los no-primos", opciones, grupos);

        preguntaTest.usarExclusividad(jugador2);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0, jugador1.puntaje().getPuntaje());
        assertEquals(2, jugador2.puntaje().getPuntaje());

    }

    @Test
    public void test06_5ResponderGroupChoiceyAsignarPuntajesCorrectamenteConExclusividadPuntajeActivadaParaLosDosJugadores() {

        //Ordenar en los grupos:
        //Grupo 0 = numeros primos
        //Grupo 1 = numeros no primos
        OpcionGroup opcion1 = new OpcionGroup("2", "0");
        OpcionGroup opcion2 = new OpcionGroup("8", "1");
        OpcionGroup opcion3 = new OpcionGroup("13", "0");
        OpcionGroup opcion4 = new OpcionGroup("12", "1");
        OpcionGroup opcion5 = new OpcionGroup("17", "0");

        Jugador jugador1 = new Jugador("Ivan");
        Jugador jugador2 = new Jugador("Enrique");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();

        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcion1.elegirGrupo("0", opcionesJugador1);
        opcion2.elegirGrupo("1", opcionesJugador1);
        opcion3.elegirGrupo("0", opcionesJugador1);
        opcion4.elegirGrupo("1", opcionesJugador1);
        opcion5.elegirGrupo("0", opcionesJugador1);

        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        opcion1.elegirGrupo("1", opcionesJugador1);
        opcion2.elegirGrupo("0", opcionesJugador1);
        opcion3.elegirGrupo("1", opcionesJugador1);
        opcion4.elegirGrupo("0", opcionesJugador1);
        opcion5.elegirGrupo("1", opcionesJugador1);

        Respuesta respuesta1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuesta2 = new Respuesta(opcionesJugador2, jugador2.puntaje());

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        ArrayList<String> grupos = new ArrayList<String>();
        grupos.add("0");
        grupos.add("1");
        GroupChoice preguntaTest = new GroupChoice("Colocar en el grupo 0 los numeros primos y en el grupo 1 los no-primos", opciones, grupos);

        preguntaTest.usarExclusividad(jugador1);
        preguntaTest.usarExclusividad(jugador2);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0, jugador1.puntaje().getPuntaje());
        assertEquals(4, jugador2.puntaje().getPuntaje());

    }
    @Test
    public void test06_6OrderedChoiceConMasDeSeisOpcionesLanzaExcepcion(){

        OpcionGroup opcion1 = new OpcionGroup("2", "0");
        OpcionGroup opcion2 = new OpcionGroup("8", "1");
        OpcionGroup opcion3 = new OpcionGroup("13", "0");
        OpcionGroup opcion4 = new OpcionGroup("12", "1");
        OpcionGroup opcion5 = new OpcionGroup("17", "0");
        OpcionGroup opcion6 = new OpcionGroup("257", "0");
        OpcionGroup opcion7 = new OpcionGroup("1223", "0");

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        todasLasOpciones.add(opcion3);
        todasLasOpciones.add(opcion4);
        todasLasOpciones.add(opcion5);
        todasLasOpciones.add(opcion6);
        todasLasOpciones.add(opcion7);

        ArrayList<String> grupos = new ArrayList<String>();
        grupos.add("0");
        grupos.add("1");
        assertThrows(GroupChoiceCantidadDeOpcionesEsIncorrectaException.class, () ->
        { new GroupChoice("Colocar en el grupo 0 los numeros primos y en el grupo 1 los no-primos", todasLasOpciones, grupos);
        });



    }
    @Test
    public void test06_7GroupChoiceConMenosDeDosOpcionesLanzaExcepcion(){

        OpcionGroup opcion1 = new OpcionGroup("2", "0");

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        todasLasOpciones.add(opcion1);

        ArrayList<String> grupos = new ArrayList<String>();
        grupos.add("0");
        grupos.add("1");
        assertThrows(GroupChoiceCantidadDeOpcionesEsIncorrectaException.class, () ->
        { new GroupChoice("Colocar en el grupo 0 los numeros primos y en el grupo 1 los no-primos", todasLasOpciones, grupos);
        });
    }

}