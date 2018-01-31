/*
 * 
 * By  Adrian Garcia San Jose.
 * 
 */
package lluvia_de_estrellas;

/**
 *
 * @author adri
 */
import java.awt.event.KeyListener;
import javax.swing.JButton;

public class Game {
    
    private Vista view;
    private ControlLetras ctrlLetras;
    
    public Game(){
        view=new Vista();
        ctrlLetras=new ControlLetras(this);
        JButton boton;
    }
    
    
    public void vistaAddEscuchadorLetras(KeyListener escucha){
        view.addEscuchadorLetras(escucha);
    }
    
    public void mandarLetra(JButton btn){
        view.addLetra(btn);
    }
    
    public void eliminarLetra(String letra){
        view.deleteLetra(letra);
    }
    
}
