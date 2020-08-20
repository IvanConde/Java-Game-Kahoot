package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.modalidades.ModalidadPenalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionBooleana;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

public class MultipleChoiceModalidadPenalidadTest {

    @Test
    public void test05_1ResponderMultipleChoiceConPenalidadCorrectamenteUnJugadorTodoBienYOtroTodoMal(){

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

        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Sofia");

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
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todasLasOpciones, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(2, jugador1.puntaje().getPuntaje());
        assertEquals(-1, jugador2.puntaje().getPuntaje());

    }

    @Test
    public void test05_3ResponderMultipleChoiceConPenalidadUnaRespuestaCorrectaDeDos(){

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

        Jugador jugador1 = new Jugador("Federico");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        //Opciones elegidas por el Jugador 1.
        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion1);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        ModalidadPenalidad conPenalidad = new ModalidadPenalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todasLasOpciones, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());

    }

    @Test
    public void test05_4ResponderMultipleChoiceConPenalidadUnaCorrectaYUnaErroneaDeDos(){

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

        Jugador jugador1 = new Jugador("Federico");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        //Opciones elegidas por el Jugador 1.
        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion1);
        opcionesJugador1.add(opcion4);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        ModalidadPenalidad conPenalidad = new ModalidadPenalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todasLasOpciones, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(0, jugador1.puntaje().getPuntaje());

    }

    @Test
    public void test05_5ResponderMultipleChoiceConPenalidadConDosJugadores(){

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

        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Sofia");

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
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todasLasOpciones, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
        assertEquals(-1, jugador2.puntaje().getPuntaje());

    }

    @Test
    public void test05_6ResponderMultipleChoiceConPenalidadUnaCorrectaYDosErroneasDeTres(){

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

        Jugador jugador1 = new Jugador("Federico");

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        //Opciones elegidas por el Jugador 1.
        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion1);
        opcionesJugador1.add(opcion4);
        opcionesJugador1.add(opcion5);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        ModalidadPenalidad conPenalidad = new ModalidadPenalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todasLasOpciones, conPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(-1, jugador1.puntaje().getPuntaje());

    }

    @Test
    public void test05_7ResponderMultipleChoiceyAsignarPuntajesCorrectamenteConExclusividadPuntaje(){

        OpcionBooleana opcion1 = new OpcionBooleana("Si",true);
        OpcionBooleana opcion2 = new OpcionBooleana("Totalmente",true);
        OpcionBooleana opcion3 = new OpcionBooleana("no",false);
        OpcionBooleana opcion4 = new OpcionBooleana("para nada",false);
        OpcionBooleana opcion5 = new OpcionBooleana("nunca",false);

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        todasLasOpciones.add(opcion3);
        todasLasOpciones.add(opcion4);
        todasLasOpciones.add(opcion5);

        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Milagros");


        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion1);
        opcionesJugador1.add(opcion2);


        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        opcionesJugador2.add(opcion1);
        opcionesJugador2.add(opcion2);

        //Se instancian las respuestas con la lista de opciones elegidas y el puntaje del jugador.
        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2, jugador2.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        ModalidadPenalidad penalidad = new ModalidadPenalidad();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todasLasOpciones, penalidad);
        preguntaTest.usarExclusividad(jugador1);
        preguntaTest.usarExclusividad(jugador2);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(2, jugador1.puntaje().getPuntaje());
    }

}