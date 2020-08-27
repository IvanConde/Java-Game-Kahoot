package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.CicloPreguntas;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CicloPreguntaUnitTest {

    @Test
    public void test01_CrearCicloPreguntas(){
        CicloPreguntas ciclo = new CicloPreguntas();
        assertNotEquals(null, ciclo);
    }

    @Test
    public void test02_seCrean10Preguntas(){
        CicloPreguntas ciclo = new CicloPreguntas();
        ciclo.setCantPreguntas(10);
        assertEquals(10,ciclo.getCantPreguntas());
    }

    @Test
    public void test03_seObtieneUnaPregunta(){
        CicloPreguntas ciclo = new CicloPreguntas();

        assertTrue(ciclo.obtenerPreguntaAleatoria() instanceof Pregunta);
    }

}
