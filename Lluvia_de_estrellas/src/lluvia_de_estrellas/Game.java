/*
 * 
 * By  Adrian Garcia San Jose.
 * 
 */
package lluvia_de_estrellas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author adri
 */

public class Game {
    
    private Vista view;
    private ControlLetras ctrlLetras;
    
     //guille
      private Timer temporizador;
    private double x1Barra, x2Barra, yBarra;
  
    public Game(){
        view=new Vista(this);
        ctrlLetras=new ControlLetras(this);
        //JButton boton;
    }
    
  
    
    public void vistaAddEscuchadorLetras(KeyListener escucha){
        view.addEscuchadorLetras(escucha);
    }
    
    public void mandarLetra(JLabel letra){
        view.addLetra(letra);
    }
    
    public void eliminarLetra(String letra){
        view.deleteLetra(letra);
    }
   //guille
  public void error() {
        temporizador.start();
        temporizador = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getVentana().setBackground(Color.RED);
            }
        });
        temporizador.stop();
        view.getVentana().setBackground(Color.GRAY);
    }
  public void actualizarPosBarra(double x1Barra, double x2Barra, double yBarra){
        this.x1Barra = x1Barra;
        this.x2Barra = x2Barra;
        this.yBarra = yBarra;
    }
}
