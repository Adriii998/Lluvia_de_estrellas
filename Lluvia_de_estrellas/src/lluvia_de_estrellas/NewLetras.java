/*
 * 
 * By  Adrian Garcia San Jose.
 * 
 */
package lluvia_de_estrellas;

import java.util.Timer;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author adri
 */
public class NewLetras {

    private static int HEIGHTPANEL = 50;
    private static int WIDTHPANEL = 50;

    private String usadas = "";
    private String posibles;

    private Niveles levels;
    private int tiempoCaida;
    /*referencia al timer de cada cuanto se mueve una letra*/
    private Timer timerCaida;
    
    private ControlLetras control;

    public NewLetras(ControlLetras ctrl) {
        this.control=ctrl;
        levels = new Niveles();

        posibles = levels.getLEVEL1();
        tiempoCaida = levels.getCAIDA1();

        timerCaida = new Timer();
    }

    public JButton getLetra() {
        JButton boton;

        boton = new JButton(generarLetra());
        //de momento es 50 por poner algo
        boton.setBounds(50, 50, WIDTHPANEL, HEIGHTPANEL);

        return null;
    }

    //selecciona una de las letras posibles de ese nivel
    private String generarLetra() {
        String seleccionada = "";
        int posicion; //posicion de la que se va a seleccionar la letra

        posicion = (int) Math.random() * posibles.length();
        //coge una letra
        seleccionada = "" + posibles.charAt(posicion);

        while (usadas.contains(seleccionada)) {
            posicion = (int) Math.random() * posibles.length();
            //coge una letra
            seleccionada = "" + posibles.charAt(posicion);
        }
        return seleccionada;
    }
    
    public boolean teclaPulsada(String letra){
        if(usadas.contains(letra)){
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

}
