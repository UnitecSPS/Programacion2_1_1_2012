/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Gotcha
 */
enum TipoConsola{
    XBOX(5),WII(2),PS3(10);
    public int prestigio;
    
    TipoConsola(int p){
        prestigio = p;
    }
}

public class Consola {
    private TipoConsola tipo;
    /*public static final int TIPO_XBOX = 2;
    public static final int TIPO_WII = 3;
    public static final int TIPO_PS3 = 1;*/
    
    public void impTipo(){
        if( tipo == TipoConsola.XBOX){
            //xbox
            System.out.println("XBOX");
        }
        else if( tipo == TipoConsola.WII){
            //wii
            System.out.println("WII");
        }
        else if( tipo == TipoConsola.PS3){
            //ps3
            System.out.println("PS3");
        }
        else{
            System.out.println("Consola no determinada");
        }
    }
    
    public double getPrecio(){
        if( tipo == TipoConsola.XBOX){
            //xbox
            return 299;
        }
        else if( tipo == TipoConsola.WII){
            //wii
            return 199;
        }
        else if( tipo == TipoConsola.PS3){
            //ps3
            return 320;
        }
        else{
            return -1;
        }
    }
}
