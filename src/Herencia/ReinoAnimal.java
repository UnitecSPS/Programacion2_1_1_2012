/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Gotcha
 */
public class ReinoAnimal {
    public static void main(String args[]){
        Animal a= new Perro();
        Animal b= new Gato();
        Animal c= new Vaca();
        
        a.voyHablar();
        b.voyHablar();
        c.voyHablar();
        
        System.out.println("hijos de a: " + a.hijos());
        System.out.println("hijos de b: " + b.hijos());
    }
}
