package edu.fiuba.algo3.modelo.testUnitarios;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.exclusividad.ExclusividadNulo;
import edu.fiuba.algo3.modelo.modalidades.ModalidadParcial;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionBooleana;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

public class ModalidadParcialUnitTest {

    @Test
    public void test01_CrearModalidadParcial(){

        ModalidadParcial ModalidadParcialTest = new ModalidadParcial();
        assertEquals(true, ModalidadParcialTest != null);

    }

    @Test
    public void test02_calcularPuntajeSinExclusividadyConRespuestasCorrectas(){

        ModalidadParcial ModalidadParcialTest = new ModalidadParcial();
        Opcion opcionTest = new OpcionBooleana("test", true);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());
        ModalidadParcialTest.calcularPuntaje(respuestaTest, new ExclusividadNulo());
        assertEquals(1, respuestaTest.puntaje().getPuntaje());

    }

    @Test
    public void test03_calcularPuntajeSinExclusividadyConRespuestasIncorrectas(){

        ModalidadParcial ModalidadParcialTest = new ModalidadParcial();
        Opcion opcionTest = new OpcionBooleana("test", false);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());
        ModalidadParcialTest.calcularPuntaje(respuestaTest, new ExclusividadNulo());
        assertEquals(0, respuestaTest.puntaje().getPuntaje());

    }

    @Test
    public void test04_calcularPuntajeConExclusividadyConRespuestasCorrectas(){

        ModalidadParcial ModalidadParcialTest = new ModalidadParcial();
        Opcion opcionTest = new OpcionBooleana("test", true);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());
        ModalidadParcialTest.calcularPuntaje(respuestaTest, new ExclusividadNulo());
        assertEquals(1, respuestaTest.puntaje().getPuntaje());

    }

    @Test
    public void test05_calcularPuntajeConExclusividadyConRespuestasIncorrectas(){

        ModalidadParcial ModalidadParcialTest = new ModalidadParcial();
        Opcion opcionTest = new OpcionBooleana("test", false);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());
        ModalidadParcialTest.calcularPuntaje(respuestaTest, new ExclusividadNulo());
        assertEquals(0, respuestaTest.puntajeTemporal());

    }

    @Test
    public void test06_calcularPuntajeSinExclusividadyConRespuestasIncorrectasyCorrectas(){

        ModalidadParcial ModalidadParcialTest = new ModalidadParcial();
        Opcion opcionTest1 = new OpcionBooleana("test1", true);
        Opcion opcionTest2 = new OpcionBooleana("test2", false);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest1);
        opcionList.add(opcionTest2);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());
        ModalidadParcialTest.calcularPuntaje(respuestaTest, new ExclusividadNulo());
        assertEquals(0, respuestaTest.puntaje().getPuntaje());

    }

    @Test
    public void test07_calcularPuntajeConExclusividadyConRespuestasIncorrectasyCorrectas(){

        ModalidadParcial ModalidadParcialTest = new ModalidadParcial();
        Opcion opcionTest1 = new OpcionBooleana("test1", true);
        Opcion opcionTest2 = new OpcionBooleana("test2", false);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest1);
        opcionList.add(opcionTest2);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());
        ModalidadParcialTest.calcularPuntaje(respuestaTest, new ExclusividadNulo());
        assertEquals(0, respuestaTest.puntaje().getPuntaje());

    }

}