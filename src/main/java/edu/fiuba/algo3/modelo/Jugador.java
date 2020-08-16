package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.ArrayList;

public class Jugador {

    private Puntaje puntaje;
    private String nombre;
    private ArrayList<Multiplicador> multiplicadores;
    public Respuesta respuesta;
    private int cantExclusividad;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntaje = new Puntaje();
        this.multiplicadores = new ArrayList<Multiplicador>();
        this.multiplicadores.add(new Multiplicador(2));
        this.multiplicadores.add(new Multiplicador(3));

        this.cantExclusividad = 2;
    }

    public Puntaje puntaje(){
        return puntaje;
    }

    public void usarMultiplicador(Pregunta pregunta, int multiplicador) {
        if (pregunta.tienePenalidad() && !this.tieneMultiplicador(multiplicador)) {
            this.respuesta = new RespuestaDecoratorMultiplicador(this.respuesta);
            ((RespuestaDecoratorMultiplicador)this.respuesta).setMultiplicador(multiplicadores.get(multiplicador));
        }
    }

    public boolean tieneMultiplicador(int multiplicador){
        return !multiplicadores.get(multiplicador).seUtilizo();
    }

    public String verNombre(){
        return this.nombre;
    }

    public boolean activarExclusividad(){
        if(cantExclusividad > 0){
            cantExclusividad -= 1;
            return true;
        }
        return false;
    }

    public Respuesta responder(){

        return
    }

}