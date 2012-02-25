/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen2;

/**
 *
 * @author Gotcha
 */
public class PrestamoVivienda extends Prestamo implements iPrestamo {

    private boolean usaBanprovi;
    
    public PrestamoVivienda(double m,int c,boolean ub){
        super(m,c);
        usaBanprovi = ub;
    }
    
    @Override
    public void imprimir() {
        System.out.println("monto total: " + montoPrestamo);
        System.out.println("tasa: " + this.getTasaInteres());
        System.out.println("Detalle de las cuotas\n-------");
        for(Cuota c : cuotas ){
            System.out.println("C-" + c.getPagoMensual() +
                    (c.isPagada() ? " PAGADA " : " PENDIENTE "));
        }
        System.out.println("Saldo Pendiente: " + saldoPendiente());
    }

    @Override
    public double getTasaInteres() {
        return usaBanprovi ? 0.1 : 0.2;
    }

    @Override
    public double saldoPendiente() {
        double pendiente = 0;
        for( Cuota c : cuotas ){
            if( !c.isPagada() )
                pendiente += c.getPagoMensual();
        }
        return pendiente + 57000;
    }
    
}
