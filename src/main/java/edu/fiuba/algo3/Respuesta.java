package edu.fiuba.algo3;

import java.util.ArrayList;

public class Respuesta {
    ArrayList<Integer> respuestajugador;
    Puntaje puntajejugador;
    public Respuesta(ArrayList<Integer> respuesta, Puntaje puntaje){
        respuestajugador = respuesta;
        puntajejugador = puntaje;
    }
    public void modificarpuntaje(int puntos){
        puntajejugador.calcularpuntaje(puntos);
    }
    public ArrayList<Integer> verRespuestaJugador(){
        return respuestajugador;
    }
}
