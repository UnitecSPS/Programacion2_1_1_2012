/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion2_1_1_2012;

import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class TestErrores {
    public static Scanner lea = new Scanner(System.in);
        
    public static void main(String args[]){
        //new ArrayIndexOutOfBoundsException();
        
        System.out.println("BLOQUE 1");
       
        do{
            try{
                test();
                break;
            }
            catch(Exception e){
                System.out.println("NADIE LO TRATO!");
                lea.next();//limpie
            }
        }while(true);
        
        
        System.out.println("BLOQUE 4");
    }
    
    public static void test(){
        try{
            //int y = 6/0;
            int x = lea.nextInt();
            System.out.println("BLOQUE 2");
        }
        catch(NullPointerException np){
            System.out.println("Instancia la clase");
        }
        catch(ArrayIndexOutOfBoundsException ae){
            System.out.println("Ingrese bien la posicion");
        }
        catch(ArithmeticException ae){
            System.out.println("No divida entre cero");
        }
        finally{
            System.out.println("CODIGOS DEL FINALLY");
        }
        
        
        System.out.println("Codigo final en TEST");
    }
}
