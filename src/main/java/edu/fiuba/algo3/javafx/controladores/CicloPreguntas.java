package edu.fiuba.algo3.javafx.controladores;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.vistas.VistaJuego;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class CicloPreguntas {
   private VistaJuego ventana;
    private Panel panel;
    private Timeline contadorPantallaActual;
    public CicloPreguntas(Panel panel, VistaJuego ventana){
        this.panel = panel;
        this.ventana = ventana;
        Pregunta pregunta = this.generarPregunta();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(30), new EventHandler<ActionEvent>() {

            private int i = 1;

            @Override
            public void handle(ActionEvent event) {
                System.out.println(contadorPantallaActual.getCycleCount());
                ventana.mostrarPregunta(pregunta, panel.nombreJugador(2), contadorPantallaActual);
                i++;
            }
        }));

        ventana.mostrarPregunta(pregunta, panel.nombreJugador(1), timeline);
        contadorPantallaActual = timeline;
        timeline.setCycleCount(1);
        timeline.play();

    }
    public Pregunta generarPregunta(){
        return this.panel.crearPregunta();
    }
}
