package edu.fiuba.algo3.modelo.testunitarios;
import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JugadorUnitTest {

    @Test
    public void test01_CrearJugador(){

      Jugador jugadorTest = new Jugador("Test");
      assertNotEquals(null, jugadorTest);

    }

    @Test
    public void test02_ActivarExclusividadCuandoAunTieneUsosDevulveTrue(){

        Jugador jugadorTest = new Jugador("Test");
        assertEquals(true, jugadorTest.activarExclusividad());

    }

    @Test
    public void test03_ActivarExclusividadCuandoNoTieneUsosDevulveFalse(){

        Jugador jugadorTest = new Jugador("Test");
        jugadorTest.activarExclusividad();
        jugadorTest.activarExclusividad();
        assertEquals(false, jugadorTest.activarExclusividad());

    }

}