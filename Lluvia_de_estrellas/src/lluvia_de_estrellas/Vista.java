import javax.swing.*;

public class Vista extends JFrame{
    private JFrame ventana;
    private Bar bar;
    private Game game;
    private BarControl bc;
    private Jmenubar jmb;


    public Vista(Game game){
        ventana = new JFrame("BARRA");
        bar = new Bar(game);
        jmb = new Jmenubar();
        ventana.add(bar);
        ventana.setJMenuBar(jmb.getJmenubar()); // Añadimos JMenuBar a la ventana
        //setFocusable(true);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setBounds(0,0,800,600);
        ventana.setResizable(false);
        ventana.setVisible(true);
    }



    public JFrame getVentana() {
        return ventana;
    }




}
