/*
 * 
 * By  Adrian Garcia San Jose.
 * 
 */
package lluvia_de_estrellas;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author adri
 */
public class Vista extends JFrame{
    
    ArrayList <JButton> botones;
    
    public Vista(){
        this.setBounds(50,50,500,500);
        this.setLayout(null);
        
        botones=new ArrayList();
        
        this.setVisible(true);
    }
    
    public void addLetra(JButton boton){
        botones.add(boton);
    }
    
    public void deleteLetra(String letra){
        botones.remove(getPosicionLetra(letra));
    }
    
    public int getPosicionLetra(String letra){
        for (int i = 0; i < botones.size(); i++) {
            if(botones.get(i).getActionCommand().equals(letra)){
                return i;
            }
        }
        return -1;
    }
    
    
}
