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
    private int x;
    private int y;

    public Message(TypeMessage type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    Message() {
    }

    public TypeMessage getType() {
        return type;
    }

    public void setType(TypeMessage type) {
        this.type = type;
    }
    
    public void setCoordonees(int x, int y){
        this.x = x;
        this.y = y;
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


    
    
}
