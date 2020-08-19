package edu.fiuba.algo3.javafx.vistas;
import edu.fiuba.algo3.javafx.controladores.AccionExclusividadPuntaje;
import edu.fiuba.algo3.javafx.controladores.AccionMultiplicadorNinguno;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaExclusividad {

    private Stage window;

    public VistaExclusividad(Stage stage) {
        this.window = stage;
    }

    public void desplegar(Pregunta pregunta, Jugador jugador, VistaPregunta vistaPregunta) {
        if (!jugador.tieneExclusividad()) {
            vistaPregunta.mostrarPregunta(pregunta, jugador);
            return;
        }

        Label nombreJugadorLabel = new Label(jugador.verNombre() + " elegí si queres activar exclusividad de puntaje para esta pregunta");
        nombreJugadorLabel.setFont(new Font("Arial", 16));
        Button ninguno = new Button("Ninguno");
        ninguno.setOnAction(new AccionMultiplicadorNinguno(pregunta, jugador, vistaPregunta));

        Button exclusividadPuntaje = new Button("Activar exclusividad de puntaje");
        exclusividadPuntaje.setOnAction(new AccionExclusividadPuntaje(pregunta, jugador, vistaPregunta));

        if (!jugador.tieneExclusividad()) {
            exclusividadPuntaje.setDisable(true);
        }
            VBox layoutExclusividad = new VBox();
            layoutExclusividad.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            layoutExclusividad.getChildren().add(nombreJugadorLabel);
            layoutExclusividad.getChildren().add(exclusividadPuntaje);
            layoutExclusividad.getChildren().add(ninguno);

            layoutExclusividad.setAlignment(Pos.CENTER);
            layoutExclusividad.setSpacing(10);

            window.getScene().setRoot(layoutExclusividad);
            window.sizeToScene();
            window.show();
    }

}