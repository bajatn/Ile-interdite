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
    private int x;
    private int y;
    private Aventurier aventurier;

    public Message(TypeMessage type, int x, int y, Aventurier aventurier) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.aventurier = aventurier;
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

    public Aventurier getAventurier() {
        return aventurier;
    }
    
    
}
