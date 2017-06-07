/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import java.util.ArrayList;

/**
 *
 * @author ravinelt
 */
public class Explorateur extends Aventurier {

    public Explorateur(String role, Tuile tuile) {
        super(role, tuile);
    }

    
    @Override
    public ArrayList<Tuile> deplacer(){
        ArrayList<Tuile> choixTuile = new ArrayList<Tuile>();
        int positionX = getPositionX();
        int positionY = getPositionY();
        ArrayList<Tuile> collecTuiles = getTuileActu().calculerAutours(); // idem ????
        for (Tuile tuile: collecTuiles){
            if (tuile.getEtat() == Etat.Asseche || tuile.getEtat() == Etat.Inonde){
              choixTuile.add(tuile);
            }
        }
        return choixTuile;
    }
    
    @Override
    public ArrayList<Tuile> assecher(){
        ArrayList<Tuile> choixTuile = new ArrayList<Tuile>();
        int positionX = getPositionX();
        int positionY = getPositionY();
        ArrayList<Tuile> collecTuiles = getTuileActu().calculerAutours();
        for (Tuile tuile: collecTuiles){
            if (tuile.getEtat() == Etat.Inonde){
              choixTuile.add(tuile);
            }
        }
        return choixTuile;
    }
}
