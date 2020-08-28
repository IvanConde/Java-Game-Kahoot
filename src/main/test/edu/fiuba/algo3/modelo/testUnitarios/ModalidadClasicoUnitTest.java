package edu.fiuba.algo3.modelo.testUnitarios;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.exclusividad.ExclusividadNulo;
import edu.fiuba.algo3.modelo.exclusividad.ExclusividadPuntaje;
import edu.fiuba.algo3.modelo.modalidades.ModalidadClasico;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionBooleana;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

public class ModalidadClasicoUnitTest {
    @Test
    public void test01_CrearModalidadClasico(){

        ModalidadClasico ModalidadClasicoTest = new ModalidadClasico();
        assertEquals(true, ModalidadClasicoTest != null);

    }

    @Test
    public void test02_calcularPuntajeSinExclusividadyConRespuestasCorrectas(){

        ModalidadClasico ModalidadClasicoTest = new ModalidadClasico();
        Opcion opcionTest = new OpcionBooleana("test", true);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());
        ModalidadClasicoTest.calcularPuntaje(respuestaTest, new ExclusividadNulo());
        assertEquals(1,respuestaTest.puntaje().getPuntaje());

    }

    @Test
    public void test03_calcularPuntajeSinExclusividadyConRespuestasIncorrectas(){

        ModalidadClasico ModalidadClasicoTest = new ModalidadClasico();
        Opcion opcionTest = new OpcionBooleana("test", false);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());
        ModalidadClasicoTest.calcularPuntaje(respuestaTest, new ExclusividadNulo());
        assertEquals(0, respuestaTest.puntaje().getPuntaje());

    }

    @Test
    public void test04_calcularPuntajeConExclusividadyConRespuestasCorrectas(){

        ModalidadClasico ModalidadClasicoTest = new ModalidadClasico();
        Opcion opcionTest = new OpcionBooleana("test", true);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());
        ModalidadClasicoTest.calcularPuntaje(respuestaTest, new ExclusividadPuntaje(new ExclusividadNulo()));
        assertEquals(1, respuestaTest.puntajeTemporal());

    }

    @Test
    public void test05_calcularPuntajeConExclusividadyConRespuestasIncorrectas(){

        ModalidadClasico ModalidadClasicoTest = new ModalidadClasico();
        Opcion opcionTest = new OpcionBooleana("test", false);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());
        ModalidadClasicoTest.calcularPuntaje(respuestaTest, new ExclusividadPuntaje(new ExclusividadNulo()));
        assertEquals(0, respuestaTest.puntajeTemporal());

    }

}