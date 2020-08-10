package edu.fiuba.algo3.javafx.controladores;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.vistas.VistaJuego;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

public class CicloPreguntas {
   private VistaJuego ventana;
    private Panel panel;
    public CicloPreguntas(Panel panel, VistaJuego ventana){
        this.panel = panel;
        this.ventana = ventana;
        Pregunta pregunta = this.generarPregunta();
        ventana.construirPantallas(pregunta, 1);


    }
    public Pregunta generarPregunta(){
        return this.panel.crearPregunta();
    }
}
