/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

import java.util.ArrayList;

/**
 *
 * @author Gotcha
 */
public class CuentaCheques extends CuentaBancaria{
    ArrayList<Integer> numCheques;
    
    public CuentaCheques(int cod,String n){
        super(cod,n,5000);
        numCheques = new ArrayList<Integer>();
    }
    
    public void addCheque(int nc){
        numCheques.add(nc);
    }
    
    public void printCheques(){
        for(Integer i : numCheques){
            System.out.println("Cheque: " + i);
        }
    }
    
    @Override
    public double getTasa(){
        return 0;
    }
    
    @Override
    public void QuienSoy(){
        System.out.println("Soy CHEQUERA");
        super.QuienSoy();
        
    }
}
