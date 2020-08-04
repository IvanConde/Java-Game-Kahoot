package edu.fiuba.algo3.modelo;

public class Jugador {

    static final int MULTIPLICADORX2 = 2;
    static final int MULTIPLICADORX3 = 3;
    private Puntaje puntaje;
    private String nombre;
    private int multiplicadoresX2;
    private int multiplicadoresX3;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntaje = new Puntaje();
        this.multiplicadoresX2 = 1;
        this.multiplicadoresX3 = 1;
    }

    public Puntaje puntaje(){
        return puntaje;
    }

    public boolean tieneMultiplicadorX2(){
        if(multiplicadoresX2 > 0){
            return true;
        }
        return false;
    }

    public boolean tieneMultiplicadorX3(){
        if(multiplicadoresX3 > 0){
            return true;
        }
        return false;
    }

    public void usarMultiplicadorX2(){
        if(this.tieneMultiplicadorX2()){
            puntaje.setMultiplicador(MULTIPLICADORX2);
        }
    }

    public void usarMultiplicadorX3(){
        if(this.tieneMultiplicadorX3()){
            puntaje.setMultiplicador(MULTIPLICADORX3);
        }
    }

}