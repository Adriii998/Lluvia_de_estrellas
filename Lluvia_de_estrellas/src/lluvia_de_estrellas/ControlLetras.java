/*
 * 
 * By  Adrian Garcia San Jose.
 * 
 */
package lluvia_de_estrellas;

import java.awt.Rectangle;
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
        //timer.start();
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
    
    public void nuevaLetra() {
        if (letras.getTamañoUsadas() < letras.getTamañoPosibles()) {
            juego.mandarLetra(letras.getLetra());
        }
    }
    
    public Rectangle getRecBarra(){
        return juego.getRect();
    }
    
    public void setLimit(Rectangle rec){
        letras.setLimite(rec);
    }
    
    //cuando se ha perdido la partida se para el timer de creacion
    //ya el game se encargara de restaurar todo
    public void perder(){
        timer.stop();
        juego.pausarTodo();
    }
    /**
     * 
     * @param i 
     */
    public void cambiarNivel(int i){
        //letras.cambiarNivel(i);
        letras.restaurar(i);
    }
    
    //va a reiniciar todo
    public void restaurar(int nivel){
        
        letras.restaurar(nivel);
        
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nuevaLetra();
            }
        });
        timer.start();
    }

}
