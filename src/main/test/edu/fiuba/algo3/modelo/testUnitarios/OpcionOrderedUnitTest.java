package edu.fiuba.algo3.modelo.testUnitarios;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionOrdered;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class OpcionOrderedUnitTest {

    @Test
    public void test01_CrearOpcionOrderedConstructor1(){

        OpcionOrdered opcionTest = new OpcionOrdered("0", 0);
        assertNotEquals(null, opcionTest);

    }

    @Test
    public void test02_CrearOpcionConstructor2(){

        OpcionOrdered opcionTest = new OpcionOrdered("0", 0, 0);
        assertNotEquals(null, opcionTest);

    }

    @Test
    public void test03_ElegirPosicion() {

        OpcionOrdered opcionTest = new OpcionOrdered("0", 0);
        ArrayList<Opcion> opcionesJugador = new ArrayList<Opcion>();
        opcionTest.elegirPosicion(0, opcionesJugador);
        assertEquals(1, opcionesJugador.size());

    }

    @Test
    public void test04_DevulveTrueCuandoPosicionOriginalEsIgualaPosicionJugador(){

        OpcionOrdered opcionTest = new OpcionOrdered("test", 0, 0);
        assertTrue(opcionTest.esCorrecto());

    }

    @Test
    public void test05_DevulveFalseCuandoPosicionOriginalEsDistintoAPosicionJugador(){

        OpcionOrdered opcionTest = new OpcionOrdered("test", 0, 1);
        assertFalse(opcionTest.esCorrecto());

    }

}