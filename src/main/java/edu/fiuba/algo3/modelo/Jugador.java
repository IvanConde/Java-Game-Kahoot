package edu.fiuba.algo3.modelo;

public class Jugador {

    private String nombre;
    private Puntaje puntaje;

    public Jugador(String nombre) {
        this.nombre = nombre;
        Puntaje puntaje= new Puntaje();
        this.puntaje = puntaje;
    }

    public int getPuntaje() {
        return puntaje.getValor();
    }

    public void elegirRespuesta(Respuesta respuesta) {
        respuesta.elegidapor(this);
    }

    public void recibirPuntaje(int modificador) {
        this.puntaje.modificar(modificador);
    }

}
