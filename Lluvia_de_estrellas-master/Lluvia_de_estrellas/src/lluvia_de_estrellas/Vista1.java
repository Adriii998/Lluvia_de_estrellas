/*
 * 
 * By  Adrian Garcia San Jose.
 * 
 */
package lluvia_de_estrellas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
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
    private JLabel niveles;
    private JLabel puntuacion;
    private JLabel reinicio;

    public Vista1(Game juego) {
        this.setBounds(50, 50, 800, 600);
        this.setLayout(null);
    
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlBarra = new ControlBarra(juego, this);
        controlMenu = new ControlMenu(juego);
        this.setJMenuBar(controlMenu.getMenu());
        
        this.colorVista();
        this.setResizable(false);
        botones = new ArrayList();
        this.datosJuego();
        
        this.add(puntuacion);
        this.setVisible(true);
    }

    public void colorVista() {
        int r=125;
        int g=255;
        int b=51;
        Color colorVista = new Color(r, g, b);
        
       this.setBackground(colorVista);
       this.setVisible(true);

    }

    public void anadirPanel(JPanel panelBarra, JPanel divisoria) {
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

    public void addLetra(JLabel letra) {
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

    /*
    elimina las letras
    funcion para cuando pierdes que cambie lo necesario
     */
    public void restaurar() {
        for (JLabel botone : botones) {
            this.remove(botone);
        }
     
        botones.clear();
        this.repaint();
    }

    public void actualizarPuntos(int puntos) {
        String texto;
        texto = puntuacion.getText().substring(0, 8);
        puntuacion.setText(texto + puntos);
    }

    public void datosJuego() {

        niveles = new JLabel("NIVEL: ");
        niveles.setBounds(10, 15, 150, 40);
        niveles.setFont(niveles.getFont().deriveFont(20.0f));
        niveles.setForeground(Color.BLUE);
        puntuacion = new JLabel("PUNTOS: ");
        puntuacion.setBounds(10, 500, 150, 40);
        puntuacion.setFont(puntuacion.getFont().deriveFont(20.0f));
        puntuacion.setForeground(Color.BLUE);

        this.add(niveles);
        this.add(puntuacion);

    }

    public void actualizarNivel(int nivel) {
        String texto;
        texto = niveles.getText().substring(0, 7);
        niveles.setText(texto + nivel);

    }
    
    public void perderReiniciarJuego(){
       
        
        reinicio = new JLabel("GAME OVER: ELIGE NIVEL PARA VOLVER A JUGAR. ");
        reinicio.setBounds(150, 200,520 ,40);
        reinicio.setFont(reinicio.getFont().deriveFont(20.0f));
        reinicio.setForeground(Color.BLUE);
        this.add(reinicio);
                
            
        
    }
    public void limpiarPantalla(){
        reinicio.setText(" ");
        
            
   }

}
