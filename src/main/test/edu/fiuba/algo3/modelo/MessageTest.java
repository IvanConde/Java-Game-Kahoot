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
    //@Test
    //public void test01CrearPregunta() {
    //    ArrayList<Integer> respuestaCorrecta = new ArrayList<Integer>();
     //   respuestaCorrecta.add(1);
     //   VerdaderoFalso preguntaTest =new VerdaderoFalso("Es Tomas su primer nombre?", respuestaCorrecta, new NoPenalidad());
      //  assertEquals(preguntaTest.comprobarRespuesta(respuestaCorrecta), true);
    //}

    @Test
    public void test02ResponderVerdaderoYFlasoCorrectamenteV1(){
        Jugador jugador1 = new Jugador();

        Jugador jugador2 = new Jugador();

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Integer> respuestaCorrecta = new ArrayList<Integer>();
        respuestaCorrecta.add(1);
        ArrayList<Integer> respuestaIncorrecta = new ArrayList<Integer>();
        respuestaIncorrecta.add(0);
        Respuesta respuestacorrecta = new Respuesta(respuestaCorrecta, jugador1.puntaje());
        Respuesta respuestaincorrecta = new Respuesta(respuestaIncorrecta, jugador2.puntaje());
        respuestas.add(respuestacorrecta);
        respuestas.add(respuestaincorrecta);
        NoPenalidad sinPenalidad = new NoPenalidad();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", respuestaCorrecta, sinPenalidad);
        preguntaTest.Responderpregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }
}