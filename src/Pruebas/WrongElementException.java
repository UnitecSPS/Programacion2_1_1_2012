/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

/**
 *
 * @author Gotcha
 */
public class WrongElementException extends Exception implements Emilson  {
    public WrongElementException(String s){
        super(s);
    }

    @Override
    public void preguntar() {
        System.out.println("Emilson: Puedo implementar?\nIng: SI :)");
    }
}
