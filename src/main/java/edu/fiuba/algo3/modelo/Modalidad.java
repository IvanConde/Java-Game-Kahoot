package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
public abstract class Modalidad {
    protected int modificadorCorrecto;
    protected int modificadorIncorrecto;
    public abstract void calcularPuntaje(Respuesta respuesta, ArrayList<Integer> correctas);
}

