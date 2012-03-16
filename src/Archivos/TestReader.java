/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package Archivos;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class TestReader {
    public static void main(String args[]){
        Scanner lea = new Scanner(System.in);
        
        System.out.println("TXT FILE: ");
        String txtFile = lea.next();
        
        try{
            FileReader fr = new FileReader(txtFile);
            
            System.out.println("Ingrese modo READ (1) SCANNER (2) ");
            int tipo = lea.nextInt();
            
            if( tipo == 1 ){
                //averiguar el size
                File f = new File(txtFile);
                //crear el buffer
                int cantCaracteres = (int)f.length();
                char contenido[] = new char[ cantCaracteres ];

                int cc = fr.read(contenido);

                System.out.println("Caracteres leidos: " + cc + 
                        " deberia ser igual al length " + f.length());

                System.out.println("CONTENIDO\n------");
                System.out.println( contenido);
                
                for(int c=0; c < contenido.length; c++ ){
                    System.out.println(contenido[c]);
                }
            }
            else{
            
                //SCANNER---MODE
                Scanner lector = new Scanner(fr);
                lector.useDelimiter(System.getProperty("line.separator"));
                System.out.println("CONTENIDO");
                while( lector.hasNext() ){
                    System.out.println(lector.next());
                }
            }
            
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}
