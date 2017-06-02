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
public class Tuile {
 
    private int x;
    private int y;
    private Etat etat;
    private Lieu nom;
    private Grille grille;
    
    ////////////////////////////////////////////////////

    public Tuile(int x, int y, Etat etat, Lieu nom) {
        this.x = x;
        this.y = y;
        this.etat = etat;
        this.nom = nom;
    }

    
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Lieu getNom() {
        return nom;
    }
    public Etat getEtat() {
        return etat;
    }
    
    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    
    public void addToListeCasesDispo(){
        // Pour Marc et Thomas
    }
    
    public ArrayList<Tuile> calculerAutours(){
        ArrayList<Tuile> result = new ArrayList<>();
        for (Tuile tuile: grille.getTuiles()){
            if ((tuile.getX() == x) && (tuile.getY() == (y+1)) || 
                (tuile.getX() == x) && (tuile.getY() == (y-1)) || 
                (tuile.getX() == (x+1)) && (tuile.getY() == y) || 
                (tuile.getX() == (x-1)) && (tuile.getY() == y) || 
                (tuile.getX() == (x+1)) && (tuile.getY() == (y+1)) ||
                (tuile.getX() == (x-1)) && (tuile.getY() == (y+1)) ||
                (tuile.getX() == (x+1)) && (tuile.getY() == (y-1)) ||
                (tuile.getX() == (x-1)) && (tuile.getY() == (y-1))) 
            {
                result.add(tuile);
            }
        }
        return result;
    }
    
        public ArrayList<Tuile> calculerAdjacent(int x, int y){
        ArrayList<Tuile> result = new ArrayList<>();
        for (Tuile tuile: grille.getTuiles()){
            if ((tuile.getX() == x) && (tuile.getY() == (y+1)) || 
                (tuile.getX() == x) && (tuile.getY() == (y-1)) || 
                (tuile.getX() == (x+1)) && (tuile.getY() == y) ||
                (tuile.getX() == (x-1)) && (tuile.getY() == y)) 
            {
                result.add(tuile);
            }
        }
        return result;
    }
    
}
