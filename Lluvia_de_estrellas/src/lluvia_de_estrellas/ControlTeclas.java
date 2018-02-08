/*
 * 
 * By  Adrian Garcia San Jose.
 * 
 */
package lluvia_de_estrellas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author adri
 */
public class ControlTeclas implements KeyListener{

    private ControlLetras letras;
    private ControlBarra bar;
    
    public ControlTeclas(ControlLetras letras,ControlBarra bar){
        this.letras=letras;
        this.bar=bar;
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("pulsado");
        letras.recibirLetra(""+e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("pulsado");
        bar.recibirTecla(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
