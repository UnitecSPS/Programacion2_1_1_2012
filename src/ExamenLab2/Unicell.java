/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author CarlosArmando
 */
public class Unicell {
    private static ArrayList<PlanComercial> planes = new ArrayList<PlanComercial>();
    private static Scanner lea = new Scanner(System.in);
    
    public static void main(String args[]){
        int op;
        
        do{
            System.out.println("1- Agregar Plan");
            System.out.println("2- Cobrar Plan");
            System.out.println("3- Imprimir Detalle");
            System.out.println("4- Cliente Viejo");
            System.out.println("5- Salir");
            System.out.print("\nEscoja opcion: ");
            op = lea.nextInt();
            
            switch( op ){
                case 1:
                    agregarCliente();
                    break;
                case 2:
                    System.out.println("Ingresar Nombre: ");
                    String n = lea.next();
                    pagoTotalMes( n );
                    break;
                case 3:
                    imprimirDetalle();
                    break;
                case 4:
                    PlanComercial viejo = clienteViejo();
                    System.out.println("Viejo: " + viejo);
                    break;
            }
            
        }while( op != 5 );
        
    }

    private static void agregarCliente() {
        System.out.print("Ingrese Nombre: ");
        String n = lea.next();
        System.out.println("Ingrese tipo: ");
        String t = lea.next();
        
        if( t.equals( PlanComercial.TIPO_40 ) )
            planes.add( new Plan40(n) );
        else if( t.equals( PlanComercial.TIPO_80) ){
            System.out.print("Quiere Internet s/n ");
            char i = lea.next().charAt(0);
            planes.add( new Plan80(n, i == 's' ? true : false) );
        }
        else{
            System.out.println("TIPO PLAN INCORRECTO");
        }
    }

    private static void pagoTotalMes(String n) {
        
        for(PlanComercial pc : planes){
            if( pc.nombre.equals(n) ){
                try{
                    System.out.print("Ingrese minutos: ");
                    int mins = lea.nextInt();
                    System.out.print("Ingrese Mensagitos: ");
                    int msgs = lea.nextInt();
                    
                    double m = pc.getPagoMensual(mins, msgs);
                    
                    System.out.println("Monto a Pagar: " + m);
                }
                catch(Exception e){
                    System.out.println("ERROR: " + e.getMessage());
                }
                
                return;
            }
        }
        
        System.out.println("NO EXISTE CLIENTE!");
    }

    private static void imprimirDetalle() {
        for(PlanComercial pc : planes )
            System.out.println("PLAN: " + pc);
    }

    private static PlanComercial clienteViejo() {
        int mayorPos = 0;
        long mayorSegsDiff = 0;
        Date now = new Date();
        
        for(int p = 0; p < planes.size(); p++ ){
            long diff = now.getTime() - planes.get(p).inicioPlan.getTime();
            
            if( diff > mayorSegsDiff ){
                mayorPos = p;
                mayorSegsDiff = diff;
            }
        }
        
        if( planes.size() > 0 )
            return planes.get(mayorPos);
        else
            return null;
        
        /*O SIMPLEMENTE !! :)
        return planes.get( 0 ); 
        YA QUE LOS PLANES SE GUARDAN EN ORDEN!! EN EL ARRAYLIST y ES OBVIO QUE 
        EL DE LA POSICION 0 FUE EL PRIMERITO QUE GUARDE! POR ENDE EL MAS VIEJO!
        CLARO SE VALIDA QUE POR LO MENOS ESTE GUARDADO 1! SINO SE RETORNA NULL
         * 
         */
    }
    
}
