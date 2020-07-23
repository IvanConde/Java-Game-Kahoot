package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class Pregunta {
    public abstract void recibirRespuestas(ArrayList<Respuesta> respuestas);
    public abstract void evaluarRespuesta(Respuesta respuesta);
}
