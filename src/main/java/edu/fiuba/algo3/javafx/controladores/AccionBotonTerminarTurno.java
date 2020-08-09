package edu.fiuba.algo3.javafx.controladores;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.vistas.VistaJuego;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class AccionBotonTerminarTurno implements EventHandler<ActionEvent> {
    private int i = 1;
    private Timeline contadorPantallaActual;
    private VistaJuego ventana;
    private Pregunta pregunta;
    private Panel panel;
    public AccionBotonTerminarTurno(Timeline contadorPantallaActual, VistaJuego ventana, Pregunta pregunta, Panel panel){
        this.contadorPantallaActual = contadorPantallaActual;
        this.ventana = ventana;
        this.pregunta = pregunta;
        this.panel = panel;
    }
    @Override
    public void handle(ActionEvent event) {
        System.out.println(contadorPantallaActual.getCycleCount());
        ventana.mostrarPregunta(pregunta, panel.nombreJugador(2), contadorPantallaActual);
        i++;
    }
}
