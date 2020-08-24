package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.excepciones.VerdaderoYFalsoCantidadDeOpcionesEsIncorrectaException;
import edu.fiuba.algo3.modelo.excepciones.VyFMasDeDosOpcionesException;
import edu.fiuba.algo3.modelo.modalidades.ModalidadClasico;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionBooleana;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;

public class VyFSinModalidadPenalidadTest {

    @Test
    public void test01_1CrearVyFSinPenalidad() {

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionBooleana opcionVerdadero = new OpcionBooleana("verdadero", true);
        OpcionBooleana opcionFalso = new OpcionBooleana("falso", false);
        todasLasOpciones.add(opcionVerdadero);
        todasLasOpciones.add(opcionFalso);
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, new ModalidadClasico());
        assertEquals(todasLasOpciones, preguntaTest.verBotones());

    }

    @Test
    public void test01_2ResponderVerdaderoYFalsoYAsignarPuntajesCorrectamente(){

        Jugador jugador1 = new Jugador("Federico");
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionBooleana opcionVerdadero = new OpcionBooleana("verdadero", true);
        OpcionBooleana opcionFalso = new OpcionBooleana("falso", false);
        todasLasOpciones.add(opcionVerdadero);
        todasLasOpciones.add(opcionFalso);
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Opcion> opcionJugador1 = new ArrayList<Opcion>();
        opcionJugador1.add(opcionVerdadero);

        Respuesta respuestaJugador1 = new Respuesta(opcionJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        ModalidadClasico sinPenalidad = new ModalidadClasico();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());

    }

    @Test
    public void test01_3ResponderVerdaderoYFalsoYAsignarPuntajesIncorrectamente(){

        Jugador jugador1 = new Jugador("Federico");
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionBooleana opcionVerdadero = new OpcionBooleana("verdadero", true);
        OpcionBooleana opcionFalso = new OpcionBooleana("falso", false);
        todasLasOpciones.add(opcionVerdadero);
        todasLasOpciones.add(opcionFalso);
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Opcion> opcionJugador1 = new ArrayList<Opcion>();
        opcionJugador1.add(opcionFalso);

        Respuesta respuestaJugador1 = new Respuesta(opcionJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        ModalidadClasico sinPenalidad = new ModalidadClasico();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(0, jugador1.puntaje().getPuntaje());

    }

    @Test
    public void test01_4ResponderVerdaderoYFalsoYAsignarPuntajesDosJugadoresCorrectamenteEIncorrectamente(){

        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Jose");
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionBooleana opcionVerdadero = new OpcionBooleana("verdadero", true);
        OpcionBooleana opcionFalso = new OpcionBooleana("falso", false);
        todasLasOpciones.add(opcionVerdadero);
        todasLasOpciones.add(opcionFalso);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Opcion> opcionJugador1 = new ArrayList<Opcion>();
        opcionJugador1.add(opcionVerdadero);

        ArrayList<Opcion> opcionJugador2 = new ArrayList<Opcion>();
        opcionJugador2.add(opcionFalso);

        Respuesta respuestaJugador1 = new Respuesta(opcionJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionJugador2, jugador2.puntaje());
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        ModalidadClasico sinPenalidad = new ModalidadClasico();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
        assertEquals(0, jugador2.puntaje().getPuntaje());

    }
    @Test
    public void test01_5CrearVyFLanzaErrorPorOpcionesMasDeDos() {

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionBooleana opcionVerdadero = new OpcionBooleana("verdadero", true);
        OpcionBooleana opcionFalso = new OpcionBooleana("falso", false);
        OpcionBooleana opcionAlgo = new OpcionBooleana("algo", false);
        todasLasOpciones.add(opcionVerdadero);
        todasLasOpciones.add(opcionFalso);
        todasLasOpciones.add(opcionAlgo);
        assertThrows(VerdaderoYFalsoCantidadDeOpcionesEsIncorrectaException.class, () ->
        {new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, new ModalidadClasico());
        });

    }

    @Test
    public void test01_6CrearVyFLanzaErrorPorCorrectasMultiples() {

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionBooleana opcionVerdadero = new OpcionBooleana("verdadero", true);
        OpcionBooleana opcionFalso = new OpcionBooleana("falso", true);
        todasLasOpciones.add(opcionVerdadero);
        todasLasOpciones.add(opcionFalso);
        assertThrows(VyFMasDeDosOpcionesException.class, () ->
            {new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, new ModalidadClasico());
        });

    }

    @Test
    public void test01_7ResponderUnaPreguntaDeVerdaderoYFalsoConUnaActivacionDeExclusividadCalculaBienElPuntaje(){
        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Jose");
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionBooleana opcionVerdadero = new OpcionBooleana("verdadero", true);
        OpcionBooleana opcionFalso = new OpcionBooleana("falso", false);
        todasLasOpciones.add(opcionVerdadero);
        todasLasOpciones.add(opcionFalso);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Opcion> opcionJugador1 = new ArrayList<Opcion>();
        opcionJugador1.add(opcionVerdadero);

        ArrayList<Opcion> opcionJugador2 = new ArrayList<Opcion>();
        opcionJugador2.add(opcionFalso);

        Respuesta respuestaJugador1 = new Respuesta(opcionJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionJugador2, jugador2.puntaje());
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        ModalidadClasico sinPenalidad = new ModalidadClasico();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, sinPenalidad);
        preguntaTest.usarExclusividad(jugador1);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(2, jugador1.puntaje().getPuntaje());
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test01_8ResponderUnaPreguntaDeVerdaderoYFalsoConDosActivacionesDeExclusividadCalculaBienElPuntaje(){
        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Jose");
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionBooleana opcionVerdadero = new OpcionBooleana("verdadero", true);
        OpcionBooleana opcionFalso = new OpcionBooleana("falso", false);
        todasLasOpciones.add(opcionVerdadero);
        todasLasOpciones.add(opcionFalso);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Opcion> opcionJugador1 = new ArrayList<Opcion>();
        opcionJugador1.add(opcionVerdadero);

        ArrayList<Opcion> opcionJugador2 = new ArrayList<Opcion>();
        opcionJugador2.add(opcionFalso);

        Respuesta respuestaJugador1 = new Respuesta(opcionJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionJugador2, jugador2.puntaje());
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        ModalidadClasico sinPenalidad = new ModalidadClasico();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, sinPenalidad);
        preguntaTest.usarExclusividad(jugador1);
        preguntaTest.usarExclusividad(jugador2);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(4, jugador1.puntaje().getPuntaje());
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }

    @Test
    public void test01_9ResponderUnaPreguntaDeVerdaderoYFalsoConExclusividadNoDaPuntosSiAmbosJugadoresRespondenCorrectamente(){
        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Jose");
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionBooleana opcionVerdadero = new OpcionBooleana("verdadero", true);
        OpcionBooleana opcionFalso = new OpcionBooleana("falso", false);
        todasLasOpciones.add(opcionVerdadero);
        todasLasOpciones.add(opcionFalso);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Opcion> opcionJugador1 = new ArrayList<Opcion>();
        opcionJugador1.add(opcionVerdadero);

        ArrayList<Opcion> opcionJugador2 = new ArrayList<Opcion>();
        opcionJugador2.add(opcionFalso);

        Respuesta respuestaJugador1 = new Respuesta(opcionJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionJugador1, jugador2.puntaje());
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        ModalidadClasico sinPenalidad = new ModalidadClasico();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, sinPenalidad);
        preguntaTest.usarExclusividad(jugador1);
        preguntaTest.usarExclusividad(jugador2);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(0, jugador1.puntaje().getPuntaje());
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }
}