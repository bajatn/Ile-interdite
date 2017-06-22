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

    private boolean aVole = false;
    
    public Pilote(Tuile tuile) {
        super("Pilote", tuile, Color.BLUE, 3,"<html>Le Pilote peut, une fois par tour,<br> voler jusqu'à n'importe quelle tuile de l'île pour une action. </html>");
        aVole = false;
    }
    
    public boolean getAVole() {
        return aVole;
    }
    
    @Override
    public void setAVole(boolean aVole) {
        this.aVole = aVole;
    }
    
    
    @Override
    public ArrayList<Tuile> deplacer(){
        if(aVole == false){
            ArrayList<Tuile> choixTuile = new ArrayList<Tuile>();
            for (Tuile tuile: getTuileActu().getGrille().getTuiles()){ 
                if (tuile.getEtat() == Etat.Asseche || tuile.getEtat() == Etat.Inonde){
                    choixTuile.add(tuile);
                }
            }
            return choixTuile;
        } else {
            return super.deplacer();            
        }
    }
    
    public void deplacerVersTuile(int x, int y){
       ArrayList<Tuile> tuilesDeplacementNormal = this.getTuileActu().calculerAdjacent();
       boolean deplacementNormal = false;
        
       for (Tuile tuile : tuilesDeplacementNormal){
           if (this.getTuileActu().getGrille().getTuile(x, y) == tuile){
               deplacementNormal = true;
           }
       }
       if (deplacementNormal == false){
           this.setAVole(true);
       }
       
        super.deplacerVersTuile(x, y);
    }
            
}

