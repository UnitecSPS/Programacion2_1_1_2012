/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package AutoLote;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gotcha
 */
public class AutoControl {
    private RandomAccessFile ramAuto;
    private RandomAccessFile ramFacturas;
    
    public AutoControl(){
        try {
            ramAuto = new RandomAccessFile("autos.alt","rw");
            ramFacturas = new RandomAccessFile("facturas.alt","rw");
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
