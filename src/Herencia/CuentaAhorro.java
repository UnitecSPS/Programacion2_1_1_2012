/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Gotcha
 */
public class CuentaAhorro extends CuentaBancaria {
    private boolean activo;
    
    public CuentaAhorro(int cod,String n){
        super(cod,n,1000);
        activo = true;
    }
}
