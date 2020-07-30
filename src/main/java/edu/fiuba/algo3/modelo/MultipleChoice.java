package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MultipleChoice extends Choice {
    public MultipleChoice(String pregunta, ArrayList<Integer> correcta, Modalidad penalidad) {
        super(pregunta, correcta, penalidad);
    }
}
