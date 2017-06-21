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
public abstract class Pile_de_Cartes {
    private ArrayList<Carte> cartes ;
    private ArrayList<Carte> defausse;
    private Carte carte_dessus;

    
    public Pile_de_Cartes() {
        this.cartes = new ArrayList<>();
        this.defausse = new ArrayList<>();
    }
    
    public ArrayList<Carte> getCartes() {
        return cartes;
    }

    public ArrayList<Carte> getDefausse() {
        return defausse;
    }

    public Carte getCarte_dessus() {
        return carte_dessus;
    }
    
    public void addCarte(Carte carte){
        cartes.add(carte);
    }
    
    public void defausseCarte(Carte carte){
        defausse.add(carte);
    }
    
    public void setCarte_dessus(){
        carte_dessus = cartes.get((int)(Math.random()*cartes.size()));
    }

    public Carte pioche() {
        Carte result = carte_dessus;
        cartes.remove(carte_dessus);
        if (cartes.isEmpty()){
            this.ChangerPile();
        }
        setCarte_dessus();
        return result;

    }
    
    public void ChangerPile(){
        for(Carte carte : defausse){
           cartes.add(carte);
        }
        setCarte_dessus();
        defausse.clear();
    }
}
