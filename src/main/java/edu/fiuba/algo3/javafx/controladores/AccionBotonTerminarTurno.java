package edu.fiuba.algo3.javafx.controladores;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.vistas.VistaJuego;
import edu.fiuba.algo3.javafx.vistas.VistaPregunta;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class AccionBotonTerminarTurno implements EventHandler<ActionEvent> {

    private int i = 1;
    private VistaPregunta ventana;
    private Pregunta pregunta;
    private Panel panel;
    public AccionBotonTerminarTurno(VistaPregunta ventana, Pregunta pregunta){
        this.ventana = ventana;
        this.pregunta = pregunta;
    }

    @Override
    public void handle(ActionEvent event) {
        /*
        if(pregunta instanceof GroupChoice){
            panel.recolectarRespuestasGroup(ventana.getContestateActual());
        }
        if(ventana.getContestateActual() == 2) {
            panel.responderPregunta();
            ventana.proximaPregunta();
            return;
        }
        ventana.construirPantallas(pregunta, 2);
        i++;
         */
    }
}
