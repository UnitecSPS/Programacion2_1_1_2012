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
public class CuentaBancaria {
    protected int codigo;
    protected String cliente;
    protected Date fechaInicio;
    protected double saldo;
    protected static String BANCO;
    
    static{
        BANCO = "BAC";
    }
    
    public CuentaBancaria(int cod,String c, double sm){
        codigo = cod;
        cliente = c;
        saldo = sm;
    }
    
    public double getTasa(){
        return 0.02;
    }
    
    public void deposito(double m){
        saldo += m;
    }
    
    public void retiro(double m){
        if( saldo > m )
            saldo -= m;
    }
}
