package edu.fiuba.algo3.modelo.testUnitarios;
import edu.fiuba.algo3.modelo.Puntaje;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PuntajeUnitTest {

    @Test
    public void test01_CrearPuntaje(){

        Puntaje puntajeTest = new Puntaje();
        assertNotEquals(null, puntajeTest);

    }

    @Test
    public void test02_CalcularPuntajeSinMultiplicador(){

        Puntaje puntajeTest = new Puntaje();
        puntajeTest.modificarPuntaje(1);
        assertEquals(1, puntajeTest.getPuntaje());

    }

}