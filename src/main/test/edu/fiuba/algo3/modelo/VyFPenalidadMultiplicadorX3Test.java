
package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
public class VyFPenalidadMultiplicadorX3Test {
/*
    @Test
    public void test07_1ResponderVerdaderoYFalsoConPenalidadyMultiplicadorX3yAsignarPuntajesCorrectamente(){
        Jugador jugador1 = new Jugador("Federico");
        jugador1.usarMultiplicadorX3();
        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        Opcion opcionVerdadero = new OpcionChoice("verdadero", true);
        Opcion opcionFalso = new OpcionChoice("falso", false);
        todas.add(opcionVerdadero);
        todas.add(opcionFalso);
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Opcion> opcionJugador1 = new ArrayList<Opcion>();
        opcionJugador1.add(opcionVerdadero);

        Respuesta respuestaJugador1 = new Respuesta(opcionJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        Penalidad conPenalidad = new Penalidad();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todas, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(3, jugador1.puntaje().getPuntaje());
    }
    @Test
    public void test07_2ResponderVerdaderoYFlasoConPenalidadyMultiplicadorX3yAsignarPuntajesIncorrectamente(){
        Jugador jugador1 = new Jugador("Federico");
        jugador1.usarMultiplicadorX3();
        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        Opcion opcionVerdadero = new Opcion("verdadero", true);
        Opcion opcionFalso = new Opcion("falso", false);
        todas.add(opcionVerdadero);
        todas.add(opcionFalso);
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Opcion> opcionJugador1 = new ArrayList<Opcion>();
        opcionJugador1.add(opcionFalso);

        Respuesta respuestaJugador1 = new Respuesta(opcionJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        Penalidad conPenalidad = new Penalidad();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todas, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(-3, jugador1.puntaje().getPuntaje());
    }
    @Test
    public void test07_3ResponderVerdaderoYFlasoConPenalidadDosJugadoresCorrectamenteEIncorrectamenteConMultiplicadorX3SoloCorrecto(){
        Jugador jugador1 = new Jugador("Federico");
        jugador1.usarMultiplicadorX3();
        Jugador jugador2 = new Jugador("Jose");
        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        Opcion opcionVerdadero = new Opcion("verdadero", true);
        Opcion opcionFalso = new Opcion("falso", false);
        todas.add(opcionVerdadero);
        todas.add(opcionFalso);

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
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todas, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(3, jugador1.puntaje().getPuntaje());
        assertEquals(-1, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test07_4ResponderVerdaderoYFlasoConPenalidadDosJugadoresCorrectamenteEIncorrectamenteConMultiplicadorX3SoloIncorrecto(){
        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Jose");
        jugador2.usarMultiplicadorX3();
        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        Opcion opcionVerdadero = new Opcion("verdadero", true);
        Opcion opcionFalso = new Opcion("falso", false);
        todas.add(opcionVerdadero);
        todas.add(opcionFalso);

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
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todas, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
        assertEquals(-3, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test07_5ResponderVerdaderoYFlasoConPenalidadDosJugadoresCorrectamenteEIncorrectamenteConMultiplicadorX3Ambos(){
        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Jose");
        jugador1.usarMultiplicadorX3();
        jugador2.usarMultiplicadorX3();
        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        Opcion opcionVerdadero = new Opcion("verdadero", true);
        Opcion opcionFalso = new Opcion("falso", false);
        todas.add(opcionVerdadero);
        todas.add(opcionFalso);

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
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todas, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(3, jugador1.puntaje().getPuntaje());
        assertEquals(-3, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test07_6ResponderVerdaderoYFlasoConPenalidadyMultiplicadorX3RespondeDosVecesYSoloSeMultiplicaPuntajeDeLaPrimerRespuesta(){
        Jugador jugador1 = new Jugador("Federico");
        jugador1.usarMultiplicadorX3();
        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        Opcion opcionVerdadero = new Opcion("verdadero", true);
        Opcion opcionFalso = new Opcion("falso", false);
        todas.add(opcionVerdadero);
        todas.add(opcionFalso);
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Opcion> opcionJugador1 = new ArrayList<Opcion>();
        opcionJugador1.add(opcionVerdadero);

        Respuesta respuestaJugador1 = new Respuesta(opcionJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        Penalidad conPenalidad = new Penalidad();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todas, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(4, jugador1.puntaje().getPuntaje());
    }
    @Test
    public void test07_7ResponderVerdaderoYFlasoConPenalidadyMultiplicadorX3yAsignarPuntajesIncorrectamenteDosVecesSoloMultiplicaElPrimero(){
        Jugador jugador1 = new Jugador("Federico");
        jugador1.usarMultiplicadorX3();
        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        Opcion opcionVerdadero = new Opcion("verdadero", true);
        Opcion opcionFalso = new Opcion("falso", false);
        todas.add(opcionVerdadero);
        todas.add(opcionFalso);
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Opcion> opcionJugador1 = new ArrayList<Opcion>();
        opcionJugador1.add(opcionFalso);

        Respuesta respuestaJugador1 = new Respuesta(opcionJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        Penalidad conPenalidad = new Penalidad();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todas, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(-4, jugador1.puntaje().getPuntaje());
    }
    @Test
    public void test07_8ResponderVerdaderoYFlasoConPenalidadDosJugadoresCorrectamenteEIncorrectamenteConMultiplicadorX3AmbosRespondenDosVecesSoloMultiplicaElPrimero(){
        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Jose");
        jugador1.usarMultiplicadorX3();
        jugador2.usarMultiplicadorX3();
        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        Opcion opcionVerdadero = new Opcion("verdadero", true);
        Opcion opcionFalso = new Opcion("falso", false);
        todas.add(opcionVerdadero);
        todas.add(opcionFalso);

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
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todas, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(4, jugador1.puntaje().getPuntaje());
        assertEquals(-4, jugador2.puntaje().getPuntaje());
    }
 */

}
