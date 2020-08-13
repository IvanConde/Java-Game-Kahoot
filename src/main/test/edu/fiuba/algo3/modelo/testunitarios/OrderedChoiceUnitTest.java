package edu.fiuba.algo3.modelo.testunitarios;
import edu.fiuba.algo3.modelo.excepciones.OrderedChoiceMasDeUnaOpcionConLaPosicionOriginalException;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionOrdered;
import edu.fiuba.algo3.modelo.preguntas.OrderedChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class OrderedChoiceUnitTest {

    @Test
    public void test01_CrearPreguntaOrderedChoice(){
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionOrdered opcion1 = new OpcionOrdered("1", 1);
        OpcionOrdered opcion2 = new OpcionOrdered("0", 0);
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        OrderedChoice preguntaOrderedChoiceTest = new OrderedChoice("test", todasLasOpciones);
        assertNotEquals(null, preguntaOrderedChoiceTest);
    }

    @Test
    public void test02_CrearPreguntaOrderedChoiceConDosOpcionesConLaMismaPosicionOriginalSaltaUnaExcepcion(){
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionOrdered opcion1 = new OpcionOrdered("1", 1);
        OpcionOrdered opcion2 = new OpcionOrdered("1", 1);
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        Exception excepcionEsperada = assertThrows(OrderedChoiceMasDeUnaOpcionConLaPosicionOriginalException.class,()->{ OrderedChoice preguntaOrderedChoiceTest = new OrderedChoice("test", todasLasOpciones);});
        String mensajeEsperado = "no es posible más de una opcion con las misma posicion original";
        String mensajeVerdadero = excepcionEsperada.getMessage();
        assertTrue(mensajeVerdadero.contains(mensajeEsperado));
    }

    @Test
    public void test03_TienePenalidadSiempreDevulveFalse(){
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionOrdered opcion1 = new OpcionOrdered("1", 1);
        OpcionOrdered opcion2 = new OpcionOrdered("0", 0);
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        OrderedChoice preguntaOrderedChoiceTest = new OrderedChoice("test", todasLasOpciones);
        assertFalse(preguntaOrderedChoiceTest.tienePenalidad());
    }
}
