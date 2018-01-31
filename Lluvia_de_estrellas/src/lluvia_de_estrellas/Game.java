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
import javax.swing.JButton;

public class Game {
    
    private Vista view;
    private ControlLetras ctrlLetras;
    
    public Game(){
        view=new Vista();
        ctrlLetras=new ControlLetras(this);
        JButton boton;
    }
    
    
    public void vistaAddEscuchadorLetras(){
    }
    
    public void mandarLetra(JButton btn){
        view.addLetra(btn);
    }
    
}
