package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ExclusividadDePuntaje {
    private int magnitud = 2;
    private boolean EstadoDeActivacion = false;

    public ExclusividadDePuntaje(){}

    public void activarExclusividad(Jugador jugador){
        jugador.activarExclusividad();
        if(EstadoDeActivacion){
            this.magnitud = 4;
        }else{
            EstadoDeActivacion = true;
        }
    }

    public boolean verEstado(){
        return EstadoDeActivacion;
    }

    public void aplicarExclusividad(ArrayList<Respuesta> respuestas){
        if(EstadoDeActivacion){
            Respuesta respuesta1 = respuestas.get(0);
            Respuesta respuesta2 = respuestas.get(1);
            if(respuesta1.puntajeTemporal() > respuesta2.puntajeTemporal()){
                respuesta1.modificarPuntaje(respuesta1.puntajeTemporal() * this.magnitud);
            }
            else if(respuesta1.puntajeTemporal() < respuesta2.puntajeTemporal()){
                respuesta2.modificarPuntaje(respuesta2.puntajeTemporal() * this.magnitud);
            }
        }
    }

    public int verMagnitud(){
        return this.magnitud;
    }
}