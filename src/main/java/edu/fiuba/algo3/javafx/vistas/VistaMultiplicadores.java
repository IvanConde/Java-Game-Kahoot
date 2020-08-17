package edu.fiuba.algo3.javafx.vistas;

import edu.fiuba.algo3.javafx.controladores.AccionMultiplicadorNinguno;
import edu.fiuba.algo3.javafx.controladores.AccionMultiplicadorX2;
import edu.fiuba.algo3.javafx.controladores.AccionMultiplicadorX3;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaMultiplicadores {

    private Scene sceneJuego;
    private Stage window;

    public VistaMultiplicadores(Stage stage){
        this.window = stage;
    }

    public void desplegar(Pregunta pregunta, Jugador jugador){
        if(!jugador.tieneMultiplicadorx2() && !jugador.tieneMultiplicadorx3()){
            return;
        }
        System.out.println("hay penalidad");
        Label nombreJugadorLabel = new Label(jugador.verNombre() + " elige un multiplicador para esta pregunta");
        Button ninguno = new Button("Ninguno");
        ninguno.setOnAction(new AccionMultiplicadorNinguno(pregunta, jugador));

        Button multiplicadorX2 = new Button("Activar multiplicador x2");
        multiplicadorX2.setOnAction(new AccionMultiplicadorX2(pregunta, jugador));

        Button multiplicadorX3 = new Button("Activar multiplicador x3");
        multiplicadorX3.setOnAction(new AccionMultiplicadorX3(pregunta, jugador));

        if(!jugador.tieneMultiplicadorx2()){
            multiplicadorX2.setDisable(true);
        }else if(!jugador.tieneMultiplicadorx3()){
            multiplicadorX3.setDisable(true);
        }

        VBox layoutMultiplicador = new VBox();
        layoutMultiplicador.getChildren().add(nombreJugadorLabel);
        layoutMultiplicador.getChildren().add(multiplicadorX2);
        layoutMultiplicador.getChildren().add(multiplicadorX3);
        layoutMultiplicador.getChildren().add(ninguno);
        sceneJuego = new Scene(layoutMultiplicador, 640, 480); //640x480
        window.setScene(sceneJuego);
    }
}
