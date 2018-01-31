/*
 * 
 * By  Adrian Garcia San Jose.
 * 
 */
package lluvia_de_estrellas;

import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author adri
 */
public class Vista extends JFrame {

    ArrayList<JButton> botones;
    
    //guille
  private JFrame ventana;
    private Bar bar;
    private Game game;
    private BarControl bc;
    private Jmenubar jmb;
  
    public Vista() {
        ventana = new JFrame("BARRA");
        bar = new Bar(game);
        jmb = new Jmenubar();
        ventana.add(bar);
        ventana.setJMenuBar(jmb.getJmenubar()); // Añadimos JMenuBar a la ventana
        //setFocusable(true);
      botones=new ArrayList();

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setBounds(0,0,800,600);
        ventana.setResizable(false);
        ventana.setVisible(true);
    }

    public void addLetra(JButton boton) {
        botones.add(boton);
        this.add(boton);
        this.repaint();
    }

    public void deleteLetra(String letra) {
        this.remove(botones.get(getPosicionLetra(letra)));
        botones.remove(getPosicionLetra(letra));
    }

    public int getPosicionLetra(String letra) {
        for (int i = 0; i < botones.size(); i++) {
            if (botones.get(i).getActionCommand().equals(letra)) {
                return i;
            }
        }
        return -1;
    }
    
    public void addEscuchadorLetras(KeyListener control){
        this.addKeyListener(control);
    }
  
  public JFrame getVentana() {
        return ventana;
  }

}
