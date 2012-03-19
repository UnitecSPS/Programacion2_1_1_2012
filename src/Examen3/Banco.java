/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen3;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class Banco {
    private RandomAccessFile ram;
    
    public Banco() throws FileNotFoundException{
        ram = new RandomAccessFile("cuentas.bac", "rw");
    }
    
    private boolean buscarCuenta(int cod) throws IOException{
        ram.seek(0);
        while( ram.getFilePointer() < ram.length() ){
            if( ram.readInt() == cod )
                return true;
            ram.readUTF();
            ram.seek(ram.getFilePointer() + 25 );
        }
        
        return false;
    }
    
    public boolean agregarCuenta(int cod,String n) throws IOException{
        if( buscarCuenta( cod ) ){
            System.out.println("CODIGO YA EXISTE");
            return false;
        }
        
        //cod no existe
        Date now = new Date();
        ram.writeInt(cod);
        ram.writeUTF(n);
        ram.writeDouble(500);
        ram.writeLong(now.getTime());
        ram.writeLong(now.getTime());
        ram.writeBoolean(true);
        return true;
    }
    
    public boolean hacerDeposito(int cod,double monto) throws IOException{
        if( buscarCuenta(cod) ){
           //encontramos
            ram.readUTF();
            long pos = ram.getFilePointer();
            double saldo = ram.readDouble();
            ram.readLong();
            ram.readLong();
            
            if( !ram.readBoolean() )
                monto -= (monto * 0.1);
            
            ram.seek(pos);
            ram.writeDouble(saldo + monto);
            ram.readLong();
            ram.writeLong(new Date().getTime());
            return true;
        }
        return false;
    }
    
    public boolean hacerRetiro(int cod,double monto) throws IOException{
        if( buscarCuenta( cod ) ){
            ram.readUTF();
            long pos = ram.getFilePointer();
            double saldo = ram.readDouble();
            ram.readLong();
            ram.readLong();
            
            if( ram.readBoolean() && saldo > monto ){
                ram.seek(pos);
                ram.writeDouble(saldo - monto);
                ram.readLong();
                ram.writeLong(new Date().getTime());
                return true;
            }
        } 
        return false;
    }
    
    public void inactivarCuentas() throws IOException{
        ram.seek(0);
        while( ram.getFilePointer() < ram.length()){
            ram.readInt();
            ram.readUTF();
            ram.readDouble();
            ram.readLong();
            long uf = ram.readLong();
            Date now = new Date();
            long diff = now.getTime() - uf;
            double dias = diff / ( 1000*60*60*24);
            
            if( dias >= 186 ){
                ram.writeBoolean(false);
            }
            else
                ram.readBoolean();
        }
    }
    
    public void exportarCuenta(String txtFile,boolean activas) throws IOException{
        FileWriter fw = new FileWriter(txtFile);
        
        ram.seek(0);
        
        while( ram.getFilePointer() < ram.length()){
            int cod = ram.readInt();
            String n = ram.readUTF();
            double s = ram.readDouble();
            long c = ram.readLong();
            long uf = ram.readLong();
            
            if( activas == ram.readBoolean() ){
                String d = cod + " - " + n + " lps " + s + " creada " +
                        (new Date(c)) + " - " + (new Date(uf));
                fw.write(d);
            }
        }
        
        fw.close();
    }
    
    
    public boolean depositoTercero(int co,int cd,double m) throws IOException{
        if( hacerRetiro(co,m)){
            return hacerDeposito(cd,m);
        }
        return false;   
    }
}
