/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Gotcha
 */
public class Banco {
    public static void main(String args[]){
        CuentaAhorro ca = new CuentaAhorro(1,"Carlos");
        System.out.println("nombre: " + ca.cliente);
    }
}
