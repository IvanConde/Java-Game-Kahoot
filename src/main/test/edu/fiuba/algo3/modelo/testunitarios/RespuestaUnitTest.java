package edu.fiuba.algo3.modelo.testunitarios;

import edu.fiuba.algo3.modelo.puntaje.PuntajeConcreto;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class RespuestaUnitTest {
    @Test
    public void test01_CrearRespuesta(){
        ArrayList<Opcion> RespuestasTest = new ArrayList<Opcion>();
        PuntajeConcreto puntajeConcretoTest = new PuntajeConcreto();
        Respuesta respuestaTest = new Respuesta(RespuestasTest, puntajeConcretoTest);
        assertNotEquals(null, respuestaTest);
    }

    @Test
    public void test02_ModificarPuntaje(){
        ArrayList<Opcion> RespuestasTest = new ArrayList<Opcion>();
        PuntajeConcreto puntajeConcretoTest = new PuntajeConcreto();
        Respuesta respuestaTest = new Respuesta(RespuestasTest, puntajeConcretoTest);
        assertEquals(0, puntajeConcretoTest.getPuntaje());
        respuestaTest.modificarPuntaje(1);
        assertEquals(1, puntajeConcretoTest.getPuntaje());
    }
}
