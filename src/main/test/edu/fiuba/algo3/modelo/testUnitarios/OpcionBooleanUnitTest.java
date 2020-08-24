package edu.fiuba.algo3.modelo.testUnitarios;
import edu.fiuba.algo3.modelo.opciones.OpcionBooleana;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OpcionBooleanUnitTest {

    @Test
    public void test01_CrearInstanciaDeOpcionBoolean(){

        OpcionBooleana opcionTest= new OpcionBooleana("test", true);
        assertEquals(false, opcionTest == null);

    }

    @Test
    public void test02_esCorrectoConBooleanotrue(){

        OpcionBooleana opcionTest= new OpcionBooleana("test", true);
        assertEquals(true, opcionTest.esCorrecto());

    }

    @Test
    public void test03_esCorrectoConBooleanofalse(){

        OpcionBooleana opcionTest= new OpcionBooleana("test", false);
        assertEquals(false, opcionTest.esCorrecto());

    }

}