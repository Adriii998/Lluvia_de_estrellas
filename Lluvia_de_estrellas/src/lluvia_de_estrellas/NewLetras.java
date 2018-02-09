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
    private int pixelesMover = 1;

    private ArrayList<Letra> letras;

    private Letra letra;

    public NewLetras(ControlLetras ctrl) {
        this.control = ctrl;

        levels = new Niveles();

        posibles = levels.getLEVEL1();
        tiempoCaida = levels.getCAIDA1();

        
        letras = new ArrayList();
        
        iniciarTimerCaida();
    }

    public JLabel getLetra() {

        letra = new Letra(generarLetra());
        letras.add(letra.getThis());

        return letra.getLetra();
    }

    /**
     *
     * @return retorna la letra que se ha generado de entre las posibles
     */
    private String generarLetra() {
        String seleccionada = "";
        System.out.println("posibles.lengisaokasdofijwaeoi---->   " + posibles);
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

    
    /**
     * fuera de uso, ahora lo hace la clase letra
     * @return la posicion en la que se va a colocar en la pantalla
     */
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
        letras.remove(indice);
        usadas = usadas.substring(0, indice) + usadas.substring(indice + 1);
    }

    //parte de movimiento de las letras
    /**
     * @param
     */
    public void caer() {

        for (Letra let : letras) {
            let.mover(pixelesMover);
            comprobarPos(let);
        }
    }

    public void comprobarPos(Letra let) {
        JLabel letra = let.getLetra();
        if (letra.getBounds().intersects(control.getRecBarra())) {
            let.cambiarDireccion();
        }
        if (letra.getBounds().intersects(limite.getBounds()) || letra.getY() - letra.getHeight() <= 0) {
            timerCaida.stop();
            control.perder();
        }
    }

    //getter de tamaño usadas y posibles
    public int getTamañoUsadas() {
        return usadas.length();
    }

    public int getTamañoPosibles() {
        return posibles.length();
    }

    public void cambiarNivel(int i) {
        switch (i) {
            case 1:
                posibles = levels.getLEVEL1();
                tiempoCaida = levels.getCAIDA1();
                break;
            case 2:
                posibles = levels.getLEVEL2();
                tiempoCaida = levels.getCAIDA2();
                break;
            case 3:
                posibles = levels.getLEVEL3();
                tiempoCaida = levels.getCAIDA3();
                break;
            case 4:
                posibles = levels.getLEVEL4();
                tiempoCaida = levels.getCAIDA4();
                break;
            case 5:
                posibles = levels.getLEVEL5();
                tiempoCaida = levels.getCAIDA5();
                break;
        }
        timerCaida.stop();
        iniciarTimerCaida();
    }
    
    //reiniciar el arrayList de letras
    //el propio cambiar nivel inicia de nuevo el timer
    public void restaurar(int nivel){
        cambiarNivel(nivel);
        letras.clear();
        usadas="";
    }
    
    public void iniciarTimerCaida(){
        timerCaida = new Timer(tiempoCaida, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caer();
            }
        });
        timerCaida.start();
    }
}
