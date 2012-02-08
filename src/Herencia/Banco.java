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
        cas[0] = new CuentaAhorro(1,"Carlos");
        //upcasting 
        cas[1] = new CuentaAhorro(2,"Emilson");
        cas[2] = new CuentaCheques(3,"Eduardo");
        
        if( cas[2] instanceof CuentaCheques){
            //downcasting indirecto
            System.out.println("SI SOY CHEQUE!");
            CuentaCheques cq = (CuentaCheques)cas[2];
            cq.retiro(1000);
            cq.printCheques();
        
            //downcasting directo
            ((CuentaCheques)cas[2]).retiro(900);
            ((CuentaCheques)cas[2]).printCheques();
        }
        
        CuentaBancaria ban = new CuentaBancaria(5,"ll",100) {

            int x = 0;
            @Override
            public double getTasa() {
                test();
                return 0.1;
            }
            
            public void test(){
                System.out.println("TEST " + x);
            }
        };
        
        CuentaBancaria ban2 = new CuentaBancaria(5,"ll",100) {

            @Override
            public double getTasa() {
                return 0.5;
            }
        };
        
        System.out.println("tasa: " + ban.getTasa());
        System.out.println("tasa: " + ban2.getTasa());
        
    }
}
