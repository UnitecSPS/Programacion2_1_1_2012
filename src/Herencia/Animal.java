/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Gotcha
 ring */
public abstract class Animal {
    protected String nombre;
    protected int patas;
    
    public Animal(String n,int p){
        nombre = n;
        patas = p;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getPatas() {
        return patas;
    }
    
    public abstract void voyHablar();
    public abstract int hijos();
}
