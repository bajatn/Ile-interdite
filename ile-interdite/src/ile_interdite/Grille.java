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
    
    public Grille(ArrayList<Tuile> tuiles) {
        
     /*                 // Essaie boucle for pour la création de la grille
        Lieu lieuElem 
        for (int i=1; i<=36; i++) {
            Tuile tuile = new Tuile(i%6, i, Asséché, Lieu[1]);
        }
     */
    
        this.tuiles.add(new Tuile(1, 1, null, null));
        this.tuiles.add(new Tuile(2, 1, null, null));
        this.tuiles.add(new Tuile(3, 1, Asseche, Le_Pont_des_Abimes));
        this.tuiles.add(new Tuile(4, 1, Asseche, La_Porte_de_Bronze));
        this.tuiles.add(new Tuile(5, 1, null, null));
        this.tuiles.add(new Tuile(6, 1, null, null));
        this.tuiles.add(new Tuile(1, 2, null, null));
        this.tuiles.add(new Tuile(2, 2, Asseche, La_Caverne_des_Ombres));
        this.tuiles.add(new Tuile(3, 2, Asseche, La_Porte_de_Fer));
        this.tuiles.add(new Tuile(4, 2, Asseche, La_Porte_d_Or));
        this.tuiles.add(new Tuile(5, 2, Asseche, Les_Falaises_de_l_Oubli));
        this.tuiles.add(new Tuile(6, 2, null, null));
        this.tuiles.add(new Tuile(1, 3, Asseche, Le_Palais_de_Corail));
        this.tuiles.add(new Tuile(2, 3, Asseche, La_Porte_d_Argent));
        this.tuiles.add(new Tuile(3, 3, Asseche, Les_Dunes_de_l_Illusion));
        this.tuiles.add(new Tuile(4, 3, Asseche, Heliport));
        this.tuiles.add(new Tuile(5, 3, Asseche, La_Porte_de_Cuivre));
        this.tuiles.add(new Tuile(6, 3, Asseche, Le_Jardin_des_Hurlements));
        this.tuiles.add(new Tuile(1, 4, Asseche, La_Foret_Pourpre));
        this.tuiles.add(new Tuile(2, 4, Asseche, Le_Lagon_Perdu));
        this.tuiles.add(new Tuile(3, 4, Asseche, Le_Marais_Brumeux));
        this.tuiles.add(new Tuile(4, 4, Asseche, Observatoire));
        this.tuiles.add(new Tuile(5, 4, Asseche, Le_Rocher_Fantome));
        this.tuiles.add(new Tuile(6, 4, Asseche, La_Caverne_du_Brasier));
        this.tuiles.add(new Tuile(1, 5, null, null));
        this.tuiles.add(new Tuile(2, 5, Asseche, Le_Temple_du_Soleil));
        this.tuiles.add(new Tuile(3, 5, Asseche, Le_Temple_de_La_Lune));
        this.tuiles.add(new Tuile(4, 5, Asseche, Le_Palais_des_Marees));
        this.tuiles.add(new Tuile(5, 5, Asseche, Le_Val_du_Crepuscule));
        this.tuiles.add(new Tuile(6, 5, null, null));
        this.tuiles.add(new Tuile(1, 6, null, null));
        this.tuiles.add(new Tuile(2, 6, null, null));
        this.tuiles.add(new Tuile(3, 6, Asseche, La_Tour_du_Guet));
        this.tuiles.add(new Tuile(4, 6, Asseche, Le_Jardin_des_Murmures));
        this.tuiles.add(new Tuile(5, 6, null, null));
        this.tuiles.add(new Tuile(6, 6, null, null));
    }
    
    public ArrayList<Tuile> getTuiles() {
        return tuiles;
    }
    
    
    public void addToCaseDispo() {
        // Pour marc et Thomas :*
    }
    
    public Tuile getTuile(int x, int y){
        for (Tuile tuile: tuiles){
            if (tuile.getX() == x && tuile.getY() == y){
                return tuile;
            }
        };
        return null;
    }
    
    public void assécherTuile(int x, int y){
        if (getTuile(x, y) != null){
            getTuile(x, y).setEtat(Asseche);
        }
    }
    
}
