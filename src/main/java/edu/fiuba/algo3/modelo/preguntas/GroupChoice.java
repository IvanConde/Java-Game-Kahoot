package edu.fiuba.algo3.modelo.preguntas;
import edu.fiuba.algo3.modelo.excepciones.GroupChoiceCantidadDeOpcionesEsIncorrectaException;
import edu.fiuba.algo3.modelo.excepciones.OrderedChoiceCantidadDeOpcionesEsIncorrectaException;
import edu.fiuba.algo3.modelo.modalidades.ModalidadClasico;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import java.util.ArrayList;

public class GroupChoice extends Pregunta {

    private ArrayList<String> grupos;

    public GroupChoice(String pregunta, ArrayList<Opcion> todasLasOpciones, ArrayList<String> grupos) {
        super(pregunta, todasLasOpciones, new ModalidadClasico());
        this.grupos = grupos;
        if(todasLasOpciones.size() < 2 || todasLasOpciones.size() > 6){
            throw new GroupChoiceCantidadDeOpcionesEsIncorrectaException("El numero de Opciones es incorrecto. Se creó la pregunta con " + String.valueOf(todasLasOpciones.size()) + "opciones, la cantidad de opciones tiene que estar entre 2 y 6");
        }
    }

    public ArrayList<String> devolverGrupos(){
        return this.grupos;
    }

}