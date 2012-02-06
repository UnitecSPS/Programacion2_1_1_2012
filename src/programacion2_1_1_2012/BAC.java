/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion2_1_1_2012;

import Herencia.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class BAC {
    
    static ArrayList<CuentaBancaria> cuentas = new ArrayList<CuentaBancaria>();
    static Scanner lea = new Scanner(System.in);
            
    public static void main(String args[]){
        int resp;
        System.out.println("Banco: " + CuentaBancaria.BANCO);
        do{
            System.out.println("1- Agregar Cuenta");
            System.out.println("2- Deposito");
            System.out.println("3- Retiros");
            System.out.println("4- Imprimir Cuentas");
            System.out.println("5- Salir");
            System.out.println("\nOpcion: ");
            resp = lea.nextInt();
            
            switch( resp ){
                case 1:
                    agregarCuenta();
                    break;
                case 2:
                    depositos();
                    break;
                case 3:
                   // retiros();
                    break;
                case 4:
                    imprimir();
                    break;
            }
        }while( resp != 5);
    }

    private static void agregarCuenta() {
        System.out.println("Tipo de Cuenta? A (ahorro) o C (Cheque): ");
        char tipo = lea.next().charAt(0);
        
        System.out.println("Codigo: ");
        int n = lea.nextInt();
        System.out.println("Nombre: ");
        String no = lea.next();
        
        switch( tipo ){
            case 'A':
            case 'a':
                cuentas.add(new CuentaAhorro(n,no));
                break;
            case 'C':
            case 'c':
                cuentas.add(new CuentaCheques(n,no));
                break;
            default:
                System.out.println("TIPO INVALIDO");
        }
    }

    private static void depositos() {
        System.out.println("Numero de Cuenta: ");
        int nc = lea.nextInt();
        System.out.println("Monto a Depositar: ");
        double monto = lea.nextDouble();
        
        for(CuentaBancaria cb : cuentas){
            if( cb.getCodigo() == nc ){
                cb.deposito(monto);
                break;
            }
        }
    }

    private static void imprimir() {
        for(CuentaBancaria cb: cuentas)
            System.out.println(cb);
    }
}
