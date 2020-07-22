package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.Jugador;
import edu.fiuba.algo3.Respuesta;
import edu.fiuba.algo3.VerdaderoFalso;
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
        respuestacorrecta.add(1);
        VerdaderoFalso preguntaTest = VerdaderoFalso("Es Tomas su primer nombre?", respuestacorrecta, SinPenalidad() new) new;
        assertEquals(preguntaTest.comprobarRespuesta(respuestaCorrecta), true);
    }

    @Test
    public void test02ResponderVerdaderoYFlasoCorrectamenteV1(){
        Jugador jugador1 = Jugador() new;
        Respuesta respuestacorrecta = Respuesta(1, jugador1.puntaje()) new;
        Jugador jugador2 = Jugador() new;
        Respuesta respuestaincorrecta = Respuesta(0, jugador2.puntaje()) new;
        ArrayList<Respuesta> respuestas = ArrayList() new;
        respuestas.add(respuestacorrecta);
        respuestas.add(respuestaincorrecta);
        ArrayList<Integer> respuestaCorrecta = new ArrayList<>;
        respuestacorrecta.add(1);
        VerdaderoFalso preguntaTest = VerdaderoFalso("Es Tomas su primer nombre?", respuestacorrecta, SinPenalidad() new) new;
        preguntatest.responderpregunta(respuestas)
        assertEquals(1, jugador1.puntaje());
        assertEquals(0, jugador2.puntaje());
    }
}