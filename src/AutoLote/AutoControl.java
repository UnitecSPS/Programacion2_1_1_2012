/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package AutoLote;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
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
    
    public void imprimirFacturas() throws IOException{
        ramFacturas.seek(0);
        while( ramFacturas.getFilePointer() < ramFacturas.length() ){
            int cf = ramFacturas.readInt();
            int cc = ramFacturas.readInt();
            long fecha = ramFacturas.readLong();
            double pre = ramFacturas.readDouble();
            String cliente = ramFacturas.readUTF();
            
            System.out.println(cf + " - " + new Date(fecha));
            System.out.println("Se vendio el carro " + cc + " a " + cliente);
            System.out.println("TOTAL: " + pre + "\n");
        }
    }
    
    public double montoGenerado(Date inicio,Date fin)throws IOException{
        ramFacturas.seek(0);
        double monto = 0;
        while( ramFacturas.getFilePointer() < ramFacturas.length() ){
            ramFacturas.readInt();
            ramFacturas.readInt();
            Date fecha = new Date( ramFacturas.readLong());
            double pre = ramFacturas.readDouble();
            ramFacturas.readUTF();
            
            if( fecha.after(inicio) && fecha.before(fin) ){
                // o ==> fecha.getTime() >= inicio.getTime() && fecha.getTime() <= fin.getTime()
                monto += pre;
            }
        }
        
        return monto;
    }
    
    public boolean updateFactura(int codf, double prec)throws IOException{
        ramFacturas.seek(0);
        while( ramFacturas.getFilePointer() < ramFacturas.length() ){
            int cf = ramFacturas.readInt();
            ramFacturas.readInt();
            
            if( cf == codf ){
                //guardar la nueva fecha
                Date now = new Date();
                ramFacturas.writeLong( now.getTime() );
                //actualizo precio
                ramFacturas.writeDouble(prec);
                //me voy!
                return true;
            }
            else{
                //solo leo para q avance                
                ramFacturas.readLong();
                ramFacturas.readDouble();
                ramFacturas.readUTF();
            }
        }
        
        return false;
    }
    
    public void listarCarros(Date fecha) throws IOException{
        ramAuto.seek(0);
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        int aniof = c.get(Calendar.YEAR);
            
        while( ramAuto.getFilePointer() < ramAuto.length() ){
            int cod = ramAuto.readInt();
            String d = ramAuto.readUTF();
            boolean m = ramAuto.readBoolean();
            double prec = ramAuto.readDouble();
            int anio = ramAuto.readInt();
           
            //la otra opcion es pasar los MILISEGUNDOS de la fecha a ANIO!
            //fecha.getTime()/(1000*60*60*24*365)
            System.out.println("probando...aniof: " + aniof);
            
            if( ramAuto.readBoolean() && anio == aniof ){
                System.out.println(cod + "-" + d + (m ? " Mecanico " : " Automatico ") +
                        " Lps " + prec + " anio " + anio);
            }
        }
    }
    
    public void exportCarrosDisponibles(String txtFile) throws IOException{
        ramAuto.seek(0);
        FileWriter fw = new FileWriter(txtFile);
        
        fw.write("\tLISTA DE CARROS DISPONIBLES\n\t-------------------------\n");
        
        while(ramAuto.getFilePointer() < ramAuto.length()){
           int cod = ramAuto.readInt();
           String d = ramAuto.readUTF();
           boolean m = ramAuto.readBoolean();
           double prec = ramAuto.readDouble();
           int anio = ramAuto.readInt();
           
           if( ramAuto.readBoolean() ){
               String dato = cod + " - " + d + (m ? " MECANICO " : " AUTOMATICO ") +
                       " Lps " + prec + " Anio: " + anio;
               fw.write(dato + "\n");
           }
        }
        
        fw.close();
        
    }
    
}