/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;
/**
 *
 * @author ravinelt
 */
public class Message {
    private TypeMessage type;
    private Carte_Tresor carte;
    private Aventurier aventurier;
    private int x;
    private int y;
    private Boolean deplaceCarte;

    public Message(TypeMessage type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    Message() {
    }

    public Aventurier getAventurier() {
        return aventurier;
    }

    public TypeMessage getType() {
        return type;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Carte_Tresor getCarte() {
        return carte;
    }

    public Boolean getDeplaceCarte() {
        return deplaceCarte;
    }
    
    
    
    public void setType(TypeMessage type) {
        this.type = type;
    }
    
    public void setCoordonees(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setCarte(Carte_Tresor carte) {
        this.carte = carte;
    }

    public void setAventurier(Aventurier aventurier) {
        this.aventurier = aventurier;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDeplaceCarte(Boolean deplaceCarte) {
        this.deplaceCarte = deplaceCarte;
    }
    
    
    

    


    
    
}
