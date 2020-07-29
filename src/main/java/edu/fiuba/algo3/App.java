package edu.fiuba.algo3;
import edu.fiuba.algo3.modelo.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    Jugador jugador1;
    Jugador jugador2;
    @Override
    public void start(Stage stage) {
        stage.setTitle("Kahoot2.0");
        Label textoInfo = new Label("Inserte nombre del primer jugador");
        TextField textField = new TextField();
        EventHandler<KeyEvent> enterentexto = new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent ke)
            {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    if(jugador1 == null) {
                        textoInfo.setText("Inserte nombre del segundo jugador");
                        jugador1 = new Jugador(textField.getText());
                    }else{
                        jugador2 = new Jugador(textField.getText());
                    }
                }
            }
        };
        textField.setOnKeyPressed(enterentexto);
        VBox layout = new VBox();
        layout.getChildren().add(textoInfo);
        layout.getChildren().add(textField);
        var scene = new Scene(layout, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}