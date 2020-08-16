package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.opciones.Opcion;

import java.util.ArrayList;

public interface Respuesta {
    void modificarPuntaje(int puntos);

    ArrayList<Opcion> verRespuestaJugador();

    void agregarPuntajeTemporal(int puntos);

    int puntajeTemporal();

    Puntaje puntaje();

    void setRepuestas(ArrayList<Opcion> respuesta);
}