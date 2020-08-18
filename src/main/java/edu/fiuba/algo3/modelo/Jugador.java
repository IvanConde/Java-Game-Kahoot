package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.modificadoresdepuntaje.ModificadorMultiplicador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.ArrayList;

public class Jugador {

    private Puntaje puntaje;
    private String nombre;
    private ArrayList<ModificadorMultiplicador> multiplicadores;
    private int cantExclusividad;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntaje = new Puntaje();
        this.multiplicadores = new ArrayList<ModificadorMultiplicador>();
        multiplicadores.add(new ModificadorMultiplicador(2));
        multiplicadores.add(new ModificadorMultiplicador(3));
        this.cantExclusividad = 2;
    }

    public Puntaje puntaje(){
        return puntaje;
    }

    public void usarMultiplicador(Pregunta pregunta, int multiplicador) {
        if (pregunta.tienePenalidad() && !multiplicadores.get(multiplicador-2).seUtilizo()) {
            puntaje.setModificador(multiplicadores.get(multiplicador-2));
        }
    }

    public boolean tieneMultiplicador(int multiplicador){
        return !multiplicadores.get(multiplicador-2).seUtilizo();
    }

    public String verNombre(){
        return this.nombre;
    }

    public boolean activarExclusividad(){
        if(this.tieneExclusividad()){
            cantExclusividad -= 1;
            return true;
        }
        return false;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public boolean tieneExclusividad(){
        return cantExclusividad > 0;
    }

}