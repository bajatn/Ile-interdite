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
public class Pilote extends Aventurier {

    public Pilote(Tuile tuile) {
        super("Pilote", tuile);
    }
    
    Boolean aVole = false;
    @Override
    public ArrayList<Tuile> deplacer(){
        if(aVole = false){
        ArrayList<Tuile> choixTuile = new ArrayList<Tuile>();
        ArrayList<Tuile> collecTuiles = getTuileActu().getGrille().getTuiles();
        aVole = true;
        return collecTuiles;
        }else{
        ArrayList<Tuile> choixTuile = new ArrayList<Tuile>();
        // int positionX = getPositionX();
        // int positionY = getPositionY();
        ArrayList<Tuile> collecTuiles = getTuileActu().calculerAdjacent();
        for (Tuile tuile: collecTuiles){
            if (tuile.getEtat() == Etat.Asseche || tuile.getEtat() == Etat.Inonde){
              choixTuile.add(tuile);
            }
        }
        return choixTuile;        
         }
       }
            
    }
