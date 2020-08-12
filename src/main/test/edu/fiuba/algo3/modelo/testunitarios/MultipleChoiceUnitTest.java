package edu.fiuba.algo3.modelo.testunitarios;

import edu.fiuba.algo3.modelo.modalidades.ModalidadClasico;
import edu.fiuba.algo3.modelo.modalidades.ModalidadPenalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionBooleana;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class MultipleChoiceUnitTest {

    @Test
    public void test01_CrearMultipleChoice(){
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionBooleana opcion1 = new OpcionBooleana("test1", true);
        OpcionBooleana opcion2 = new OpcionBooleana("test2", false);
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        MultipleChoice multipleChoicePreguntaTest = new MultipleChoice("test", todasLasOpciones, new ModalidadClasico());
        assertNotEquals(null, multipleChoicePreguntaTest);
    }

    @Test
    public void test02_TienePenalidadDevulveTrueCuandoLaModalidadDeLaPreguntaEsUnaInstanciaDeModalidadPenalidad(){
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionBooleana opcion1 = new OpcionBooleana("test1", true);
        OpcionBooleana opcion2 = new OpcionBooleana("test2", false);
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        MultipleChoice multipleChoicePreguntaTest = new MultipleChoice("test", todasLasOpciones, new ModalidadPenalidad());
        assertTrue(multipleChoicePreguntaTest.tienePenalidad());
    }

    @Test
    public void test03_TienePenalidadDevulveFalseCuandoLaModalidadDeLaPreguntaNoEsUnaInstanciaDeModalidadPenalidad(){
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionBooleana opcion1 = new OpcionBooleana("test1", true);
        OpcionBooleana opcion2 = new OpcionBooleana("test2", false);
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        MultipleChoice multipleChoicePreguntaTest = new MultipleChoice("test", todasLasOpciones, new ModalidadClasico());
        assertFalse(multipleChoicePreguntaTest.tienePenalidad());
    }
}
