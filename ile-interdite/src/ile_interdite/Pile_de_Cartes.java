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
        this.carte_dessus = carte_dessus;
        defausse = new ArrayList<>();
    }
    
    public ArrayList<Carte> getCartes() {
        return cartes;
    }
    
    public void addCarte(Carte carte){
        cartes.add(carte);
    }
    
    public void DefausseCarte(Carte carte){
        cartes.remove(carte);
        defausse.add(carte);
    }
    
    public void setCarte_dessus(){
        carte_dessus = cartes.get((int)Math.random()*cartes.size());
    }

    public Carte pioche() {
        Carte result = carte_dessus;
        DefausseCarte(carte_dessus);
        setCarte_dessus();
        return result;
    }
    
    public void ChangerPile(){
        if(cartes.isEmpty()){
            for(Carte carte : defausse){
               cartes.add(carte);
            }
            defausse = new ArrayList<>(); 
        }
   }
}
