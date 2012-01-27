/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

/**
 *
 * @author Gotcha
 */
public class Plan {
    protected int numCelular;
    protected String nombre;
    protected static int MAX_MINS = 10000;
            
    public Plan(int nc,String n){
        numCelular = nc;
        nombre = n;
    }
    
    public static int getMaxMin(){
        return MAX_MINS;
    }
}
