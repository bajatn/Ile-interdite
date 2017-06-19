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
public class Messager extends Aventurier {

    public Messager(Tuile tuile) {
        super("Messager", tuile, Color.GRAY);
    }
    
    @Override
    public ArrayList<Aventurier> donnerCarte(){
        ArrayList<Aventurier> choixAventuriers = new ArrayList<Aventurier>();
        ArrayList<Tuile> collecTuiles = getTuileActu().getGrille().getTuiles();
        for (Tuile tuile: collecTuiles){
            if (!(tuile.getAventuriers().isEmpty())){
                for (Aventurier elem : tuile.getAventuriers()){
                    choixAventuriers.add(elem); 
                }
            }
        }
        return choixAventuriers;   
    }
}
