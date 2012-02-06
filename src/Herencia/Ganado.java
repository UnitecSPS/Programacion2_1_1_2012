/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Gotcha
 */
public abstract class Ganado extends Animal{
    public Ganado(String n){
        super(n,4);
    }
    
    public abstract String quien();
    
    @Override
    public int hijos(){
        return 5;
    }
}
