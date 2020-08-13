package edu.fiuba.algo3.javafx.controladores;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.vistas.VistaJuego;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AccionMultiplicadorX3 implements EventHandler<ActionEvent> {
    public Pregunta pregunta;
    int cualJugador;
    VistaJuego ventana;
    Panel panel;
    public AccionMultiplicadorX3(Pregunta pregunta, int cualJugador, VistaJuego ventana, Panel panel) {
        this.pregunta = pregunta;
        this.cualJugador = cualJugador;
        this.ventana = ventana;
        this.panel = panel;
    }

    @Override
    public void handle(ActionEvent e) {
        System.out.println("se multiplico 3");
        panel.usarMultiplicadorJugadorX3(pregunta, cualJugador);
        ventana.mostrarPregunta(pregunta, cualJugador);
    }

}
