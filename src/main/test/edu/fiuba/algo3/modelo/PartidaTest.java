package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.modalidades.ModalidadClasico;
import edu.fiuba.algo3.modelo.modalidades.ModalidadParcial;
import edu.fiuba.algo3.modelo.modalidades.ModalidadPenalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionBooleana;
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
}
