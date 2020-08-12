package edu.fiuba.algo3.modelo.testunitarios;
import edu.fiuba.algo3.modelo.excepciones.VyFMasDeDosOpcionesException;
import edu.fiuba.algo3.modelo.modalidades.ModalidadClasico;
import edu.fiuba.algo3.modelo.modalidades.ModalidadPenalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionBooleana;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;


public class VyFUnitTest {

    @Test
    public void test01_CrearVyF() {

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionBooleana opcionVerdadero = new OpcionBooleana("verdadero", true);
        OpcionBooleana opcionFalso = new OpcionBooleana("falso", false);
        todasLasOpciones.add(opcionVerdadero);
        todasLasOpciones.add(opcionFalso);
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, new ModalidadClasico());
        assertEquals(false, preguntaTest==null);
    }

    @Test
    public void test02_VerBotonesDeVyF(){
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionBooleana opcionVerdadero = new OpcionBooleana("verdadero", true);
        OpcionBooleana opcionFalso = new OpcionBooleana("falso", false);
        todasLasOpciones.add(opcionVerdadero);
        todasLasOpciones.add(opcionFalso);
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, new ModalidadClasico());
        assertEquals(todasLasOpciones, preguntaTest.verBotones());
    }

    @Test
    public void test03_VyFMasDeDosOpcionesException(){
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionBooleana opcionVerdadero1 = new OpcionBooleana("verdadero", true);
        OpcionBooleana opcionVerdadero2 = new OpcionBooleana("verdadero", true);
        OpcionBooleana opcionFalso = new OpcionBooleana("falso", false);
        todasLasOpciones.add(opcionVerdadero1);
        todasLasOpciones.add(opcionVerdadero2);
        todasLasOpciones.add(opcionFalso);
        Exception excepcionEsperada = assertThrows(VyFMasDeDosOpcionesException.class,()->{VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, new ModalidadClasico());});
        String mensajeEsperado = "no es posible más de una opcion correcta en VerdaderoYFalso";
        String mensajeVerdadero = excepcionEsperada.getMessage();
        assertTrue(mensajeVerdadero.contains(mensajeEsperado));
    }

    @Test
    public void test04_TienePenalidadDevulveTrueCuandoLaModalidadDeLaPreguntaEsUnaInstanciaDeModalidadPenalidad(){
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionBooleana opcionVerdadero = new OpcionBooleana("verdadero", true);
        OpcionBooleana opcionFalso = new OpcionBooleana("falso", false);
        todasLasOpciones.add(opcionVerdadero);
        todasLasOpciones.add(opcionFalso);
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, new ModalidadPenalidad());
        assertTrue(preguntaTest.tienePenalidad());
    }

    @Test
    public void test05_TienePenalidadDevulveFalseCuandoLaModalidadDeLaPreguntaNoEsUnaInstanciaDeModalidadPenalidad(){
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionBooleana opcionVerdadero = new OpcionBooleana("verdadero", true);
        OpcionBooleana opcionFalso = new OpcionBooleana("falso", false);
        todasLasOpciones.add(opcionVerdadero);
        todasLasOpciones.add(opcionFalso);
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, new ModalidadClasico());
        assertFalse(preguntaTest.tienePenalidad());
    }
}
