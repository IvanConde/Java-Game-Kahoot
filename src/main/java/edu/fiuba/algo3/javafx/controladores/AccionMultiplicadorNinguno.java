package edu.fiuba.algo3.javafx.controladores;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.vistas.VistaJuego;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AccionMultiplicadorNinguno implements EventHandler<ActionEvent> {
    public Pregunta pregunta;
    int cualJugador;
    VistaJuego ventana;
    public AccionMultiplicadorNinguno(Pregunta pregunta, int cualJugador, VistaJuego ventana){
        this.pregunta = pregunta;
        this.cualJugador = cualJugador;
        this.ventana = ventana;
    }
    @Override
    public void handle(ActionEvent e) {
        System.out.println("se multiplico nada");
        ventana.mostrarPregunta(pregunta, cualJugador);
    }
}
