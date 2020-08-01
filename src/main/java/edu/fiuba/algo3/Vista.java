package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Vista {
    /*
    Stage window;
    Controlador control;
    Scene sceneIngresoNombres, sceneJuego;
    public Vista(Stage stage, Controlador controlador){
        this.window = stage;
        this.control = controlador;
        stage.setTitle("Kahoot2.0");
    }
    public void inicialJuego(){
        Label textoInfo = new Label("Inserte nombre del primer jugador y presione ENTER");
        TextField textField = new TextField();
        control.agregarAccionEnter(textField, textoInfo);
        VBox layoutInicial = new VBox();
        layoutInicial.getChildren().add(textoInfo);
        layoutInicial.getChildren().add(textField);
        sceneIngresoNombres = new Scene(layoutInicial, 640, 480);
        this.window.setScene(sceneIngresoNombres);
        this.window.show();
    }
    public void juego(){
            control.controlarPreguntas();
    }
    public void mostrarPregunta(Pregunta pregunta){
        Label preguntaUsuario = new Label(pregunta.verPregunta());
        ArrayList<Opcion> opciones = pregunta.verBotones();
        VBox layoutJuego = new VBox();
        layoutJuego.getChildren().add(preguntaUsuario);
        for(Opcion i : opciones){
            Button botonOpcion = new Button(i);
            control.agregarAccionBotonOpcion(botonOpcion, i);
            layoutJuego.getChildren().add(botonOpcion);
        }
        sceneJuego = new Scene(layoutJuego, 640, 480);
        window.setScene(sceneJuego);
    }

     */
}
