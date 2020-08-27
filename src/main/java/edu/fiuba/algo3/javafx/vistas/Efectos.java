package edu.fiuba.algo3.javafx.vistas;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Efectos {

    public void agregarEfecto(Button boton) {
        //boton.setBackground(new Background(new BackgroundFill(Color.color(Math.random(), Math.random(), Math.random()), CornerRadii.EMPTY, Insets.EMPTY)));

        DropShadow shadow = new DropShadow();
        boton.setMaxSize(500,200);
        boton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> boton.setEffect(shadow));

        boton.addEventHandler(MouseEvent.MOUSE_EXITED,
                e -> boton.setEffect(null));
    }

}