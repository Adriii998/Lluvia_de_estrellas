/*
 * 
 * By  Adrian Garcia San Jose.
 * 
 */
package lluvia_de_estrellas;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author adri
 */
public class Game implements Serializable{

    private Vista1 view;
    private ControlLetras ctrlLetras;


    //private BarControl ctrlBarra;
    private ControlTeclas control;
   

    //guille
    private Timer temporizador;
    private int contadorTiempo = 0;
    private boolean timerEmpezado = false;
    private Rectangle recBarra;
   

    private boolean finalizado;
    
    private Rectangle limite;
    
    private int puntos;
    private int nivel;
    private Datos datos;
    private NewLetras generaLetras;//para el array de letras
    private Bar barra;//para conseguir la x,y de la barra.
    
    public Game() {
        finalizado = false;
        view = new Vista1(this);
        ctrlLetras = new ControlLetras(this);
     
        
        //JButton boton;
        control = new ControlTeclas(ctrlLetras, view.getControlBarra());
        this.vistaAddEscuchadorLetras(control);
        limite=view.getControlBarra().getLimite().getBounds();
        ctrlLetras.setLimit(limite);
        puntos=0;
        nivel=1;
        ctrlLetras.restaurar(nivel);//inicia el timer de creacion de letras
        datos=new Datos();
        actualizarNivel();
    }

    public void vistaAddEscuchadorLetras(KeyListener escucha) {
        System.out.println("añadir escuchador");
        //view.addEscuchadorLetras(escucha);
        view.addEscuchadorLetras(escucha);
    }

    public void mandarLetra(JLabel letra) {
        if (!finalizado) {
            view.addLetra(letra);
        }
    }

    public void eliminarLetra(String letra){
        if(!finalizado){
            view.deleteLetra(letra);
            puntos++;
            view.actualizarPuntos(puntos);
            isPerdido();
        }
    }
    
    public void error() {
        if (!finalizado) {
            puntos--;
            view.actualizarPuntos(puntos);
            if (!timerEmpezado) {
                temporizador = new Timer(50, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        esperarTiempo();
                    }
                });
                temporizador.start();
                //temporizador.stop();
                timerEmpezado = true;
            }
            isPerdido();
        }

    }

    public void esperarTiempo() {
        contadorTiempo += temporizador.getDelay();
        view.getContentPane().setBackground(Color.RED);
        System.out.println("contador de tiemnpo->>>>> " + contadorTiempo);
        if (contadorTiempo >= 100) {
            System.out.println("AHORRRRRRRAAAAA");
            temporizador.stop();
            timerEmpezado = false;
            contadorTiempo = 0;
            view.getContentPane().setBackground(Color.WHITE);
        }
    }

    public void isPerdido(){
        if(puntos<=0){
            /**
             * llamo al control letras. perder porque ese metodo llama a juego.pausar todo
             */
            ctrlLetras.perder();
          
        }
        if(puntos>=10){
            
            this.subirNivel();
        }
        
    }
    
    public void actualizarPosBarra(Rectangle rec) {
        recBarra = rec;
    }

    //borrara las letras que haya en la pantalla
    public void pausarTodo() {
        finalizado=true;
        view.perderReiniciarJuego();
        view.restaurar();
    }

    public Rectangle getRect() {
        return recBarra;
    }

    public void pasarNiveles(int i) {
        if(finalizado){
            finalizado=false;
            ctrlLetras.restaurar(i);
             view.limpiarPantalla();
        }else{
            ctrlLetras.cambiarNivel(i);
           
            view.restaurar();
        }
        puntos=0;
        nivel=i;
        view.actualizarPuntos(puntos);
        view.actualizarNivel(i);//lea pasamos el nivel
      
       
        
    }
    
    public void subirNivel(){
       
        if(nivel<5){
            
            nivel++;
            
            ctrlLetras.restaurar(nivel);
            view.restaurar();
           
            puntos=0;
            view.actualizarNivel(nivel);
           
           
        }
      
    }
    
    public void actualizarNivel(){
        
        view.actualizarNivel(nivel);
    }
    
    
  public void serializar(){
      ArrayList<Letra> letras=new ArrayList();
              generaLetras=new NewLetras(ctrlLetras);
              barra=new Bar();
              
     datos.escribirDatos(nivel,generaLetras.getLetras(),puntos,barra.getxBarra(),barra.getyBarra());
       letras=generaLetras.getLetras();
       int numero=letras.size();
       System.out.println("tamano letras"+numero);
       for (int i = 0; i < letras.size(); i++) {
           System.out.println("Dentro de serializar"+letras.toString());
          
      }
  }
  public void deserializar(){
        try {
            datos.leerDatos();
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
  }

    public int getNivel() {
        return nivel;
    }

  
    
    
}
