/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Gotcha
 */
public class CuentaTipoInvalidaException extends RuntimeException{
    public CuentaTipoInvalidaException(char t){
        super("TIPO DE CUENTA INVALIDA: " + t);
    }
}
