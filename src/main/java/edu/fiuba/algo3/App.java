package edu.fiuba.algo3;
import edu.fiuba.algo3.javafx.Panel;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */

public class App extends Application {

    @Override
    public void start(Stage stage) {

        Panel panel = new Panel(stage);
        panel.iniciarJuego();

    }

    public static void main(String[] args) {

        launch();

    }

}