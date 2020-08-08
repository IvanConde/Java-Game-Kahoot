package edu.fiuba.algo3.modelo;

public class Multiplicador {

    private int magnitud;
    private Boolean seUtilizo = false;

    public Multiplicador(int magnitud) {
        this.magnitud = magnitud;
    }

    public Boolean seUtilizo() {
        return seUtilizo;
    }

    public int multiplicarPuntos(int puntos) {
        this.seUtilizo = true;
        return puntos * this.magnitud;
    }

}