/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab1;

/**
 *
 * @author Gotcha
 */
public class CuentaFacebook extends CuentaRedSocial{
    
    public CuentaFacebook(String u,String p){
        super(u,p);
    }
    
    public void agregarComentario(int pos,String cmt){
        if( pos >= 0 && pos < posts.size() ){
            posts.get(pos).agregarComentario(cmt);
        }
            
    }
}
