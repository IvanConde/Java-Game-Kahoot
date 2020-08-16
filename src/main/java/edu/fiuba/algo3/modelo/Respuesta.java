package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.modificadoresdepuntaje.ModificadorStandard;
import edu.fiuba.algo3.modelo.opciones.Opcion;

import java.util.ArrayList;

public class Respuesta {
    private ArrayList<Opcion> respuesta;
    private Puntaje puntaje;
    private int puntajeTemporal;

    public Respuesta(ArrayList<Opcion> respuesta, Puntaje puntaje){
        this.respuesta = respuesta;
        this.puntaje = puntaje;
    }
    public void modificarPuntaje(int puntos){
        puntaje.modificarPuntaje(puntos);
        puntaje.setModificador(new ModificadorStandard());
    }
    public ArrayList<Opcion> verRespuestaJugador(){
        return respuesta;
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
}