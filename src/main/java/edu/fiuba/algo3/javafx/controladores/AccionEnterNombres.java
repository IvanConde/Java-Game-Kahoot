package edu.fiuba.algo3.javafx.controladores;
import edu.fiuba.algo3.javafx.Panel;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class AccionEnterNombres implements EventHandler<KeyEvent> {

    private Label textoInfo;
    private TextField barraTexto;
    private Panel panel;

    public AccionEnterNombres(Label  textoInfo, TextField barraTexto, Panel panel, Stage ventana){
        this.textoInfo = textoInfo;
        this.barraTexto = barraTexto;
        this.panel = panel;
    }

    @Override
    public void handle(KeyEvent key) {
        if (key.getCode().equals(KeyCode.ENTER)) {
            textoInfo.setText("Inserte el nombre del segundo jugador y presione ENTER");
            panel.agregarJugador(barraTexto.getText());
            barraTexto.clear();
            if(panel.juegoPuedeComenzar()) {
                panel.comenzarJuego();
            }
        }
    }

}