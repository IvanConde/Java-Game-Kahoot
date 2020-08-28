package edu.fiuba.algo3.modelo.exclusividad;
import edu.fiuba.algo3.modelo.Respuesta;
import java.util.ArrayList;

public interface Exclusividad {


    void aplicarExclusividad(ArrayList<Respuesta> respuestas);

    int verMagnitud();

    void aplicarPuntos(Respuesta respuesta, int puntos);
}
