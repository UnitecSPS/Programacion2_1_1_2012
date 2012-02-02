/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen1;

import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class Empresa {
    private static Empleado emps[];
    private static Scanner lea = new Scanner(System.in);
    
    public static void main(String args[]){
        emps = new Empleado[100];
           
        agregarEmpleado('a');
        Empleado e = mejorEmpleado();
        
    }

    private static void agregarEmpleado(char c) {
        int pos = posVacia(0);
        
        if( pos >= 0 ){
            String n = lea.next();
            int co = lea.nextInt();
            double s = lea.nextDouble();
            
            if( c == 'T' || c == 't' ){
                char z = lea.next().charAt(0);
                
                emps[pos] = new EmpleadoTemporal(n,s,co,z);
            }
            else if( c == 'E'){
                emps[pos] = new Empleado(n,s,co);
            }
            else{
                System.out.println("CODIGO INCORRECTO");
            }
        }
    }
    
    private static int posVacia(int pos){
        if( pos < emps.length ){
            if( emps[pos] == null )
                return pos;
            return posVacia(pos + 1);
        }
        return -1;
    }

    private static Empleado mejorEmpleado() {
        return mejorEmpleado(0,Double.MIN_VALUE,0);
    }

    private static Empleado mejorEmpleado(int pos, double mayor,int index) {
        if( pos < emps.length ){
            if( emps[pos] != null ){
                if( emps[pos].salario > mayor ){
                    mayor = emps[pos].salario;
                    index = pos;
                }
            }
            
            return mejorEmpleado(pos+1,mayor,index);
        }
        
        return emps[index];
    }
}
