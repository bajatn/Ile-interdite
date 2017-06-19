/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import java.util.ArrayList;

/**
 *
 * @author bajatn
 */
public class Sac_de_sable extends Carte_Tresor {

    public Sac_de_sable() {
        super("Sac_de_sable");
    }
    
    
    public ArrayList<Tuile> utiliserCarte(Grille grille){
        ArrayList<Tuile> choixTuile = new ArrayList<Tuile>();
        ArrayList<Tuile> collecTuiles = grille.getTuiles();
        for (Tuile tuile: collecTuiles){
            if (tuile.getEtat() == Etat.Inonde){
              choixTuile.add(tuile);
            }
        }
    return choixTuile;
    }
}
