package edu.fiuba.algo3.modelo.puntaje;

import edu.fiuba.algo3.modelo.Multiplicador;

public class PuntajeDecoratorMultiplicador extends PuntajeDecorator{
    private Multiplicador multiplicador;

    public PuntajeDecoratorMultiplicador(Puntaje componente, Multiplicador multiplicador) {
        super(componente);
        this.multiplicador = multiplicador;
    }

    @Override
    public void agregarPuntos(int puntos) {
        this.componente.agregarPuntos(multiplicador.multiplicarPuntos(puntos));
    }
}
