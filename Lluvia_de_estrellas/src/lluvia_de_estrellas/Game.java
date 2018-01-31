import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Game {
    private Vista view;
    private Timer temporizador;
    private double x1Barra, x2Barra, yBarra;

    public Game() {
        view = new Vista(this);


    }

    public void error() {
        temporizador.start();
        temporizador = new javax.swing.Timer(1000, new ActionListener() {
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
