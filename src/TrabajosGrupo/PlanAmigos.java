/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajosGrupo;

/**
 *
 * @author Gotcha
 */
public final class PlanAmigos extends PlanCliente{
    private int amigos[] = {0,0,0};
    
    public PlanAmigos(int nc,String c){
        super(nc,c);
    }
    
    public boolean agregarAmigo(int nc){
        for(int n=0; n < 3; n++){
            if( amigos[n] == 0 ){
                //vacio!
                amigos[n] = nc;
                return true;
            }
        }
        System.out.println("No hay Espacio");
        return false;
    }
    
    public boolean borrarAmigo(int nc){
        for(int n=0; n < 3; n++){
            if( amigos[n] == nc ){
                amigos[n] = 0;
                return true;
            }
        }
        System.out.println("No existe ese celular en los amigos");
        return false;
    }
    
    @Override
    public void imprimir(){
        System.out.print("PLAN AMIGOS: ");
        super.imprimir();
        for(int nc : amigos){
            if( nc != 0 )
                System.out.println("Amigo Cell: " + nc);
        }
    }

    @Override
    public double getPago(int cmins, int cmsgs) {
        this.setCantmins(cmins);
        this.setCantmsgs(cmsgs);
        return (cantmins*1.5) + (cantmsgs*0.5) + tengoAmigos();
    }

    private int tengoAmigos() {
        int tot=0;
        for(int nc : amigos){
            if( nc != 0 )
                tot++;
        }
        return tot;
    }
    
}
