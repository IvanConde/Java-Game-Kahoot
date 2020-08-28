package edu.fiuba.algo3.javafx.vistas;
import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.controladores.AccionEmpezarJuego;
import edu.fiuba.algo3.javafx.controladores.AccionMostrarReglas;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.layout.BackgroundFill;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class VistaInicial {

    private Stage window;
    private Scene sceneMenuPrincipal;

    public VistaInicial(Stage stage){
        this.window = stage;
    }

    public void mostrar(Panel panel) {
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        InnerShadow is = new InnerShadow();
        is.setOffsetX(4.0f);
        is.setOffsetY(4.0f);

        Label textoInfo = new Label("Bienvenido a Kahoot 2.0");
        textoInfo.setEffect(ds);
        textoInfo.setTextFill(Color.RED);
        textoInfo.setFont(Font.font(null, FontWeight.BOLD, 32));

        Button boton1 = new Button("Comenzar Juego");
        Button boton2 = new Button("Reglas");
        boton1.setOnAction(new AccionEmpezarJuego(panel, this.window));
        boton2.setOnAction(new AccionMostrarReglas(panel, this, this.window));
        VBox layoutInicial = new VBox();
        layoutInicial.setSpacing(10);
        layoutInicial.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));

        Efectos efectoBoton = new Efectos();
        efectoBoton.agregarEfecto(boton2);
        efectoBoton.agregarEfecto(boton1);

        layoutInicial.setAlignment(Pos.CENTER);
        layoutInicial.getChildren().add(textoInfo);
        layoutInicial.getChildren().add(boton1);
        layoutInicial.getChildren().add(boton2);
        sceneMenuPrincipal = new Scene(layoutInicial, 800, 600);
        this.window.setScene(sceneMenuPrincipal);
        this.window.show();
    }

}