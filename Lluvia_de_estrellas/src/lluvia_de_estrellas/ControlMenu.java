package lluvia_de_estrellas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;

public class ControlMenu implements ActionListener {

    private Game game;
    private Jmenubar menu;

    public ControlMenu(Game juego) {
        this.game = juego;
        menu = new Jmenubar();
        menu.anadirEscuchadores(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String accion = e.getActionCommand();

        switch (accion) {
            case "SALIR":
                System.out.println("Salir");
                System.exit(0);
                break;
            case "GUARDAR":
                System.out.println("Guardar");

                break;
            case "CARGAR":
                System.out.println("Cargar");
                break;
            case "LEVEL 1":
                System.out.println("Level 1");
                game.pasarNiveles(1);
                break;
            case "LEVEL 2":
                System.out.println("Level 2");
                game.pasarNiveles(2);
                break;
            case "LEVEL 3":
                System.out.println("level 3");
                game.pasarNiveles(3);
                break;
            case "LEVEL 4":
                System.out.println("Level 4");
                game.pasarNiveles(4);
                break;
            case "LEVEL 5":
                System.out.println("level 5");
                game.pasarNiveles(5);
                break;

            default:
        }

        //  game.pasarNiveles(Integer.parseInt(accion.substring(accion.length()-1)));
    }

    public JMenuBar getMenu() {
        return menu.getJmenubar();
    }

}
