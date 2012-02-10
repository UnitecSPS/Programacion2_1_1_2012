/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajosGrupo;

/**
 *
 * @author Gotcha
 */
public abstract class PlanCliente {
    protected int numCell;
    protected String cliente;
    protected int cantmins,cantmsgs;
    public static final String COMPANIA_TELEFONICA = "TiGO";
    
    public PlanCliente(int nc,String c){
        numCell = nc;
        cliente = c;
        cantmins = 0;
        cantmsgs = 0;
    }

    public final int getCantmins() {
        return cantmins;
    }

    public final void setCantmins(int cantmins) {
        this.cantmins = cantmins;
    }

    public final int getCantmsgs() {
        return cantmsgs;
    }

    public final void setCantmsgs(int cantmsgs) {
        this.cantmsgs = cantmsgs;
    }

    public final String getCliente() {
        return cliente;
    }

    public final void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public final int getNumCell() {
        return numCell;
    }

    public final void setNumCell(int numCell) {
        this.numCell = numCell;
    }
    
    public void imprimir(){
        System.out.printf("Cliente: %s - %d y tiene %d mins y %d msgs.\n",cliente,
                numCell,cantmins,cantmsgs);
    }
    
    public abstract double getPago(int cmins,int cmsgs);
}
