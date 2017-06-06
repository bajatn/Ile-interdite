package ile_interdite;
import static ile_interdite.Etat.*;
import java.util.*;

/**
 *
 * @author ravinelt
 */
public class Aventurier {
    private int nbAction;
    private String role;
    
    private Tuile tuileActu;

    
    
    

    public Aventurier(int nbAction, String role, Tuile tuile) {
        this.nbAction = nbAction;
        this.role = role;
        this.tuileActu = tuile;
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
    public void setNbAction(int nbAction) {
        this.nbAction = nbAction;
    }
    public void setTuileActu(Tuile tuileActu) {
        this.tuileActu = tuileActu;
    }
    
    public ArrayList<Tuile> deplacer(){
        ArrayList<Tuile> choixTuile = new ArrayList<Tuile>();
        // int positionX = getPositionX();
        // int positionY = getPositionY();
        ArrayList<Tuile> collecTuiles = getTuileActu().calculerAdjacent(); // addToCaseDispo indispensable ???
        for (Tuile tuile: collecTuiles){
            if (tuile.getEtat() == Etat.Asseche){
              choixTuile.add(tuile);
            }
        }
        return choixTuile;        
    }
    
    public ArrayList<Tuile> assecher(){
        ArrayList<Tuile> choixTuile = new ArrayList<Tuile>();
        //int positionX = getPositionX();
        //int positionY = getPositionY();
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

    
    
    public void attendre(){
        
    }
    public void action(){
        
    }
}

