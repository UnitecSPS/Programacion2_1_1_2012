/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen1;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class EmpleadoTemporal extends Empleado {
    private Date fin;
    private char zona;
    
    public EmpleadoTemporal(String n,double s,int c,char z){
        super(n,s,c);
        zona = z;
        fin = inicio;
    }
    
    /**
     * Aqui configuro la fecha final del empleado
     * @param year El anio final
     * @param month El mes
     * @param day  El dia
     */
    public void setFechaFin(int year,int month,int day){
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        Date temp = c.getTime();
     
        if( temp.after(inicio) ){
            fin = temp;
        }
        else
            System.out.println("Fecha Fin es menor a inicio");
        
    }
    
    @Override
    public String toString(){
        return super.toString() + "-" + fin;
    }
}
