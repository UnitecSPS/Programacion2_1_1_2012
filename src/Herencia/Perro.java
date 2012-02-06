/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Gotcha
 */
public class Perro extends Animal {
    public Perro(){
        super("Perro",4);
    }

    @Override
    public void voyHablar() {
        System.out.println("Gua Gua Guaooooo");
    }

    @Override
    public int hijos() {
        return 5;
    }
}
