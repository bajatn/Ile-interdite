package ile_interdite;
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

    public void setPosition(Tuile tuile) {
        this.tuileActu = tuile;
        
    }

    public int getPositionY() {
        return tuileActu.getY();
    }
    
    public void setNbAction(int nbAction) {
        this.nbAction = nbAction;
    }
    
    public ArrayList<Tuile> deplacer(){
        ArrayList<Tuile> choixTuile = new ArrayList<Tuile>();
        int positionX = getPositionX();
        int positionY = getPositionY();
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
        int positionX = getPositionX();
        int positionY = getPositionY();
        ArrayList<Tuile> collecTuiles = getTuileActu().calculerAdjacent();
        for (Tuile tuile: collecTuiles){
            if (tuile.getEtat() == Etat.Inonde){
              choixTuile.add(tuile);
            }
        }
        return choixTuile;
    }
    
    public void attendre(){
        
    }
    public void action(){
        
    }
}

