package edu.fiuba.algo3.modelo.testunitarios;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionGroup;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class GroupChoiceUnitTest {

    @Test
    public void test01_CrearPreguntaGroupChoice(){

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionGroup opcion1 = new OpcionGroup("1", "1");
        OpcionGroup opcion2 = new OpcionGroup("0", "0");
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        ArrayList<String> grupos = new ArrayList<String>();
        grupos.add("0");
        grupos.add("1");
        GroupChoice preguntaGroupChoiceTest = new GroupChoice("test", todasLasOpciones,grupos);
        assertNotEquals(null, preguntaGroupChoiceTest);

    }

    @Test
    public void test02_TienePenalidadSiempreDevulveFalse(){

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionGroup opcion1 = new OpcionGroup("1", "1");
        OpcionGroup opcion2 = new OpcionGroup("0", "0");
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        ArrayList<String> grupos = new ArrayList<String>();
        grupos.add("0");
        grupos.add("1");
        GroupChoice preguntaGroupChoiceTest = new GroupChoice("test", todasLasOpciones,grupos);
        assertFalse(preguntaGroupChoiceTest.tienePenalidad());

    }

}