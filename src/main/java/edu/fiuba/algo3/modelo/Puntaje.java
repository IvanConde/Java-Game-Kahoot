package edu.fiuba.algo3.modelo;

public class Puntaje {

    private int puntaje;
    private Multiplicador multiplicador;

    public Puntaje() {
        this.puntaje = 0;
    }

    public void calcularPuntaje(int puntos) {
        if ((this.multiplicador != null) && !(this.multiplicador.seUtilizo())) {
            puntaje += this.multiplicador.multiplicarPuntos(puntos);
        } else {
            puntaje += puntos;
        }
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setMultiplicador(Multiplicador multiplicador) {
        this.multiplicador = multiplicador;
    }
}
/*
    public void setExclusividad(ExclusividadDePuntaje exclusividad) {
        this.exclusividad = exclusividad;
}

}
        else if((this.exclusividad != null) && (this.exclusividad.sePuedeUsar())){
        puntaje += this.exclusividad.
 */