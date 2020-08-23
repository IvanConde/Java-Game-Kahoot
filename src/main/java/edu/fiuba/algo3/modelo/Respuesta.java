package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.modificadoresdepuntaje.ModificadorStandard;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import java.util.ArrayList;

public class Respuesta {
    private ArrayList<Opcion> opciones;
    private Puntaje puntaje;
    private int puntajeTemporal;
    private int opcionesCorrectas;
    private int opcionesIncorrectas;

    public Respuesta(ArrayList<Opcion> opciones, Puntaje puntaje) {
        this.opciones = opciones;
        this.puntaje = puntaje;
        this.puntajeTemporal = 0;
    }

    public void modificarPuntaje(int puntos) {
        puntaje.modificarPuntaje(puntos);
        puntaje.setModificador(new ModificadorStandard());
    }

    /*
    public ArrayList<Opcion> verRespuestaJugador(){
        return opciones;
    }
     */



    public void contarOpciones(){
        this.opcionesIncorrectas = 0;
        this.opcionesIncorrectas = 0;
        for (Opcion opcionElegida : opciones) {
            if (!(opcionElegida.esCorrecto())) {
                this.opcionesIncorrectas += 1;
            }
            else{
                this.opcionesCorrectas += 1;
            }
        }
    }

    public int opcionesCorrectas(){return this.opcionesCorrectas;}
    public int opcionesIncorrectas(){return this.opcionesIncorrectas;}

    public void agregarPuntajeTemporal(int puntos){
        this.puntajeTemporal = puntos;
    }

    public int puntajeTemporal(){
        return this.puntajeTemporal;
    }

    public Puntaje puntaje() {
        return puntaje;
    }

    public ArrayList<Opcion> getOpciones(){
        return opciones;
    }

}