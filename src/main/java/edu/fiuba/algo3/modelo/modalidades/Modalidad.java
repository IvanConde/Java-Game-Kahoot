package edu.fiuba.algo3.modelo.modalidades;
import edu.fiuba.algo3.modelo.Respuesta;

public abstract class Modalidad {
    static final int OPCIONESCORRECTAS = 0;
    static final int OPCIONESINCORRECTAS = 1;
    public abstract int calcularPuntaje(Respuesta respuesta);

    public abstract boolean esPenalidad();

    public void intentarAplicarExclusividad(Respuesta respuesta, Boolean tieneExclusividad, int puntos) {
        if (tieneExclusividad) {
            respuesta.agregarPuntajeTemporal(puntos);
        } else {
            respuesta.modificarPuntaje(puntos);
        }
    }
}