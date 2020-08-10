package edu.fiuba.algo3.modelo.testunitarios;

import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.modalidades.Penalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionBooleana;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModalidadPenalidadUnitTest {
    @Test
    public void test01_CrearModalidadParcial(){
        Penalidad ModalidadPenalidadTest = new Penalidad();
        assertEquals(true, ModalidadPenalidadTest != null);
    }

    @Test
    public void test02_calcularPuntajeConRespuestasCorrectas(){
        Penalidad ModalidadPenalidadTest = new Penalidad();
        Opcion opcionTest = new OpcionBooleana("test", true);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());
        ModalidadPenalidadTest.calcularPuntaje(respuestaTest, false);
        assertEquals(1, respuestaTest.puntaje().getPuntaje());
    }

    @Test
    public void test03_calcularPuntajeConRespuestasIncorrectas(){
        Penalidad ModalidadPenalidadTest = new Penalidad();
        Opcion opcionTest = new OpcionBooleana("test", false);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());
        ModalidadPenalidadTest.calcularPuntaje(respuestaTest, false);
        assertEquals(-1, respuestaTest.puntaje().getPuntaje());
    }

    @Test
    public void test04_calcularPuntajeCon2RespuestasCorrectas(){
        Penalidad ModalidadPenalidadTest = new Penalidad();
        Opcion opcionTest1 = new OpcionBooleana("test", true);
        Opcion opcionTest2 = new OpcionBooleana("test", true);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest1);
        opcionList.add(opcionTest2);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());
        ModalidadPenalidadTest.calcularPuntaje(respuestaTest, false);
        assertEquals(2, respuestaTest.puntaje().getPuntaje());
    }

    @Test
    public void test05_calcularPuntajeCon2RespuestasIncorrectas(){
        Penalidad ModalidadPenalidadTest = new Penalidad();
        Opcion opcionTest1 = new OpcionBooleana("test", false);
        Opcion opcionTest2 = new OpcionBooleana("test", false);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest1);
        opcionList.add(opcionTest2);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());
        ModalidadPenalidadTest.calcularPuntaje(respuestaTest, false);
        assertEquals(-2, respuestaTest.puntaje().getPuntaje());
    }

    @Test
    public void test06_calcularPuntajeCon1RespuestaIncorrectasy1RespuestaCorrecta(){
        Penalidad ModalidadPenalidadTest = new Penalidad();
        Opcion opcionTest1 = new OpcionBooleana("test", true);
        Opcion opcionTest2 = new OpcionBooleana("test", false);
        ArrayList<Opcion> opcionList= new ArrayList<Opcion>();
        opcionList.add(opcionTest1);
        opcionList.add(opcionTest2);
        Respuesta respuestaTest = new Respuesta(opcionList, new Puntaje());
        ModalidadPenalidadTest.calcularPuntaje(respuestaTest, false);
        assertEquals(0, respuestaTest.puntaje().getPuntaje());
    }
}
