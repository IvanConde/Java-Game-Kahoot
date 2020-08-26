package edu.fiuba.algo3.modelo.testUnitarios;
import edu.fiuba.algo3.modelo.modificadoresDePuntaje.ModificadorMultiplicador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ModificadorMultiplicadorUnitTest {

    @Test
    public void test01_CrearMultiplicador(){

        ModificadorMultiplicador modificadorMultiplicadorTest = new ModificadorMultiplicador(2);
        assertNotEquals(null, modificadorMultiplicadorTest);

    }

    @Test
    public void test02_MultiplicarPuntos(){

        ModificadorMultiplicador modificadorMultiplicadorTest = new ModificadorMultiplicador(2);
        int puntosTest = modificadorMultiplicadorTest.modificarPuntos(1, 0);
        assertEquals(2, puntosTest);

    }

    @Test
    public void test03_ConfirmarQueElObjetoSeModifico(){

        ModificadorMultiplicador modificadorMultiplicadorTest = new ModificadorMultiplicador(2);
        assertEquals(false, modificadorMultiplicadorTest.seUtilizo());
        modificadorMultiplicadorTest.modificarPuntos(1, 0);
        assertEquals(true, modificadorMultiplicadorTest.seUtilizo());

    }

}