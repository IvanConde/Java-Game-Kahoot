package edu.fiuba.algo3.javafx.controladores;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.vistas.VistaJuego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AccionMultiplicadorX2 implements EventHandler<ActionEvent> {
    public Pregunta pregunta;
    Jugador jugador;
    VistaJuego ventana;
    public AccionMultiplicadorX2(Pregunta pregunta, Jugador jugador) {
        this.pregunta = pregunta;
        this.jugador = jugador;
        //this.ventana = ventana;
    }

    @Override
    public void handle(ActionEvent e) {
        System.out.println("se multiplico 2");
        jugador.usarMultiplicadorX2(pregunta);
        /*
        ventana.mostrarPregunta(pregunta, cualJugador);

         */
    }

}