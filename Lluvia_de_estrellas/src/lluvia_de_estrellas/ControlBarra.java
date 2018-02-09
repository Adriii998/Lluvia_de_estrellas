/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lluvia_de_estrellas;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * @author guille
 */
public class ControlBarra{
    
    private Bar barra;
    private Game game;
    public ControlBarra(Game juego,Vista1 vista){
        barra=new Bar();
        this.game=juego;
        game.actualizarPosBarra(barra.getBounds());
        
        vista.anadirPanel(barra.getBarra(), barra.getDivisoria());
        
    }
    
    public void recibirTecla(int codigo){
        
        System.out.println("ME LLEGA flecha");
        
        if (codigo==KeyEvent.VK_RIGHT){
            System.out.println("hola1");
            barra.moverDerecha();
        }

        if (codigo==KeyEvent.VK_LEFT){
            System.out.println("hola2");
            barra.moverIzquierda();
        }
        
        game.actualizarPosBarra(barra.getBounds());
    }
    
    public Rectangle getLimite(){
        return barra.getLimite();
    }
    
}
