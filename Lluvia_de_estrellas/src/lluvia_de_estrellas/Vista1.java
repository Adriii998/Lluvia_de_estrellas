/*
 * 
 * By  Adrian Garcia San Jose.
 * 
 */
package lluvia_de_estrellas;

import java.awt.Color;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author adri
 */
public class Vista1 extends JFrame {

    ArrayList<JLabel> botones;
    private ControlBarra controlBarra;
    private ControlMenu controlMenu;

    public Vista1(Game juego) {
        this.setBounds(50, 50, 800, 600);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlBarra=new ControlBarra(juego,this);
        controlMenu=new ControlMenu();
        this.setJMenuBar(controlMenu.getMenu());
        
        botones=new ArrayList();
        
        this.setVisible(true);
    }
    
    public void anadirPanel(JPanel panelBarra,JPanel divisoria){
        this.add(panelBarra);
        this.add(divisoria);
    }

    public ControlBarra getControlBarra() {
        return controlBarra;
    }
    
    public void addEscuchadorLetras(KeyListener control) {
        this.addKeyListener(control);
        System.out.println("hola hola");
    }
    
     public void addLetra(JLabel letra){
         botones.add(letra);
         this.add(letra);
         this.repaint();
     }
     
     public void deleteLetra(String letra) {
        this.remove(botones.get(getPosicionLetra(letra)));
        botones.remove(getPosicionLetra(letra));
        repaint();
    }
     
     public int getPosicionLetra(String letra) {
        for (int i = 0; i < botones.size(); i++) {
            if (botones.get(i).getText().equals(letra)) {
                return i;
            }
        }
        return -1;
    }


}