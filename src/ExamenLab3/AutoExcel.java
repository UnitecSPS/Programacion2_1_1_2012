/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab3;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gotcha
 */
public class AutoExcel {
    static RevisionControl rc = new RevisionControl();
    static Scanner lea = new Scanner(System.in);

    public static void main(String args[]){
        
        int op = 0;
        
        do{
            try {
                System.out.println("1- Agregar Cliente");
                System.out.println("2- Generar Revision");
                System.out.println("3- Actualizar Monto");
                System.out.println("4- Historial Cliente");
                System.out.println("5- Cliente Estrella");
                System.out.println("6- Backup");
                System.out.println("7- Salir");
                System.out.println("Escoja opcion: ");
                op = lea.nextInt();
                
                switch( op ){
                    case 1:
                        agregarCliente();
                        break;
                    case 2:
                        generar();
                        break;
                    case 3:
                        actualizar();
                        break;
                    case 4:
                        historial();
                        break;
                    case 5:
                        estrella();
                        break;
                    case 6:
                        backup();
                        break;
                }
            } catch (IOException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
            
        }while( op != 7);
        
    }

    private static void agregarCliente() throws IOException {
        System.out.println("Codigo: ");
        int cod = lea.nextInt();
        System.out.println("Nombre: ");
        String n = lea.next();
        
        if( rc.agregarCliente(cod, n) )
            System.out.println("Agregado con Exito");
        else
            System.out.println("No se pudo Agregar");
    }

    private static void generar() throws IOException {
        System.out.println("Cod Cliente: ");
        int cod = lea.nextInt();
        System.out.println("Monto a Pagar: ");
        double monto = lea.nextDouble();
        
        if( rc.generarRevision(cod, monto))
            System.out.println("AGREGADO CON EXITO");
        else
            System.out.println("NO SE PUDO GENERAR REVISION");
    }

    private static void actualizar() throws IOException {
        System.out.println("Codigo Rev: ");
        String cod = lea.next();
        System.out.println("Nuevo Monto: ");
        double monto = lea.nextDouble();
        
        if( rc.actualizarMonto(cod, monto) )
            System.out.println("ACTUALIZADO CON EXITO");
        else
            System.out.println("NO SE PUDO ACTUALIZAR");
    }

    private static void historial() throws IOException {
        System.out.println("Codigo Cliente: ");
        int cod = lea.nextInt();
        
        rc.imprimirHistorico(cod);
    }

    private static void estrella() throws IOException {
        rc.clienteEstrella();
    }

    private static void backup() throws IOException {
        System.out.println("Nombre del Archivo: ");
        rc.backup(lea.next());
    }
}
