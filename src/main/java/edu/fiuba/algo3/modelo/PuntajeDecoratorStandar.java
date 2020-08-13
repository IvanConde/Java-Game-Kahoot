package edu.fiuba.algo3.modelo;

public class PuntajeDecoratorStandar extends PuntajeDecorator{

    public PuntajeDecoratorStandar(Puntaje componente) {
        super(componente);
    }

    @Override
    public void calcularPuntaje(int puntos) {
        componente.calcularPuntaje(puntos);
    }
}
