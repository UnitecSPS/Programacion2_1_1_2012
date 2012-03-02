
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package AutoLote;

/**
 *
 * @author Gotcha
 */
public class EligeTuCarro {
    public static void main(String args[]){
        AutoControl at = new AutoControl();
        Scanner lea = new Scanner(System.in);
        
        int op;
        
        do{
            System.out.println("\n\nMENU PRINCIPAL\n-------");
            System.out.println("1- Ingrese Auto");
            System.out.println("2- Imprimir Autos Disponibles");
            System.out.println("3- Buscar Auto");
            System.out.println("4- Salir");
            System.out.print("\nEscoja opcion: ");
            op = lea.nextInt();
            
            try{
                switch( op ){
                    case 1:
                        System.out.print("Descripcion: ");
                        String d = lea.next();
                        System.out.print("Mecanico (s/n): ");
                        char mec = lea.next().charAt(0);
                        System.out.print("Precio: ");
                        double p = lea.nextDouble();
                        System.out.print("Anio del Carro: ");
                        int a = lea.nextInt();
                        
                        at.adicionarCarro(d,mec == 's' ? true : false, p, a);
                        break;
                    case 2:
                        at.imprimirAutosDisponibles();
                        break;
                    case 3:
                        System.out.print("Ingrese Codigo: ");
                        long result = at.buscarAuto( lea.nextInt() );
                        if( result > -1 )
                            System.out.println("Si ESTA Disponible");
                        else
                            System.out.println("No existe o NO esta disponible");
                        break;
                        
                }
            }
            catch(Exception e ){
                System.out.println("Error: " + e.getMessage());
            }
        }while( op != 4 );
        
    }
}
