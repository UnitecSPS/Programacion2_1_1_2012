/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab1;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class CuentaRedSocial {
    protected String username;
    protected String password;
    protected Date inicio;
    protected ArrayList<Post> posts;
    
    public CuentaRedSocial(String u,String p){
        username = u;
        password = p;
        inicio = new Date();
        posts = new ArrayList<Post>();
    }
    
    public void imprimir(){
        System.out.println("User: " + username + " desde " + inicio);
        for(Post p : posts){
            p.imprimir();
        }
    }
    
    public void agregarPost(String msg){
        posts.add(new Post(msg));
    }
}
