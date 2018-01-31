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
public class ControlLetras implements KeyListener {
    
    private NewLetras letras;
    private Game juego;
    
    //timer que va a generar las letras cada cierto tiempo
    Timer timer;
    
    public ControlLetras(Game game){
        timer=new Timer(1000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nuevaLetra();
            }
        });
        letras=new NewLetras(this);
        this.juego=game;
        timer.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        String pulsada=(""+e.getKeyChar()).toUpperCase();
        if(letras.teclaPulsada(pulsada)){
            
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
    public void nuevaLetra(){
        System.out.println("nueva letra");
        juego.mandarLetra(letras.getLetra());
    }
    
}
