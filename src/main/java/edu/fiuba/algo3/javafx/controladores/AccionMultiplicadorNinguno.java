package edu.fiuba.algo3.javafx.controladores;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.vistas.VistaJuego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AccionMultiplicadorNinguno implements EventHandler<ActionEvent> {
    private Pregunta pregunta;
    private Jugador jugador;
    private VistaJuego ventana;
    public AccionMultiplicadorNinguno(Pregunta pregunta, Jugador jugadorActual){
        this.pregunta = pregunta;
        this.jugador = jugador;
    }
    @Override
    public void handle(ActionEvent e) {
        //System.out.println("No se multiplico nada");
        //ventana.mostrarPregunta(pregunta, cualJugador);
        //ventana.mostrarPregunta(pregunta, jugador);
    }
}
