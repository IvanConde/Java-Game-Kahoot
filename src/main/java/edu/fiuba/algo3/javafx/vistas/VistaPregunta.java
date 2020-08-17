package edu.fiuba.algo3.javafx.vistas;

import edu.fiuba.algo3.javafx.Partida;
import edu.fiuba.algo3.javafx.controladores.*;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionGroup;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class VistaPregunta {

    private ArrayList<Jugador> jugadores;
    private VistaMultiplicadores vistaMultiplicadores;
    private Partida partida;
    private Stage window;
    private Scene sceneJuego;
    private CicloPreguntas cicloPreguntas;
    private VistaJuego vistaJuego;

    public VistaPregunta(ArrayList<Jugador> jugadores, Stage stage, Partida partida, VistaJuego vistaJuego) {
        this.jugadores = jugadores;
        this.window = stage;
        this.vistaMultiplicadores = new VistaMultiplicadores(window);
        this.partida = partida;
        this.vistaJuego = vistaJuego;
    }

    public void construirPantallas(Pregunta pregunta) {
            Jugador jugadorActual = this.partida.obtenerJugadorActual();
            if (pregunta.tienePenalidad()) {
                vistaMultiplicadores.desplegar(pregunta, jugadorActual, this);
            }else {
                this.mostrarPregunta(pregunta, jugadorActual);
                System.out.println("Se construyo una pregunta");
            }
    }

    public void mostrarPregunta(Pregunta pregunta, Jugador jugadorActual) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(30), new AccionBotonTerminarTurno(pregunta, partida, this)));
        Label nombreJugadorLabel = new Label("Responde " + jugadorActual.verNombre() + ":");
        Label preguntaUsuario = new Label(pregunta.verPregunta());
        VBox layoutJuego = new VBox();
        layoutJuego.getChildren().add(nombreJugadorLabel);
        layoutJuego.getChildren().add(preguntaUsuario);
        Button botonContestar = new Button("[Enviar respuesta]");
        /*
        ArrayList<Opcion> opciones = pregunta.verBotones();

        if (pregunta instanceof VerdaderoFalso) {
            this.desplegarBotonesVerdaderoyFalso(layoutJuego, opciones, botonContestar, jugadorActual);
        } else if (pregunta instanceof GroupChoice) {
            desplegarBotonesGroupChoice(layoutJuego, opciones, (GroupChoice) pregunta);
        } else {
            this.desplegarBotonesMultiplesRespuestas(layoutJuego, opciones, jugadorActual);
        }

         */
        botonContestar.setOnAction(new Contestar(timeline, this));
        layoutJuego.getChildren().add(botonContestar);
        //sceneJuego = new Scene(layoutJuego, 640, 480); //640x480
        //window.setScene(sceneJuego);
        window.getScene().setRoot(layoutJuego);
        window.sizeToScene();
        window.show();
        timeline.setCycleCount(1);
        timeline.play();
    }

    public void desplegarBotonesGroupChoice(VBox layoutJuego, ArrayList<Opcion> opciones, GroupChoice pregunta){
        for(Opcion i : opciones){
            if(!(i instanceof OpcionGroup)){
                //TODO: agregar excepcion
            }
            Label opcionTexto = new Label(i.getStringOpcion()+ ":");
            ArrayList<String> grupos = pregunta.devolverGrupos();
            ToggleSwitch botonOpcion = new ToggleSwitch((OpcionGroup) i, grupos.get(0), grupos.get(1));
            //panel.agregarRespuestaJugadorGroup(botonOpcion);
            botonOpcion.setMaxWidth(300);
            layoutJuego.getChildren().add(opcionTexto);
            layoutJuego.getChildren().add(botonOpcion);
        }
    }
    public void desplegarBotonesVerdaderoyFalso(VBox layoutJuego, ArrayList<Opcion> opciones, Button contestar, Jugador jugadorActual){
        Button boton1 = new Button("Verdadero");
        Button boton2 = new Button("Falso");
        //boton1.setOnAction(new AccionBotonOpcionVyF(opciones.get(1), boton1, jugadorActual, contestar, partida));
        //boton2.setOnAction(new AccionBotonOpcionVyF(opciones.get(0), boton2, jugadorActual, contestar, partida));
        layoutJuego.getChildren().add(boton1);
        layoutJuego.getChildren().add(boton2);
    }
    public void desplegarBotonesMultiplesRespuestas(VBox layoutJuego, ArrayList<Opcion> opciones, Jugador jugadorActual){
        for(Opcion i : opciones){
            Button botonOpcion = new Button(i.getStringOpcion());
            //botonOpcion.setOnAction(new AccionBotonOpcion(i, botonOpcion, panel, jugadorActual));
            layoutJuego.getChildren().add(botonOpcion);
        }
    }
    
    /*
    public void recolectarRespuestasGroup(Jugador jugadorActual){
        for(ToggleSwitch interruptor : respuestasJugadorGroup){
            if(jugadorActual == 1){
                interruptor.respuestaJugador(opcionesJugador1);
            }else {
                interruptor.respuestaJugador(opcionesJugador2);
            }
        }
        respuestasJugadorGroup = new ArrayList<ToggleSwitch>();
    }
     */

    public void proximaPregunta(){
        vistaJuego.mostrar();
    }
}
