package edu.fiuba.algo3.modelo.modificadoresDePuntaje;

public class ModificadorMultiplicador implements Modificador{

    private int magnitud;
    private Boolean seUtilizo = false;

    public ModificadorMultiplicador(int magnitud) {
        this.magnitud = magnitud;
    }

    public Boolean seUtilizo() {
        return seUtilizo;
    }

    public int modificarPuntos(int puntosNuevos, int puntosActuales) {
        this.seUtilizo = true;
        return (puntosNuevos * this.magnitud) + puntosActuales;
    }

}