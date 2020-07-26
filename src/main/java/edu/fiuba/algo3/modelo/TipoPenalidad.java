package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class TipoPenalidad {
    public abstract void calcularpuntaje(Respuesta respuesta, ArrayList<Integer> correctas);
}

