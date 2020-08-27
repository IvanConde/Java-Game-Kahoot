package edu.fiuba.algo3.javafx.controladores;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.opciones.OpcionGroup;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AccionHandlerGroup implements EventHandler<ActionEvent> {

    private String grupo;
    private OpcionGroup opcion;
    private Jugador jugador;
    private Partida partida;

    public AccionHandlerGroup(OpcionGroup opcion, Jugador jugador, Partida partida, String grupo){
        this.opcion = opcion;
        this.jugador = jugador;
        this.partida = partida;
        this.grupo = grupo;
    }

    @Override
    public void handle(ActionEvent e) {
        partida.agregarRespuestaGroup(opcion, jugador, grupo);
    }

}
