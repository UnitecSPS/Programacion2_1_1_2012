/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen2;

import java.util.Scanner;

/**
 *
 * @author Gotcha
 */

enum TipoPrestamo{
    AUTO, VIVIENDA;
}

public class ClientePrestamo {
    public String nombre, telefono;
    public Prestamo prestamo;
    
    public ClientePrestamo(String n,String t){
        nombre = n;
        telefono = t;
    }
    
    public void setPrestamo(TipoPrestamo tp)throws TipoInvalidoException{
        Scanner lea = new Scanner(System.in);
        System.out.println("Monto Prestamo: ");
        double m = lea.nextDouble();
        System.out.println("Cantidad de Cuotas: ");
        int cant = lea.nextInt();
        
        if( tp == TipoPrestamo.VIVIENDA ){
            boolean b = lea.hasNextBoolean();
            prestamo = new PrestamoVivienda(m,cant,b);
        }
        else if( tp == TipoPrestamo.AUTO){
            String serie = lea.next();
            prestamo = new PrestamoAuto(m,cant,serie);
        }
        else{
            throw new TipoInvalidoException();
        }
            
        
                
    }
}
