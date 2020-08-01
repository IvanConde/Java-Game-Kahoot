package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Clasico;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.VerdaderoFalso;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Controlador {
    /*
    Vista ventana;
    Panel panel;
    public void comienzo(Stage stage){
        this.ventana = new Vista(stage, this);
        this.panel = new Panel();
        this.ventana.inicialJuego();
    }
    public void agregarAccionBotonOpcion(Button boton, String opcion){
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println(opcion);
                boton.setDisable(true);
            }
        });
    }
    public void agregarAccionEnter(TextField barraTexto, Label textoInfo){
        EventHandler<KeyEvent> enterentexto = new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent ke)
            {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    textoInfo.setText("Inserte nombre del segundo jugador y presione ENTER");
                    panel.agregarJugador(barraTexto.getText());
                    barraTexto.clear();
                    if(panel.juegoPuedeComenzar()) {
                        ventana.juego();
                    }
                }
            }
        };
        barraTexto.setOnKeyPressed(enterentexto);
    }
    public void controlarPreguntas(){
        Pregunta pregunta = this.generarpregunta();
        ventana.mostrarPregunta(pregunta);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {

            private int i = 1;

            @Override
            public void handle(ActionEvent event) {
                ventana.mostrarPregunta(pregunta);
                i++;
            }
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }
    public Pregunta generarpregunta(){
        return this.panel.crearPregunta();
    }

     */
}
