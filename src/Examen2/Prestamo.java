/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen2;

/**
 *
 * @author Gotcha
 */
public abstract class Prestamo {
    protected double montoPrestamo;
    protected Cuota cuotas[];
    
    public Prestamo(double total, int cant){
        montoPrestamo = total;
        double mensual = montoPrestamo / cant;
        cuotas  = new Cuota[ cant ];
        
        for(int c =0; c < cant; c++ ){
            cuotas[ c ] = new Cuota(mensual);
        }
    }
    
    public abstract void imprimir();
}
