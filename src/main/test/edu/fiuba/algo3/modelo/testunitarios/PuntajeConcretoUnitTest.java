package edu.fiuba.algo3.modelo.testunitarios;

import edu.fiuba.algo3.modelo.Multiplicador;
import edu.fiuba.algo3.modelo.puntaje.PuntajeConcreto;
import edu.fiuba.algo3.modelo.puntaje.PuntajeDecoratorMultiplicador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PuntajeConcretoUnitTest {

    @Test
    public void test01_CrearPuntaje(){
        PuntajeConcreto puntajeConcretoTest = new PuntajeConcreto();
        assertNotEquals(null, puntajeConcretoTest);
    }

    @Test
    public void test02_CalcularPuntaje(){
        PuntajeConcreto puntajeConcretoTest = new PuntajeConcreto();
        puntajeConcretoTest.calcularPuntaje(1);
        assertEquals(1, puntajeConcretoTest.getPuntaje());
    }

    @Test
    public void test03_CalcularPuntajeConMultiplicadorUsandoElDecorator(){
        PuntajeConcreto puntajeConcretoTest = new PuntajeConcreto();
        Multiplicador multiplicadorTest = new Multiplicador(2);
        PuntajeDecoratorMultiplicador decoratorTest = new PuntajeDecoratorMultiplicador(puntajeConcretoTest, multiplicadorTest);
        decoratorTest.calcularPuntaje(1);
        assertEquals(2, puntajeConcretoTest.getPuntaje());
    }
}
