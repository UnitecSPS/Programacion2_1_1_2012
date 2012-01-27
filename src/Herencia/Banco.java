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
        CuentaBancaria cas[] = new CuentaBancaria[3];
        cas[0] = new CuentaBancaria(1,"Carlos",1000);
        //upcasting 
        cas[1] = new CuentaAhorro(2,"Emilson");
        cas[2] = new CuentaCheques(3,"Eduardo");
        
        for(CuentaBancaria cb : cas){
            cb.QuienSoy();
        }
        
        if( cas[1] instanceof CuentaCheques){
            //downcasting indirecto
            System.out.println("SI SOY CHEQUE!");
            CuentaCheques cq = (CuentaCheques)cas[2];
            cq.addCheque(1);
            cq.addCheque(2);
            cq.printCheques();
        
            //downcasting directo
            ((CuentaCheques)cas[2]).addCheque(3);
            ((CuentaCheques)cas[2]).addCheque(4);
            ((CuentaCheques)cas[2]).printCheques();
        }
        
    }
}
