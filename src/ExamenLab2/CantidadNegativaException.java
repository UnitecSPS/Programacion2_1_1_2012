/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab2;

/**
 *
 * @author CarlosArmando
 */
public class CantidadNegativaException extends RuntimeException{
    public CantidadNegativaException(){
        super("No puede haber cantidades negativas");
    }
}
