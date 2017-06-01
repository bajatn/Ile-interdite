package ile_interdite;
import java.util.*;

/**
 *
 * @author ravinelt
 */
public class Aventurier {
    private int nbAction;
    private String role;
    private int positionX;
    private int positionY;
    

    public Aventurier(int nbAction, String role, int positionX, int positionY) {
        this.nbAction = nbAction;
        this.role = role;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setNbAction(int nbAction) {
        this.nbAction = nbAction;
    }
    
    public void deplacer(){
        int posX = getPositionX();
        int posY = getPositionY();
        
        ArrayList<Tuile> tuilesDispo = calculerAdjacent();
        
        
        
        
        
    }
    
    public void assecher(){
        
    }
    
    public void attendre(){
        
    }
    public void action(){
        
    }
}

