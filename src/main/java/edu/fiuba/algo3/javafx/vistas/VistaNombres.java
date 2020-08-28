package edu.fiuba.algo3.javafx.vistas;
import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.controladores.AccionEnterNombres;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.BackgroundFill;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class VistaNombres {

    private Stage window;

    public VistaNombres(Stage stage){
        this.window = stage;
    }

    public void mostrar(Panel panel) {
        Label textoInfo = new Label("      Inserte el nombre del primer jugador y presione ENTER:");
        textoInfo.setFont(new Font("Arial", 16));
        TextField textField = new TextField();
        textField.setFont(Font.font(18));
        EventHandler<KeyEvent> ingresarNombre = new AccionEnterNombres(textoInfo, textField, panel, window);
        textField.setOnKeyPressed(ingresarNombre);
        VBox layoutNombres = new VBox(10);
        layoutNombres.setPadding(new Insets(90,90,90,90));
        layoutNombres.setBackground(new Background(new BackgroundFill(Color.VIOLET, CornerRadii.EMPTY, Insets.EMPTY)));

        layoutNombres.getChildren().add(textoInfo);
        layoutNombres.getChildren().add(textField);
        window.getScene().setRoot(layoutNombres);
        window.sizeToScene();
        window.show();
    }

}