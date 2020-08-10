package edu.fiuba.algo3.modelo.testunitarios;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionEstructurada;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class OpcionEstructuradaUnitTest {

    @Test
    public void test01_CrearInstanciaDeOpcionBooleanConElConstructor1(){
        OpcionEstructurada opcionTest= new OpcionEstructurada("test", 1);
        assertEquals(false, opcionTest == null);
    }

    @Test
    public void test02_CrearInstanciaDeOpcionBooleanConElConstructor2(){
        OpcionEstructurada opcionTest= new OpcionEstructurada("test", 1, 2);
        assertEquals(false, opcionTest == null);
    }

    @Test
    public void test03_esCorrectoConOriginalyEleccionJugadorIguales(){
        OpcionEstructurada opcionTest= new OpcionEstructurada("test", 1, 1);
        assertEquals(true, opcionTest.esCorrecto());
    }

    @Test
    public void test04_esCorrectoConOriginalyEleccionJugadorDistintos(){
        OpcionEstructurada opcionTest= new OpcionEstructurada("test", 1, 2);
        assertEquals(false, opcionTest.esCorrecto());
    }

    @Test
    public void test05_Elegir(){
        OpcionEstructurada opcionTest= new OpcionEstructurada("test", 1);
        ArrayList<Opcion> opcionesJugador = new ArrayList<Opcion>();
        opcionTest.elegir(0, opcionesJugador);
        assertEquals(true, opcionesJugador.get(0)!=null );
    }
}
