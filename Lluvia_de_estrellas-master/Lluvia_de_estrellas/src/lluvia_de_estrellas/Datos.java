/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lluvia_de_estrellas;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorca
 */
public class Datos {
    
     public  void escribirDatos(int nivel,ArrayList<Letra> letras,int puntos,int xBarra,int yBarra){        
         System.out.println("Estoy dentro");
         for (Letra letra : letras) {
                System.out.println("Dentro serializar "+letras.toString());
         }
        try(
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("datosJuego.ddr"))){
            //permite guardar un objeto a tipo binario
            oos.writeObject(nivel);//guarda el objeto de forma binaria
            oos.writeObject(letras);
            oos.writeObject(puntos);
            oos.writeObject(xBarra);
            oos.writeObject(yBarra);
            
            oos.close();//cierra fichero
        }catch(IOException e){
        }
       
    }
    public  void leerDatos() throws IOException {
        int  nivelAux;
        int puntosAux;
       
        int xBarraAux;
        int yBarraAux;
        ObjectInputStream ois=null;//no tiene para detectar el final fichero
        try{
            ois=new ObjectInputStream(new FileInputStream("datosJuego.ddr") );
            //crea a paritr de los cero y nos y lo convierte en objeto
            while(true){//debemo ponerlo para la excepcion
                nivelAux=(int)ois.readObject();//este lo convierte objeto empleado se tiene que hacer cast de ese tipo
                 ArrayList<Letra> auxLetras=(ArrayList)ois.readObject();
                puntosAux=(int)ois.readObject();
                xBarraAux=(int)ois.readObject();
                yBarraAux=(int)ois.readObject();
                
                
                
                System.out.println("nivel "+nivelAux);
                for (Letra auxLetra : auxLetras) {
                    
                    System.out.println("hola"+auxLetra.toString());
                    
                }
                System.out.println("Los puntos"+puntosAux);
                System.out.println("X barra"+xBarraAux);
                System.out.println("Y barra"+yBarraAux);
            }            
        }catch(ClassNotFoundException e){
        }catch(EOFException e){try {
            //excepcion de final de fichero
            
            ois.close();//
            } catch (IOException ex) {
                Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        
    }
}
