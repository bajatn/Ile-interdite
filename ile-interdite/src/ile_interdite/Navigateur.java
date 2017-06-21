/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import java.awt.Color;

/**
 *
 * @author ravinelt
 */
public class Navigateur extends Aventurier {

    public Navigateur( Tuile tuile) {
        super("Navigateur", tuile,Color.YELLOW, 4," Le Navigateur peut déplacer un autre joueur d'une ou deux tuiles adjacentes pour une action. ");
    }


    
}
