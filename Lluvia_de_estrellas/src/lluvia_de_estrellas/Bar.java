package lluvia_de_estrellas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Bar{
    //private BarControl bc;
    private double xBarra = 100;
    private double yBarra = 500;
    private double anchoBarra = 100;
    private ImageIcon imagen;
    
    private JPanel barra;
    private JPanel divisoria;



    public Bar() {
        crearBarra();
        crearDivisoria();
    }
    
    public void crearBarra(){
        barra=new JPanel();
        barra.setBounds(150, 375, 150, 25);
        barra.setBackground(Color.BLUE);
    }
    
    public void crearDivisoria(){
        divisoria=new JPanel();
        divisoria.setBounds(0, 400, 500, 5);
        divisoria.setBackground(Color.BLACK);
    }

    public JPanel getBarra() {
        return barra;
    }

    public JPanel getDivisoria() {
        return divisoria;
    }


    public void paintComponent() {
        
    }

    public void moverIzquierda() {
        xBarra -= 10;
        //game.actualizarPosBarra(xBarra,(xBarra+anchoBarra),yBarra);
    }

    public void moverDerecha() {
        xBarra += 10;
        //repaint();
        //game.actualizarPosBarra(xBarra,(xBarra+anchoBarra),yBarra);
    }


}


