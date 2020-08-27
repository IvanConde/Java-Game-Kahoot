package edu.fiuba.algo3.modelo.excepciones;

public class PreguntaInvalidaException extends RuntimeException {

    public PreguntaInvalidaException(String mensaje){
        super(mensaje);
    }

}