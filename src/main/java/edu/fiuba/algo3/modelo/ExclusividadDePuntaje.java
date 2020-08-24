package edu.fiuba.algo3.modelo;
import java.util.ArrayList;

public interface ExclusividadDePuntaje {

    //public void activarExclusividad(Jugador jugador);

    public boolean verEstado();

    public void aplicarExclusividad(ArrayList<Respuesta> respuestas);

    public int verMagnitud();

}