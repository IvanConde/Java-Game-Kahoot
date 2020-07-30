package edu.fiuba.algo3;
import edu.fiuba.algo3.modelo.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    Scene sceneIngresoNombres, sceneJuego;
    Stage window;
    @Override
    public void start(Stage stage) {
        window = stage;
        stage.setTitle("Kahoot2.0");
        Label textoInfo = new Label("Inserte nombre del primer jugador y presione ENTER");
        TextField textField = new TextField();
        EventHandler<KeyEvent> enterentexto = new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent ke)
            {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    if(jugador1 == null) {
                        textoInfo.setText("Inserte nombre del segundo jugador y presione ENTER");
                        jugador1 = new Jugador(textField.getText());
                        textField.clear();
                    }else{
                        jugador2 = new Jugador(textField.getText());
                        juego();
                    }
                }
            }
        };
        textField.setOnKeyPressed(enterentexto);
        VBox layoutInicial = new VBox();
        layoutInicial.getChildren().add(textoInfo);
        layoutInicial.getChildren().add(textField);
        sceneIngresoNombres = new Scene(layoutInicial, 640, 480);


        stage.setScene(sceneIngresoNombres);
        stage.show();
    }
    private void juego(){
        Label pregunta = new Label("El mate es rico?");
        Button verdadero = new Button("Verdadero");
        Button falso = new Button("Falso");
        VBox layoutJuego = new VBox();
        layoutJuego.getChildren().add(pregunta);
        layoutJuego.getChildren().add(verdadero);
        layoutJuego.getChildren().add(falso);
        sceneJuego = new Scene(layoutJuego, 640, 480);
        window.setScene(sceneJuego);
    }

    public static void main(String[] args) {
        launch();
    }

}