package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Respuesta {
    private ArrayList<Integer> respuesta;
    private Puntaje puntaje;

    public Respuesta(ArrayList<Integer> respuesta, Puntaje puntaje){
        this.respuesta = respuesta;
        this.puntaje = puntaje;
    }
    public void modificarPuntaje(int puntos){
        puntaje.calcularPuntaje(puntos);
    }

    public ArrayList<Integer> verRespuestaJugador(){
        return respuesta;
    }
}
