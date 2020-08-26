package edu.fiuba.algo3.modelo.testUnitarios;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.modalidades.ModalidadPenalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionBooleana;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModalidadPenalidadUnitTest {

    @Test
    public void test01_CrearModalidadParcial(){

        ModalidadPenalidad ModalidadPenalidadTest = new ModalidadPenalidad();
        assertEquals(true, ModalidadPenalidadTest != null);

    }

    @Test
    public void test02_calcularPuntajeConRespuestasCorrectas(){

        ModalidadPenalidad ModalidadPenalidadTest = new ModalidadPenalidad();
        Opcion opcionTest = new OpcionBooleana("test", true);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());
        assertEquals(1, ModalidadPenalidadTest.calcularPuntaje(respuestaTest));

    }

    @Test
    public void test03_calcularPuntajeConRespuestasIncorrectas(){

        ModalidadPenalidad ModalidadPenalidadTest = new ModalidadPenalidad();
        Opcion opcionTest = new OpcionBooleana("test", false);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());
        assertEquals(-1, ModalidadPenalidadTest.calcularPuntaje(respuestaTest));

    }

    @Test
    public void test04_calcularPuntajeCon2RespuestasCorrectas(){

        ModalidadPenalidad ModalidadPenalidadTest = new ModalidadPenalidad();
        Opcion opcionTest1 = new OpcionBooleana("test", true);
        Opcion opcionTest2 = new OpcionBooleana("test", true);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest1);
        opcionList.add(opcionTest2);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());

        assertEquals(2, ModalidadPenalidadTest.calcularPuntaje(respuestaTest));

    }

    @Test
    public void test05_calcularPuntajeCon2RespuestasIncorrectas(){

        ModalidadPenalidad ModalidadPenalidadTest = new ModalidadPenalidad();
        Opcion opcionTest1 = new OpcionBooleana("test", false);
        Opcion opcionTest2 = new OpcionBooleana("test", false);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest1);
        opcionList.add(opcionTest2);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());
        assertEquals(-2, ModalidadPenalidadTest.calcularPuntaje(respuestaTest));

    }

    @Test
    public void test06_calcularPuntajeCon1RespuestaIncorrectasy1RespuestaCorrecta(){

        ModalidadPenalidad ModalidadPenalidadTest = new ModalidadPenalidad();
        Opcion opcionTest1 = new OpcionBooleana("test", true);
        Opcion opcionTest2 = new OpcionBooleana("test", false);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest1);
        opcionList.add(opcionTest2);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());
        ModalidadPenalidadTest.calcularPuntaje(respuestaTest);
        assertEquals(0, respuestaTest.puntaje().getPuntaje());

    }

}