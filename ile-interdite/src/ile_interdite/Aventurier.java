package ile_interdite;
import static ile_interdite.Etat.*;
import java.awt.Color;
import java.util.*;

/**
 *
 * @author ravinelt
 */
public class Aventurier {
    private String role;
    private Tuile tuileActu;
    private Color couleur;
    

    public Aventurier(String role, Tuile tuile, Color couleur) {
        this.role = role;
        this.tuileActu = tuile;
        this.couleur = couleur;
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
        for (Tuile tuile: tuileActu.getGrille().getTuiles()){
            if (tuile.getX() == x && tuile.getY() == y){
                tuileVisee = tuile;
            }
        }
        if (tuileVisee != null && tuileVisee.getEtat() != Submerge){
            setTuileActu(tuileVisee);
        }
        
        
    }  
}

