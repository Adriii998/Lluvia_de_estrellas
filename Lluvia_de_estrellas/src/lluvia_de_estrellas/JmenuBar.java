/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lluvia_de_estrellas;

import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author jorca
 */
public class JmenuBar {

    private JMenu archivo;
    private JMenu level;
    private JMenuItem salir;
    private JMenuItem guardar;
    private JMenuItem cargar;
    private JMenuItem level1;
    private JMenuItem level2;
    private JMenuItem level3;
    private JMenuItem level4;
    private JMenuItem level5;
    private ControlMenu controlMenu;
    private JMenuBar jmenubar;
    private ControlMenu control;
    private Game game;

    public JmenuBar(Game game) {
          this.game=game;
          control=new ControlMenu();
          creaMenu();
          anadirEscuchadores();
        
    }

    public void creaMenu() {

        jmenubar = new JMenuBar();
        //menus
        archivo = new JMenu("ARCHIVO");
        level = new JMenu("LEVEL");

        //itemMenus archivos
        salir = new JMenuItem("SALIR");
        guardar = new JMenuItem("GUARDAR");
        cargar = new JMenuItem("CARGAR");

        archivo.add(salir);
        archivo.add(guardar);
        archivo.add(cargar);

        //items level
        level1 = new JMenuItem("LEVEL 1");
        level2 = new JMenuItem("LEVEL 2");
        level3 = new JMenuItem("LEVEL 3");
        level4 = new JMenuItem("LEVEL 4");
        level5 = new JMenuItem("LEVEL 5");

        level1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_DOWN_MASK));
        level2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_DOWN_MASK));
        level3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_DOWN_MASK));
        level4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.CTRL_DOWN_MASK));
        level5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, InputEvent.CTRL_DOWN_MASK));
        
        
        level.add(level1);
        level.add(level2);
        level.add(level3);
        level.add(level4);
        level.add(level5);
        
        jmenubar.add(archivo);
        jmenubar.add(level);
        
      

    }
    
    
    
    
    public void anadirEscuchadores(){
        
        salir.addActionListener(control);
        guardar.addActionListener(control);
        cargar.addActionListener(control);
        level1.addActionListener(control);
        level2.addActionListener(control);
        level3.addActionListener(control);
        level4.addActionListener(control);
        level5.addActionListener(control);
        
        
    }

    public JMenuBar getJmenubar() {
        
        return jmenubar;
    }

   
    
    
    
  

}
