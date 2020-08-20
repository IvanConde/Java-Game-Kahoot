package edu.fiuba.algo3.modelo.preguntas;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.excepciones.MultipleChoiceCantidadDeOpcionesEsIncorrectaException;
import edu.fiuba.algo3.modelo.excepciones.OrderedChoiceCantidadDeOpcionesEsIncorrectaException;
import edu.fiuba.algo3.modelo.excepciones.OrderedChoiceMasDeUnaOpcionConLaPosicionOriginalException;
import edu.fiuba.algo3.modelo.modalidades.ModalidadClasico;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionOrdered;
import java.util.ArrayList;

public class OrderedChoice extends Pregunta {

    public OrderedChoice(String pregunta, ArrayList<Opcion> todasLasOpciones) {
        super(pregunta, todasLasOpciones, new ModalidadClasico());
        ArrayList<Integer> posiciones = new ArrayList<Integer>();
        if(todasLasOpciones.size() < 2 || todasLasOpciones.size() > 5){
            throw new OrderedChoiceCantidadDeOpcionesEsIncorrectaException("El numero de Opciones es incorrecto. Se creó la pregunta con " + String.valueOf(todasLasOpciones.size()) + "opciones, la cantidad de opciones tiene que estar entre 2 y 5");
        }
        for(Opcion opcion : todasLasOpciones){
            Integer posicionOriginal =(Integer)(((OpcionOrdered)opcion).getPosicionOriginal());
            if(posiciones.contains(posicionOriginal)){
                throw new OrderedChoiceMasDeUnaOpcionConLaPosicionOriginalException("no es posible más de una opcion con las misma posicion original");
            }else{
                posiciones.add(((OpcionOrdered)opcion).getPosicionOriginal());
            }
        }
    }

    @Override
    public void comprobarRespuesta(Respuesta respuesta) {
        if(respuesta.getOpciones().size() == todasLasOpciones.size()) {
            modalidad.calcularPuntaje(respuesta, exclusividad.verEstado());
        }
    }

}