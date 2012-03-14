
import java.util.Calendar;
import java.util.Date;
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
            System.out.println("4- Actualizar Precio");
            System.out.println("5- Vender Auto");
            System.out.println("6- Listar Facturas");
            System.out.println("7- Monto Generado");
            System.out.println("8- Actualizar Factura");
            System.out.println("9- Listar Carros por anio");
            System.out.println("10- Exportar Carros Disponibles");
            System.out.println("11- Salir");
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
                    case 4:
                        System.out.print("Ingrese codigo: ");
                        int cod = lea.nextInt();
                        System.out.print("Precio Nuevo: ");
                        double pre = lea.nextDouble();
                        at.updatePrecio(cod, pre);
                        break;
                    case 5:
                        System.out.print("Cod Carro: ");
                        cod = lea.nextInt();
                        System.out.print("Cliente: ");
                        String cli = lea.next();
                        
                        if( at.venderAuto(cod, cli) )
                            System.out.println("FACTURA CREADA");
                        else
                            System.out.println("FACTURA FALLO");
                        break;
                    case 6:
                        at.imprimirFacturas();
                        break;
                    case 7:
                        Calendar c = Calendar.getInstance();
                        //inicio
                        c.set(lea.nextInt(), lea.nextInt(), lea.nextInt());
                        Date i = c.getTime();
                        //fin
                        c.set(lea.nextInt(), lea.nextInt(), lea.nextInt());
                        Date f = c.getTime();
                        
                        System.out.println("Se genero: " + at.montoGenerado(i, f));
                        break;
                    case 8:
                        System.out.println("Cod Factura: ");
                        int cf = lea.nextInt();
                        System.out.println("Nuevo Monto: ");
                        double m = lea.nextDouble();
                        
                        if( at.updateFactura(cf, m))
                            System.out.println("Se actualizo con exito");
                        else
                            System.out.println("No existe factura");
                        break;
                    case 9:
                        //fecha
                        c = Calendar.getInstance();
                        c.set(lea.nextInt(), lea.nextInt(), lea.nextInt());
                        at.listarCarros(c.getTime());
                        break;
                    case 10:
                        System.out.print("Ingrese nombre de txt: ");
                        at.exportCarrosDisponibles(lea.next());
                        break;
                        
                }
            }
            catch(Exception e ){
                System.out.println("Error: " + e.getMessage());
            }
        }while( op != 11 );
        
    }
}
