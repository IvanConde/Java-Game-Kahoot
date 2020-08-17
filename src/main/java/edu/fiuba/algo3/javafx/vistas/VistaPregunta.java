package edu.fiuba.algo3.javafx.vistas;

import edu.fiuba.algo3.javafx.controladores.AccionBotonOpcion;
import edu.fiuba.algo3.javafx.controladores.AccionBotonOpcionVyF;
import edu.fiuba.algo3.javafx.controladores.AccionBotonTerminarTurno;
import edu.fiuba.algo3.javafx.controladores.ToggleSwitch;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class VistaPregunta {

    private ArrayList<Jugador> jugadores;
    private VistaMultiplicadores vistaMultiplicadores;

    public VistaPregunta(ArrayList<Jugador> jugadores, Stage stage) {
        this.jugadores = jugadores;
        this.vistaMultiplicadores = new VistaMultiplicadores(stage);
    }

    public void construirPantallas(Pregunta pregunta) {
        for (Jugador jugador : jugadores) {
            if (pregunta.tienePenalidad()) {
                vistaMultiplicadores.desplegar(pregunta, jugador);
            }
            this.mostrarPregunta(pregunta, jugador);
        }

    }

    public void mostrarPregunta(Pregunta pregunta, Jugador jugador) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(30), new AccionBotonTerminarTurno(this, pregunta)));
        Label nombreJugadorLabel = new Label("Responde " + jugador.verNombre() + ":");
        Label preguntaUsuario = new Label(pregunta.verPregunta());
        ArrayList<Opcion> opciones = pregunta.verBotones();
        VBox layoutJuego = new VBox();
        layoutJuego.getChildren().add(nombreJugadorLabel);
        layoutJuego.getChildren().add(preguntaUsuario);
        Button botonContestar = new Button("[Enviar respuesta]");

        if (pregunta instanceof VerdaderoFalso) {
            this.desplegarBotonesVerdaderoyFalso(layoutJuego, opciones, botonContestar, jugador);
        } else if (pregunta instanceof GroupChoice) {
            desplegarBotonesGroupChoice(layoutJuego, opciones, (GroupChoice) pregunta);
        } else {
            this.desplegarBotonesMultiplesRespuestas(layoutJuego, opciones, jugador);
        }
    }



    public void desplegarBotonesGroupChoice(VBox layoutJuego, ArrayList<Opcion> opciones, GroupChoice pregunta){
        for(Opcion i : opciones){
            if(!(i instanceof OpcionGroup)){
                //TODO: agregar excepcion
            }
            Label opcionTexto = new Label(i.getStringOpcion()+ ":");
            ArrayList<String> grupos = pregunta.devolverGrupos();
            ToggleSwitch botonOpcion = new ToggleSwitch((OpcionGroup) i, grupos.get(0), grupos.get(1));
            panel.agregarRespuestaJugadorGroup(botonOpcion);
            botonOpcion.setMaxWidth(300);
            layoutJuego.getChildren().add(opcionTexto);
            layoutJuego.getChildren().add(botonOpcion);
        }
    }
    public void desplegarBotonesVerdaderoyFalso(VBox layoutJuego, ArrayList<Opcion> opciones, Button contestar, Jugador jugador){
        Button boton1 = new Button("Verdadero");
        Button boton2 = new Button("Falso");
        boton1.setOnAction(new AccionBotonOpcionVyF(opciones.get(1), boton1, jugador, contestar));
        boton2.setOnAction(new AccionBotonOpcionVyF(opciones.get(0), boton2, jugador, contestar));
        layoutJuego.getChildren().add(boton1);
        layoutJuego.getChildren().add(boton2);
    }
    public void desplegarBotonesMultiplesRespuestas(VBox layoutJuego, ArrayList<Opcion> opciones, Jugador jugador){
        for(Opcion i : opciones){
            Button botonOpcion = new Button(i.getStringOpcion());
            botonOpcion.setOnAction(new AccionBotonOpcion(i, botonOpcion, panel, jugador));
            layoutJuego.getChildren().add(botonOpcion);
        }
    }
    
    /*
    public void recolectarRespuestasGroup(Jugador jugador){
        for(ToggleSwitch interruptor : respuestasJugadorGroup){
            if(jugador == 1){
                interruptor.respuestaJugador(opcionesJugador1);
            }else {
                interruptor.respuestaJugador(opcionesJugador2);
            }
        }
        respuestasJugadorGroup = new ArrayList<ToggleSwitch>();
    }
     */
}
