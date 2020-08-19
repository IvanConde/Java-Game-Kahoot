package edu.fiuba.algo3.modelo.preguntas;
import edu.fiuba.algo3.modelo.modalidades.Modalidad;
import edu.fiuba.algo3.modelo.excepciones.VyFMasDeDosOpcionesException;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import java.util.ArrayList;

public class VerdaderoFalso extends Pregunta {

    public VerdaderoFalso(String pregunta, ArrayList<Opcion> todasLasRespuestas, Modalidad modalidad) throws VyFMasDeDosOpcionesException {
        super(pregunta, todasLasRespuestas, modalidad);
        int contadorCorrectas = 0;
        for(Opcion opcion : todasLasRespuestas){
            if(opcion.esCorrecto()){
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