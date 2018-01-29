package lluvia_de_estrellas;


import javax.swing.JFrame;
import javax.swing.JMenuBar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorca
 */
public class Vista extends JFrame{
    
    public Vista(){
        
    
        this.setTitle("LLuvia Estrellas");
        this.setBounds(500, 300, 600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
    }
    
    public void anadirMenubar(JMenuBar barra){
        
        this.setJMenuBar(barra);
         this.setVisible(true);
    }

    
}
