package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class GroupChoiceTest {
    @Test
    public void test06_1SeCreaGroupChoiceConOpcionesEnGruposCorrectos(){
        //Ordenar en los grupos:
        //Grupo 0 = numeros primos
        //Grupo 1 = numeros no primos
        OpcionGroup opcion1 = new OpcionGroup("2",0);
        OpcionGroup opcion2 = new OpcionGroup("8",1);
        OpcionGroup opcion3 = new OpcionGroup("13",0);
        OpcionGroup opcion4 = new OpcionGroup("12",1);
        OpcionGroup opcion5 = new OpcionGroup("17",0);


        Jugador jugador = new Jugador("Ivan");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        ArrayList<Opcion> opcionesJugador = new ArrayList<Opcion>();
        OpcionOrdered opcion1Jugador = new OpcionOrdered(opcion1.getStringOpcion(), opcion1.getGrupoOriginal(), 0);
        OpcionOrdered opcion2Jugador = new OpcionOrdered(opcion2.getStringOpcion(), opcion2.getGrupoOriginal(), 1);
        OpcionOrdered opcion3Jugador = new OpcionOrdered(opcion3.getStringOpcion(), opcion3.getGrupoOriginal(), 0);
        OpcionOrdered opcion4Jugador = new OpcionOrdered(opcion4.getStringOpcion(), opcion4.getGrupoOriginal(), 1);
        OpcionOrdered opcion5Jugador = new OpcionOrdered(opcion5.getStringOpcion(), opcion5.getGrupoOriginal(), 0);

        opcionesJugador.add(opcion1Jugador);
        opcionesJugador.add(opcion2Jugador);
        opcionesJugador.add(opcion3Jugador);
        opcionesJugador.add(opcion4Jugador);
        opcionesJugador.add(opcion5Jugador);

        Respuesta respuesta = new Respuesta(opcionesJugador,jugador.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        GroupChoice preguntaTest = new GroupChoice("Colocar en el grupo 0 los numeros primos y en el grupo 1 los no-primos", opciones);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(1,jugador.puntaje().getPuntaje());
    }
    @Test
    public void test06_2GroupChoiceConAlgunasOrdenadasCorrectamente() {
        //Ordenar en los grupos:
        //Grupo 0 = numeros primos
        //Grupo 1 = numeros no primos
        OpcionGroup opcion1 = new OpcionGroup("2", 0);
        OpcionGroup opcion2 = new OpcionGroup("8", 1);
        OpcionGroup opcion3 = new OpcionGroup("13", 0);
        OpcionGroup opcion4 = new OpcionGroup("12", 1);
        OpcionGroup opcion5 = new OpcionGroup("17", 0);


        Jugador jugador = new Jugador("Ivan");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        ArrayList<Opcion> opcionesJugador = new ArrayList<Opcion>();
        OpcionOrdered opcion1Jugador = new OpcionOrdered(opcion1.getStringOpcion(), opcion1.getGrupoOriginal(), 0);
        OpcionOrdered opcion2Jugador = new OpcionOrdered(opcion2.getStringOpcion(), opcion2.getGrupoOriginal(), 1);
        OpcionOrdered opcion3Jugador = new OpcionOrdered(opcion3.getStringOpcion(), opcion3.getGrupoOriginal(), 1);
        OpcionOrdered opcion4Jugador = new OpcionOrdered(opcion4.getStringOpcion(), opcion4.getGrupoOriginal(), 0);
        OpcionOrdered opcion5Jugador = new OpcionOrdered(opcion5.getStringOpcion(), opcion5.getGrupoOriginal(), 0);

        opcionesJugador.add(opcion1Jugador);
        opcionesJugador.add(opcion2Jugador);
        opcionesJugador.add(opcion3Jugador);
        opcionesJugador.add(opcion4Jugador);
        opcionesJugador.add(opcion5Jugador);

        Respuesta respuesta = new Respuesta(opcionesJugador, jugador.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        GroupChoice preguntaTest = new GroupChoice("Colocar en el grupo 0 los numeros primos y en el grupo 1 los no-primos", opciones);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0, jugador.puntaje().getPuntaje());
    }
    @Test
    public void test06_3OrderedChoiceConDosJugadoresConUnoTodasCorrectasYOtrasTodasIncorrectas(){
        //Ordenar en los grupos:
        //Grupo 0 = numeros primos
        //Grupo 1 = numeros no primos
        OpcionGroup opcion1 = new OpcionGroup("2",0);
        OpcionGroup opcion2 = new OpcionGroup("8",1);
        OpcionGroup opcion3 = new OpcionGroup("13",0);
        OpcionGroup opcion4 = new OpcionGroup("12",1);
        OpcionGroup opcion5 = new OpcionGroup("17",0);


        Jugador jugador1 = new Jugador("Ivan");
        Jugador jugador2 = new Jugador("Enrique");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        OpcionOrdered opcion1Jugador1 = new OpcionOrdered(opcion1.getStringOpcion(), opcion1.getGrupoOriginal(), 1);
        OpcionOrdered opcion2Jugador1 = new OpcionOrdered(opcion2.getStringOpcion(), opcion2.getGrupoOriginal(), 0);
        OpcionOrdered opcion3Jugador1 = new OpcionOrdered(opcion3.getStringOpcion(), opcion3.getGrupoOriginal(), 1);
        OpcionOrdered opcion4Jugador1 = new OpcionOrdered(opcion4.getStringOpcion(), opcion4.getGrupoOriginal(), 0);
        OpcionOrdered opcion5Jugador1 = new OpcionOrdered(opcion5.getStringOpcion(), opcion5.getGrupoOriginal(), 1);

        opcionesJugador1.add(opcion1Jugador1);
        opcionesJugador1.add(opcion2Jugador1);
        opcionesJugador1.add(opcion3Jugador1);
        opcionesJugador1.add(opcion4Jugador1);
        opcionesJugador1.add(opcion5Jugador1);


        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        OpcionOrdered opcion1Jugador2 = new OpcionOrdered(opcion1.getStringOpcion(), opcion1.getGrupoOriginal(), 0);
        OpcionOrdered opcion2Jugador2 = new OpcionOrdered(opcion2.getStringOpcion(), opcion2.getGrupoOriginal(), 1);
        OpcionOrdered opcion3Jugador2 = new OpcionOrdered(opcion3.getStringOpcion(), opcion3.getGrupoOriginal(), 0);
        OpcionOrdered opcion4Jugador2 = new OpcionOrdered(opcion4.getStringOpcion(), opcion4.getGrupoOriginal(), 1);
        OpcionOrdered opcion5Jugador2 = new OpcionOrdered(opcion5.getStringOpcion(), opcion5.getGrupoOriginal(), 0);

        opcionesJugador1.add(opcion1Jugador2);
        opcionesJugador1.add(opcion2Jugador2);
        opcionesJugador1.add(opcion3Jugador2);
        opcionesJugador1.add(opcion4Jugador2);
        opcionesJugador1.add(opcion5Jugador2);

        Respuesta respuesta1 = new Respuesta(opcionesJugador1,jugador1.puntaje());
        Respuesta respuesta2 = new Respuesta(opcionesJugador2,jugador2.puntaje());

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        GroupChoice preguntaTest = new GroupChoice("Colocar en el grupo 0 los numeros primos y en el grupo 1 los no-primos", opciones);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0,jugador1.puntaje().getPuntaje());
        assertEquals(1,jugador2.puntaje().getPuntaje());
    }
}
