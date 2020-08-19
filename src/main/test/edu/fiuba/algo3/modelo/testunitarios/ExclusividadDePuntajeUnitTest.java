package edu.fiuba.algo3.modelo.testunitarios;
import edu.fiuba.algo3.modelo.ExclusividadDePuntaje;
import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExclusividadDePuntajeUnitTest {

    @Test
    public void test01_CrearExclusividadDePuntaje(){

        ExclusividadDePuntaje exclusividadDePuntajeTest = new ExclusividadDePuntaje();
        assertNotEquals(null, exclusividadDePuntajeTest);

    }

    @Test
    public void test02_ActivarExlusividadUnaVezDeberiaCambiarSuEstadoDeACtivaciontrue(){

        ExclusividadDePuntaje exclusividadDePuntajeTest = new ExclusividadDePuntaje();
        assertEquals(false,exclusividadDePuntajeTest.verEstado());
        Jugador jugadorTest = new Jugador("test");
        exclusividadDePuntajeTest.activarExclusividad(jugadorTest);
        assertEquals(true, exclusividadDePuntajeTest.verEstado());

    }

    @Test
    public void test03_ActivarExclusividadMasDeUnaVezDeberiaDuplicarSuMagnitud(){

        ExclusividadDePuntaje exclusividadDePuntajeTest = new ExclusividadDePuntaje();
        Jugador jugadorTest = new Jugador("test");
        exclusividadDePuntajeTest.activarExclusividad(jugadorTest);
        exclusividadDePuntajeTest.activarExclusividad(jugadorTest);
        assertEquals(4, exclusividadDePuntajeTest.verMagnitud());

    }

}