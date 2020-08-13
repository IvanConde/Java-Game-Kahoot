package edu.fiuba.algo3.modelo;

public class PuntajeDecoratorMultiplicador extends PuntajeDecorator{
    private Multiplicador multiplicador;

    public PuntajeDecoratorMultiplicador(Puntaje componente, Multiplicador multiplicador) {
        super(componente);
        this.multiplicador = multiplicador;
    }

    @Override
    public void calcularPuntaje(int puntos) {
        this.componente.calcularPuntaje(multiplicador.multiplicarPuntos(puntos));
    }
}
