/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import static ile_interdite.Lieu.*;
import static ile_interdite.Type_Tresor.*;
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
    private Type_Tresor tresor;
    private ArrayList<Aventurier> aventuriers;
    
    ////////////////////////////////////////////////////

    public Tuile(int x, int y, Etat etat, Lieu nom, Grille grille) {
        this.x = x;
        this.y = y;
        this.etat = etat;
        this.nom = nom;
        this.grille = grille;
        this.aventuriers = new ArrayList<>();
        
        
        
        if (this.nom==La_Caverne_des_Ombres || this.nom==La_Caverne_du_Brasier){
            this.tresor = le_cristal_ardent;
        }
        else if (this.nom==Le_Jardin_des_Hurlements || this.nom==Le_Jardin_des_Murmures){
            this.tresor = la_statue_du_zephyr;
        }
        else if (this.nom==Le_Temple_de_La_Lune || this.nom==Le_Temple_du_Soleil){
            this.tresor = la_pierre_sacree;
        }
        else if (this.nom ==Le_Palais_des_Marees || this.nom ==Le_Palais_de_Corail){
            this.tresor = le_calice_de_l_onde;
        }
        else {this.tresor = null;}
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
    public Grille getGrille() {
        return grille;
    }

    public Type_Tresor getTresor() {
        return tresor;
    }

    public void setTresor(Type_Tresor tresor) {
        this.tresor = tresor;
    }
    
    public void addAventurier(Aventurier aventurier){
        this.aventuriers.add(aventurier);
    }
    public void removeAventurier(Aventurier aventurier){
        this.aventuriers.remove(aventurier);
    }
    public ArrayList<Aventurier> getAventuriers() {
        return aventuriers;
    }
    
    
    
    
    public void setEtat(Etat etat) {
        this.etat = etat;
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
    
        public ArrayList<Tuile> calculerAdjacent(){
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