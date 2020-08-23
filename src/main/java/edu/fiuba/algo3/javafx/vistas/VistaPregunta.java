package edu.fiuba.algo3.javafx.vistas;
import edu.fiuba.algo3.javafx.Partida;
import edu.fiuba.algo3.javafx.controladores.*;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionGroup;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;
import javafx.scene.layout.BackgroundFill;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class VistaPregunta {

    static final int TIEMPO = 30;
    private VistaMultiplicadores vistaMultiplicadores;
    private Partida partida;
    private Stage window;
    private VistaJuego vistaJuego;
    private VistaExclusividad vistaExclusividad;
    private Jugador jugadorActual;

    public VistaPregunta(Stage stage, Partida partida, VistaJuego vistaJuego) {
        this.window = stage;
        this.vistaMultiplicadores = new VistaMultiplicadores(window);
        this.vistaExclusividad = new VistaExclusividad(window);
        this.partida = partida;
        this.vistaJuego = vistaJuego;
    }

    public void construirPantallas(Pregunta pregunta) {
        this.jugadorActual = this.partida.obtenerJugadorActual();
        if (pregunta.tienePenalidad()) {
            vistaMultiplicadores.desplegar(pregunta, this.jugadorActual, this);
        }else {
            vistaExclusividad.desplegar(pregunta, this.jugadorActual, this);
        }
    }

    public void mostrarPregunta(Pregunta pregunta) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(TIEMPO), new AccionBotonTerminarTurno(pregunta, partida, this)));
        Label nombreJugadorLabel = new Label("Responde " + this.jugadorActual.verNombre() + ":");
        Label preguntaUsuario = new Label(pregunta.verPregunta());
        preguntaUsuario.setFont(new Font("Arial", 16));
        Label puntosActuales = new Label("Puntaje actual:"+ this.jugadorActual.puntaje().getPuntaje());
        VBox layoutJuego = new VBox();
        layoutJuego.setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));
        layoutJuego.getChildren().add(nombreJugadorLabel);
        layoutJuego.getChildren().add(preguntaUsuario);
        layoutJuego.getChildren().add(puntosActuales);
        Button botonContestar = new Button("[Enviar respuesta]");
        ArrayList<Opcion> opciones = pregunta.verBotones();

        layoutJuego.setAlignment(Pos.CENTER);
        layoutJuego.setSpacing(10);
        if (pregunta instanceof VerdaderoFalso) {
            this.desplegarBotonesVerdaderoyFalso(layoutJuego, opciones, botonContestar);
        } else if (pregunta instanceof GroupChoice) {
            desplegarBotonesGroupChoice(layoutJuego, opciones, (GroupChoice) pregunta);
        } else {
            this.desplegarBotonesMultiplesRespuestas(layoutJuego, opciones);
        }

        partida.setPreguntaActual(pregunta);
        botonContestar.setOnAction(new Contestar(timeline, this));
        layoutJuego.getChildren().add(botonContestar);

        window.getScene().setRoot(layoutJuego);
        window.sizeToScene();
        window.show();
        timeline.setCycleCount(1);
        timeline.play();
    }

    public void desplegarBotonesGroupChoice(VBox layoutJuego, ArrayList<Opcion> opciones, GroupChoice pregunta){
        for(Opcion opcion : opciones){
            Label opcionTexto = new Label(opcion.getStringOpcion()+ ":");
            opcionTexto.setFont(new Font("Arial", 16));

            ArrayList<String> grupos = pregunta.devolverGrupos();
            ToggleSwitch botonOpcion = new ToggleSwitch((OpcionGroup) opcion, grupos.get(0), grupos.get(1));
            partida.agregarRespuestaJugadorGroup(botonOpcion);
            botonOpcion.setMaxWidth(300);
            layoutJuego.getChildren().add(opcionTexto);
            layoutJuego.getChildren().add(botonOpcion);
        }
    }

    public void desplegarBotonesVerdaderoyFalso(VBox layoutJuego, ArrayList<Opcion> opciones, Button contestar){
        Button boton1 = new Button("Verdadero");
        Button boton2 = new Button("Falso");
        boton1.setOnAction(new AccionBotonOpcionVyF(opciones.get(1), boton1, this.jugadorActual, contestar, partida));
        boton2.setOnAction(new AccionBotonOpcionVyF(opciones.get(0), boton2, this.jugadorActual, contestar, partida));
        layoutJuego.getChildren().add(boton1);
        layoutJuego.getChildren().add(boton2);
    }

    public void desplegarBotonesMultiplesRespuestas(VBox layoutJuego, ArrayList<Opcion> opciones){
        for(Opcion opcion : opciones){
            Button botonOpcion = new Button(opcion.getStringOpcion());
            botonOpcion.setOnAction(new AccionBotonOpcion(opcion, botonOpcion, this.jugadorActual, this.partida));
            layoutJuego.getChildren().add(botonOpcion);
        }
    }

    public void proximaPregunta(){
        vistaJuego.mostrar();
    }

}