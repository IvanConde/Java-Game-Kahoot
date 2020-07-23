package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoYFalso extends Pregunta {

    private Respuesta respuestaCorrecta;
    private String pregunta;

    public VerdaderoYFalso(String pregunta, Respuesta respuestaCorrecta) {
        this.pregunta = pregunta;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public void recibirRespuestas(ArrayList<Respuesta> respuestas) {
        for (int i = 0; i < respuestas.size(); i++) {
            this.evaluarRespuesta(respuestas.get(i));
        }
    }

    public void evaluarRespuesta(Respuesta respuesta) {
        if (respuesta.getRespuesta() == this.respuestaCorrecta.getRespuesta()) {
            (respuesta.respondidaPor()).recibirPuntaje(1);
        } else {
            (respuesta.respondidaPor()).recibirPuntaje(0);

        }
    }

    public String getRespuestaCorrecta() {
        return this.respuestaCorrecta.getRespuesta();
    }

}