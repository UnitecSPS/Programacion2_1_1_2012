/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

import java.util.Calendar;
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
        //inicio
        fechaInicio = new Date();
    }
    
    public String getCliente() {
        return cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public double getSaldo() {
        return saldo;
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
    
    public void generarIntereses(){
        saldo += saldo * getTasa();
    }
    
    @Override
    public String toString(){
        String dato = this.codigo + "-" + cliente +
                "-" + saldo + " lps en saldo.";
        return dato;
    }
}
