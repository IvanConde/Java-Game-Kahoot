package edu.fiuba.algo3.modelo;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.json.simple.JSONObject;

import java.io.*;

import java.util.ArrayList;

public class MultipleChoiceClasicoTest {
    @Test
    public void test03_1CrearMultipleChoiceClasico() throws FileNotFoundException {
        Jugador jugador = new Jugador("Nicolas");
        JSONParser parser = new JSONParser();
        try(Reader reader = new FileReader("preguntas.json")){
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);

            JSONObject multipleChoice = (JSONObject) jsonObject.get("MultipleChoice");

            JSONObject pregunta1 = (JSONObject) multipleChoice.get("Pregunta1");
            String textoPregunta = (String) pregunta1.get("textoPregunta");

            String opcion1texto = (String) pregunta1.get("opcion1Texto");
            boolean opcion1EsCorrecto = (boolean) pregunta1.get("opcion1");

            String opcion2texto = (String) pregunta1.get("opcion2Texto");
            boolean opcion2EsCorrecto = (boolean) pregunta1.get("opcion2");

            String opcion3texto = (String) pregunta1.get("opcion3Texto");
            boolean opcion3EsCorrecto = (boolean) pregunta1.get("opcion3");

            String opcion4texto = (String) pregunta1.get("opcion4Texto");
            boolean opcion4EsCorrecto = (boolean) pregunta1.get("opcion4");

            String opcion5texto = (String) pregunta1.get("opcion5Texto");
            boolean opcion5EsCorrecto = (boolean) pregunta1.get("opcion5");

            OpcionChoice opcion1 = new OpcionChoice(opcion1texto,opcion1EsCorrecto);
            OpcionChoice opcion2 = new OpcionChoice(opcion2texto,opcion2EsCorrecto);
            OpcionChoice opcion3 = new OpcionChoice(opcion3texto,opcion3EsCorrecto);
            OpcionChoice opcion4 = new OpcionChoice(opcion4texto,opcion4EsCorrecto);
            OpcionChoice opcion5 = new OpcionChoice(opcion5texto,opcion5EsCorrecto);

            ArrayList<Opcion> todas = new ArrayList<Opcion>();
            todas.add(opcion1);
            todas.add(opcion2);
            todas.add(opcion3);
            todas.add(opcion4);
            todas.add(opcion5);

            ArrayList<Opcion> opcionesJugador = new ArrayList<Opcion>();
            opcionesJugador.add(opcion2);

            Respuesta respuesta = new Respuesta(opcionesJugador,jugador.puntaje());
            ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
            respuestas.add(respuesta);

            //Se crea la pregunta con la lista de opciones y la modalidad elegida.
            MultipleChoice preguntaTest = new MultipleChoice(textoPregunta, todas, new Clasico());
            preguntaTest.responderPregunta(respuestas);
            assertEquals(1,jugador.puntaje().getPuntaje());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void test03_2ResponderMultipleChoiceyAsignarPuntajesCorrectamente(){
        OpcionChoice opcion1 = new OpcionChoice("Si",true);
        OpcionChoice opcion2 = new OpcionChoice("Totalmente",true);
        OpcionChoice opcion3 = new OpcionChoice("no",false);
        OpcionChoice opcion4 = new OpcionChoice("para nada",false);
        OpcionChoice opcion5 = new OpcionChoice("nunca",false);

        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        todas.add(opcion1);
        todas.add(opcion2);
        todas.add(opcion3);
        todas.add(opcion4);
        todas.add(opcion5);

        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Sofia");

        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion1);
        opcionesJugador1.add(opcion2);

        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        opcionesJugador2.add(opcion3);
        opcionesJugador2.add(opcion4);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        //Se instancian las respuestas con la lista de opciones elegidas y el puntaje del jugador.
        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2, jugador2.puntaje());

        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        Clasico sinPenalidad = new Clasico(); //Modalidad de la pregunta

        //Se crea la pregunta con la lista de opciones y la modalidad elegida.
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, sinPenalidad);

        //Se pasan las respuestas de los jugadores a la pregunta.
        preguntaTest.responderPregunta(respuestas);

        assertEquals(1, jugador1.puntaje().getPuntaje());
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }
    @Test
    public void test03_3ResponderMultipleChoiceyAsignarPuntajesCorrectamenteConUnaDeDosBien(){
        OpcionChoice opcion1 = new OpcionChoice("Si",true);
        OpcionChoice opcion2 = new OpcionChoice("Totalmente",true);
        OpcionChoice opcion3 = new OpcionChoice("no",false);
        OpcionChoice opcion4 = new OpcionChoice("para nada",false);
        OpcionChoice opcion5 = new OpcionChoice("nunca",false);

        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        todas.add(opcion1);
        todas.add(opcion2);
        todas.add(opcion3);
        todas.add(opcion4);
        todas.add(opcion5);

        Jugador jugador1 = new Jugador("Federico");

        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion2);
        opcionesJugador1.add(opcion3);

        //Se instancian las respuestas con la lista de opciones elegidas y el puntaje del jugador.
        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);

        Clasico sinPenalidad = new Clasico();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0, jugador1.puntaje().getPuntaje());
    }
    @Test
    public void test03_4ResponderMultipleChoiceyAsignarPuntajesCorrectamenteConUnaTodasBienYUnaMal(){
        OpcionChoice opcion1 = new OpcionChoice("Si",true);
        OpcionChoice opcion2 = new OpcionChoice("Totalmente",true);
        OpcionChoice opcion3 = new OpcionChoice("no",false);
        OpcionChoice opcion4 = new OpcionChoice("para nada",false);
        OpcionChoice opcion5 = new OpcionChoice("nunca",false);

        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        todas.add(opcion1);
        todas.add(opcion2);
        todas.add(opcion3);
        todas.add(opcion4);
        todas.add(opcion5);

        Jugador jugador1 = new Jugador("Federico");

        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion4);
        opcionesJugador1.add(opcion3);

        //Se instancian las respuestas con la lista de opciones elegidas y el puntaje del jugador.
        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);

        Clasico sinPenalidad = new Clasico();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(0, jugador1.puntaje().getPuntaje());
    }
}
