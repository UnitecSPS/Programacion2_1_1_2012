/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab2;

/**
 *
 * @author CarlosArmando
 */
public final class Plan40 extends PlanComercial{
    
    public Plan40(String n){
        super(n);
    }

    @Override
    public String getTipo() {
        return TIPO_40;
    }

    @Override
    public double getPrecioPorMinuto() {
        return 1.8;
    }

    @Override
    public double getPrecioPorMensaje() {
        return 0.8;
    }

    @Override
    public double getPagoMensual(int cantmins, int cantmsgs) {
        double monto = 40, rebaja = 0;
        
        if( cantmins < 0 || cantmsgs < 0 )
            throw new CantidadNegativaException();
        
        if( cantmins > 160 )
            monto += ( cantmins - 160 ) * this.getPrecioPorMinuto();
        if( cantmsgs > 200 )
            monto += ( cantmsgs - 200 ) * this.getPrecioPorMensaje();
        
        if( cantmins < 30 )
            rebaja = monto * 0.05;
        
        return monto - rebaja;
        
    }
    
}
