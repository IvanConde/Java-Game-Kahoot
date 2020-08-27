package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.modalidades.ModalidadClasico;
import edu.fiuba.algo3.modelo.modalidades.ModalidadPenalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionBooleana;
import edu.fiuba.algo3.modelo.opciones.OpcionGroup;
import edu.fiuba.algo3.modelo.opciones.OpcionOrdered;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.OrderedChoice;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntasConTurnoTest {
    @Test
    public void test01_GroupChoiceConTurno() {

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
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Turno turno = new Turno(jugadores);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        ArrayList<String> grupos = new ArrayList<String>();
        grupos.add("0");
        grupos.add("1");
        GroupChoice preguntaTest = new GroupChoice("Colocar en el grupo 0 los numeros primos y en el grupo 1 los no-primos", opciones, grupos);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0, turno.getJugadorActual().puntaje().getPuntaje());
        turno.seCambiaJugador();
        assertEquals(1, turno.getJugadorActual().puntaje().getPuntaje());
    }

    @Test
    public void test02_MultipleChoiceConTurno(){

        OpcionBooleana opcion1 = new OpcionBooleana("Si",true);
        OpcionBooleana opcion2 = new OpcionBooleana("Totalmente",true);
        OpcionBooleana opcion3 = new OpcionBooleana("no",false);
        OpcionBooleana opcion4 = new OpcionBooleana("para nada",false);
        OpcionBooleana opcion5 = new OpcionBooleana("nunca",false);

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        todasLasOpciones.add(opcion3);
        todasLasOpciones.add(opcion4);
        todasLasOpciones.add(opcion5);

        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Sofia");

        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion1);
        opcionesJugador1.add(opcion2);

        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        opcionesJugador2.add(opcion3);
        opcionesJugador2.add(opcion4);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Turno turno = new Turno(jugadores);

        //Se instancian las respuestas con la lista de opciones elegidas y el puntaje del jugador.
        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2, jugador2.puntaje());

        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        ModalidadClasico sinPenalidad = new ModalidadClasico(); //Modalidad de la pregunta

        //Se crea la pregunta con la lista de opciones y la modalidad elegida.
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todasLasOpciones, sinPenalidad);

        //Se pasan las respuestas de los jugadores a la pregunta.
        preguntaTest.responderPregunta(respuestas);

        assertEquals(1, turno.getJugadorActual().puntaje().getPuntaje());
        turno.seCambiaJugador();
        assertEquals(0, turno.getJugadorActual().puntaje().getPuntaje());

    }

    @Test
    public void test03_OrderedChoiceConTurno(){

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
        opcion1.elegirPosicion(0, opcionesJugador1);
        opcion2.elegirPosicion(1, opcionesJugador1);
        opcion3.elegirPosicion(3, opcionesJugador1);
        opcion4.elegirPosicion(2, opcionesJugador1);
        opcion5.elegirPosicion(4, opcionesJugador1);

        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        opcion1.elegirPosicion(0, opcionesJugador2);
        opcion2.elegirPosicion(1, opcionesJugador2);
        opcion3.elegirPosicion(2, opcionesJugador2);
        opcion4.elegirPosicion(3, opcionesJugador2);
        opcion5.elegirPosicion(4, opcionesJugador2);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1,jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2,jugador2.puntaje());

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Turno turno = new Turno(jugadores);

        OrderedChoice preguntaTest = new OrderedChoice("Ordenar de menor a mayor", opciones);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0,turno.getJugadorActual().puntaje().getPuntaje());
        turno.seCambiaJugador();
        assertEquals(1, turno.getJugadorActual().puntaje().getPuntaje());

    }

    @Test
    public void test04_VerdaderoFalsoConTurno(){

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
        opcion1.elegirPosicion(0, opcionesJugador1);
        opcion2.elegirPosicion(1, opcionesJugador1);
        opcion3.elegirPosicion(3, opcionesJugador1);
        opcion4.elegirPosicion(2, opcionesJugador1);
        opcion5.elegirPosicion(4, opcionesJugador1);

        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        opcion1.elegirPosicion(0, opcionesJugador2);
        opcion2.elegirPosicion(1, opcionesJugador2);
        opcion3.elegirPosicion(2, opcionesJugador2);
        opcion4.elegirPosicion(3, opcionesJugador2);
        opcion5.elegirPosicion(4, opcionesJugador2);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1,jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2,jugador2.puntaje());

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Turno turno = new Turno(jugadores);

        OrderedChoice preguntaTest = new OrderedChoice("Ordenar de menor a mayor", opciones);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0,turno.getJugadorActual().puntaje().getPuntaje());
        turno.seCambiaJugador();
        assertEquals(1, turno.getJugadorActual().puntaje().getPuntaje());

    }

    @Test
    public void test02_4ResponderVerdaderoYFlasoConPenalidadDosJugadoresCorrectamenteEIncorrectamente() {

        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Jose");
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionBooleana opcionVerdadero = new OpcionBooleana("verdadero", true);
        OpcionBooleana opcionFalso = new OpcionBooleana("falso", false);
        todasLasOpciones.add(opcionVerdadero);
        todasLasOpciones.add(opcionFalso);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Opcion> opcionJugador1 = new ArrayList<Opcion>();
        opcionJugador1.add(opcionVerdadero);

        ArrayList<Opcion> opcionJugador2 = new ArrayList<Opcion>();
        opcionJugador2.add(opcionFalso);

        Respuesta respuestaJugador1 = new Respuesta(opcionJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionJugador2, jugador2.puntaje());
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Turno turno = new Turno(jugadores);

        ModalidadPenalidad conPenalidad = new ModalidadPenalidad();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1,turno.getJugadorActual().puntaje().getPuntaje());
        turno.seCambiaJugador();
        assertEquals(-1, turno.getJugadorActual().puntaje().getPuntaje());

    }

}
