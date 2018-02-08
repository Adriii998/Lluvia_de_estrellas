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
public class Vista extends JFrame {

    ArrayList<JLabel> botones;

    //guille
    
    private Bar bar;
    private Game game;
    private BarControl bc;
    private Jmenubar jmb;
    
    private JPanel panel;
    
    private JPanel ventana;

    public Vista(Game game) {
        
        ventana= (JPanel) this.getContentPane();
        
        
        
        this.setLayout(null);
        
        //probando cosas
        //ventana = new JFrame("BARRA");
        //bar = new Bar(game);
        bc=new BarControl(bar);
        
        jmb = new Jmenubar();
        
        panel=new JPanel();
        panel.setBounds(0, 500, 800, 100);
        panel.setBackground(Color.RED);
       // panel.add(bar);
        this.add(panel);
        
        
        //this.add(bar);
        this.setJMenuBar(jmb.getJmenubar()); // Añadimos JMenuBar a la ventana
        
        
        
        
        //setFocusable(true);
        botones = new ArrayList();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 800, 600);
        //ventana.setResizable(false);
        this.setVisible(true);
    }

    public void addLetra(JLabel letra) {
        
        
        
        letra.setBounds(50, 50, 50, 50);
        this.add(letra);
        this.repaint();
        
        
        System.out.println("GENEROOOOOOOOOOOOOOOOOOOOO--"+letra.getText());
        botones.add(letra);
        this.add(letra);
        this.repaint();
        
    }

    public void deleteLetra(String letra) {
        this.remove(botones.get(getPosicionLetra(letra)));
        botones.remove(getPosicionLetra(letra));
    }

    public int getPosicionLetra(String letra) {
        for (int i = 0; i < botones.size(); i++) {
            if (botones.get(i).getText().equals(letra)) {
                return i;
            }
        }
        return -1;
    }

    public void addEscuchadorLetras(KeyListener control) {
        this.addKeyListener(control);
        ventana.addKeyListener(control);
        System.out.println("hola hola");
    }

    public JFrame getVentana() {
        return this;
    }

    public Bar getBar() {
        return bar;
    }

    public BarControl getBc() {
        return bc;
    }
    
    
}
