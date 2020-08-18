package edu.fiuba.algo3;
import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.datos.CrearPreguntas;
import edu.fiuba.algo3.javafx.vistas.VistaInicial;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        Media media = new Media(Paths.get("musica.mp3").toUri().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.play();

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
