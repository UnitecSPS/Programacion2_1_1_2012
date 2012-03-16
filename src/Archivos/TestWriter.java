/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package Archivos;

import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class TestWriter {
    public static void main(String args[]){
        FileWriter fw = null;
        Scanner lea = new Scanner(System.in);
        lea.useDelimiter(System.getProperty("line.separator"));
        
        try{
            System.out.print("Filename: ");
            String filename = lea.next();
            
            fw = new FileWriter(filename, true);
            
            do{
                System.out.println("Ingrese algo: ");
                String algo = lea.next();
                
                if( algo.equals("SALIR"))
                    break;
                
                fw.write(algo + "\n");
                fw.flush();
            }while(true);
            
            fw.close();
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
