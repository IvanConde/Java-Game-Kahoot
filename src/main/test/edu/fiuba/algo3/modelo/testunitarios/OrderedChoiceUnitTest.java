package edu.fiuba.algo3.modelo.testunitarios;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionOrdered;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
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
        GroupChoice preguntaOrderedChoiceTest = new GroupChoice("test", todasLasOpciones);
        assertNotEquals(null, preguntaOrderedChoiceTest);
    }
}
