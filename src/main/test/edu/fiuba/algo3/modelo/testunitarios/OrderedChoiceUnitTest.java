package edu.fiuba.algo3.modelo.testunitarios;
import edu.fiuba.algo3.modelo.modalidades.Clasico;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionEstructurada;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class OrderedChoiceUnitTest {

    @Test
    public void test01_CrearPreguntaOrderedChoice(){
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionEstructurada opcion1 = new OpcionEstructurada("1", 1);
        OpcionEstructurada opcion2 = new OpcionEstructurada("0", 0);
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        GroupChoice preguntaOrderedChoiceTest = new GroupChoice("test", todasLasOpciones, new Clasico());
        assertNotEquals(null, preguntaOrderedChoiceTest);
    }
}
