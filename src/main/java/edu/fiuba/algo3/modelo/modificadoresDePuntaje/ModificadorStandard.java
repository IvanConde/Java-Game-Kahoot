package edu.fiuba.algo3.modelo.modificadoresDePuntaje;

public class ModificadorStandard implements Modificador{

    @Override
    public int modificarPuntos(int puntosNuevos, int puntosActuales) {
        return puntosNuevos + puntosActuales;
    }

}