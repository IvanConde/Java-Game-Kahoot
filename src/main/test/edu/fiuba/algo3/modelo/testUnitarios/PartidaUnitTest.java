package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionBooleana;
import edu.fiuba.algo3.modelo.opciones.OpcionGroup;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PartidaUnitTest {
    static final int CANTJUGADORES = 2;
    private Jugador jugador1 = new Jugador("Lucas");
    private Jugador jugador2 = new Jugador("Nicolas");
    private ArrayList<Jugador> jugadores = new ArrayList<>();

    private void guardarJugadores(){
        this.jugadores.add(jugador1);
        this.jugadores.add(jugador2);
    }

    @Test
    public void test01_CrearPartida(){
        Partida partida = new Partida(jugadores);
        assertNotEquals(null, partida);
    }

    @Test
    public void test02_partidaDevuelveElPrimerJugador(){
        guardarJugadores();
        Partida partida = new Partida(jugadores);
        assertEquals(jugador1, partida.obtenerJugadorActual());
    }
    @Test
    public void test03_NoSeContestoPregunta() {
        guardarJugadores();
        Partida partida = new Partida(jugadores);

        assertEquals(false, partida.seContestoPregunta());
    }

    @Test
    public void test04_PartidaVuelveADevolverAlPrimerJugadorDespuesDeTerminarLaPregunta() {
        guardarJugadores();
        Partida partida = new Partida(jugadores);
        for(int i = 0; i<CANTJUGADORES; i++) {
            partida.seContestoPregunta(); //Chequea si los dos jugadores ya contestaron la pregunta
        }
        assertEquals(jugador1, partida.obtenerJugadorActual());
    }

    @Test
    public void test05_SiNoSeContestoPreguntaCambiaAlJugador2() {
        guardarJugadores();
        Partida partida = new Partida(jugadores);
        partida.seContestoPregunta();
        assertEquals(jugador2, partida.obtenerJugadorActual());
    }

    @Test
    public void test06_SeGuardaLaOpcionEnOpciones() {
        guardarJugadores();
        Partida partida = new Partida(jugadores);
        ArrayList<Opcion> opciones = new ArrayList<>();
        OpcionBooleana opcion = new OpcionBooleana("",true);
        partida.agregarRespuesta(opciones, opcion);
        assertEquals(opcion, opciones.get(0));
    }
}