/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;


/**
 *
 * @author Gotcha
 */
public class ClaseB {
    public static void main(String args[]){
        ClaseA ca = new ClaseA();
        
        try {
            System.out.println("Pot: " + ca.potencia(2, -1));
        } catch (NegativeNumberException ex) {
            System.out.println(ex.getMessage());
        }
        
        //ca.algo();
    }
}
