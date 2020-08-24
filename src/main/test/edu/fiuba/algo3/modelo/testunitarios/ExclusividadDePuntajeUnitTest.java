package edu.fiuba.algo3.modelo.testunitarios;

import edu.fiuba.algo3.modelo.exclusividad.ExclusividadNulo;
import edu.fiuba.algo3.modelo.exclusividad.ExclusividadPuntaje;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ExclusividadDePuntajeUnitTest {

    @Test
    public void test01_CrearExclusividadDePuntaje(){

        ExclusividadPuntaje exclusividadDePuntajeTest = new ExclusividadPuntaje(new ExclusividadNulo());
        assertNotEquals(null, exclusividadDePuntajeTest);

    }

    @Test
    public void test03_ActivarExclusividadMasDeUnaVezDeberiaDuplicarSuMagnitud(){

        ExclusividadPuntaje exclusividadDePuntajeTest = new ExclusividadPuntaje(new ExclusividadPuntaje(new ExclusividadNulo()));
        assertEquals(4, exclusividadDePuntajeTest.verMagnitud());

    }

}