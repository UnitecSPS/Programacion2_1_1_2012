/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package AutoLote;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

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
            inicializarCodigos();
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private void inicializarCodigos() {
        try{
           RandomAccessFile ramCods = new RandomAccessFile("codigos.alt", "rw");
           
           if( ramCods.length() == 0 ){
               //es nuevo
               ramCods.writeInt(1);//cods carros
               ramCods.writeInt(1);//cod facturas
               
               ramCods.close();
           }
        }
        catch(IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    private int getCodigoSecuencial(int offset) throws IOException{
        RandomAccessFile ramCods = new RandomAccessFile("codigos.alt", "rw");
        ramCods.seek(offset);
        
        int codigo = ramCods.readInt();
        //dejar actualizado
        ramCods.seek(offset);
        ramCods.writeInt( codigo + 1);
        ramCods.close();
        
        return codigo;
        
    }
    
    private int getCodigoCarro() throws IOException{
        return getCodigoSecuencial(0);
    }
    
    private int getCodigoFactura() throws IOException{
        return getCodigoSecuencial(4);
    }
    
    public void adicionarCarro(String d,boolean m,double p,int a) throws IOException{
        ramAuto.seek(ramAuto.length());
        
        //formato a guardar
        ramAuto.writeInt( this.getCodigoCarro() );
        ramAuto.writeUTF(d); //descripcion
        ramAuto.writeBoolean(m); //mecanico o no
        ramAuto.writeDouble(p); //precio
        ramAuto.writeInt(a); //anio
        ramAuto.writeBoolean(true); //dispo
    }
    
    public void imprimirAutosDisponibles() throws IOException{
        ramAuto.seek(0);
        
        while( ramAuto.getFilePointer() < ramAuto.length() ){
            int cod = ramAuto.readInt();
            String d = ramAuto.readUTF();
            boolean m = ramAuto.readBoolean();
            double prec = ramAuto.readDouble();
            int anio = ramAuto.readInt();
            
            if( ramAuto.readBoolean() ){
                System.out.println(cod + "-" + d + (m ? " Mecanico " : " Automatico ") +
                        " Lps " + prec + " anio " + anio);
            }
        }
    }
    
    public long buscarAuto(int codAuto) throws IOException{
        ramAuto.seek(0);
        
        while( ramAuto.getFilePointer() < ramAuto.length() ){
            long pos = ramAuto.getFilePointer();
            int cod = ramAuto.readInt();
            ramAuto.readUTF();
            ramAuto.seek( ramAuto.getFilePointer() + 13 );
            
            if( ramAuto.readBoolean() && cod == codAuto )
                return pos;
        }
        
        return -1;
    }
    
    
    public void updatePrecio(int codCarro, double prec) throws IOException{
        long pos = buscarAuto(codCarro);
        
        if( pos > -1 ){
            //lo encontre
            ramAuto.seek(pos);
            ramAuto.readInt();
            String s = ramAuto.readUTF();
            ramAuto.readBoolean();
            
            ramAuto.writeDouble(prec);
            System.out.println("Se actualizo el precio de " + s);
        }
        else
            System.out.println("No se encontro ese registro");
    }
    
    private double crearFactura(int cc,double p,String c) throws IOException{
        ramFacturas.seek( ramFacturas.length() );
        
        int codf = getCodigoFactura();
        System.out.println("No. Factura " + codf);
        ramFacturas.writeInt( codf );
        ramFacturas.writeInt(cc);
        Date d = new Date();
        System.out.println(d);
        ramFacturas.writeLong( d.getTime() );
        double imp = p * 0.12;
        double total = p + imp;
        ramFacturas.writeDouble( total );
        ramFacturas.writeUTF(c);
        return total;
    }
    
    public boolean venderAuto(int codcarro,String cliente) throws IOException{
        long pos = buscarAuto(codcarro);
        
        if( pos > -1 ){
            ramAuto.seek(pos);
            ramAuto.readInt();
            String s = ramAuto.readUTF();
            ramAuto.readBoolean();
            
            double tot= crearFactura(codcarro, ramAuto.readDouble(), cliente);
            
            ramAuto.readInt();
            ramAuto.writeBoolean(false); // ya no esta disponible
            
            System.out.println("El carro: " +  s + " Vendido a " +
                    cliente + " por Lps. " + tot);
            return true;
        }
        
        return false;
    }
    
}