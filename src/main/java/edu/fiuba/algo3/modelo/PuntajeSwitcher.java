package edu.fiuba.algo3.modelo;

public class PuntajeSwitcher implements Puntaje{
    PuntajeDecorator decorador;

    public PuntajeSwitcher(){
        decorador = new PuntajeDecoratorStandar( new PuntajeConcreto());
    }

    @Override
    public void calcularPuntaje(int puntos) {
        decorador.calcularPuntaje(puntos);
        if(decorador instanceof PuntajeDecoratorMultiplicador){
            this.decorador = new PuntajeDecoratorStandar(decorador.getComponente());
        }
    }

    @Override
    public int getPuntaje() {
        return decorador.getPuntaje();
    }

    public Puntaje puntaje(){
        return decorador.getComponente();
    }

    public void setMultiplicador(Multiplicador multiplicador){
        decorador = new PuntajeDecoratorMultiplicador(decorador.getComponente(), multiplicador);
    }
}
