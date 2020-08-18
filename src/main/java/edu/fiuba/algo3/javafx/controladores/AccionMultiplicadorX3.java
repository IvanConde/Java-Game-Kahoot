package edu.fiuba.algo3.javafx.controladores;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.vistas.VistaJuego;
import edu.fiuba.algo3.javafx.vistas.VistaPregunta;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AccionMultiplicadorX3 implements EventHandler<ActionEvent> {
    private Pregunta pregunta;
    private Jugador jugador;
    private VistaPregunta vistaPregunta;

    public AccionMultiplicadorX3(Pregunta pregunta, Jugador jugador, VistaPregunta vistaPregunta) {
        this.pregunta = pregunta;
        this.jugador = jugador;
        this.vistaPregunta = vistaPregunta;
    }

    @Override
    public void handle(ActionEvent e) {
        System.out.println("se multiplico 3");
        jugador.usarMultiplicador(pregunta, 3);
        vistaPregunta.mostrarPregunta(pregunta, jugador);
    }
}
