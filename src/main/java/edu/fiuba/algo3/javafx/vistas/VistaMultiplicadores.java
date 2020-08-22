package edu.fiuba.algo3.javafx.vistas;
import edu.fiuba.algo3.javafx.controladores.AccionMultiplicadorNinguno;
import edu.fiuba.algo3.javafx.controladores.AccionMultiplicador;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.BackgroundFill;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class VistaMultiplicadores {

    private Stage window;

    public VistaMultiplicadores(Stage stage){
        this.window = stage;
    }

    public void desplegar(Pregunta pregunta, Jugador jugador, VistaPregunta vistaPregunta){
        if(!jugador.tieneMultiplicador(2) && !jugador.tieneMultiplicador(3)){
            vistaPregunta.mostrarPregunta(pregunta, jugador);
            return;
        }

        Label nombreJugadorLabel = new Label(jugador.verNombre() + " elige un multiplicador para esta pregunta");
        nombreJugadorLabel.setFont(new Font("Arial", 16));
        Button ninguno = new Button("Ninguno");
        ninguno.setOnAction(new AccionMultiplicadorNinguno(pregunta, jugador, vistaPregunta));

        Button multiplicadorX2 = new Button("Activar multiplicador x2");
        multiplicadorX2.setOnAction(new AccionMultiplicador(pregunta, jugador, vistaPregunta, 2));

        Button multiplicadorX3 = new Button("Activar multiplicador x3");
        multiplicadorX3.setOnAction(new AccionMultiplicador(pregunta, jugador, vistaPregunta, 3));

        Label puntosActuales = new Label("Puntaje actual:"+ jugador.puntaje().getPuntaje());


        if(!jugador.tieneMultiplicador(2)){
            multiplicadorX2.setDisable(true);
        }else if(!jugador.tieneMultiplicador(3)){
            multiplicadorX3.setDisable(true);
        }

        VBox layoutMultiplicador = new VBox();
        layoutMultiplicador.setBackground(new Background(new BackgroundFill(Color.INDIANRED, CornerRadii.EMPTY, Insets.EMPTY)));
        layoutMultiplicador.getChildren().add(nombreJugadorLabel);
        layoutMultiplicador.getChildren().add(puntosActuales);
        layoutMultiplicador.getChildren().add(multiplicadorX2);
        layoutMultiplicador.getChildren().add(multiplicadorX3);
        layoutMultiplicador.getChildren().add(ninguno);

        layoutMultiplicador.setAlignment(Pos.CENTER);
        layoutMultiplicador.setSpacing(10);

        window.getScene().setRoot(layoutMultiplicador);
        window.sizeToScene();
        window.show();
    }

}