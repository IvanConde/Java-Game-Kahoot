package edu.fiuba.algo3.modelo.modalidades;
import edu.fiuba.algo3.modelo.Respuesta;

public abstract class Modalidad {

    public abstract void calcularPuntaje(Respuesta respuesta, boolean tieneExclusividad);

    public abstract boolean esPenalidad();

    public void aplicarExclusividad(Respuesta respuesta, Boolean tieneExclusividad, int puntos) {
        if (tieneExclusividad) {
            respuesta.agregarPuntajeTemporal(puntos);
        } else {
            respuesta.modificarPuntaje(puntos);
        }
    }
}