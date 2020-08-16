package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.opciones.Opcion;

import java.util.ArrayList;

public class RespuestaConcreta implements Respuesta{
    private ArrayList<Opcion> respuesta;
    private Puntaje puntaje;
    private int puntajeTemporal;

    public RespuestaConcreta(Puntaje puntaje){
        this.puntaje = puntaje;
    }

    @Override
    public void modificarPuntaje(int puntos){
        puntaje.modificarPuntaje(puntos);
    }

    @Override
    public ArrayList<Opcion> verRespuestaJugador(){
        return respuesta;
    }

    @Override
    public void agregarPuntajeTemporal(int puntos){
        this.puntajeTemporal = puntos;
    }

    @Override
    public int puntajeTemporal(){
        return this.puntajeTemporal;
    }

    @Override
    public Puntaje puntaje() {
        return puntaje;
    }

    @Override
    public void setRepuestas(ArrayList<Opcion> respuesta) {
        this.respuesta = respuesta;
    }
}
