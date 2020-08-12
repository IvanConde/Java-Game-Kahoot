package edu.fiuba.algo3.modelo.preguntas;
import edu.fiuba.algo3.modelo.modalidades.ModalidadClasico;
import edu.fiuba.algo3.modelo.modalidades.Modalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;

import java.util.ArrayList;

public class GroupChoice extends Pregunta {
    private ArrayList<String> grupos;
    public GroupChoice(String pregunta, ArrayList<Opcion> todasLasOpciones, ArrayList<String> grupos) {
        super(pregunta, todasLasOpciones, new ModalidadClasico());
        this.grupos = grupos;
    }

    public ArrayList<String> devolverGrupos(){
        return this.grupos;
    }
}
