package edu.fiuba.algo3.javafx.controladores;
import edu.fiuba.algo3.javafx.vistas.VistaPregunta;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadoresDePuntaje.Modificador;
import edu.fiuba.algo3.modelo.modificadoresDePuntaje.ModificadorMultiplicador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AccionMultiplicador implements EventHandler<ActionEvent> {

    private Pregunta pregunta;
    private Jugador jugador;
    private VistaPregunta vistaPregunta;
    private ModificadorMultiplicador multiplicador;

    public AccionMultiplicador(Pregunta pregunta, Jugador jugador, VistaPregunta vistaPregunta, ModificadorMultiplicador multiplicador) {
        this.pregunta = pregunta;
        this.jugador = jugador;
        this.vistaPregunta = vistaPregunta;
        this.multiplicador = multiplicador;
    }

    @Override
    public void handle(ActionEvent e) {
        jugador.usarMultiplicador(pregunta, multiplicador);
        vistaPregunta.mostrarPregunta(pregunta);
    }
}