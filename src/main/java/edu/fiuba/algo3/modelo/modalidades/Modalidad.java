package edu.fiuba.algo3.modelo.modalidades;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;

public abstract class Modalidad {
    static final int OPCIONESCORRECTAS = 0;
    static final int OPCIONESINCORRECTAS = 1;
    public abstract int calcularPuntaje(Respuesta respuesta);

    public boolean esPenalidad(){
        return false;
    }

    public void intentarAplicarExclusividad(Respuesta respuesta, Exclusividad exclusividad, int puntos) {
        exclusividad.aplicarPuntos(respuesta, puntos);
    }
}