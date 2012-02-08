/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Gotcha
 */
public class Consola {
    private int tipo;
    public static final int TIPO_XBOX = 2;
    public static final int TIPO_WII = 3;
    public static final int TIPO_PS3 = 1;
    
    public void impTipo(){
        if( tipo == TIPO_XBOX){
            //xbox
            System.out.println("XBOX");
        }
        else if( tipo == TIPO_WII){
            //wii
            System.out.println("WII");
        }
        else if( tipo == TIPO_PS3){
            //ps3
            System.out.println("PS3");
        }
        else{
            System.out.println("Consola no determinada");
        }
    }
    
    public double getPrecio(){
        if( tipo == TIPO_XBOX){
            //xbox
            return 299;
        }
        else if( tipo == TIPO_WII){
            //wii
            return 199;
        }
        else if( tipo == TIPO_PS3){
            //ps3
            return 320;
        }
        else{
            return -1;
        }
    }
}
