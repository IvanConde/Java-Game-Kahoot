package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoYFalsoTest{

    @Test
    public void SeCreaVerdaderoYFalsoConRespuestaCorrecta(){
        Respuesta respuestaCorrecta = new Respuesta("Verdadero");
        VerdaderoYFalso preguntaVF = new VerdaderoYFalso("¿El sol es una estrella?", respuestaCorrecta);
        assertEquals(preguntaVF.getRespuestaCorrecta(), "Verdadero");
    }

    @Test
    public void VerdaderoYFalsoRecibeListaYAsignaPuntos(){
        ArrayList <Respuesta> respuestas = new ArrayList();

        Jugador jugador1 = new Jugador("Manolo");
        Jugador jugador2 = new Jugador("Nicolas");

        Respuesta respuestaCorrecta = new Respuesta("Verdadero");
        Respuesta respuestaIncorrecta = new Respuesta("Falso");
        VerdaderoYFalso preguntaVF = new VerdaderoYFalso("¿El sol es una estrella?", respuestaCorrecta);

        jugador1.elegirRespuesta(respuestaCorrecta);
        jugador2.elegirRespuesta(respuestaIncorrecta);

        respuestas.add(respuestaCorrecta);
        respuestas.add(respuestaIncorrecta);

        preguntaVF.recibirRespuestas(respuestas);

        assertEquals(jugador1.getPuntaje(), 1);
        assertEquals(jugador2.getPuntaje(), 0);

    }

}