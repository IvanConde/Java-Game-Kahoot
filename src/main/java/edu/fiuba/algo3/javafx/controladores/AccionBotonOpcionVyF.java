package edu.fiuba.algo3.javafx.controladores;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class AccionBotonOpcionVyF implements EventHandler<ActionEvent> {

    private Opcion opcion;
    private Button boton;
    private Partida partida;
    private Jugador jugador;
    private Button contestar;

    public AccionBotonOpcionVyF(Opcion opcion, Button boton, Jugador jugador, Button contestar, Partida partida){
        this.opcion = opcion;
        this.boton = boton;
        this.jugador = jugador;
        this.contestar = contestar;
        this.partida = partida;
    }

    @Override
    public void handle(ActionEvent e) {
        contestar.fire();
        partida.agregarRespuestaJugador(opcion, jugador);
        boton.setDisable(true);
    }

}