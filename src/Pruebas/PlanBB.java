/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

/**
 *
 * @author Gotcha
 */
public class PlanBB extends Plan{
    private boolean fullSocial;
    
    public PlanBB(int nc,String n,boolean fs){
        super(nc,n);
        fullSocial = fs
                ;
    }
}
