package edu.fiuba.algo3.javafx;


import edu.fiuba.algo3.javafx.controladores.ToggleSwitch;
import edu.fiuba.algo3.javafx.vistas.VistaInicial;
import edu.fiuba.algo3.javafx.vistas.VistaJuego;
import edu.fiuba.algo3.modelo.*;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
/*import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;*/


public class Panel { // Panel es el modelo de un MVC
    private Jugador jugador1;
    private Jugador jugador2;
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private VistaInicial vistaInicial;
    private VistaJuego vistaJuego;
    private Stage stage;

    public Panel(Stage stage){
        this.stage = stage;
        this.vistaInicial = new VistaInicial(stage);
    }

    public void iniciarJuego(){
        stage.setTitle("Kahoot2.0");
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        //MediaPlayer player = new MediaPlayer(media);
        //player.play();
        this.vistaInicial.mostrar(this);
    }

    public boolean juegoPuedeComenzar(){
        if(jugador1 == null || jugador2 == null ){ return false;}
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        return true;
    }

    public void agregarJugador(String nombre){
        if (this.jugador1 == null){
            this.jugador1 = new Jugador(nombre);
        }else {
            this.jugador2 = new Jugador(nombre);
        }
    }

    public void comenzarJuego(){
        this.vistaJuego = new VistaJuego(stage, jugadores);
        this.vistaJuego.mostrar();
    }

    /*
    public void agregarRespuestaJugador(Opcion opcion, int cualJugador){
        System.out.println(opcion.getStringOpcion());
        if(cualJugador == 1){
            agregarRespuesta(opcionesJugador1, opcion);
        }else{
            agregarRespuesta(opcionesJugador2, opcion);
        }
    }
    public void agregarRespuesta(ArrayList<Opcion> opcionesJugador, Opcion opcion){
        if(preguntaActual instanceof OrderedChoice){
            if(opcion instanceof OpcionOrdered){
                OpcionOrdered opcionEstructurada = (OpcionOrdered) opcion;
                opcionEstructurada.elegirPosicion(opcionesJugador.size() + 1, opcionesJugador);
            }else{
                //TODO: misma excepcion que con group
            }
        }else {
            opcionesJugador.add(opcion);
        }
    }
    public void responderPregunta(){
        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2, jugador2.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        preguntaActual.responderPregunta(respuestas);
        opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador2 = new ArrayList<Opcion>();
        System.out.println(jugador1.puntaje().getPuntaje());
        System.out.println(jugador2.puntaje().getPuntaje());
    }

    public Pregunta obtenerPreguntaAleatoria(){
        int tamaño = this.queue.size();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(tamaño);
        Pregunta pregunta = (Pregunta) this.queue.remove(randomInt);
        this.preguntaActual = pregunta;
        return pregunta;
    }
    public String nombreJugador(int cualJugador){
        if(cualJugador == 1){
            return jugador1.verNombre();
        }
        return jugador2.verNombre();
    }
    public Boolean jugadorTieneMultiplicadorx2(int cualJugador){
        if(cualJugador == 1){
            return jugador1.tieneMultiplicadorx2();
        }
        return jugador2.tieneMultiplicadorx2();
    }
    public Boolean jugadorTieneMultiplicadorx3(int cualJugador){
        if(cualJugador == 1){
            return jugador1.tieneMultiplicadorx3();
        }
        return jugador2.tieneMultiplicadorx3();
    }
    public void usarMultiplicadorJugadorX2(Pregunta pregunta, int cualJugador){
        if(cualJugador == 1){
            jugador1.usarMultiplicadorX2(pregunta);
        }else{
            jugador2.usarMultiplicadorX2(pregunta);
        }
    }
    public void usarMultiplicadorJugadorX3(Pregunta pregunta, int cualJugador){
        if(cualJugador == 1){
            jugador1.usarMultiplicadorX3(pregunta);
        }else{
            jugador2.usarMultiplicadorX3(pregunta);
        }
    }
    public int puntajeJugador(int cualJugador){
        if(cualJugador == 1){
            return jugador1.puntaje().getPuntaje();
        }
        return jugador2.puntaje().getPuntaje();
    }
    public void agregarRespuestaJugadorGroup(ToggleSwitch interruptor){
        respuestasJugadorGroup.add(interruptor);
    }
    public void recolectarRespuestasGroup(int cualJugador){
        for(ToggleSwitch interruptor : respuestasJugadorGroup){
            if(cualJugador == 1){
                interruptor.respuestaJugador(opcionesJugador1);
            }else {
                interruptor.respuestaJugador(opcionesJugador2);
            }
        }
        respuestasJugadorGroup = new ArrayList<ToggleSwitch>();
    }
     */
}
