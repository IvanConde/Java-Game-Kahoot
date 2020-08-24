package edu.fiuba.algo3.modelo.exclusividad;
import edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public interface Exclusividad {


    public void aplicarExclusividad(ArrayList<Respuesta> respuestas);

    public int verMagnitud();

    public void aplicarPuntos(Respuesta respuesta, int puntos);
}
