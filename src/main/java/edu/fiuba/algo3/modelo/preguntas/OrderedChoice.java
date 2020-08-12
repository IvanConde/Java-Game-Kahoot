package edu.fiuba.algo3.modelo.preguntas;
import edu.fiuba.algo3.modelo.excepciones.OrderedChoiceMasDeUnaOpcionConLaPosicionOriginalException;
import edu.fiuba.algo3.modelo.modalidades.ModalidadClasico;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionOrdered;

import java.util.ArrayList;

public class OrderedChoice extends Pregunta {
    public OrderedChoice(String pregunta, ArrayList<Opcion> todasLasOpciones) {
        super(pregunta, todasLasOpciones, new ModalidadClasico());
        ArrayList<Integer> posiciones = new ArrayList<Integer>();
        for(Opcion opcion : todasLasOpciones){
            Integer posicionOriginal =(Integer)(((OpcionOrdered)opcion).getPosicionOriginal());
            if(posiciones.contains(posicionOriginal)){
                throw new OrderedChoiceMasDeUnaOpcionConLaPosicionOriginalException("no es posible más de una opcion con las misam posicion original");
            }else{
                posiciones.add(((OpcionOrdered)opcion).getPosicionOriginal());
            }

        }
    }
}