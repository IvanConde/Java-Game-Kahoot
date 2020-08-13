package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

import java.util.ArrayList;

public class Respuesta {
    private ArrayList<Opcion> opciones;
    private Puntaje puntaje;
    private int puntajeTemporal;

    public Respuesta(ArrayList<Opcion> opciones, Puntaje puntaje){
        this.opciones = opciones;
        this.puntaje = puntaje;
        this.puntajeTemporal = 0;
    }
    public void modificarPuntaje(int puntos){
        puntaje.calcularPuntaje(puntos);
    }
    public ArrayList<Opcion> verRespuestaJugador(){
        return opciones;
    }

    public void agregarPuntajeTemporal(int puntos){
        this.puntajeTemporal = puntos;
    }

    public int puntajeTemporal(){
        return this.puntajeTemporal;
    }

    public Puntaje puntaje() {
        return puntaje;
    }

    public ArrayList<Opcion> getOpciones(){
        return opciones;
    }
}