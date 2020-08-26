package edu.fiuba.algo3.javafx.controladores;
import edu.fiuba.algo3.javafx.datos.CrearPreguntas;
import edu.fiuba.algo3.javafx.vistas.VistaPregunta;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import java.util.LinkedList;
import java.util.Random;

public class CicloPreguntas {

    private int cantidadPreguntas = 10;
    private LinkedList preguntas;

    public CicloPreguntas(){
        CrearPreguntas crearPreguntas = new CrearPreguntas();
        this.preguntas = crearPreguntas.parsear();
    }

    public void correrPregunta(VistaPregunta ventana){
            ventana.construirPantallas(this.obtenerPreguntaAleatoria());
            cantidadPreguntas -= 1;
    }

    public Pregunta obtenerPreguntaAleatoria(){
        int tamaño = this.preguntas.size();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(tamaño);
        Pregunta pregunta = (Pregunta) this.preguntas.remove(randomInt);
        return pregunta;
    }

    public int getCantPreguntas(){
        return cantidadPreguntas;
    }

}