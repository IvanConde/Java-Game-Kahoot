package edu.fiuba.algo3.modelo.testunitarios;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.modalidades.Clasico;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionBooleana;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

public class ModalidadClasicoUnitTest {
    @Test
    public void test01_CrearModalidadClasico(){
        Clasico ModalidadClasicoTest = new Clasico();
        assertEquals(true, ModalidadClasicoTest != null);
    }

    @Test
    public void test02_calcularPuntajeSinExclusividadyConRespuestasCorrectas(){
        Clasico ModalidadClasicoTest = new Clasico();
        Opcion opcionTest = new OpcionBooleana("test", true);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());
        ModalidadClasicoTest.calcularPuntaje(respuestaTest, false);
        assertEquals(1, respuestaTest.puntaje().getPuntaje());
    }

    @Test
    public void test03_calcularPuntajeSinExclusividadyConRespuestasIncorrectas(){
        Clasico ModalidadClasicoTest = new Clasico();
        Opcion opcionTest = new OpcionBooleana("test", false);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());
        ModalidadClasicoTest.calcularPuntaje(respuestaTest, false);
        assertEquals(0, respuestaTest.puntaje().getPuntaje());
    }

    @Test
    public void test04_calcularPuntajeConExclusividadyConRespuestasCorrectas(){
        Clasico ModalidadClasicoTest = new Clasico();
        Opcion opcionTest = new OpcionBooleana("test", true);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());
        ModalidadClasicoTest.calcularPuntaje(respuestaTest, true);
        assertEquals(1, respuestaTest.puntajeTemporal());
    }

    @Test
    public void test05_calcularPuntajeConExclusividadyConRespuestasIncorrectas(){
        Clasico ModalidadClasicoTest = new Clasico();
        Opcion opcionTest = new OpcionBooleana("test", false);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());
        ModalidadClasicoTest.calcularPuntaje(respuestaTest, true);
        assertEquals(0, respuestaTest.puntajeTemporal());
    }
}
