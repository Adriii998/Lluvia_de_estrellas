package lluvia_de_estrellas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class BarControl implements KeyListener{
    private Bar bar;

    public BarControl(Bar bar){
        this.bar=bar;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_RIGHT){
            System.out.println("hola1");
            bar.moverDerecha();
        }

        if (e.getKeyCode()==KeyEvent.VK_LEFT){
            System.out.println("hola2");
            bar.moverIzquierda();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }

}
