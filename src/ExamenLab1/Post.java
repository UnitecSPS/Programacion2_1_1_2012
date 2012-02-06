/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab1;

import java.util.ArrayList;

/**
 *
 * @author Gotcha
 */
public class Post {
    public String mensaje;
    public ArrayList<String> comentarios;
    
    public Post(String msg){
        mensaje = msg;
        comentarios = new ArrayList<String>();
    }
    
    public void agregarComentario(String msg){
        comentarios.add(msg);
    }
    
    public void imprimir(){
        System.out.println("POST:\n-----------------");
        System.out.println(mensaje);
        for(String c : comentarios)
            System.out.println("\t" + c + "\n");
    }
}
