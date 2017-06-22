/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import static ile_interdite.Type_Tresor.*;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author ravinelt
 */
public class Explorateur extends Aventurier {

    public Explorateur(Tuile tuile) {
        super("Explorateur", tuile, Color.GREEN, 3,"L'Explorateur peut se déplacer et assécher en diagonale. ");
        this.addCarte(new Partie_Tresor(la_statue_du_zephyr));
        this.addCarte(new Partie_Tresor(le_cristal_ardent));
        this.addCarte(new Partie_Tresor(le_calice_de_l_onde));
        this.addCarte(new Partie_Tresor(la_pierre_sacree));
        this.addCarte(new Helicoptere());
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
