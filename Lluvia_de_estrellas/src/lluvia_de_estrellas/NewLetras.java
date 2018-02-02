/*
 * 
 * By  Adrian Garcia San Jose.
 * 
 */
package lluvia_de_estrellas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.Timer;


/**
 *
 * @author adri
 */
public class NewLetras {

    private ControlLetras control;

    //private int heightVentana=800;
    private int widthVentana = 800;

    private static int HEIGHTPANEL = 50;
    private static int WIDTHPANEL = 50;

    private String usadas = "";
    private String posibles;

    private Niveles levels;
    private int tiempoCaida;
    /*referencia al timer de cada cuanto se mueve una letra*/
    private Timer timerCaida;

    private ArrayList<JLabel> botones;

    private JLabel letra;

    public NewLetras(ControlLetras ctrl) {
        this.control = ctrl;

        levels = new Niveles();

        posibles = levels.getLEVEL1();
        tiempoCaida = levels.getCAIDA1();

        timerCaida = new Timer(tiempoCaida, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caer();
            }
        });

        botones = new ArrayList();
        timerCaida.start();
    }

    public JLabel getLetra() {
         
        
        
        letra = new JLabel(generarLetra());
        //de momento es 50 por poner algo
        letra.setBounds(100, 100, WIDTHPANEL, HEIGHTPANEL);
        letra.setBackground(Color.red);
        botones.add(letra);
        
        
        System.out.println("Label letra---> "+letra.getText());
        
        return letra;
    }

    /**
     *
     * @return retorna la letra que se ha generado de entre las posibles
     */
    private String generarLetra() {
        String seleccionada = "";

        System.out.println("posibles.leng->" + posibles.length());

        //coge una letra
        //seleccionada = "" + posibles.charAt(getPosicion());
        while (usadas.contains(seleccionada) && usadas.length() < posibles.length()) {
            //coge una letra
            seleccionada = "" + posibles.charAt(getPosicion());

        }
        usadas += seleccionada;
        return seleccionada;
    }

    public int getPosicion() {
        int posicion; //posicion de la que se va a seleccionar la letra
        posicion = (int) (Math.random() * posibles.length());

        return posicion;
    }

    public int posXAleatoria() {
        int x = (int) (Math.random() * widthVentana);
        return x;
    }

    /*
    public int posYAleatoria(){
        int y=(int) (Math.random()*heightVentana);
        return y;
    }*/
    /**
     *
     * @param letra la letra pulsada en teclado
     * @return si es valida o no
     */
    public boolean teclaPulsada(String letra) {
        if (usadas.contains(letra)) {
            quitarLetra(letra);
            return true;
        }
        return false;
    }

    //elimina la letra del boton que se ha pulsado
    public void quitarLetra(String letra) {
        int indice = usadas.indexOf(letra);

        usadas = usadas.substring(0, indice) + usadas.substring(indice + 1);
    }

    //parte de movimiento de las letras
    /**
     * @param
     */
    public void caer() {
        for (JLabel btn : botones) {
            btn.setBounds(btn.getX(), btn.getY() + 20, 50, 50);
        }
        //boton.setBounds(50, boton.getY()+10, 50, 50);
    }

    //getter de tamaño usadas y posibles
    public int getTamañoUsadas() {
        return usadas.length();
    }

    public int getTamañoPosibles() {
        return posibles.length();
    }

}
