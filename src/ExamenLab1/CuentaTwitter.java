/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab1;

/**
 *
 * @author Gotcha
 */
public class CuentaTwitter extends CuentaRedSocial{
    private String followers[];
    private int follows = 0;
    
    public CuentaTwitter(String u, String p){
        super(u,p);
        followers = new String[500];
    }
    
    public void agregarFollower(String f){
        if( follows < followers.length ){
            followers[ follows ] = f;
            follows++;
        }
        else{
            System.out.println("Ya no hay espacio");
        }
    }
    
    @Override
    public void imprimir(){
        super.imprimir();
        imprimirFollowers(0);
    }

    private void imprimirFollowers(int pos) {
        if( pos < follows ){
            System.out.println("Follower: " + followers[pos] );
            imprimirFollowers( pos + 1 );
        }
    }
}
