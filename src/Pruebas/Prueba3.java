/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gotcha
 */
public class Prueba3 {
    static int numeros[] = {0,0,0,0,0,0};
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String args[]){
        try {
            System.out.println("Agregar Elemento: ");
            agregarElemento(lea.nextInt());
        } catch (WrongElementException ex) {
            System.out.println("Numeros negativos NOO");
        }
    }
    
    public static void agregarElemento(int valor) throws WrongElementException{
        if( valor < 0 )
            throw new WrongElementException("Valor no puede ser negativo");
        
        do{
            try{
                System.out.println("Ingrese posicion: ");
                int pos = lea.nextInt();
                numeros[ pos ] = valor;
                break;
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("POSICION INCORRECTA..Ingrese de nuevo la posicion");
            }
        }while(true);
    }
}
