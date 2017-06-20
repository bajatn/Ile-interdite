/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

/**
 *
 * @author ravinelt
 */
public class Carte_Inondation extends Carte{
    private Lieu lieu;

    public Carte_Inondation(Lieu lieu) {
        this.lieu = lieu;
    }

    public Lieu getLieu() {
        return lieu;
    }
    
}
