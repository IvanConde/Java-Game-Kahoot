package edu.fiuba.algo3.javafx.datos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.excepciones.ModalidadInvalidaException;
import edu.fiuba.algo3.modelo.excepciones.PreguntaInvalidaException;
import edu.fiuba.algo3.modelo.modalidades.Clasico;
import edu.fiuba.algo3.modelo.modalidades.Modalidad;
import edu.fiuba.algo3.modelo.modalidades.Parcial;
import edu.fiuba.algo3.modelo.modalidades.Penalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionBooleana;
import edu.fiuba.algo3.modelo.opciones.OpcionGroup;
import edu.fiuba.algo3.modelo.opciones.OpcionOrdered;
import edu.fiuba.algo3.modelo.preguntas.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Iterator;
import java.util.LinkedList;

//throws FileNotFoundException
public class CrearPreguntas {
    private LinkedList queue;

    public CrearPreguntas(){
        queue = new LinkedList();
    }

    public LinkedList parsear() {
        JSONParser parser = new JSONParser();
        try(Reader reader = new FileReader("preguntas.json")){
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            jsonObject.keySet().forEach(clave ->
                    {
                        String clavePregunta = (String) clave;

                        JSONArray valor = (JSONArray) jsonObject.get(clave);
                        System.out.println(valor);
                        for(int i=0; i<5;i++) {
                            ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
                            JSONObject pregunta = (JSONObject) valor.get(i);
                            this.crearPregunta(clavePregunta, pregunta);
                        }
                    });
                    } catch (IOException | ParseException ioException) {
            ioException.printStackTrace();
        }
        return this.queue;
    }

    public void crearPregunta(String clavePregunta, JSONObject jsonPregunta){
        if(clavePregunta.equalsIgnoreCase("MultipleChoice")){
            this.crearMultipleChoice(jsonPregunta);
        }else if(clavePregunta.equalsIgnoreCase("OrderedChoice")){
            this.crearOrderedChoice(jsonPregunta);
        }else if(clavePregunta.equalsIgnoreCase("VerdaderoFalso")){
            this.crearVerdaderoFalso(jsonPregunta);
        }else if(clavePregunta.equalsIgnoreCase("GroupChoice")){
            this.crearGroupChoice(jsonPregunta);
        }else{
            throw new PreguntaInvalidaException("El tipo de pregunta leida no existe");
        }
    }

    public void crearMultipleChoice(JSONObject jsonPregunta){
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        String textoPregunta = (String) jsonPregunta.get("textoPregunta");
        JSONObject opciones = (JSONObject) jsonPregunta.get("opciones");
        String stringModalidad = (String) jsonPregunta.get("modalidad");
        Modalidad modalidad = this.obtenerModalidad(stringModalidad);
        opciones.keySet().forEach(claveOpcion ->{
            String textoOpcion = (String) claveOpcion;
            boolean esCorrecto = (boolean) opciones.get(claveOpcion);
            OpcionBooleana opcion = new OpcionBooleana(textoOpcion, esCorrecto);
            todasLasOpciones.add(opcion);
        });
        MultipleChoice pregunta = new MultipleChoice(textoPregunta, todasLasOpciones, modalidad);
        this.queue.add(pregunta);
    }

    public void crearVerdaderoFalso(JSONObject jsonPregunta){
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        String textoPregunta = (String) jsonPregunta.get("textoPregunta");
        JSONObject opciones = (JSONObject) jsonPregunta.get("opciones");
        String stringModalidad = (String) jsonPregunta.get("modalidad");
        Modalidad modalidad = this.obtenerModalidad(stringModalidad);
        opciones.keySet().forEach(claveOpcion ->{
            String textoOpcion = (String) claveOpcion;
            boolean esCorrecto = (boolean) opciones.get(claveOpcion);
            OpcionBooleana opcion = new OpcionBooleana(textoOpcion, esCorrecto);
            todasLasOpciones.add(opcion);
        });
        VerdaderoFalso pregunta = new VerdaderoFalso(textoPregunta, todasLasOpciones, modalidad);
        this.queue.add(pregunta);
    }

    public void crearOrderedChoice(JSONObject jsonPregunta){
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        String textoPregunta = (String) jsonPregunta.get("textoPregunta");
        JSONObject opciones = (JSONObject) jsonPregunta.get("opciones");
        opciones.keySet().forEach(claveOpcion ->
        {
            String textoOpcion = (String) claveOpcion;
            int posicionOriginal =  ((Long)opciones.get(claveOpcion)).intValue();
            OpcionOrdered opcion = new OpcionOrdered(textoOpcion,posicionOriginal);
            todasLasOpciones.add(opcion);
        });
        OrderedChoice pregunta = new OrderedChoice(textoPregunta, todasLasOpciones);
        this.queue.add(pregunta);
    }

    public void crearGroupChoice(JSONObject jsonPregunta){
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        String textoPregunta = (String) jsonPregunta.get("textoPregunta");
        JSONObject opciones = (JSONObject) jsonPregunta.get("opciones");
        opciones.keySet().forEach(claveOpcion ->{
            String textoOpcion = (String) claveOpcion;
            String grupoOriginal = (String) opciones.get(claveOpcion);
            OpcionGroup opcion = new OpcionGroup(textoOpcion, grupoOriginal);
            todasLasOpciones.add(opcion);
        });
        GroupChoice pregunta = new GroupChoice(textoPregunta, todasLasOpciones);
        this.queue.add(pregunta);
    }

    public Modalidad obtenerModalidad(String stringModalidad){
        Modalidad modalidad;
        if(stringModalidad.equalsIgnoreCase("penalidad")){
            modalidad = new Penalidad();
        }else if(stringModalidad.equalsIgnoreCase("clasico")){
            modalidad = new Clasico();
        }else if(stringModalidad.equalsIgnoreCase("parcial")){
            modalidad = new Parcial();
        }else{
            throw new ModalidadInvalidaException("La modalidad leida no existe");
        }
        return modalidad;
    }
}
