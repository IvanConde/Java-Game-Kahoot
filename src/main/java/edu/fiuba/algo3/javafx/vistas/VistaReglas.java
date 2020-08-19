package edu.fiuba.algo3.javafx.vistas;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.controladores.AccionEmpezarJuego;
import edu.fiuba.algo3.javafx.controladores.AccionEnterNombres;
import edu.fiuba.algo3.javafx.controladores.AccionVolverMenuPrincipal;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class VistaReglas {
    private Stage window;

    public VistaReglas(Stage stage){
        this.window = stage;
    }

    public void mostrar(VistaInicial menuPrincipal, Panel panel) {
        Label textoHeader = new Label("Reglas:");
        Label textoRegla1 = new Label("1. Solo hay 2 Jugadores, Cada Jugador Tiene 2 usos de exclusividad de puntaje \n y un uso de Multiplicador X2 y Multplicador X3");
        Label textoRegla2 = new Label("2.Una vez elegida una opcion En Multiple Choice, Verdadero y Falso, Group Choice \n no se puede Deseleccionar" );
        VBox layoutReglas = new VBox();
        Button botonVolver = new Button("Volver a menu Principal");
        botonVolver.setOnAction(new AccionVolverMenuPrincipal(menuPrincipal, panel));
        layoutReglas.getChildren().add(textoHeader);
        layoutReglas.getChildren().add(textoRegla1);
        layoutReglas.getChildren().add(textoRegla2);
        layoutReglas.getChildren().add(botonVolver);
        window.getScene().setRoot(layoutReglas);
        window.sizeToScene();
        window.show();
        System.out.println("Se construyo ventana Reglas");
    }
}
