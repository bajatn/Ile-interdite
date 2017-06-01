package ile_interdite;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ravinelt
 */
public class Controleur {
    
    private Grille grille;
    private ArrayList<Aventurier> aventuriers;
    private VueAventurier vue;
    
    public void tour(){
        
    }
    
    private String getRole(String roleAventurier){
        
    }
    
    private Tuile getTuile(int x, int y){
        
    }
    
    public Tuile choixTuile(){
        
    }
    
    public void traiterMessage ( Message message){
        
    }
    
    public void assecher(Aventurier aventurier){
        int positionX = aventurier.getPositionX();
        int positionY = aventurier.getPositionY();
        ArrayList<Tuile> collecTuiles = calculerAdjacent(positionX, positionY);
        for (Tuile tuile: collecTuiles){
            if (tuile.getEtat() == Etat.Inonde){
                System.out.println("tuile : " + tuile.getNom());
             //   vue.Afficher(tuile);
            }
        }
    }
    
    public ArrayList<Tuile> calculerAdjacent(int x, int y){
        ArrayList<Tuile> result = new ArrayList<>();
        for (Tuile tuile: grille.getTuiles()){
            if ((tuile.getX() == x) && (tuile.getY() == (y+1)) || (tuile.getX() == x) && (tuile.getY() == (y-1)) || (tuile.getX() == (x+1)) && (tuile.getY() == y) || (tuile.getX() == (x-1)) && (tuile.getY() == y)) {
                result.add(tuile);
            }
        }
        return result;
    }
    
    
}
