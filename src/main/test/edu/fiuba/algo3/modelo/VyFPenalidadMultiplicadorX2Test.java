package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.modalidades.Penalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionBooleana;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

public class VyFPenalidadMultiplicadorX2Test {

    @Test
    public void test06_1ResponderVerdaderoYFalsoConPenalidadyMultiplicadorX2yAsignarPuntajesCorrectamente(){

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
        Penalidad conPenalidad = new Penalidad();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, conPenalidad);
        jugador1.usarMultiplicadorX2(preguntaTest);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(2, jugador1.puntaje().getPuntaje());

    }

    @Test
    public void test06_2ResponderVerdaderoYFalsoConPenalidadyMultiplicadorX2yAsignarPuntajesIncorrectamente(){

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
        Penalidad conPenalidad = new Penalidad();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, conPenalidad);
        jugador1.usarMultiplicadorX2(preguntaTest);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(-2, jugador1.puntaje().getPuntaje());

    }

    @Test
    public void test06_3ResponderVerdaderoYFalsoConPenalidadDosJugadoresCorrectamenteEIncorrectamenteConMultiplicadorX2SoloCorrecto(){

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
        Penalidad conPenalidad = new Penalidad();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, conPenalidad);
        jugador1.usarMultiplicadorX2(preguntaTest);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(2, jugador1.puntaje().getPuntaje());
        assertEquals(-1, jugador2.puntaje().getPuntaje());

    }

    @Test
    public void test06_4ResponderVerdaderoYFalsoConPenalidadDosJugadoresCorrectamenteEIncorrectamenteConMultiplicadorX2SoloIncorrecto(){

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
        Penalidad conPenalidad = new Penalidad();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, conPenalidad);
        jugador2.usarMultiplicadorX2(preguntaTest);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
        assertEquals(-2, jugador2.puntaje().getPuntaje());

    }

    @Test
    public void test06_5ResponderVerdaderoYFalsoConPenalidadDosJugadoresCorrectamenteEIncorrectamenteConMultiplicadorX2Ambos(){

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
        Penalidad conPenalidad = new Penalidad();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, conPenalidad);
        jugador1.usarMultiplicadorX2(preguntaTest);
        jugador2.usarMultiplicadorX2(preguntaTest);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(2, jugador1.puntaje().getPuntaje());
        assertEquals(-2, jugador2.puntaje().getPuntaje());

    }

    @Test
    public void test06_6ResponderVerdaderoYFalsoConPenalidadyMultiplicadorX2RespondeDosVecesYSoloSeMultiplicaPuntajeDeLaPrimerRespuesta(){

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
        Penalidad conPenalidad = new Penalidad();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, conPenalidad);
        jugador1.usarMultiplicadorX2(preguntaTest);
        preguntaTest.responderPregunta(respuestas);
        jugador1.usarMultiplicadorX2(preguntaTest);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(3, jugador1.puntaje().getPuntaje());

    }

    @Test
    public void test06_7ResponderVerdaderoYFalsoConPenalidadyMultiplicadorX2yAsignarPuntajesIncorrectamenteDosVecesSoloMultiplicaElPrimero(){

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
        Penalidad conPenalidad = new Penalidad();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, conPenalidad);
        jugador1.usarMultiplicadorX2(preguntaTest);
        preguntaTest.responderPregunta(respuestas);
        jugador1.usarMultiplicadorX2(preguntaTest);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(-3, jugador1.puntaje().getPuntaje());

    }

    @Test
    public void test06_8ResponderVerdaderoYFalsoConPenalidadDosJugadoresCorrectamenteEIncorrectamenteConMultiplicadorX2AmbosRespondenDosVecesSoloMultiplicaElPrimero(){

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
        Penalidad conPenalidad = new Penalidad();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, conPenalidad);
        jugador1.usarMultiplicadorX2(preguntaTest);
        jugador2.usarMultiplicadorX2(preguntaTest);
        preguntaTest.responderPregunta(respuestas);
        jugador1.usarMultiplicadorX2(preguntaTest);
        jugador2.usarMultiplicadorX2(preguntaTest);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(3, jugador1.puntaje().getPuntaje());
        assertEquals(-3, jugador2.puntaje().getPuntaje());

    }

}