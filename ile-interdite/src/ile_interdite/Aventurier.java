package ile_interdite;
import static ile_interdite.Etat.*;
import java.awt.Color;
import java.util.*;

/**
 *
 * @author ravinelt
 */
public abstract class Aventurier {
    private String role;
    private Tuile tuileActu;
    private Color couleur;
    private ArrayList<Type_Tresor> tresor;
    

    public Aventurier(String role, Tuile tuile, Color couleur) {
        this.role = role;
        this.tuileActu = tuile;
        this.couleur = couleur;
        this.tresor= null;
    }

    public Color getCouleur() {
        return couleur;
    }

    public Tuile getTuileActu() {
        return tuileActu;
    }
    public int getPositionX() {
        return tuileActu.getX();
    }
    public String getRole() {
        return role;
    }
    public int getPositionY() {
        return tuileActu.getY();
    }
    
    public void setPosition(Tuile tuile) {
        this.tuileActu = tuile;
    }

    public void setTuileActu(Tuile tuileActu) {
        this.tuileActu = tuileActu;
    }
    
    public ArrayList<Tuile> deplacer(){
        ArrayList<Tuile> choixTuile = new ArrayList<Tuile>();
        ArrayList<Tuile> collecTuiles = getTuileActu().calculerAdjacent();
        for (Tuile tuile: collecTuiles){
            if (tuile.getEtat() == Etat.Asseche || tuile.getEtat() == Etat.Inonde){
              choixTuile.add(tuile);
            }
        }
        return choixTuile;        
    }
    
    public ArrayList<Tuile> assecher(){
        ArrayList<Tuile> choixTuile = new ArrayList<Tuile>();
        ArrayList<Tuile> collecTuiles = getTuileActu().calculerAdjacent();
        for (Tuile tuile: collecTuiles){
            if (tuile.getEtat() == Etat.Inonde){
              choixTuile.add(tuile);
            }
        }
        return choixTuile;
    }
    
    public void deplacerVersTuile(int x, int y){
        Tuile tuileVisee = null;
        tuileVisee = this.getTuileActu().getGrille().getTuile(x, y);
        setTuileActu(tuileVisee);
        System.out.println("Votre Aventurier s'est déplacé en " + x + "-" + y);System.out.println("");
    }  

    
    public void setAVole(boolean b) {
    }
    
    public void prendreTresor(){
        this.tresor.add(getTuileActu().getTresor());
        getTuileActu().setTresor(null);
    }

    public Aventurier donnerCarte(){
        ArrayList<Aventurier> choixAventurier = new ArrayList<Aventurier>();
        ArrayList<Aventurier> collectAventuriers = ;
        for (Aventurier aventurier: collectAventuriers){
            if (){
              choixAventurier.add(tuile);
            }
        }
        return choixTuile;   
    }


}
