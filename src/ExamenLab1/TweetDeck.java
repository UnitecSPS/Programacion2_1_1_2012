/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab1;

import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class TweetDeck {
    static CuentaRedSocial cuenta=null;
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String args[]){
        //lea.useDelimiter(System.getProperty("line.separator"));
        int resp;
        
        do{
            System.out.println("1- Config Cuenta");
            System.out.println("2- Agregar Seguidor");
            System.out.println("3- Agregar Post");
            System.out.println("4- Agregar Comentario");
            System.out.println("5- Imprimir");
            System.out.println("6- Salir");
            System.out.println("\nEscoja opcion: ");
            resp = lea.nextInt();
            
            switch( resp ){
                case 1:
                    configCuenta();
                    break;
                case 2:
                    agregarSeguidor();
                    break;
                case 3:
                    agregarPost();
                    break;
                case 4:
                    agregarComentario();
                    break;
                case 5:
                    imprimir();
                    break;
            }
        }while( resp != 6);
    }

    private static void configCuenta() {
        System.out.println("Ingrese el tipo 0 (Facebook) o 1 (Twitter): ");
        int tipo = lea.nextInt();
        
        System.out.print("Username: ");
        String u = lea.next();
        System.out.print("Password: ");
        String p = lea.next();
        
        if( tipo == 0 )
            cuenta = new CuentaFacebook(u,p);
        else if( tipo == 1)
            cuenta = new CuentaTwitter(u,p);
        else
            System.out.println("TIPO INVALIDO");
    }

    private static void agregarSeguidor() {
        if( cuenta != null ){
            if( cuenta instanceof CuentaTwitter ){
                System.out.print("Nombre del Follower: ");
                String f = lea.next();
                
                ((CuentaTwitter)cuenta).agregarFollower(f);
            }
            else
                System.out.println("LA CUENTA NO ES DE TWITTER");              
        }
        else
            System.out.println("Configure la cuenta primero");
    }

    private static void agregarPost() {
        if( cuenta != null ){
            System.out.print("Mensaje: ");
            String msg = lea.next();
            cuenta.agregarPost(msg);
        }
        else
            System.out.println("Configure la cuenta primero");
    }

    private static void agregarComentario() {
        if( cuenta != null ){
            if( cuenta instanceof CuentaFacebook ){
                System.out.print("Numero de Post: ");
                int p = lea.nextInt();
                System.out.print("Comentario: ");
                String c = lea.next();
                
                ((CuentaFacebook)cuenta).agregarComentario(p, c);
            }
            else
                System.out.println("LA CUENTA NO ES DE FACEBOOK");              
        }
        else
            System.out.println("Configure la cuenta primero");
    }

    private static void imprimir() {
        cuenta.imprimir();
    }
}
