package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;
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

public class Controlador {
    Vista ventana;
    Panel panel;
    Timeline contadorPantallaActual;
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
        EventHandler<KeyEvent> input = new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent key)
            {
                if (key.getCode().equals(KeyCode.ENTER)) {
                    textoInfo.setText("Inserte nombre del segundo jugador y presione ENTER");
                    panel.agregarJugador(barraTexto.getText());
                    barraTexto.clear();
                    if(panel.juegoPuedeComenzar()) {
                        ventana.juego();
                    }
                }
            }
        };
        barraTexto.setOnKeyPressed(input);
    }
    public void controlarPreguntas(){
        Pregunta pregunta = this.generarPregunta();
        ventana.mostrarPregunta(pregunta, panel.nombreJugador(1));
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(30), new EventHandler<ActionEvent>() {

            private int i = 1;

            @Override
            public void handle(ActionEvent event) {
                System.out.println(contadorPantallaActual.getCycleCount());
                ventana.mostrarPregunta(pregunta, panel.nombreJugador(2));
                i++;
            }
        }));
        contadorPantallaActual = timeline;
        timeline.setCycleCount(1);
        timeline.play();
    }
    public Pregunta generarPregunta(){
        return this.panel.crearPregunta();
    }
    public void argregarABotonDetenerTimer(Button boton){
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if(contadorPantallaActual.getCycleCount() == 1) {
                    contadorPantallaActual.jumpTo(Duration.millis(30001));
                }
                ventana.pantallaFinal();
            }
        });
    }
}