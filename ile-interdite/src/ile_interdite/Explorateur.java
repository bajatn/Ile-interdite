/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author ravinelt
 */
public class Explorateur extends Aventurier {

    public Explorateur(Tuile tuile) {
        super("Explorateur", tuile,Color.GREEN);
    }

    
    @Override
    public ArrayList<Tuile> deplacer(){
        ArrayList<Tuile> choixTuile = new ArrayList<Tuile>();
        ArrayList<Tuile> collecTuiles = getTuileActu().calculerAutours();
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
        ArrayList<Tuile> collecTuiles = getTuileActu().calculerAutours();
        for (Tuile tuile: collecTuiles){
            if (tuile.getEtat() == Etat.Inonde){
              choixTuile.add(tuile);
            }
        }
        return choixTuile;
    }
}
