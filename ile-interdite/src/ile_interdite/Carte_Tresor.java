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
public abstract class Carte_Tresor extends Carte{
    
    private String type;

    public Carte_Tresor(String type) {
        this.type = type;
    }
    
    public ArrayList<Tuile> utiliserCarte(Grille grille){
        return null;
    }

    public String getType() {
        return type;
    }

    
}


