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

    private Vista1 view;
    private ControlLetras ctrlLetras;

    //private BarControl ctrlBarra;
    private ControlTeclas control;

    //guille
    private Timer temporizador;
    private int contadorTiempo = 0;
    private boolean timerEmpezado = false;
    private double x1Barra, x2Barra, yBarra;

    public Game() {
        view = new Vista1(this);
        ctrlLetras = new ControlLetras(this);
        //JButton boton;
        control = new ControlTeclas(ctrlLetras, view.getControlBarra());
        this.vistaAddEscuchadorLetras(control);
    }

    public void vistaAddEscuchadorLetras(KeyListener escucha) {
        System.out.println("añadir escuchador");
        //view.addEscuchadorLetras(escucha);
        view.addEscuchadorLetras(escucha);
    }

    public void mandarLetra(JLabel letra) {
        view.addLetra(letra);
    }

    public void eliminarLetra(String letra) {
        view.deleteLetra(letra);
    }
    //guille

    public void error() {
        if (!timerEmpezado) {
            temporizador = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    esperarTiempo();
                }
            });
            temporizador.start();
            //temporizador.stop();
            timerEmpezado=true;
        }
    }

    public void esperarTiempo() {
        contadorTiempo += temporizador.getDelay();
        view.getContentPane().setBackground(Color.RED);
        System.out.println("contador de tiemnpo->>>>> " + contadorTiempo);
        if (contadorTiempo >= 200) {
            System.out.println("AHORRRRRRRAAAAA");
            temporizador.stop();
            timerEmpezado=false;
            contadorTiempo = 0;
            view.getContentPane().setBackground(Color.WHITE);
        }
    }

    public void actualizarPosBarra(double x1Barra, double x2Barra, double yBarra) {
        this.x1Barra = x1Barra;
        this.x2Barra = x2Barra;
        this.yBarra = yBarra;
    }
}
