package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.modalidades.ModalidadClasico;
import edu.fiuba.algo3.modelo.modalidades.ModalidadParcial;
import edu.fiuba.algo3.modelo.modalidades.ModalidadPenalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionBooleana;
import edu.fiuba.algo3.modelo.opciones.OpcionGroup;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartidaTest {
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private Jugador jugador1 = new Jugador("Lucas");
    private Jugador jugador2 = new Jugador("Nicolas");

    private void guardarJugadores(){
        this.jugadores.add(jugador1);
        this.jugadores.add(jugador2);
    }

    @Test
    public void test01_VerdaderoFalsoEnPartidaConModalidadClasica() {
        guardarJugadores();
        Partida partida = new Partida(jugadores);
        ModalidadClasico modalidad = new ModalidadClasico();
        ArrayList<Opcion> todas = new ArrayList<>();
        OpcionBooleana opcion = new OpcionBooleana("",true);
        OpcionBooleana opcion2 = new OpcionBooleana("",false);
        todas.add(opcion);
        todas.add(opcion2);
        VerdaderoFalso pregunta = new VerdaderoFalso("", todas, modalidad);
        partida.setPreguntaActual(pregunta);
        partida.agregarRespuestaJugador(opcion, jugador1);
        partida.responderPregunta();
        assertEquals(1, jugador1.puntaje().getPuntaje());
    }

    @Test
    public void test02_VerdaderoFalsoConPenalidadYOpcionIncorrecta() {
        guardarJugadores();
        Partida partida = new Partida(jugadores);
        ModalidadPenalidad modalidad = new ModalidadPenalidad();
        ArrayList<Opcion> todas = new ArrayList<>();
        OpcionBooleana opcion = new OpcionBooleana("",true);
        OpcionBooleana opcion2 = new OpcionBooleana("",false);
        todas.add(opcion);
        todas.add(opcion2);
        VerdaderoFalso pregunta = new VerdaderoFalso("", todas, modalidad);
        partida.setPreguntaActual(pregunta);
        partida.agregarRespuestaJugador(opcion2, jugador1);
        partida.responderPregunta();
        assertEquals(-1, jugador1.puntaje().getPuntaje());
    }

    @Test
    public void test03_MultipleChoiceConParcialYDosOpcionesCorrectasParaJugador1EIncorrectasParaJugador2() {
        guardarJugadores();
        Partida partida = new Partida(jugadores);
        ModalidadParcial modalidad = new ModalidadParcial();
        ArrayList<Opcion> todas = new ArrayList<>();
        OpcionBooleana opcion = new OpcionBooleana("",true);
        OpcionBooleana opcion2 = new OpcionBooleana("",false);
        OpcionBooleana opcion3 = new OpcionBooleana("",true);
        todas.add(opcion);
        todas.add(opcion2);
        todas.add(opcion3);
        MultipleChoice pregunta = new MultipleChoice("", todas, modalidad);
        partida.setPreguntaActual(pregunta);
        partida.agregarRespuestaJugador(opcion, jugador1);
        partida.agregarRespuestaJugador(opcion3,jugador1);
        partida.agregarRespuestaJugador(opcion2, jugador2);
        partida.responderPregunta();
        assertEquals(2, jugador1.puntaje().getPuntaje());
        assertEquals(0,jugador2.puntaje().getPuntaje());
    }

    @Test
    public void test06_1SeCreaGroupChoiceConOpcionesEnGruposCorrectosYSeGuardanLasRespuestasConPartida() {

        //Ordenar en los grupos:
        //Grupo 0 = numeros primos
        //Grupo 1 = numeros no primos
        ArrayList<Opcion> todas = new ArrayList<>();
        OpcionGroup opcion1 = new OpcionGroup("2", "0");
        OpcionGroup opcion2 = new OpcionGroup("8", "1");
        OpcionGroup opcion3 = new OpcionGroup("13", "0");
        OpcionGroup opcion4 = new OpcionGroup("12", "1");
        OpcionGroup opcion5 = new OpcionGroup("17", "0");
        todas.add(opcion1);
        todas.add(opcion2);
        todas.add(opcion3);
        todas.add(opcion4);
        todas.add(opcion5);

        ArrayList<String> grupos = new ArrayList<>();
        grupos.add("0");
        grupos.add("1");

        guardarJugadores();
        Partida partida = new Partida(jugadores);
        partida.agregarRespuestaGroup(opcion1, jugador1, "0");
        partida.agregarRespuestaGroup(opcion2, jugador1, "1");
        partida.agregarRespuestaGroup(opcion3, jugador1, "0");
        partida.agregarRespuestaGroup(opcion4, jugador1, "1");
        partida.agregarRespuestaGroup(opcion5, jugador1, "0");

        GroupChoice preguntaTest = new GroupChoice("Colocar en el grupo 0 los numeros primos y en el grupo 1 los no-primos", todas, grupos);
        partida.setPreguntaActual(preguntaTest);
        partida.responderPregunta();
        assertEquals(1, jugador1.puntaje().getPuntaje());

    }
}
