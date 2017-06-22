/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;


import static ile_interdite.Etat.*;
import static ile_interdite.Lieu.*;
import java.util.ArrayList;

/**
 *
 * @author bajatn
 */
public class Grille {
    private ArrayList<Tuile> tuiles;
    
    public Grille(Pile_de_Cartes_Inondation pile) {
        tuiles = new ArrayList();        
        this.tuiles.add(new Tuile(1, 1, null, null, this));
        this.tuiles.add(new Tuile(2, 1, null, null, this));
        this.tuiles.add(new Tuile(3, 1, Asseche, Le_Pont_des_Abimes, this));
        this.tuiles.add(new Tuile(4, 1, Asseche, La_Porte_de_Bronze, this));
        this.tuiles.add(new Tuile(5, 1, null, null, this));
        this.tuiles.add(new Tuile(6, 1, null, null, this));
        this.tuiles.add(new Tuile(1, 2, null, null, this));
        this.tuiles.add(new Tuile(2, 2, Asseche, La_Caverne_des_Ombres, this));
        this.tuiles.add(new Tuile(3, 2, Asseche, La_Porte_de_Fer, this));
        this.tuiles.add(new Tuile(4, 2, Asseche, La_Porte_d_Or, this));
        this.tuiles.add(new Tuile(5, 2, Asseche, Les_Falaises_de_l_Oubli, this));
        this.tuiles.add(new Tuile(6, 2, null, null, this));
        this.tuiles.add(new Tuile(1, 3, Asseche, Le_Palais_de_Corail, this));
        this.tuiles.add(new Tuile(2, 3, Asseche, La_Porte_d_Argent, this));
        this.tuiles.add(new Tuile(3, 3, Asseche, Les_Dunes_de_l_Illusion, this));
        this.tuiles.add(new Tuile(4, 3, Asseche, Heliport, this));
        this.tuiles.add(new Tuile(5, 3, Asseche, La_Porte_de_Cuivre, this));
        this.tuiles.add(new Tuile(6, 3, Asseche, Le_Jardin_des_Hurlements, this));
        this.tuiles.add(new Tuile(1, 4, Asseche, La_Foret_Pourpre, this));
        this.tuiles.add(new Tuile(2, 4, Asseche, Le_Lagon_Perdu, this));
        this.tuiles.add(new Tuile(3, 4, Asseche, Le_Marais_Brumeux, this));
        this.tuiles.add(new Tuile(4, 4, Asseche, Observatoire, this));
        this.tuiles.add(new Tuile(5, 4, Asseche, Le_Rocher_Fantome, this));
        this.tuiles.add(new Tuile(6, 4, Asseche, La_Caverne_du_Brasier, this));
        this.tuiles.add(new Tuile(1, 5, null, null, this));
        this.tuiles.add(new Tuile(2, 5, Asseche, Le_Temple_du_Soleil, this));
        this.tuiles.add(new Tuile(3, 5, Asseche, Le_Temple_de_La_Lune, this));
        this.tuiles.add(new Tuile(4, 5, Asseche, Le_Palais_des_Marees, this));
        this.tuiles.add(new Tuile(5, 5, Asseche, Le_Val_du_Crepuscule, this));
        this.tuiles.add(new Tuile(6, 5, null, null, this));
        this.tuiles.add(new Tuile(1, 6, null, null, this));
        this.tuiles.add(new Tuile(2, 6, null, null, this));
        this.tuiles.add(new Tuile(3, 6, Asseche, La_Tour_du_Guet, this));
        this.tuiles.add(new Tuile(4, 6, Asseche, Le_Jardin_des_Murmures, this));
        this.tuiles.add(new Tuile(5, 6, null, null, this));
        this.tuiles.add(new Tuile(6, 6, null, null, this));
        for (int i=0; i<6; i++){
            TireCarteInondation(pile);
        }
    }
    
    public ArrayList<Tuile> getTuiles() {
        return tuiles;
    }
    
    
    
    public Tuile getTuile(int x, int y){
        for (Tuile tuile: tuiles){
            if (tuile.getX() == x && tuile.getY() == y){
                return tuile;
            }
        };
        return null;
    }
    
    public Tuile getTuile(Lieu lieu) {
        for (Tuile tuile: tuiles){
            if (tuile.getNom() == lieu){
                return tuile;
            }
        };
        return null;
    }
      
    public void assécherTuile(int x, int y){
        if (getTuile(x, y) != null && getTuile(x, y).getEtat() != Submerge){
            getTuile(x, y).setEtat(Asseche);
            System.out.println("La tuile " + x + "-" + y + " a été asséchée");System.out.println("");
        }
    }
    
    public void inonderTuile(Tuile tuile){
        if (tuile.getEtat() == Asseche){
            tuile.setEtat(Inonde);
        } else if (tuile.getEtat() == Inonde){
            tuile.setEtat(Submerge);
            if (tuile.getNom() == Heliport){
                System.out.println("///////////////");
                System.out.println(" Partie perdue");
                System.out.println("///////////////");
            }
// ça s'est quand on a une case qui se submerge sous un aventurier il faut qu'il bouge, mais ça fait tout buger...
      /*    if (!(tuile.getAventuriers().isEmpty())){
                // Il y a un ou plusieurs aventurier sur la case
                for (Aventurier aventurier: tuile.getAventuriers()){
                    if (!(aventurier.deplacer().isEmpty())){
                        // L'aventurier est deplacer vers une case aleatoire
                        Tuile tuileCible = aventurier.deplacer().get((int)Math.random()*aventurier.deplacer().size());
                        aventurier.deplacerVersTuile(tuileCible.getX(), tuileCible.getX());
                    } else {
                        // Partie perdue !
                        System.out.println("Partie perdue, un aventurier s'est noyé !");
                    }
                }
            }*/
        }
    }

    public void TireCarteInondation(Pile_de_Cartes_Inondation pile) {
        Carte carte;
        carte = pile.pioche();
        Carte_Inondation elem = (Carte_Inondation) carte;
        Lieu lieu = elem.getLieu();
        Tuile tuile = getTuile(lieu);
        inonderTuile(tuile);
        if (tuile.getEtat() != Submerge){
           pile.defausseCarte(carte); 
        }
    }   
    
    public void Inondation(Pile_de_Cartes_Inondation pile, Niveau_Eau niv) {
        Carte carte;
        for (int i=0; i<niv.getPalier(); i++){
            TireCarteInondation(pile);
        }
    }   
}
