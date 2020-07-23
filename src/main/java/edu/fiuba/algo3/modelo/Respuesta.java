package edu.fiuba.algo3.modelo;

public class Respuesta {

    private String respuesta;
    private Jugador jugador;

    public Respuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuesta() {
        return this.respuesta;
    }

    public void elegidapor(Jugador jugador){
        this.jugador = jugador;
    }

    public Jugador respondidaPor() {
        return jugador;
    }

}
