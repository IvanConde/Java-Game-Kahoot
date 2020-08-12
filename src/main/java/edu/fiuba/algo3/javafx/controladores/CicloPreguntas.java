package edu.fiuba.algo3.javafx.controladores;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.vistas.VistaJuego;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

public class CicloPreguntas {
    private VistaJuego ventana;
    private Panel panel;
    private int cantidadDePreguntas;
    public CicloPreguntas(Panel panel, VistaJuego ventana){
        this.panel = panel;
        this.ventana = ventana;
        this.cantidadDePreguntas = 5;
        correrPregunta();
    }
    public void correrPregunta(){
        if(cantidadDePreguntas > 0) {
            Pregunta pregunta = this.generarPregunta();
            ventana.construirPantallas(pregunta, 1);
            cantidadDePreguntas -= 1;
        }else{
            ventana.pantallaFinal();
        }
    }
    public Pregunta generarPregunta(){
        return this.panel.obtenerPreguntaAleatoria();
    }
}
