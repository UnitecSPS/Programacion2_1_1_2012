/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Gotcha
 */
public class Cheque {
    public int numero;
    public double monto;
    public String portador;
    
    public Cheque(int n,double m,String p){
        numero = n;
        monto = m;
        portador = p;
    }
    
    @Override
    public String toString(){
        return numero + "- a nombre de: " + portador +
                " - Lps. " + monto;
    }
}
