package edu.fiuba.algo3.modelo.modalidades;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;

public abstract class Modalidad {
    static final int OPCIONESCORRECTAS = 0;
    static final int OPCIONESINCORRECTAS = 1;
    public abstract void calcularPuntaje(Respuesta respuesta, Exclusividad exclusividad);

    public boolean esPenalidad(){
        return false;
    }

}