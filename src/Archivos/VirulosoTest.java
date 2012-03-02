
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package Archivos;

/**
 *
 * @author Gotcha
 */
public class VirulosoTest {
    public static void main(String args[]){
        try {
            //MiArchivo.viruloso();
            Scanner lea = new Scanner(System.in);
            MiArchivo.deleteEnCascada(lea.next());
        } catch (Exception ex) {
        }
    }
}
