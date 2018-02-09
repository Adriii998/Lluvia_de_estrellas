/*
 * 
 * By  Adrian Garcia San Jose.
 * 
 */
package lluvia_de_estrellas;

import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author adri
 */
public class Letra {

    /**
     * partes de la ventana
     */
    private int widthVentana = 800;
    private static int HEIGHTPANEL = 50;
    private static int WIDTHPANEL = 50;

    private JLabel letra;
    private boolean direccion;

    public Letra(String let) {
        crearLetra(let);
        direccion=true;
    }

    public void crearLetra(String let) {
        letra = new JLabel(let);
        letra.setLocation(posXAleatoria(), 0);
        letra.setFont(new Font("fuente",Font.TYPE1_FONT,15));
        letra.setBounds(posXAleatoria(), 50, 15, 15);
        //return letra;
    }
    
    //genera la posicion aleatoria
    public int posXAleatoria() {
        int x = (int) (Math.random() * widthVentana);
        return x;
    }

    //retorna la clase que se ha creado
    public Letra getThis() {
        return this;
    }
    
    //retorna el label creado
    public JLabel getLetra() {
        return letra;
    }
    
    public void cambiarDireccion(){
        direccion=false;
    }


    /**
     * si no esta callendo subira
     */
    public void mover(int pixeles) {
        if (direccion) {
            caer(pixeles);
        }else{
            subir(pixeles);
        }
    }

    public void caer(int pixelesMover) {
        letra.setLocation(letra.getX(), letra.getY()+pixelesMover);
    }
    
    public void subir(int pixelesMover){
        letra.setLocation(letra.getX(), letra.getY()-pixelesMover);
    }

}
