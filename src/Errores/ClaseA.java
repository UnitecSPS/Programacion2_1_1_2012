/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;

/**
 *
 * @author Gotcha
 */
public class ClaseA {
    
    /**
     *Funcion que me devuelve la potencia 
     * @param b La Base
     * @param e El Exponente
     * @return La potencia
     */
    public int potencia(int b,int e) throws NegativeNumberException{
        if( e < 0 ){
            throw new NegativeNumberException("EXPONENTE NEGATIVO");
        }  
        int pot=1;
        for(int p=1; p <= e; p++ )
            pot *= b;
        return pot;
    }
    
    public void algo() throws NegativeNumberException{
        potencia(2,2);
    }
}
