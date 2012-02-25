/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab2;

import java.util.Date;

/**
 *
 * @author CarlosArmando
 */
public abstract class PlanComercial {
    protected String nombre;
    protected Date inicioPlan;
    public static final String TIPO_40 = "TIPO40";
    public static final String TIPO_80 = "TIPO80";
    
    public PlanComercial(String n){
        nombre = n;
        inicioPlan = new Date();
    }
    
    
    public abstract String getTipo();
    public abstract double getPrecioPorMinuto();
    public abstract double getPrecioPorMensaje();
    public abstract double getPagoMensual(int cantmins, int cantmsgs);
    
    @Override
    public String toString(){
        String datos = "Nombre: " + nombre + " inicio: " + inicioPlan +
                " tipo: " + getTipo();
        return datos;
    }
}
