package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.modalidades.ModalidadPenalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionBooleana;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceModalidadPenalidadMultiplicadorX2Test {

    @Test
    public void test08_1ResponderMultipleChoiceConPenalidadyMultiplicadorX2yAsignarPuntajesCorrectamente(){

        OpcionBooleana opcion1 = new OpcionBooleana("Si",true);
        OpcionBooleana opcion2 = new OpcionBooleana("Totalmente",true);
        OpcionBooleana opcion3 = new OpcionBooleana("quizas",true);
        OpcionBooleana opcion4 = new OpcionBooleana("para nada",false);
        OpcionBooleana opcion5 = new OpcionBooleana("nunca",false);

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        todasLasOpciones.add(opcion3);
        todasLasOpciones.add(opcion4);
        todasLasOpciones.add(opcion5);

        Jugador jugador1 = new Jugador("Iván");
        Jugador jugador2 = new Jugador("Aldu");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        //Opciones elegidas por el Jugador 1.
        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion1);
        opcionesJugador1.add(opcion2);

        //Opciones elegidas por el Jugador 2.
        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        opcionesJugador2.add(opcion5);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2, jugador2.puntaje());
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        ModalidadPenalidad conPenalidad = new ModalidadPenalidad();
        MultipleChoice preguntaTest = new MultipleChoice("¿La tierra es plana?", todasLasOpciones, conPenalidad);
        jugador1.usarMultiplicador(preguntaTest, 2);
        jugador2.usarMultiplicador(preguntaTest, 2);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(4, jugador1.puntaje().getPuntaje());
        assertEquals(-2, jugador2.puntaje().getPuntaje());

    }

    @Test
    public void test08_2ResponderMultipleChoiceConPenalidadyMultiplicadorX2UnaRespuestaCorrectaDeDos(){

        OpcionBooleana opcion1 = new OpcionBooleana("Si",true);
        OpcionBooleana opcion2 = new OpcionBooleana("Totalmente",true);
        OpcionBooleana opcion3 = new OpcionBooleana("quizas",true);
        OpcionBooleana opcion4 = new OpcionBooleana("para nada",false);
        OpcionBooleana opcion5 = new OpcionBooleana("nunca",false);

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        todasLasOpciones.add(opcion3);
        todasLasOpciones.add(opcion4);
        todasLasOpciones.add(opcion5);

        Jugador jugador1 = new Jugador("Iván");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        //Opciones elegidas por el Jugador 1.
        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion1);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        ModalidadPenalidad conPenalidad = new ModalidadPenalidad();
        MultipleChoice preguntaTest = new MultipleChoice("¿La tierra es plana?", todasLasOpciones, conPenalidad);
        jugador1.usarMultiplicador(preguntaTest, 2);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(2, jugador1.puntaje().getPuntaje());

    }

    @Test
    public void test08_3ResponderMultipleChoiceConPenalidadyMultiplicadorX2UnaCorrectaYUnaErroneaDeDos(){

        OpcionBooleana opcion1 = new OpcionBooleana("Si",true);
        OpcionBooleana opcion2 = new OpcionBooleana("Totalmente",true);
        OpcionBooleana opcion3 = new OpcionBooleana("quizas",true);
        OpcionBooleana opcion4 = new OpcionBooleana("para nada",false);
        OpcionBooleana opcion5 = new OpcionBooleana("nunca",false);

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        todasLasOpciones.add(opcion3);
        todasLasOpciones.add(opcion4);
        todasLasOpciones.add(opcion5);

        Jugador jugador1 = new Jugador("Iván");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        //Opciones elegidas por el Jugador 1.
        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion1);
        opcionesJugador1.add(opcion4);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        ModalidadPenalidad conPenalidad = new ModalidadPenalidad();
        MultipleChoice preguntaTest = new MultipleChoice("¿La tierra es plana?", todasLasOpciones, conPenalidad);
        jugador1.usarMultiplicador(preguntaTest, 2);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(0, jugador1.puntaje().getPuntaje());

    }

    @Test
    public void test08_4ResponderMultipleChoiceConPenalidadyMultiplicadorX2ConDosJugadores(){

        OpcionBooleana opcion1 = new OpcionBooleana("Si",true);
        OpcionBooleana opcion2 = new OpcionBooleana("Totalmente",true);
        OpcionBooleana opcion3 = new OpcionBooleana("quizas",true);
        OpcionBooleana opcion4 = new OpcionBooleana("para nada",false);
        OpcionBooleana opcion5 = new OpcionBooleana("nunca",false);

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        todasLasOpciones.add(opcion3);
        todasLasOpciones.add(opcion4);
        todasLasOpciones.add(opcion5);

        Jugador jugador1 = new Jugador("Iván");
        Jugador jugador2 = new Jugador("Aldu");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        //Opciones elegidas por el Jugador 1.
        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion1);
        opcionesJugador1.add(opcion2);
        opcionesJugador1.add(opcion4);

        //Opciones elegidas por el Jugador 2.
        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        opcionesJugador2.add(opcion1);
        opcionesJugador2.add(opcion4);
        opcionesJugador2.add(opcion5);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2, jugador2.puntaje());
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        ModalidadPenalidad conPenalidad = new ModalidadPenalidad();
        MultipleChoice preguntaTest = new MultipleChoice("¿La tierra es plana?", todasLasOpciones, conPenalidad);
        jugador1.usarMultiplicador(preguntaTest, 2);
        jugador2.usarMultiplicador(preguntaTest, 2);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(2, jugador1.puntaje().getPuntaje());
        assertEquals(-2, jugador2.puntaje().getPuntaje());

    }

    @Test
    public void test08_5ResponderMultipleChoiceConPenalidadyMultiplicadorX2UnaCorrectaYDosErroneasDeTres(){

        OpcionBooleana opcion1 = new OpcionBooleana("Si",true);
        OpcionBooleana opcion2 = new OpcionBooleana("Totalmente",true);
        OpcionBooleana opcion3 = new OpcionBooleana("quizas",true);
        OpcionBooleana opcion4 = new OpcionBooleana("para nada",false);
        OpcionBooleana opcion5 = new OpcionBooleana("nunca",false);

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        todasLasOpciones.add(opcion3);
        todasLasOpciones.add(opcion4);
        todasLasOpciones.add(opcion5);

        Jugador jugador1 = new Jugador("Iván");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        //Opciones elegidas por el Jugador 1.
        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion1);
        opcionesJugador1.add(opcion4);
        opcionesJugador1.add(opcion5);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        ModalidadPenalidad conPenalidad = new ModalidadPenalidad();
        MultipleChoice preguntaTest = new MultipleChoice("¿La tierra es plana?", todasLasOpciones, conPenalidad);
        jugador1.usarMultiplicador(preguntaTest, 2);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(-2, jugador1.puntaje().getPuntaje());
    }

    @Test
    public void test08_6ResponderMultipleChoiceConPenalidadJugadorUsaElMultiplicadorDosVecesYSoloCambiaElPrimerPuntaje(){

        OpcionBooleana opcion1 = new OpcionBooleana("Si",true);
        OpcionBooleana opcion2 = new OpcionBooleana("Totalmente",true);
        OpcionBooleana opcion3 = new OpcionBooleana("quizas",true);
        OpcionBooleana opcion4 = new OpcionBooleana("para nada",false);
        OpcionBooleana opcion5 = new OpcionBooleana("nunca",false);

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        todasLasOpciones.add(opcion3);
        todasLasOpciones.add(opcion4);
        todasLasOpciones.add(opcion5);

        Jugador jugador1 = new Jugador("Iván");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        //Opciones elegidas por el Jugador 1.
        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion1);
        opcionesJugador1.add(opcion4);
        opcionesJugador1.add(opcion5);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        ModalidadPenalidad conPenalidad = new ModalidadPenalidad();
        MultipleChoice preguntaTest = new MultipleChoice("¿La tierra es plana?", todasLasOpciones, conPenalidad);
        jugador1.usarMultiplicador(preguntaTest, 2);
        preguntaTest.responderPregunta(respuestas);
        jugador1.usarMultiplicador(preguntaTest, 2);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(-3, jugador1.puntaje().getPuntaje());

    }

    @Test
    public void test08_7ResponderMultipleChoiceConPenalidadJugadoresUsanElMultiplicadorDosVecesYSoloCambiaElPrimerPuntaje(){

        OpcionBooleana opcion1 = new OpcionBooleana("Si",true);
        OpcionBooleana opcion2 = new OpcionBooleana("Totalmente",true);
        OpcionBooleana opcion3 = new OpcionBooleana("quizas",true);
        OpcionBooleana opcion4 = new OpcionBooleana("para nada",false);
        OpcionBooleana opcion5 = new OpcionBooleana("nunca",false);

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        todasLasOpciones.add(opcion3);
        todasLasOpciones.add(opcion4);
        todasLasOpciones.add(opcion5);

        Jugador jugador1 = new Jugador("Iván");

        Jugador jugador2 = new Jugador("Enrique");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        //Opciones elegidas por el Jugador 1.
        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion1);
        opcionesJugador1.add(opcion4);
        opcionesJugador1.add(opcion5);

        //Opciones elegidas por el Jugador 2.
        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        opcionesJugador2.add(opcion1);
        opcionesJugador2.add(opcion2);
        opcionesJugador2.add(opcion4);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2, jugador2.puntaje());

        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        ModalidadPenalidad conPenalidad = new ModalidadPenalidad();
        MultipleChoice preguntaTest = new MultipleChoice("¿La tierra es plana?", todasLasOpciones, conPenalidad);
        jugador1.usarMultiplicador(preguntaTest, 2);
        jugador2.usarMultiplicador(preguntaTest, 2);
        preguntaTest.responderPregunta(respuestas);
        jugador1.usarMultiplicador(preguntaTest, 2);
        jugador2.usarMultiplicador(preguntaTest, 2);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(-3, jugador1.puntaje().getPuntaje());
        assertEquals(3, jugador2.puntaje().getPuntaje());
    }
}
