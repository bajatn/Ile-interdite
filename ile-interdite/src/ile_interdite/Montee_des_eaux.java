/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

/**
 *
 * @author bajatn
 */
public class Montee_des_eaux extends Carte_Tresor {

    public Montee_des_eaux() {
        super("Montee_des_eaux");
    }
    
    public void carteTiree(Pile_de_Cartes_Tresor pileT, Pile_de_Cartes_Inondation pileI, Niveau_Eau niv){
            pileI.ChangerPile();
            niv.monteNiveau();
            pileT.defausseCarte(this);
    }
    
}
