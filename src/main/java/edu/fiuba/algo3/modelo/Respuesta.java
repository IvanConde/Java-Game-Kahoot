package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Respuesta {
    private ArrayList<String> respuesta;
    private Puntaje puntaje;

    public Respuesta(ArrayList<String> respuesta, Puntaje puntaje){
        this.respuesta = respuesta;
        this.puntaje = puntaje;
    }
    public void modificarPuntaje(int puntos){
        puntaje.calcularPuntaje(puntos);
    }

    public ArrayList<String> verRespuestaJugador(){
        return respuesta;
    }
}
