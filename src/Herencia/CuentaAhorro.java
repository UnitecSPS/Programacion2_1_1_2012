/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class CuentaAhorro extends CuentaBancaria {
    private boolean activo;
    private Date ultimaModif;
    
    public CuentaAhorro(int cod,String n){
        super(cod,n,1000);
        activo = true;
    }
    
    @Override
    public void deposito(double monto){
        if( !activo ){
            activo = true;
            monto -= monto * 0.05;
        }
        saldo += monto;
        this.ultimaModif = new Date();
        System.out.println("AHORRO");
    }
    
    @Override
    public void retiro(double monto){
        if( activo )
            super.retiro(monto);
        else
            System.out.println("Cuenta Inactiva, deposite algo primero");
    }
    
    @Override
    public String toString(){
        String dato = super.toString();
        dato += activo ? " ACTIVO " : " INACTIVO ";
        dato += " =CUENTA AHORRO= ";
        return dato;
    }
    
}
