/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public abstract class CuentaBancaria {
    protected int codigo;
    protected String cliente;
    protected Date fechaInicio;
    protected double saldo;
    public static final String BANCO = "BAC";
    public final int test = 9;
    
    static{
        //Scanner lea = new Scanner(System.in);
        //BANCO = lea.next();
    }
    
    public CuentaBancaria(int cod,String c, double sm){
        codigo = cod;
        cliente = c;
        saldo = sm;
        //inicio
        fechaInicio = new Date();
    }
    
    public final String getCliente() {
        return cliente;
    }

    public final int getCodigo() {
        return codigo;
    }

    public final Date getFechaInicio() {
        return fechaInicio;
    }

    public final double getSaldo() {
        return saldo;
    }
    
    public abstract double getTasa();
    
    public void deposito(double m){
        saldo += m;
    }
    
    public void retiro(double m){
        if( saldo > m )
            saldo -= m;
    }
    
    public void generarIntereses(){
        saldo += saldo * getTasa();
    }
    
    @Override
    public String toString(){
        //final int x = 9;
        
        String dato = this.codigo + "-" + cliente +
                "-" + saldo + " lps en saldo.";
        return dato;
    }
}
