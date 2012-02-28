/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package Archivos;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class MiArchivo {
    private File file = null;
    
    /**
     * Configurar el archivo mediante una direccion de archivo o directorio
     * @param direccion La direccion abstracta o absoluta
     */
    public void setFile(String direccion){
        file = new File( direccion );
    }
    
    public boolean crearArchivo() throws IOException{
        try{
            file.createNewFile();
            return true;
        }
        catch(NullPointerException e){
            System.out.println("COnfigure el archivo primero");
        }
        return false;
    }
    
    public boolean crearFolder(){
        try{
            file.mkdir();
            return true;
        }
        catch(NullPointerException e){
            System.out.println("COnfigure el archivo primero");
        }
        return false;
    }
    
    public boolean delete(){
        try{
            file.delete();
            return true;
        }
        catch(NullPointerException e){
            System.out.println("COnfigure el archivo primero");
        }
        return false;
    }
    
    public void infoFile(){
        try{
            if( file.exists() ){
                System.out.println("Ver Nombre: " + file.getName());
                System.out.println("Ver Path: " + file.getPath());
                System.out.println("Ver Absoluta: " + file.getAbsolutePath());
                
                if( file.isFile() )
                    System.out.println("<==ES UN ARCHIVO==>");
                else if( file.isDirectory())
                    System.out.println("<== ES DIRECTORIO ==>");
                
                if( file.isHidden() )
                    System.out.println("ESTA OCULTO");
                
                if( file.isAbsolute() )
                    System.out.println("Direccion Absoluta");
                else
                    System.out.println("Direccion Abstracta");
                
                System.out.println("BYTES: " + file.length());
                System.out.println("Ultima fecha de Modif: " + new Date(file.lastModified()) );
                
            }
            else
                System.out.println("DIRECCION NO EXISTE");
        }
        catch(NullPointerException e){
            System.out.println("COnfigure el archivo primero");
        }
    }
    
    public void dir(){
        try{
            if( file.exists() && file.isDirectory() ){
                File files[] = file.listFiles();
                int cf = 0, cd =0;
                long slengths = 0;
                
                for( File f : files ){
                    Date ultima = new Date( f.lastModified() );
                    System.out.print(ultima + "\t");
                    
                    if( f.isDirectory() ){
                        System.out.print("<DIR>\t ");
                        cd++;
                    }
                    
                    if( f.isFile()){
                        System.out.print("     \t");
                        System.out.print(f.length() + " ");
                        cf++;
                        slengths += f.length();
                    }
                    
                    System.out.println(f.getName());
                        
                }
                
                System.out.printf("(%d) Archivo(s)    %d Bytes \n(%d) Directorio(s)",
                        cf,slengths,cd);
            }
            else
                System.out.println("NO EXISTE O NO ES ARCHIVO");
        }
        catch(NullPointerException e){
            System.out.println("COnfigure el archivo primero");
        }
    }
}
