package edu.fiuba.algo3.javafx.vistas;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.controladores.AccionEnterNombres;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaInicial {
    Stage window;
    Scene sceneIngresoNombres, sceneJuego;
    Panel panel;

    public VistaInicial(Stage stage){
        this.window = stage;
        this.panel = new Panel();
        stage.setTitle("Kahoot2.0");
        this.inicialJuego();
    }
    public void inicialJuego(){
        Label textoInfo = new Label("Inserte nombre del primer jugador y presione ENTER");
        TextField textField = new TextField();
        EventHandler<KeyEvent> ingresarNombre = new AccionEnterNombres(textoInfo, textField, panel, window);
        textField.setOnKeyPressed(ingresarNombre);
        VBox layoutInicial = new VBox();
        layoutInicial.getChildren().add(textoInfo);
        layoutInicial.getChildren().add(textField);
        sceneIngresoNombres = new Scene(layoutInicial, 640, 480);
        this.window.setScene(sceneIngresoNombres);
        this.window.show();
    }


}

