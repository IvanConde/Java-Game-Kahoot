package edu.fiuba.algo3.javafx.controladores;
import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.vistas.VistaInicial;
import edu.fiuba.algo3.javafx.vistas.VistaReglas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import java.io.IOException;

public class AccionMostrarReglas implements EventHandler<ActionEvent> {

    Panel panel;
    VistaInicial menuPrincipal;
    Stage stage;

    public AccionMostrarReglas(Panel panel, VistaInicial menuPrincipal, Stage stage){
        this.panel = panel;
        this.menuPrincipal = menuPrincipal;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VistaReglas reglas =  new VistaReglas(stage);
        try {
            reglas.mostrar(menuPrincipal, panel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}