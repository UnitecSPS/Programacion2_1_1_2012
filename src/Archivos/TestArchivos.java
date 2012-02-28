
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package Archivos;

/**
 *
 * @author Gotcha
 */
public class TestArchivos {
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String args[]){
        MiArchivo ma = new MiArchivo();
        int op;
        
        do{
            System.out.println("1- Configurar Archivo");
            System.out.println("2- Crear Archivo");
            System.out.println("3- Crear Folder");
            System.out.println("4- Borrar Archivo o Directorio");
            System.out.println("5- Ver Informacion");
            System.out.println("6- Listar Directorio");
            System.out.println("7- Renombrar");
            System.out.println("8- Tree");
            System.out.println("9- Salir");
            System.out.println("\nIngrese opcion: ");
            op = lea.nextInt();
            
            try{
                switch( op ){
                    case 1:
                        System.out.println("Ingrese Direccion: ");
                        ma.setFile(lea.next());
                        break;
                    case 2:
                        if( ma.crearArchivo() )
                            System.out.println("SE CREO!");
                        else
                            System.out.println("NO SE PUDO CREAR ARCHIVO");
                        break;
                    case 3:
                        if( ma.crearFolder() )
                            System.out.println("SE CREO!");
                        else
                            System.out.println("NO SE PUDO CREAR FOLDER");
                        break;
                    case 4:
                        if( ma.delete() )
                            System.out.println("SE BORRO!");
                        else
                            System.out.println("NO SE PUDO BORRAR");
                        break;
                    case 5:
                        ma.infoFile();
                        break;
                    case 6:
                        ma.dir();
                        break;
                    case 7:
                        System.out.println("Nuevo Nombre: ");
                        
                        if( ma.renombrar(lea.next()) )
                            System.out.println("Se renombro!");
                        else
                            System.out.println("NO SE Renombro!");
                        break;
                    case 8:
                        ma.tree();
                        break;
                        
                }
            }
            catch(Exception e){
                System.out.println("ERROR: " + e.getMessage());
            }
        }while( op != 9 );
        
    }
}
