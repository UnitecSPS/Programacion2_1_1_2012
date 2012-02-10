/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajosGrupo;

/**
 *
 * @author Gotcha
 */
public final class PlanBlackberry extends PlanCliente{

    private int pin;
    private boolean fullService;
    
    public PlanBlackberry(int nc,String c,int p,boolean fs){
        super(nc,c);
        pin=p;
        fullService=fs;
    }

    public final boolean isFullService() {
        return fullService;
    }

    public final void setFullService(boolean fullService) {
        this.fullService = fullService;
    }

    public final int getPin() {
        return pin;
    }

    public final void setPin(int pin) {
        this.pin = pin;
    }
    
    @Override
    public double getPago(int cmins, int cmsgs) {
        this.setCantmins(cmins);
        this.setCantmsgs(cmsgs);
        
        double cobro = fullService ? 20 : 15;
        return (cantmins*1.2) + (cantmsgs*0.3) + cobro;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Pin: " + pin +
                (fullService ? " Servicio Full" : " Solo Redes Sociales"));
    }
    
    
    
}
