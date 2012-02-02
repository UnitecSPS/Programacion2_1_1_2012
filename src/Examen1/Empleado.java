/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen1;

import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class Empleado {
    protected String nombre;
    protected Date inicio;
    protected double salario;
    protected int codigo;
    
    public Empleado(String n,double s,int c){
        nombre = n;
        salario = s;
        codigo = c;
        inicio = new Date();
    }
    
    @Override
    public String toString(){
        String dato = codigo + "-" + nombre +
                "-" + salario + "-" + inicio;
        return dato;
    }
}
