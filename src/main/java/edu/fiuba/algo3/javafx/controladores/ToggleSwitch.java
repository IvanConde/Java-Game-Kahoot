package edu.fiuba.algo3.javafx.controladores;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionEstructurada;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
// derechos de autor https://gist.github.com/TheItachiUchiha/12e40a6f3af6e1eb6f75

public class ToggleSwitch extends HBox {
    private final Label label = new Label();
    private final Button button = new Button();
    private OpcionEstructurada opcion;
    private SimpleBooleanProperty switchedOn = new SimpleBooleanProperty(false);
    public void respuestaJugador(ArrayList<Opcion> opcionesJugador) {
        if(switchedOn.get()) {
            opcion.elegir(0, opcionesJugador);
        }else{
            opcion.elegir(1, opcionesJugador);
        }
    }

    private void init() {

        label.setText("GRUPO 1");

        getChildren().addAll(label, button);
        button.setOnAction((e) -> {
            switchedOn.set(!switchedOn.get());
        });
        label.setOnMouseClicked((e) -> {
            switchedOn.set(!switchedOn.get());
        });
        setStyle();
        bindProperties();
    }

    private void setStyle() {
        //Default Width
        setWidth(40);
        label.setAlignment(Pos.CENTER);
        setStyle("-fx-background-color: grey; -fx-text-fill:black; -fx-background-radius: 4;");
        setAlignment(Pos.CENTER_LEFT);
    }

    private void bindProperties() {
        label.prefWidthProperty().bind(widthProperty().divide(2));
        label.prefHeightProperty().bind(heightProperty());
        button.prefWidthProperty().bind(widthProperty().divide(2));
        button.prefHeightProperty().bind(heightProperty());
    }

    public ToggleSwitch(OpcionEstructurada opcion) {
        this.opcion = opcion;
        init();
        switchedOn.addListener((a,b,c) -> {
            if (c) {
                label.setText("GRUPO 2");
                setStyle("-fx-background-color: green;");
                label.toFront();
            }
            else {
                label.setText("GRUPO 1");
                setStyle("-fx-background-color: grey;");
                button.toFront();
            }
        });
    }
}