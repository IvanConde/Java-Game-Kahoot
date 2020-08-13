package edu.fiuba.algo3.modelo.puntaje;

public abstract class PuntajeDecorator implements Puntaje {
    protected Puntaje componente;

    public PuntajeDecorator(Puntaje componente){
        this.componente = componente;
    }

    @Override
    public int getPuntaje() {
        return componente.getPuntaje();
    }

    public Puntaje getComponente(){
        return componente;
    }
}
