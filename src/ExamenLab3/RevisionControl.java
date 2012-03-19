/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab3;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class RevisionControl {
    private RandomAccessFile rClientes;
    private RandomAccessFile rRevisiones;
    
    public RevisionControl(){
        try {
            rClientes = new RandomAccessFile("clientes.rev", "rw");
            rRevisiones = new RandomAccessFile("revisiones.rev", "rw");
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public boolean buscarCliente(int cod) throws IOException{
        rClientes.seek(0);
        
        while( rClientes.getFilePointer() < rClientes.length() ){
            if( rClientes.readInt() == cod )
                return true;
            rClientes.readUTF();
            rClientes.readInt();
        }
        
        return false;
    }
    
    public boolean agregarCliente(int cod, String n) throws IOException{
        if( !buscarCliente(cod) ){
            rClientes.writeInt(cod);
            rClientes.writeUTF(n);
            rClientes.writeInt(5000);
            return true;
        }
        
        return false;
    }
    
    public boolean generarRevision(int codCliente,double monto) throws IOException{
        rRevisiones.seek( rRevisiones.length() );
        
        if( buscarCliente(codCliente) ){
            String n = rClientes.readUTF();
            int kms = rClientes.readInt();
            
            System.out.println("El Cliente " + n + " hara la revision para los kms. " + kms);
            
            Date now = new Date();
            rRevisiones.writeUTF("REV" + now.getTime());
            rRevisiones.writeInt(codCliente);
            rRevisiones.writeDouble(monto);
            
            //actualizo el kms del cliente para la prox rev
            rClientes.seek( rClientes.getFilePointer() - 4 );
            rClientes.writeInt(kms + 5000);
            return true;
        }
        else
            System.out.println("Cliente NO EXISTE");
        return false;
    }
    
    public boolean actualizarMonto(String cr , double monto) throws IOException{
        rRevisiones.seek(0);
        
        while( rRevisiones.getFilePointer() < rRevisiones.length()){
            String cod = rRevisiones.readUTF();
            rRevisiones.readInt();
            rRevisiones.readDouble();
            
            if( cr.equals( cod ) ){
                rRevisiones.seek( rRevisiones.getFilePointer() - 8 );
                rRevisiones.writeDouble(monto);
                return true;
            }    
        }
        
        return false;
    }
    
    private Date sacarFecha(String codRev){
        String mili = codRev.substring(3);
        return new Date( Long.parseLong(mili) );
    }
    
    public void imprimirHistorico(int codCliente) throws IOException{
        if( buscarCliente(codCliente) ){
            double total = 0;
            rRevisiones.seek(0);
            
            while( rRevisiones.getFilePointer() < rRevisiones.length()){
                String cod = rRevisiones.readUTF();
                int client = rRevisiones.readInt();
                double monto = rRevisiones.readDouble();
                
                if( client == codCliente ){
                    System.out.println(cod + " - Lps. " + monto + " el " + 
                            sacarFecha(cod) );
                    total += monto;
                }
                
            }
            
            if( total > 0 ){
                System.out.println("TOTAL GASTADO: " + total);
            }
            else
                System.out.println("CLIENTE NO TIENE REVISIONES HECHAS");
        }
        else
            System.out.println("CLIENTE NO EXISTE");
    }
    
    private int cuantasRevs(int cliente) throws IOException{
        rRevisiones.seek(0);
        int count = 0;   
        while( rRevisiones.getFilePointer() < rRevisiones.length()){
            rRevisiones.readUTF();
            if( rRevisiones.readInt() ==  cliente )
                count++;
            rRevisiones.readDouble();
        }
        return count;
    }
    
    public void clienteEstrella() throws IOException{
        rClientes.seek(0);
        long posEstrella = 0;
        int cuantos = 0;
        
        while( rClientes.getFilePointer() < rClientes.length() ){
            long pos = rClientes.getFilePointer();
            int cod = rClientes.readInt();
            int revs = cuantasRevs( cod );
            
            if( revs > cuantos ){
                cuantos = revs;
                posEstrella = pos;
            }
            rClientes.readUTF();
            rClientes.readInt();
        }
        
        if( cuantos > 0 ){
            System.out.println("El Cliente Estrella o uno de los Estrella es: ");
            rClientes.seek(posEstrella);
            int cod = rClientes.readInt();
            String n = rClientes.readUTF();
            System.out.println(cod + "-" + n + " con " + cuantos + " Revisiones");
        }
        else
            System.out.println("No hay Revisiones");
    }
    
    public void backup( String txtFile ) throws IOException{
        rClientes.seek(0);
        FileWriter fw = new FileWriter(txtFile);
        fw.write("CLIENTES\n------------\n");
        
        while( rClientes.getFilePointer() < rClientes.length() ){
            int cod = rClientes.readInt();
            String n = rClientes.readUTF();
            int kms = rClientes.readInt();
            
            fw.write(cod + "-" + n + "-" + kms + "\n");
        }
        
        rRevisiones.seek(0);
        fw.write("REVISIONES\n-----------------\n");
        
        while( rRevisiones.getFilePointer() < rRevisiones.length()){
            String cod = rRevisiones.readUTF();
            int client = rRevisiones.readInt();
            double monto = rRevisiones.readDouble();
            
            fw.write(cod + "-" + client + "-" + monto + "\n");
        }
        
        fw.close();
    }
}
