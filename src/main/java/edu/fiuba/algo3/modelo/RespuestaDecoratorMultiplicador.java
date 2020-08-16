package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.opciones.Opcion;

import java.util.ArrayList;

public class RespuestaDecoratorMultiplicador implements Respuesta {

    Respuesta concreto;
    Multiplicador multiplicador;

    public RespuestaDecoratorMultiplicador(Respuesta concreto){
        this.concreto = concreto;
    }



    @Override
    public void modificarPuntaje(int puntos) {
        concreto.modificarPuntaje(multiplicador.multiplicarPuntos(puntos));
    }

    @Override
    public ArrayList<Opcion> verRespuestaJugador() {
        concreto.verRespuestaJugador();
        return null;
    }

    @Override
    public void agregarPuntajeTemporal(int puntos) {
            concreto.agregarPuntajeTemporal(puntos);
    }

    @Override
    public int puntajeTemporal() {
        return concreto.puntajeTemporal();
    }

    @Override
    public Puntaje puntaje() {
        return concreto.puntaje();
    }

    @Override
    public void setRepuestas(ArrayList<Opcion> respuesta) {
            concreto.setRepuestas(respuesta);
    }

    public void setMultiplicador(Multiplicador multiplicador) {
        this.multiplicador = multiplicador;
    }
}
