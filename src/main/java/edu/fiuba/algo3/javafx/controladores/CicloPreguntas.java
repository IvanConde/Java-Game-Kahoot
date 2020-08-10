package edu.fiuba.algo3.javafx.controladores;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.vistas.VistaJuego;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class CicloPreguntas {
   private VistaJuego ventana;
    private Panel panel;
    private Timeline contadorPantallaActual;
    public CicloPreguntas(Panel panel, VistaJuego ventana){
        this.panel = panel;
        this.ventana = ventana;
        Pregunta pregunta = this.generarPregunta();
        ventana.mostrarPregunta(pregunta, panel.nombreJugador(1), 1);


    }
    public Pregunta generarPregunta(){
        return this.panel.crearPregunta();
    }
}
