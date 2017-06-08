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
public class Pilote extends Aventurier {

    private boolean aVole;
    
    public Pilote(Tuile tuile) {
        super("Pilote", tuile, Color.BLUE);
        aVole = false;
    }

    public boolean getAVole() {
        return aVole;
    }
    public void setAVole(boolean aVole) {
        this.aVole = aVole;
    }
    
    
    @Override
    public ArrayList<Tuile> deplacer(){
        if(aVole = false){
            ArrayList<Tuile> choixTuile = new ArrayList<Tuile>();
            for (Tuile tuile: getTuileActu().getGrille().getTuiles()){ 
                if (tuile.getEtat() == Etat.Asseche || tuile.getEtat() == Etat.Inonde){
                    choixTuile.add(tuile);
                }
            }
            aVole = true;
            return choixTuile;
        } else {
            return super.deplacer();
        }
    }
            
}

