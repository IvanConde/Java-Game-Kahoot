package edu.fiuba.algo3.javafx.controladores;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.vistas.VistaNombres;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class AccionEmpezarJuego implements EventHandler<ActionEvent> {

    private Panel panel;
    private Stage stage;

    public AccionEmpezarJuego(Panel panel, Stage stage){
        this.panel = panel;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VistaNombres vistaNombres = new VistaNombres(stage);
        vistaNombres.mostrar(panel);
    }
}
