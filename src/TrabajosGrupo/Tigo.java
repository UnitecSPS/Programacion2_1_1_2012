/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajosGrupo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
enum TipoPlan{
    AMIGOS,BLACKBERRY
}

public class Tigo {
    public static ArrayList<PlanCliente> planes;
    public static Scanner lea;
    
    public static void main(String args[]){
        planes = new ArrayList<PlanCliente>();
        lea = new Scanner(System.in);
        
        int op;
        
        do{
            System.out.println("MENU PRINCIPAL PARA " + PlanCliente.COMPANIA_TELEFONICA);
            System.out.println("1-Agregar Plan");
            System.out.println("2-Buscar Cliente");
            System.out.println("3-Cobros");
            System.out.println("4-Agregar Amigo");
            System.out.println("5-Imprimir todo");
            System.out.println("6-Salir");
            System.out.println("\nEscoja Opcion: ");
            op = lea.nextInt();
            
            switch(op){
                case 1:
                    System.out.println("Ingrese Nombre plan (AMIGOS) o (BLACKBERRY): ");
                    String plan = lea.next();
                    //agregarPlan( TipoPlan.valueOf(plan)); <--Sacar el plan directamente
                    if( plan.equalsIgnoreCase("AMIGOS") )
                        agregarPlan(TipoPlan.AMIGOS);
                    else if(plan.equalsIgnoreCase("BLACKBERRY"))
                        agregarPlan(TipoPlan.BLACKBERRY);
                    else
                        System.out.println("PLAN INCORRECTO");
                    break;
                    
                case 2:
                    System.out.println("CLiente: ");
                    String c = lea.next();
                    
                    if( buscarCliente(c) )
                        System.out.println("Si EXISTE");
                    else
                        System.out.println("NO EXISTE");
                    break;
                    
                case 3:
                    cobros();
                    break;
                    
                case 4:
                    System.out.print("Numero Celular del cliente: ");   
                    int nc = lea.nextInt();
                    System.out.print("Numero Celular de Amigo: ");
                    int amigo = lea.nextInt();
                    
                    if( agregarAmigo(nc,amigo))
                        System.out.println("Se agrego amigo");
                    else
                        System.out.println("NO SE PUDO agregar amigo");
                    break;
                case 5:
                    imprimir();
                    break;
            }
            
        }while(op!=6);
        
    }

    private static void agregarPlan(TipoPlan tipoPlan) {
        System.out.println("Numero celular: ");
        int nc= lea.nextInt();
        System.out.println("Nombre de Cliente: ");
        String c = lea.next();
        
        if( tipoPlan == TipoPlan.AMIGOS )
            planes.add(new PlanAmigos(nc,c));
        else{
            System.out.println("Pin: ");
            int p = lea.nextInt();
            System.out.println("Full Service? (1) Redes Sociales? (0): ");
            int f = lea.nextInt();
            
            PlanBlackberry pb = new PlanBlackberry(nc, c, p, (f == 1 ? true : false) );
            planes.add(pb);
        }
            
    }

    private static boolean buscarCliente(String c) {
        for(PlanCliente pc : planes){
            if( pc.getCliente().equalsIgnoreCase(c))
                return true;
        }
        return false;
    }

    private static void cobros() {
        double tot = 0;
        
        for( PlanCliente pc : planes ){
            System.out.println("Cobrar a " + pc.getCliente());
            System.out.print("Minutos Consumidos: ");
            int cmins = lea.nextInt();
            System.out.print("Mensajes Consumidos: ");
            int cmsgs = lea.nextInt();
            
            double pago = pc.getPago(cmins, cmsgs);
            tot += pago;
            
            System.out.println("Total a Pagar: " + pago);
        }
        
        System.out.println("\nSE COBRO UN TOTAL DE "+ tot + " lps" );
    }

    private static boolean agregarAmigo(int nc, int amigo) {
        //primero buscar el numero
        for(PlanCliente pc : planes){
            if( pc.getNumCell() == nc ){
                //lo encontre!! intentar por ende agregarlo
                //Solo si es de tipo PlanAmigos
                if( pc instanceof PlanAmigos ){
                    return ((PlanAmigos)pc).agregarAmigo(amigo);
                }
                else{
                    System.out.println("Tipo Plan Incorrecto");
                }
            }
        }
        
        return false;
    }

    private static void imprimir() {
        System.out.println("Imprimir PLANES");
        for(PlanCliente pc : planes){
            pc.imprimir();
        }
    }
}
