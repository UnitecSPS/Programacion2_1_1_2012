/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Gotcha
 */
public class Vaca extends Ganado {
    public Vaca(){
        super("Vaca");
    }

    @Override
    public String quien() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void voyHablar() {
        //super.voyHablar(); --> NO SE PUEDE
        System.out.println("Muuuu Muuuuu");
    }
    
    //NO ES OBLIGATORIO PQ FUE IMPLEMENTADO EN GANADO
    @Override
    public int hijos(){
        return super.hijos();
    }
}
