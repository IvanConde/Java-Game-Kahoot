package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
public class MessageTest {
    @Test
    public void messageGreeting() {
        Message message = new Message("Hello world!");

        assertEquals("Hello world!", message.greet());
    }
    @Test
    public void test01CrearPregunta() {
        ArrayList<Integer> respuestaCorrecta = new ArrayList<Integer>();
        respuestaCorrecta.add(1);
        VerdaderoFalso preguntaTest =new VerdaderoFalso("Es Tomas su primer nombre?", respuestaCorrecta, new NoPenalidad());
        assertEquals(preguntaTest.comprobarRespuesta(respuestaCorrecta), true);
    }

    @Test
    public void test02ResponderVerdaderoYFlasoCorrectamenteV1(){
        Jugador jugador1 = new Jugador();
        Respuesta respuestacorrecta = new Respuesta(1, jugador1.puntaje());
        Jugador jugador2 = new Jugador();
        Respuesta respuestaincorrecta = Respuesta(0, jugador2.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList();
        respuestas.add(respuestacorrecta);
        respuestas.add(respuestaincorrecta);
        ArrayList<Integer> respuestaCorrecta = new ArrayList<>;
        respuestacorrecta.add(1);
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", respuestacorrecta, new SinPenalidad());
        preguntatest.responderpregunta(respuestas)
        assertEquals(1, jugador1.puntaje());
        assertEquals(0, jugador2.puntaje());
    }
}