package edu.fiuba.algo3.modelo.testunitarios;

import edu.fiuba.algo3.modelo.Multiplicador;
import edu.fiuba.algo3.modelo.PuntajeConcreto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PuntajeConcretoUnitTest {

    @Test
    public void test01_CrearPuntaje(){
        PuntajeConcreto puntajeConcretoTest = new PuntajeConcreto();
        assertNotEquals(null, puntajeConcretoTest);
    }

    @Test
    public void test02_CalcularPuntajeSinMultiplicador(){
        PuntajeConcreto puntajeConcretoTest = new PuntajeConcreto();
        puntajeConcretoTest.calcularPuntaje(1);
        assertEquals(1, puntajeConcretoTest.getPuntaje());
    }

    @Test
    public void test03_CalcularPuntajeConMultiplicador(){
        PuntajeConcreto puntajeConcretoTest = new PuntajeConcreto();
        Multiplicador multiplicadorTest = new Multiplicador(2);
        puntajeConcretoTest.setMultiplicador(multiplicadorTest);
        puntajeConcretoTest.calcularPuntaje(1);
        assertEquals(2, puntajeConcretoTest.getPuntaje());
    }
}
