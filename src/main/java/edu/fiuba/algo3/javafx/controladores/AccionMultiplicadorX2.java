package edu.fiuba.algo3.javafx.controladores;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.vistas.VistaJuego;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AccionMultiplicadorX2 implements EventHandler<ActionEvent> {
    public Pregunta pregunta;
    int cualJugador;
    VistaJuego ventana;
    Panel panel;
    public AccionMultiplicadorX2(Pregunta pregunta, int cualJugador, VistaJuego ventana, Panel panel) {
        this.pregunta = pregunta;
        this.cualJugador = cualJugador;
        this.ventana = ventana;
        this.panel = panel;
    }

    @Override
    public void handle(ActionEvent e) {
        System.out.println("se multiplico 2");
        panel.usarMultiplicadorJugador(pregunta, cualJugador, 2);
        ventana.mostrarPregunta(pregunta, cualJugador);
    }

}