package edu.fiuba.algo3.javafx.controladores;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionGroup;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import java.util.ArrayList;

public class ToggleSwitch extends HBox {

    private final Label label = new Label();
    private final Button button = new Button();
    private OpcionGroup opcion;
    private String grupo1;
    private String grupo2;
    private SimpleBooleanProperty switchedOn = new SimpleBooleanProperty(false);

    public void respuestaJugador(ArrayList<Opcion> opcionesJugador) {
        if(switchedOn.get()) {
            opcion.elegirGrupo(grupo1, opcionesJugador);
        }else{
            opcion.elegirGrupo(grupo2, opcionesJugador);
        }
    }

    private void init() {
        label.setText(grupo1);
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

    public ToggleSwitch(OpcionGroup opcion, String grupo1, String grupo2) {
        this.opcion = opcion;
        this.grupo1 = grupo1;
        this.grupo2 = grupo2;
        init();
        switchedOn.addListener((a,b,c) -> {
            if (c) {
                label.setText(grupo2);
                setStyle("-fx-background-color: green;");
                label.toFront();
            }
            else {
                label.setText(grupo1);
                setStyle("-fx-background-color: grey;");
                button.toFront();
            }
        });
    }

}