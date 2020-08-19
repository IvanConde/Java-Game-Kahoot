package edu.fiuba.algo3.modelo.modificadoresdepuntaje;

public class ModificadorStandard implements Modificador{

    @Override
    public int modificarPuntos(int puntosnuevos, int puntosactuales) {
        return puntosnuevos+puntosactuales;
    }

}