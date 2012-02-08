/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion2_1_1_2012;

import java.util.Random;

/**
 *
 * @author Gotcha
 */
public class Sortea {
    public static void main(String args[]){
        Random m = new Random();
        
        //g1 = canamel
        //g2 = danny
        //g3 = oscarmon
        //g4 = marariel
        //g5 = denwill
        System.out.println("EXPO " + (m.nextInt(5)));
        System.out.println("1 oro extra " + (m.nextInt(5)));
    }
}
