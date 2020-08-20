package edu.fiuba.algo3.javafx.vistas;
import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.controladores.AccionVolverMenuPrincipal;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.scene.layout.BackgroundFill;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class VistaReglas {

    private Stage window;

    public VistaReglas(Stage stage){
        this.window = stage;
    }

    public void mostrar(VistaInicial menuPrincipal, Panel panel) throws IOException {
        Label textoHeader = new Label("Reglas:");
        textoHeader.setFont(new Font("Arial", 24));
        VBox layoutReglas = new VBox();
        layoutReglas.setBackground(new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        Button botonVolver = new Button("Volver a menu Principal");
        botonVolver.setOnAction(new AccionVolverMenuPrincipal(menuPrincipal, panel));
        BufferedReader reader = new BufferedReader(new FileReader("reglas.txt"));
        layoutReglas.getChildren().add(textoHeader);
        try {
            String linea = reader.readLine();
            while (linea != null) {
                layoutReglas.getChildren().add(new Label(linea));
                linea = reader.readLine();
            }
        } finally {
            reader.close();
        }
        layoutReglas.getChildren().add(botonVolver);
        window.getScene().setRoot(layoutReglas);
        window.sizeToScene();
        window.show();
    }

}