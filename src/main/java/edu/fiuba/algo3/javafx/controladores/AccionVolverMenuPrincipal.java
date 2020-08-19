package edu.fiuba.algo3.javafx.controladores;
import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.vistas.VistaInicial;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AccionVolverMenuPrincipal implements EventHandler<ActionEvent> {

    VistaInicial menuPrincipal;
    Panel panel;

    public AccionVolverMenuPrincipal(VistaInicial menuPrincipal, Panel panel){
        this.menuPrincipal = menuPrincipal;
        this.panel = panel;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        menuPrincipal.mostrar(panel);
    }

}