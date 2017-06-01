/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite;

/**
 *
 * @author bajatn
 */
public class Tuile {
 
    private int x;
    private int y;
    private Etat etat;
    private Lieu nom;
    
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
    
    
    
}
