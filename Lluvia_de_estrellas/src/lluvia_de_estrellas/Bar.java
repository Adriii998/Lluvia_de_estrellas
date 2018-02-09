package lluvia_de_estrellas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javafx.geometry.Bounds;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Bar{
    //private BarControl bc;
    private int xBarra = 100;
    private int yBarra = 475 ;
    private int anchoBarra = 100;
    private ImageIcon imagen;
    
    private JPanel barra;
    private JPanel divisoria;



    public Bar() {
        crearBarra();
        crearDivisoria();
    }
    
    public void crearBarra(){
        barra=new JPanel();
        barra.setBounds(xBarra, yBarra, anchoBarra, 10);
        barra.setBackground(Color.BLUE);
    }
    
    public void crearDivisoria(){
        divisoria=new JPanel();
        divisoria.setBounds(0, 500, 500, 5);
        divisoria.setBackground(Color.BLACK);
    }

    public JPanel getBarra() {
        return barra;
    }

    public JPanel getDivisoria() {
        return divisoria;
    }


    public void moverIzquierda() {
        xBarra -= 10;
        barra.setLocation(xBarra, yBarra);
        //game.actualizarPosBarra(xBarra,(xBarra+anchoBarra),yBarra);
    }

    public void moverDerecha() {
        xBarra += 10;
        barra.setLocation(xBarra, yBarra);
        //repaint();
        //game.actualizarPosBarra(xBarra,(xBarra+anchoBarra),yBarra);
    }

    public Rectangle getBounds(){
        return barra.getBounds();
    }
        
    public Rectangle getLimite(){
        return divisoria.getBounds();
    }
}


