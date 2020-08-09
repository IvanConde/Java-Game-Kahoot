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
    public AccionBotonOpcion(Opcion opcion, Button boton, Panel panel){
        this.opcion = opcion;
        this.boton = boton;
        this.panel = panel;
    }

    @Override
    public void handle(ActionEvent e) {
        System.out.println(opcion);
        boton.setDisable(true);
    }
}
