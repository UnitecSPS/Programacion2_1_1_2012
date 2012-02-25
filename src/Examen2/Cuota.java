/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen2;

/**
 *
 * @author Gotcha
 */
public class Cuota {
    private double pagoMensual;
    private boolean pagada;
    
    public Cuota(double pm){
        pagoMensual = pm;
        pagada = false;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public double getPagoMensual() {
        return pagoMensual;
    }

    public void setPagoMensual(double pagoMensual) {
        this.pagoMensual = pagoMensual;
    }
}
