
package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
public class VyFPenalidadTest {

    @Test
    public void test02_1CrearVyFConPenalidad() {
        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        Opcion opcionVerdadero = new Opcion("verdadero", true);
        Opcion opcionFalso = new Opcion("falso", false);
        todas.add(opcionVerdadero);
        todas.add(opcionFalso);
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todas, new Penalidad());
        assertEquals(todas, preguntaTest.verBotones());
    }
    @Test
    public void test02_2ResponderVerdaderoYFlasoConPenalidadyAsignarPuntajesCorrectamente(){
        Jugador jugador1 = new Jugador("Federico");
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
        assertEquals(1, jugador1.puntaje().getPuntaje());
    }
    @Test
    public void test02_3ResponderVerdaderoYFlasoConPenalidadyAsignarPuntajesIncorrectamente(){
        Jugador jugador1 = new Jugador("Federico");
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
        assertEquals(-1, jugador1.puntaje().getPuntaje());
    }
    @Test
    public void test02_4ResponderVerdaderoYFlasoConPenalidadDosJugadoresCorrectamenteEIncorrectamente(){
        Jugador jugador1 = new Jugador("Federico");
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
        assertEquals(1, jugador1.puntaje().getPuntaje());
        assertEquals(-1, jugador2.puntaje().getPuntaje());
    }
}