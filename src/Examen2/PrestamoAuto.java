/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen2;

/**
 *
 * @author Gotcha
 */
public class PrestamoAuto extends Prestamo implements iPrestamo {
    private String serieMotor;
    private Cuota cuotasSeguro[];
    
    public PrestamoAuto(double m,int total,String sm){
        super( m, total );
        cuotasSeguro = new Cuota[ total ];
        serieMotor = sm;
        
        double montoSeguro = montoPrestamo * 0.15;
        for(int c = 0; c < total ; c++ ){
            cuotasSeguro[ c ] = new Cuota( montoSeguro/total );
        }
    }

    @Override
    public void imprimir() {
        System.out.println("Monto: " + montoPrestamo);
        for(int c=0; c < cuotas.length ; c++ ){
            System.out.println("Cuota " + (c+1) + 
                    cuotas[ c ].getPagoMensual() +
                    (cuotas[c].isPagada() ? " PAGADA " : "PENDIENTE"));
            
            System.out.println("Cuota Seguro " + (c+1) + 
                    cuotasSeguro[ c ].getPagoMensual() +
                    (cuotasSeguro[c].isPagada() ? " PAGADA " : "PENDIENTE"));
        }
    }

    @Override
    public double getTasaInteres() {
        return 0.25;
    }

    @Override
    public double saldoPendiente() {
        double pendiente = 0;
        
        for( Cuota c : cuotas ){
            if( !c.isPagada() )
                pendiente += c.getPagoMensual();
        }
        
        for( Cuota c : cuotasSeguro ){
            if( !c.isPagada() )
                pendiente += c.getPagoMensual();
        }
        
        return pendiente;
    }
}
