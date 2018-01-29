/*
 * 
 * By  Adrian Garcia San Jose.
 * 
 */
package lluvia_de_estrellas;

import java.util.Random;

/**
 *
 * @author adri
 */
public class ControlLetras {
    
    private String posibles;
    private String usadas="";
    private Random rand;
    private int NUMMAX=90;
    private int NUMMIN=65;
    
    public ControlLetras(){
        
    }
    
    public char getLetraRandom(){
        int numAle= (int) Math.floor(Math.random()*(NUMMAX-NUMMIN)+NUMMIN);
        char letra=(char)numAle;
        
        while(letraUsed(letra)){
            letra= (char) Math.floor(Math.random()*(NUMMAX-NUMMIN)+NUMMIN);
        }
        usadas+=letra;
        
        System.out.println("la letra es: "+letra+" y usados "+usadas);
        return letra;
    }
    
    private boolean letraUsed(char numAle){
        return usadas.contains(""+numAle);
    }
    
    public int getCantidadLetras(){
        System.out.println("tamaño "+usadas.length());
        return usadas.length();
    }
    
}
