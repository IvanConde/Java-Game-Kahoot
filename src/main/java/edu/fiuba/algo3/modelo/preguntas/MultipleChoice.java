package edu.fiuba.algo3.modelo.preguntas;
import edu.fiuba.algo3.modelo.excepciones.MultipleChoiceCantidadDeOpcionesEsIncorrectaException;
import edu.fiuba.algo3.modelo.modalidades.Modalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import java.util.ArrayList;

public class MultipleChoice extends Pregunta {

    public MultipleChoice(String pregunta, ArrayList<Opcion> todasLasOpciones, Modalidad modalidad) {
        super(pregunta, todasLasOpciones, modalidad);
        if(todasLasOpciones.size() < 2 || todasLasOpciones.size() > 5){
            throw new MultipleChoiceCantidadDeOpcionesEsIncorrectaException("El numero de Opciones es incorrecto. Se creó la pregunta con " + String.valueOf(todasLasOpciones.size()) + "opciones, la cantidad de opciones tiene que estar entre 2 y 5");
        }
    }

}