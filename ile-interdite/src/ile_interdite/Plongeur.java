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
      ArrayList<Tuile> tuilesEau;
      ArrayList<Tuile> tuilesEau2 = new ArrayList();
        ArrayList<Tuile> collecTuiles = getTuileActu().calculerAdjacent(); 
        for (Tuile tuile: collecTuiles){
           choixTuile.add(tuile);
           if (tuile.getEtat() == Etat.Inonde || tuile.getEtat() == Etat.Submerge ){
               tuilesEau = tuile.calculerAdjacent();
               for(Tuile tuileSub : tuilesEau){
                   if(tuile.getEtat()!=Etat.Asseche){
                        tuilesEau2.add(tuileSub);
                   }
               }
           }            
        }
        for(Tuile tuile : tuilesEau2){
            choixTuile.add(tuile);
        }
        return choixTuile;
    } 
}
