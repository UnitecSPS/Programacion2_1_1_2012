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
public class JavaBank {
    private ClientePrestamo prestamos[];
    private int contador = 0;
    private Scanner lea = new Scanner(System.in);
    
    public JavaBank( int total ){
        prestamos = new ClientePrestamo[ total ];
    }
    
    public boolean adicionCliente()throws TipoInvalidoException{
        if( contador < prestamos.length ){
            String n = lea.next();
            String tel = lea.next();
            String tipo = lea.next();
            
            prestamos[ contador ] = new ClientePrestamo(n,tel);
            prestamos[ contador ].setPrestamo(TipoPrestamo.valueOf(tipo));
            contador++;
            return true;
        }
        else{
            System.out.println("ya no espacio");
        }
        
        return false;
    }
    
    public double montoTotalPendiente(String nombre){
        for( ClientePrestamo cp : prestamos ){
            if( cp.nombre.equals(nombre) ){
                if( cp.prestamo instanceof PrestamoAuto)
                    return ((PrestamoAuto)cp.prestamo).saldoPendiente();
                else if( cp.prestamo instanceof PrestamoVivienda)
                    return ((PrestamoVivienda)cp.prestamo).saldoPendiente();
            }
        }
        
        throw new RuntimeException("Cliente No Encontrado");
    }
    
    public void imprimirDetalleMensual(){
        imprimir(0);
    }

    private void imprimir(int pos) {
        if( pos < prestamos.length ){
            System.out.println("Nombre: " + prestamos[pos].nombre);
            System.out.println("Telfono: " + prestamos[pos].telefono);
            prestamos[ pos ].prestamo.imprimir();
            
            imprimir( pos + 1);
        }
    }
}
