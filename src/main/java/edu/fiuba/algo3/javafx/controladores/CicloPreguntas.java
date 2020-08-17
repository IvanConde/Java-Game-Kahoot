package edu.fiuba.algo3.javafx.controladores;

import edu.fiuba.algo3.javafx.Panel;
import edu.fiuba.algo3.javafx.datos.CrearPreguntas;
import edu.fiuba.algo3.javafx.vistas.VistaJuego;
import edu.fiuba.algo3.javafx.vistas.VistaPregunta;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.LinkedList;
import java.util.Random;

public class CicloPreguntas {
    static final int CANTPREGUNTAS = 1;
    private VistaPregunta ventana;
    private Panel panel;
    private int cantidadDePreguntas;
    private LinkedList preguntas;

    public CicloPreguntas(VistaPregunta ventana){
        CrearPreguntas crearPreguntas = new CrearPreguntas();
        this.preguntas = crearPreguntas.parsear();
        this.panel = panel;
        this.ventana = ventana;
        this.cantidadDePreguntas = CANTPREGUNTAS;
    }
     /*
        correrPregunta();
      */

    public void correrPregunta(){
        while(cantidadDePreguntas > 0) {
            ventana.construirPantallas(this.obtenerPreguntaAleatoria());
            cantidadDePreguntas -= 1;
        }
    }

    public Pregunta obtenerPreguntaAleatoria(){
        int tamaño = this.preguntas.size();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(tamaño);
        Pregunta pregunta = (Pregunta) this.preguntas.remove(randomInt);
        return pregunta;
    }
}
