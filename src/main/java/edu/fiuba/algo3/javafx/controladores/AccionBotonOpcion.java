package edu.fiuba.algo3.javafx.controladores;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


public class AccionBotonOpcion implements EventHandler<ActionEvent> {
    private Opcion opcion;
    private Button boton;
    private Panel panel;
    private int cualJugador;
    public AccionBotonOpcion(Opcion opcion, Button boton, Panel panel, int cualJugador){
        this.opcion = opcion;
        this.boton = boton;
        this.panel = panel;
        this.cualJugador = cualJugador;
    }

    @Override
    public void handle(ActionEvent e) {
        /*
        panel.agregarRespuestaJugador(opcion, cualJugador);
        boton.setDisable(true);
         */
    }
}
