package edu.fiuba.algo3.javafx.controladores;
import edu.fiuba.algo3.javafx.vistas.VistaPregunta;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AccionMultiplicador implements EventHandler<ActionEvent> {

    private Pregunta pregunta;
    private Jugador jugador;
    private VistaPregunta vistaPregunta;
    private int magnitud;

    public AccionMultiplicador(Pregunta pregunta, Jugador jugador, VistaPregunta vistaPregunta, int magnitud) {
        this.pregunta = pregunta;
        this.jugador = jugador;
        this.vistaPregunta = vistaPregunta;
        this.magnitud = magnitud;
    }

    @Override
    public void handle(ActionEvent e) {
        jugador.usarMultiplicador(pregunta, magnitud);
        vistaPregunta.mostrarPregunta(pregunta, jugador);
    }

}