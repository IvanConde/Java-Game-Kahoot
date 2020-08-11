package edu.fiuba.algo3.modelo.preguntas;
import edu.fiuba.algo3.modelo.modalidades.ModalidadClasico;
import edu.fiuba.algo3.modelo.modalidades.Modalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;

import java.util.ArrayList;

public class OrderedChoice extends Pregunta {

    private int modificadorPuntajeExito = 1;
    private int modificadorPuntajeFracaso = 0;

    public OrderedChoice(String pregunta, ArrayList<Opcion> todasLasOpciones) {
        super(pregunta, todasLasOpciones, new ModalidadClasico());
        /*ArrayList<Integer> posiciones = new ArrayList<Integer>;
        for(Opcion opcion : todasLasOpciones){
            if(posiciones.contains((OpcionGroup)opcion.getPosicionOriginal())){
                throw new VyFMasDeDosOpcionesException("no es posible más de una opcion correcta en VerdaderoYFalso");
            }else{
                posiciones.add((OpcionGroup)opcion.getPosicionOriginal());
            }

        }*/
    }
}