/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lluvia_de_estrellas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;

/**
 *
 * @author jorca
 */
public class ControlMenu implements ActionListener{
  
    private JmenuBar menu;
    
    
    
    public ControlMenu(Vista vista){
        
        
        menu=new JmenuBar();
        menu.anadirEscuchadores(this);//anade escuchadores
        vista.anadirMenubar(menu.getJmenubar());//le pasamos el menubar a la vista

       
        
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        String accion=e.getActionCommand();
    
        
        switch (accion) {
            case "SALIR":
                System.out.println("Salir");
                break;
            case "GUARDAR":
                  System.out.println("Guardar");
                break;
            case "CARGAR":
                  System.out.println("Cargar");
                break;
            case "LEVEL 1":
                  System.out.println("Level 1");
                break;
            case "LEVEL 2":
                   System.out.println("Level 2");
                break;
            case "LEVEL 3":
                   System.out.println("level 3");
                break;
            
            case "LEVEL 4":
                     System.out.println("Level 4");
                break;
            case "LEVEL 5":
                  System.out.println("level 5");
                break;
            
            default:
               
        }
        
    }
    
}
