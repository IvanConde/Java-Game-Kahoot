package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Turno;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TurnoUnitTest {
    static final int CANTJUGADORES = 2;
    private Jugador jugador1 = new Jugador("Lucas");
    private Jugador jugador2 = new Jugador("Nicolas");
    private ArrayList <Jugador> jugadores = new ArrayList<>();

    void guardarJugadores(){
        this.jugadores.add(jugador1);
        this.jugadores.add(jugador2);
    }

    @Test
    public void test01_CrearTurno(){
        Turno turno = new Turno(this.jugadores);
        assertNotEquals(null, turno);
    }

    @Test
    public void test02_turnoDevuelveElPrimerJugador(){
        guardarJugadores();
        Turno turno = new Turno(jugadores);

        assertEquals(jugador1, turno.getJugadorActual());
    }
    @Test
    public void test03_turnoDevuelveElSegundoJugador() {
        guardarJugadores();
        Turno turno = new Turno(jugadores);
        turno.seCambiaJugador(); //Chequea si los dos jugadores ya contestaron la pregunta
        assertEquals(jugador2, turno.getJugadorActual());
    }

    @Test
    public void test04_turnoVuelveADevolverAlPrimerJugadorDespuesDeTerminarLaPregunta() {
        guardarJugadores();
        Turno turno = new Turno(jugadores);
        for(int i = 0; i<CANTJUGADORES; i++) {
            turno.seCambiaJugador(); //Chequea si los dos jugadores ya contestaron la pregunta
        }
        assertEquals(jugador1, turno.getJugadorActual());
    }
}
