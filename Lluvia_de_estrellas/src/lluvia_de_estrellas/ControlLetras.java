/*
 * 
 * By  Adrian Garcia San Jose.
 * 
 */
package lluvia_de_estrellas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;


/**
 *
 * @author adri
 */
public class ControlLetras /*implements KeyListener */{

    private NewLetras letras;
    private Game juego;

    //timer que va a generar las letras cada cierto tiempo
    Timer timer;

    public ControlLetras(Game game) {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nuevaLetra();
            }

        });
        letras = new NewLetras(this);

        this.juego = game;
        //game.vistaAddEscuchadorLetras(this);
        timer.start();
    }

    public void recibirLetra(String letra){
        String pulsada=letra.toUpperCase();
        
        if (letras.teclaPulsada(pulsada)) {
            System.out.println("CORRECTA");
            juego.eliminarLetra(pulsada);
        } else {
            System.out.println("letra incorrecta");
            juego.error();
        }
    }
    
    /*
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("PULSADA------>");
        String pulsada = ("" + e.getKeyChar()).toUpperCase();
        if (letras.teclaPulsada(pulsada)) {
            System.out.println("CORRECTA");
            juego.eliminarLetra(pulsada);
        } else {
            System.out.println("letra incorrecta");
            //juego.error();
        }
        System.out.println("hola");
    }

    @Override
    public void keyPressed(KeyEvent e) {
System.out.println("PULSADA------>");
        String pulsada = ("" + e.getKeyChar()).toUpperCase();
        if (letras.teclaPulsada(pulsada)) {
            System.out.println("CORRECTA");
            juego.eliminarLetra(pulsada);
        } else {
            System.out.println("letra incorrecta");
            //juego.error();
        }
        System.out.println("hola");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }*/

    public void nuevaLetra() {
        if (letras.getTamañoUsadas() < letras.getTamañoPosibles()) {
            juego.mandarLetra(letras.getLetra());
        }
    }
    
    public void cambiarNivel(int i){
        letras.cambiarNivel(i);
    }

}
