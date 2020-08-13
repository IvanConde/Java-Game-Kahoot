package edu.fiuba.algo3.modelo.puntaje;

public class PuntajeDecoratorStandard extends PuntajeDecorator{

    public PuntajeDecoratorStandard(Puntaje componente) {
        super(componente);
    }

    @Override
    public void agregarPuntos(int puntos) {
        componente.agregarPuntos(puntos);
    }
}
