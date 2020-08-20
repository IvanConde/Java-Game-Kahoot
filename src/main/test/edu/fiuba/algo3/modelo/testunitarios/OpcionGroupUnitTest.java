package edu.fiuba.algo3.modelo.testunitarios;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionGroup;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class OpcionGroupUnitTest {

    @Test
    public void test01_CreaOpcionGroupConstructor1(){

        OpcionGroup opcionTest = new OpcionGroup("test", "test");
        assertNotEquals(null, opcionTest);

    }

    @Test
    public void test02_CrearOpcionGroupConstructor2(){

        OpcionGroup opcionTest = new OpcionGroup("test", "test", "test");
        assertNotEquals(null, opcionTest);

    }

    @Test
    public void test03_ElegirGroupo(){

        OpcionGroup opcionTest = new OpcionGroup("test", "test");
        ArrayList<Opcion> opcionesJugador = new ArrayList<Opcion>();
        opcionTest.elegirGrupo("test", opcionesJugador);
        assertEquals(1, opcionesJugador.size());

    }

    @Test
    public void test04_DevulveTrueCuandoGrupoOriginalEsIgualaGrupoJugador(){

        OpcionGroup opcionTest = new OpcionGroup("test", "test", "test");
        assertTrue(opcionTest.esCorrecto());

    }

    @Test
    public void test05_DevulveFalseCuandoGrupoOriginalEsDistintoAGrupoJugador(){

        OpcionGroup opcionTest = new OpcionGroup("test", "test", "tes");
        assertFalse(opcionTest.esCorrecto());

    }

}