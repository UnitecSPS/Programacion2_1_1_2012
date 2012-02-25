/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab2;

/**
 *
 * @author CarlosArmando
 */
public final class Plan80 extends PlanComercial {
    private boolean fullInternet;
    
    public Plan80(String n,boolean i){
        super(n);
        fullInternet = i;
    }

    @Override
    public String getTipo() {
        return TIPO_80;
    }

    @Override
    public double getPrecioPorMinuto() {
        return 1;
    }

    @Override
    public double getPrecioPorMensaje() {
        return 0.2;
    }

    @Override
    public double getPagoMensual(int cantmins, int cantmsgs) {
        double monto = 80;
        
        if( cantmins < 0 || cantmsgs < 0 )
            throw new CantidadNegativaException();
        
        if( cantmins > 300 )
            monto += (cantmins - 300) * getPrecioPorMinuto();
        if( cantmsgs > 250 )
            monto += (cantmsgs - 250) * getPrecioPorMensaje();
        if( fullInternet )
            monto += 15;
        
        return monto;
    }
    
}
