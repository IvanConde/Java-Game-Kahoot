package edu.fiuba.algo3.javafx.controladores;
import edu.fiuba.algo3.javafx.Partida;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class AccionBotonOpcion implements EventHandler<ActionEvent> {

    private Opcion opcion;
    private Button boton;
    private Jugador jugador;
    private Partida partida;

    public AccionBotonOpcion(Opcion opcion, Button boton, Jugador jugador, Partida partida){
        this.opcion = opcion;
        this.boton = boton;
        this.jugador = jugador;
        this.partida = partida;
    }

    @Override
    public void handle(ActionEvent e) {
        partida.agregarRespuestaJugador(opcion, jugador);
        boton.setDisable(true);
    }

}