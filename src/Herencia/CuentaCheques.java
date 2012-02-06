/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class CuentaCheques extends CuentaBancaria{
    ArrayList<Cheque> numCheques;
    
    public CuentaCheques(int cod,String n){
        super(cod,n,5000);
        numCheques = new ArrayList<Cheque>();
    }
    
    private void addCheque(Cheque nc){
        numCheques.add(nc);
    }
    
    public void printCheques(){
        for(Cheque i : numCheques){
            System.out.println("Cheque: " + i);
        }
    }
    
    @Override
    public double getTasa(){
        return 0;
    }
    
    @Override
    public void retiro(double monto){
        Scanner lea = new Scanner(System.in);
        System.out.println("Numero de Cheque a cambiar: ");
        int nc = lea.nextInt();
        System.out.println("A nombre de: ");
        String n = lea.next();
        
        if( saldo > monto ){
            Cheque c = new Cheque(nc,monto,n);
            addCheque(c);
            //cobrarlo
            saldo -= monto;
        }
        else{
            System.out.println("CHEQUE REBOTADO");
        }
    }
    
    @Override
    public String toString(){
        String dato = super.toString() + " =CHEQUERA= ";
        return dato;
    }
    
    
}
