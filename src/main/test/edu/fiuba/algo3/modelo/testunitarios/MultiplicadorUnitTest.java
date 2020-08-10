package edu.fiuba.algo3.modelo.testunitarios;
import edu.fiuba.algo3.modelo.Multiplicador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MultiplicadorUnitTest {
    @Test
    public void test01_CrearMultiplicador(){
        Multiplicador multiplicadorTest = new Multiplicador(2);
        assertNotEquals(null, multiplicadorTest);
    }

    @Test
    public void test02_MultiplicarPuntos(){
        Multiplicador multiplicadorTest = new Multiplicador(2);
        int puntosTest = multiplicadorTest.multiplicarPuntos(1);
        assertEquals(2, puntosTest);
    }

    @Test
    public void test03_ConfirmarQueElObjetoSeModifico(){
        Multiplicador multiplicadorTest = new Multiplicador(2);
        assertEquals(false, multiplicadorTest.seUtilizo());
        multiplicadorTest.multiplicarPuntos(1);
        assertEquals(true, multiplicadorTest.seUtilizo());
    }
}
