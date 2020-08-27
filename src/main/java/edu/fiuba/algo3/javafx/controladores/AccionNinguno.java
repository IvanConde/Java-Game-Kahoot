package edu.fiuba.algo3.javafx.controladores;
import edu.fiuba.algo3.javafx.vistas.VistaPregunta;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AccionNinguno implements EventHandler<ActionEvent> {

    private Pregunta pregunta;
    private VistaPregunta vistaPregunta;

    public AccionNinguno(Pregunta pregunta, VistaPregunta vistaPregunta){
        this.pregunta = pregunta;
        this.vistaPregunta = vistaPregunta;
    }

    @Override
    public void handle(ActionEvent e) {
        vistaPregunta.mostrarPregunta(pregunta);
    }

}