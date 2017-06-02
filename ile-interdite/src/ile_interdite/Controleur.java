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
    

    
    
    
    
}
