package edu.fiuba.algo3.modelo.puntaje;

import edu.fiuba.algo3.modelo.Multiplicador;

public class PuntajeSwitcher implements Puntaje{
    PuntajeDecorator decorador;

    public PuntajeSwitcher(){
        decorador = new PuntajeDecoratorStandard( new PuntajeConcreto());
    }

    @Override
    public void calcularPuntaje(int puntos) {
        decorador.calcularPuntaje(puntos);
        if(decorador instanceof PuntajeDecoratorMultiplicador){
            this.decorador = new PuntajeDecoratorStandard(decorador.getComponente());
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
        if(!multiplicador.seUtilizo()){
            decorador = new PuntajeDecoratorMultiplicador(decorador.getComponente(), multiplicador);
        }
    }
}
