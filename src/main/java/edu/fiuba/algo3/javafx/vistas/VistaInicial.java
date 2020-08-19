package edu.fiuba.algo3.javafx.vistas;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.controladores.AccionEmpezarJuego;
import edu.fiuba.algo3.javafx.controladores.AccionMostrarReglas;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaInicial {
    private Stage window;
    private Scene sceneMenuPrincipal, sceneJuego;

    public VistaInicial(Stage stage){
        this.window = stage;
    }

    public void mostrar(Panel panel) {
        Label textoInfo = new Label("Bienvenido a Kahoot 2.0");
        textoInfo.setFont(new Font("Arial", 24));
        Button boton1 = new Button("Comenzar Juego");
        Button boton2 = new Button("Reglas");
        boton1.setOnAction(new AccionEmpezarJuego(panel, this.window));
        boton2.setOnAction(new AccionMostrarReglas(panel, this, this.window));
        VBox layoutInicial = new VBox();
        layoutInicial.setSpacing(10);



        DropShadow shadow = new DropShadow();
        boton1.setMaxSize(500,200);
        boton2.setMaxSize(500,200);
        boton1.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> boton1.setEffect(shadow));
        boton2.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> boton2.setEffect(shadow));

        boton1.addEventHandler(MouseEvent.MOUSE_EXITED,
                e -> boton1.setEffect(null));
        boton2.addEventHandler(MouseEvent.MOUSE_EXITED,
                e -> boton2.setEffect(null));

        layoutInicial.setAlignment(Pos.CENTER);
        layoutInicial.getChildren().add(textoInfo);
        layoutInicial.getChildren().add(boton1);
        layoutInicial.getChildren().add(boton2);
        sceneMenuPrincipal = new Scene(layoutInicial, 640, 480);
        this.window.setScene(sceneMenuPrincipal);
        this.window.show();
        System.out.println("Se construyo ventana inicial");
    }
}

