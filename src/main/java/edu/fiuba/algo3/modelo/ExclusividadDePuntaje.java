package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ExclusividadDePuntaje {
    private int magnitud = 2;

    public ExclusividadDePuntaje(){}

    public void amplificar(){
        this.magnitud = 4;
    }

    public void aplicarExclusividad(ArrayList<Respuesta> respuestas , int cantidadExclusividad){
        if(cantidadExclusividad > 0){
            Respuesta respuesta1 = respuestas.get(0);
            Respuesta respuesta2 = respuestas.get(1);
            if(respuesta1.puntajeTemporal() > respuesta2.puntajeTemporal()){
                respuesta1.puntaje().calcularPuntaje(respuesta1.puntajeTemporal() * this.magnitud);
            }
            else if(respuesta1.puntajeTemporal() < respuesta2.puntajeTemporal()){
                respuesta2.puntaje().calcularPuntaje(respuesta2.puntajeTemporal() * this.magnitud);
            }
        }
    }
}