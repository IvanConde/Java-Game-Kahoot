package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        opcion1.elegirGrupo(0, opcionesJugador);
        opcion2.elegirGrupo(1, opcionesJugador);
        opcion3.elegirGrupo(0, opcionesJugador);
        opcion4.elegirGrupo(1, opcionesJugador);
        opcion5.elegirGrupo(0, opcionesJugador);
        /*OpcionGroup opcion1Jugador = new OpcionGroup(opcion1.getStringOpcion(), opcion1.getGrupoOriginal(), 0);
        OpcionGroup opcion2Jugador = new OpcionGroup(opcion2.getStringOpcion(), opcion2.getGrupoOriginal(), 1);
        OpcionGroup opcion3Jugador = new OpcionGroup(opcion3.getStringOpcion(), opcion3.getGrupoOriginal(), 0);
        OpcionGroup opcion4Jugador = new OpcionGroup(opcion4.getStringOpcion(), opcion4.getGrupoOriginal(), 1);
        OpcionGroup opcion5Jugador = new OpcionGroup(opcion5.getStringOpcion(), opcion5.getGrupoOriginal(), 0);

        opcionesJugador.add(opcion1Jugador);
        opcionesJugador.add(opcion2Jugador);
        opcionesJugador.add(opcion3Jugador);
        opcionesJugador.add(opcion4Jugador);
        opcionesJugador.add(opcion5Jugador);*/

        Respuesta respuesta = new Respuesta(opcionesJugador,jugador.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        GroupChoice preguntaTest = new GroupChoice("Colocar en el grupo 0 los numeros primos y en el grupo 1 los no-primos", opciones, new Clasico());
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
        opcion1.elegirGrupo(1, opcionesJugador);
        opcion2.elegirGrupo(0, opcionesJugador);
        opcion3.elegirGrupo(0, opcionesJugador);
        opcion4.elegirGrupo(1, opcionesJugador);
        opcion5.elegirGrupo(0, opcionesJugador);
        /*OpcionGroup opcion1Jugador = new OpcionGroup(opcion1.getStringOpcion(), opcion1.getGrupoOriginal(), 1);
        OpcionGroup opcion2Jugador = new OpcionGroup(opcion2.getStringOpcion(), opcion2.getGrupoOriginal(), 0);
        OpcionGroup opcion3Jugador = new OpcionGroup(opcion3.getStringOpcion(), opcion3.getGrupoOriginal(), 0);
        OpcionGroup opcion4Jugador = new OpcionGroup(opcion4.getStringOpcion(), opcion4.getGrupoOriginal(), 1);
        OpcionGroup opcion5Jugador = new OpcionGroup(opcion5.getStringOpcion(), opcion5.getGrupoOriginal(), 0);

        opcionesJugador.add(opcion1Jugador);
        opcionesJugador.add(opcion2Jugador);
        opcionesJugador.add(opcion3Jugador);
        opcionesJugador.add(opcion4Jugador);
        opcionesJugador.add(opcion5Jugador);*/

        Respuesta respuesta = new Respuesta(opcionesJugador, jugador.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        GroupChoice preguntaTest = new GroupChoice("Colocar en el grupo 0 los numeros primos y en el grupo 1 los no-primos", opciones, new Clasico());
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0, jugador.puntaje().getPuntaje());
    }

    @Test
    public void test06_3GroupChoiceConDosJugadoresConUnoTodasCorrectasYOtrasTodasIncorrectas(){

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
        opcion1.elegirGrupo(0, opcionesJugador1);
        opcion2.elegirGrupo(1, opcionesJugador1);
        opcion3.elegirGrupo(0, opcionesJugador1);
        opcion4.elegirGrupo(1, opcionesJugador1);
        opcion5.elegirGrupo(0, opcionesJugador1);
        /*OpcionGroup opcion1Jugador1 = new OpcionGroup(opcion1.getStringOpcion(), opcion1.getGrupoOriginal(), 0);
        OpcionGroup opcion2Jugador1 = new OpcionGroup(opcion2.getStringOpcion(), opcion2.getGrupoOriginal(), 1);
        OpcionGroup opcion3Jugador1 = new OpcionGroup(opcion3.getStringOpcion(), opcion3.getGrupoOriginal(), 0);
        OpcionGroup opcion4Jugador1 = new OpcionGroup(opcion4.getStringOpcion(), opcion4.getGrupoOriginal(), 1);
        OpcionGroup opcion5Jugador1 = new OpcionGroup(opcion5.getStringOpcion(), opcion5.getGrupoOriginal(), 0);

        opcionesJugador1.add(opcion1Jugador1);
        opcionesJugador1.add(opcion2Jugador1);
        opcionesJugador1.add(opcion3Jugador1);
        opcionesJugador1.add(opcion4Jugador1);
        opcionesJugador1.add(opcion5Jugador1);*/

        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        opcion1.elegirGrupo(1, opcionesJugador1);
        opcion2.elegirGrupo(0, opcionesJugador1);
        opcion3.elegirGrupo(1, opcionesJugador1);
        opcion4.elegirGrupo(0, opcionesJugador1);
        opcion5.elegirGrupo(1, opcionesJugador1);
        /*OpcionGroup opcion1Jugador2 = new OpcionGroup(opcion1.getStringOpcion(), opcion1.getGrupoOriginal(), 1);
        OpcionGroup opcion2Jugador2 = new OpcionGroup(opcion2.getStringOpcion(), opcion2.getGrupoOriginal(), 0);
        OpcionGroup opcion3Jugador2 = new OpcionGroup(opcion3.getStringOpcion(), opcion3.getGrupoOriginal(), 1);
        OpcionGroup opcion4Jugador2 = new OpcionGroup(opcion4.getStringOpcion(), opcion4.getGrupoOriginal(), 0);
        OpcionGroup opcion5Jugador2 = new OpcionGroup(opcion5.getStringOpcion(), opcion5.getGrupoOriginal(), 1);

        opcionesJugador1.add(opcion1Jugador2);
        opcionesJugador1.add(opcion2Jugador2);
        opcionesJugador1.add(opcion3Jugador2);
        opcionesJugador1.add(opcion4Jugador2);
        opcionesJugador1.add(opcion5Jugador2);*/

        Respuesta respuesta1 = new Respuesta(opcionesJugador1,jugador1.puntaje());
        Respuesta respuesta2 = new Respuesta(opcionesJugador2,jugador2.puntaje());

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        GroupChoice preguntaTest = new GroupChoice("Colocar en el grupo 0 los numeros primos y en el grupo 1 los no-primos", opciones, new Clasico());
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0,jugador1.puntaje().getPuntaje());
        assertEquals(1,jugador2.puntaje().getPuntaje());

    }

    @Test
    public void test06_4GroupChoiceConPenalidadLanzaExcepcion(){
        ArrayList <Opcion> opciones = new ArrayList<Opcion>();

        assertThrows(GroupChoiceModalidadInvalidaException.class,() -> {
            GroupChoice preguntaTest = new GroupChoice("Ordenar de menor a mayor", opciones, new Penalidad());
        });
    }


    @Test
    public void test06_5GroupChoiceConModalidadpParcialLanzaExcepcion(){
        ArrayList <Opcion> opciones = new ArrayList<Opcion>();

        assertThrows(GroupChoiceModalidadInvalidaException.class,() -> {
            GroupChoice preguntaTest = new GroupChoice("Ordenar de menor a mayor", opciones, new Parcial());
        });
    }

}