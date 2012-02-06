/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Gotcha
 */
public class Gato extends Animal {
    public Gato(){
        super("Gato",4);
    }

    @Override
    public void voyHablar() {
        System.out.println("Miau Miau");
    }

    @Override
    public int hijos() {
        return 10;
    }
}
