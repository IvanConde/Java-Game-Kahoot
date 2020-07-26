package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
public class MultipleChoiceParcialTest {
    @Test
    public void test02_1CrearVyFConPenalidad() {
        ArrayList<Integer> respuestaCorrecta = new ArrayList<Integer>();
        respuestaCorrecta.add(1);
        respuestaCorrecta.add(2);
        VerdaderoFalso preguntaTest =new VerdaderoFalso("Es Tomas su primer nombre?", respuestaCorrecta, new PuntajeParcial());
        assertEquals(respuestaCorrecta, preguntaTest.verRespuestaCorrecta());
    }
    @Test
    public void test04_2ResponderVerdaderoYFlasoConPenalidadCorrectamenteV1(){
        Jugador jugador1 = new Jugador();

        Jugador jugador2 = new Jugador();
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> respuestaCorrecta = new ArrayList<Integer>();
        respuestaCorrecta.add(1);
        respuestaCorrecta.add(2);
        respuestaCorrecta.add(3);
        ArrayList<Integer> respuestaIncorrecta = new ArrayList<Integer>();
        respuestaIncorrecta.add(0);
        respuestaIncorrecta.add(2);
        respuestaIncorrecta.add(3);
        Respuesta respuestacorrecta = new Respuesta(respuestaCorrecta, jugador1.puntaje());
        Respuesta respuestaincorrecta = new Respuesta(respuestaIncorrecta, jugador2.puntaje());
        respuestas.add(respuestacorrecta);
        respuestas.add(respuestaincorrecta);
        PuntajeParcial conPenalidad = new PuntajeParcial();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", respuestaCorrecta, conPenalidad);
        preguntaTest.Responderpregunta(respuestas);
        assertEquals(3, jugador1.puntaje().getPuntaje());
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }

}
