package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MultipleChoice extends Choice {
    public MultipleChoice(String pregunta, ArrayList<String> todas, ArrayList<String> correcta, Modalidad penalidad) {
        super(pregunta, todas, correcta, penalidad);
    }
}
