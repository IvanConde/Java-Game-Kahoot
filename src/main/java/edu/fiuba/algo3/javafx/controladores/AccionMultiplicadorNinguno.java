package edu.fiuba.algo3.javafx.controladores;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.vistas.VistaJuego;
import edu.fiuba.algo3.javafx.vistas.VistaPregunta;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AccionMultiplicadorNinguno implements EventHandler<ActionEvent> {
    private Pregunta pregunta;
    private Jugador jugador;
    private VistaPregunta vistaPregunta;

    public AccionMultiplicadorNinguno(Pregunta pregunta, Jugador jugadorActual, VistaPregunta vistaPregunta){
        this.pregunta = pregunta;
        this.jugador = jugadorActual;
        this.vistaPregunta = vistaPregunta;
    }
    @Override
    public void handle(ActionEvent e) {
        System.out.println("No se multiplico nada");
        vistaPregunta.mostrarPregunta(pregunta, jugador);
    }
}
