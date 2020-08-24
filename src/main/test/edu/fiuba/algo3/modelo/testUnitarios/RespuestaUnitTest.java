package edu.fiuba.algo3.modelo.testUnitarios;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class RespuestaUnitTest {

    @Test
    public void test01_CrearRespuesta(){

        ArrayList<Opcion> RespuestasTest = new ArrayList<Opcion>();
        Puntaje puntajeTest = new Puntaje();
        Respuesta respuestaTest = new Respuesta(RespuestasTest, puntajeTest);
        assertNotEquals(null, respuestaTest);

    }

    @Test
    public void test02_ModificarPuntaje(){

        ArrayList<Opcion> RespuestasTest = new ArrayList<Opcion>();
        Puntaje puntajeTest = new Puntaje();
        Respuesta respuestaTest = new Respuesta(RespuestasTest, puntajeTest);
        assertEquals(0, puntajeTest.getPuntaje());
        respuestaTest.modificarPuntaje(1);
        assertEquals(1, puntajeTest.getPuntaje());

    }

}