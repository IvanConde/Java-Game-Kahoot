package edu.fiuba.algo3.javafx.controladores;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.vistas.VistaJuego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AccionMultiplicadorX3 implements EventHandler<ActionEvent> {
    private Pregunta pregunta;
    private Jugador jugador;

    public AccionMultiplicadorX3(Pregunta pregunta, Jugador jugador) {
        this.pregunta = pregunta;
        this.jugador = jugador;
    }

    @Override
    public void handle(ActionEvent e) {
        jugador.usarMultiplicadorX3(pregunta);
    }

}
