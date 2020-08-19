package edu.fiuba.algo3.javafx.vistas;
import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.controladores.AccionEnterNombres;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaNombres {

    private Stage window;

    public VistaNombres(Stage stage){
        this.window = stage;
    }

    public void mostrar(Panel panel) {
        Label textoInfo = new Label("Inserte el nombre del primer jugador y presione ENTER");
        TextField textField = new TextField();
        EventHandler<KeyEvent> ingresarNombre = new AccionEnterNombres(textoInfo, textField, panel, window);
        textField.setOnKeyPressed(ingresarNombre);
        VBox layoutNombres = new VBox();
        layoutNombres.getChildren().add(textoInfo);
        layoutNombres.getChildren().add(textField);
        window.getScene().setRoot(layoutNombres);
        window.sizeToScene();
        window.show();
    }

}