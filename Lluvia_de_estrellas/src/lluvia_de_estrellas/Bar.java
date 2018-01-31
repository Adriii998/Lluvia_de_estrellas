import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Bar extends JPanel {
    private BarControl bc;
    private Game game;
    private double xBarra = 100;
    private double yBarra = 500;
    private double anchoBarra = 100;


    public Bar(Game game) {
        bc = new BarControl(this);
        this.game = game;
        this.addKeyListener(bc);
        setFocusable(true);

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(new Rectangle2D.Double(xBarra, yBarra, anchoBarra, 10));

        // Creamos la línea donde desaparecen las letras
        Graphics2D linea = (Graphics2D) g;
        linea.draw(new Line2D.Float(0,510,800,510));

        System.out.println("creado");
        //repaint();
    }

    public void moverIzquierda() {
        xBarra -= 10;
        repaint();
        game.actualizarPosBarra(xBarra,(xBarra+anchoBarra),yBarra);
    }

    public void moverDerecha() {
        xBarra += 10;
        repaint();
        game.actualizarPosBarra(xBarra,(xBarra+anchoBarra),yBarra);
    }


}


