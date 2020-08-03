package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoFalso extends Choice {
    public VerdaderoFalso(String pregunta, ArrayList<Opcion> todasLasRespuestas, Modalidad penalidad) throws VyFMasDeDosOpcionesException {
        super(pregunta, todasLasRespuestas, penalidad);
        int contadorCorrectas = 0;
        for(Opcion i : todasLasRespuestas){
            if(i.esCorrecto()){
                contadorCorrectas += 1;
            }
        }
        if (contadorCorrectas > 1) {
            throw new VyFMasDeDosOpcionesException("no es posible más de una opcion correcta en VerdaderoYFalso");
        }
    }
    @Override
    public ArrayList<Opcion> verBotones(){
        return todasLasOpciones;
    }
}
