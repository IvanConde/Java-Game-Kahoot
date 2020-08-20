package edu.fiuba.algo3.javafx;
import edu.fiuba.algo3.javafx.vistas.VistaInicial;
import edu.fiuba.algo3.javafx.vistas.VistaJuego;
import edu.fiuba.algo3.modelo.*;
import javafx.stage.Stage;
import java.util.Random;
import java.io.File;
import java.util.ArrayList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Panel { // Panel es el modelo de un MVC

    private Jugador jugador1;
    private Jugador jugador2;
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private VistaInicial vistaInicial;
    private VistaJuego vistaJuego;
    private Stage stage;

    public Panel(Stage stage){
        this.stage = stage;
        this.vistaInicial = new VistaInicial(stage);
    }

    public void iniciarJuego(){
        stage.setTitle("Kahoot2.0");
        this.reproducirMusica();
        this.vistaInicial.mostrar(this);
    }

    public boolean juegoPuedeComenzar(){
        if(jugador1 == null || jugador2 == null ){
            return false;
        }
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        return true;
    }

    public void agregarJugador(String nombre){
        if (this.jugador1 == null){
            this.jugador1 = new Jugador(nombre);
        }else {
            this.jugador2 = new Jugador(nombre);
        }
    }

    public void comenzarJuego(){
        this.vistaJuego = new VistaJuego(stage, jugadores);
        this.vistaJuego.mostrar();
    }

    public void reproducirMusica(){
        ArrayList<String> canciones = new ArrayList<String>();
        canciones.add("musica//musica.mp3");
        canciones.add("musica//musica1.mp3");
        canciones.add("musica//musica2.mp3");
        canciones.add("musica//musica3.mp3");
        canciones.add("musica//musica4.mp3");
        canciones.add("musica//musica5.mp3");
        canciones.add("musica//musica6.mp3");
        canciones.add("musica//musica7.mp3");

        int tamaño = canciones.size();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(tamaño);
        String cancionElegida = canciones.get(randomInt);

        Media sound = new Media(new File(cancionElegida).toURI().toString());
        MediaPlayer player = new MediaPlayer(sound);
        player.play();
    }

}