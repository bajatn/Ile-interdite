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
public class Plongeur extends Aventurier {

    public Plongeur(Tuile tuile) {
        super("Plongeur", tuile, Color.BLACK);
    }

    @Override
    public ArrayList<Tuile> deplacer(){
        
        ArrayList<Tuile> choixTuile = new ArrayList<Tuile>();
        ArrayList<Tuile> tuilesEauAccessibles = new ArrayList<Tuile>();
        ArrayList<Tuile> collecTuiles = getTuileActu().calculerAdjacent();
        // Examine les tuiles adjacentes
        for (Tuile tuile: collecTuiles){ 
            if (tuile.getEtat() == Etat.Asseche || tuile.getEtat() == Etat.Inonde){
                choixTuile.add(tuile);
            }
            // Si il y a de l'eau dessus, on l'ajoute à tuilesEauAccessibles
            if (tuile.getEtat() == Etat.Submerge || tuile.getEtat() == Etat.Inonde){
                tuilesEauAccessibles.add(tuile);
            }
        }
        boolean modif = true;
        // Tant qu'on modifies tuilesEauAccessibles
        while (modif = true) {
            modif = false;
            // On parcours tuilesEauAccessibles
            for (Tuile tuileEau: tuilesEauAccessibles){
                // On parcours les tuiles adjacentes aux tuiles de tuilesEauAccessibles
                for (Tuile tuile: tuileEau.calculerAdjacent()){
                    if (tuile.getEtat() == Etat.Asseche || tuile.getEtat() == Etat.Inonde){
                        choixTuile.add(tuile);
                    }
                    // Si il y a de l'eau dessus, on l'ajoute à tuilesEauAccessibles
                    if (tuile.getEtat() == Etat.Submerge || tuile.getEtat() == Etat.Inonde){
                        tuilesEauAccessibles.add(tuile);
                        modif = true;
                    }
                }
            }
        }
        // Enleve la tuile sur laquelle est le joueur
        for (Tuile tuile: choixTuile){
            if (tuile == this.getTuileActu()){
                choixTuile.remove(tuile);
            }
        }
        
        return choixTuile;     
        
    } 
}
