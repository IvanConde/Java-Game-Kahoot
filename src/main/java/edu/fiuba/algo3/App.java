package edu.fiuba.algo3;
import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.datos.CrearPreguntas;
import edu.fiuba.algo3.javafx.vistas.VistaInicial;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        Panel panel = new Panel(stage);
        panel.iniciarJuego();
        /*
        VistaInicial vista = new VistaInicial(stage);
        vista.iniciarJuego();
         */
    }

    public static void main(String[] args) {
        launch();
    }

}
