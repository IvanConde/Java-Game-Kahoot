package edu.fiuba.algo3.javafx.controladores;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.Partida;
import edu.fiuba.algo3.javafx.vistas.VistaJuego;
import edu.fiuba.algo3.javafx.vistas.VistaPregunta;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class AccionBotonTerminarTurno implements EventHandler<ActionEvent> {

    private VistaPregunta vistaPregunta;
    private Pregunta pregunta;
    private Partida partida;
    public AccionBotonTerminarTurno(Pregunta pregunta, Partida partida, VistaPregunta vistaPregunta){
        this.vistaPregunta = vistaPregunta;
        this.pregunta = pregunta;
        this.partida = partida;
    }

    @Override
    public void handle(ActionEvent event) {
        /*
        if(pregunta instanceof GroupChoice){
            panel.recolectarRespuestasGroup(ventana.getContestateActual());
        }
    */
        partida.contestar(pregunta);
        if (partida.seContestoPregunta()) {
            partida.responderPregunta();
            vistaPregunta.proximaPregunta();
        } else {
            vistaPregunta.construirPantallas(pregunta);
        }
    }
}
