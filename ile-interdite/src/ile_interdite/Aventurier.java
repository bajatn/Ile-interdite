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
    
    public int getPositionX() {
        return tuileActu.getX();
    }

    public void setPositionX() {
        
    }

    public int getPositionY() {
        return tuileActu.getY();
    }

    public void setPositionY(int positionY) {
      
    }
    
    public void setNbAction(int nbAction) {
        this.nbAction = nbAction;
    }
    
    public void deplacer(){
        int posX = getPositionX();
        int posY = getPositionY();
   
        
        ArrayList<Tuile> tuilesDispo = calculerAdjacent(posX, posY);
        
        
        
    }
    
    public void assecher(){
        
    }
    
    public void attendre(){
        
    }
    public void action(){
        
    }
}

