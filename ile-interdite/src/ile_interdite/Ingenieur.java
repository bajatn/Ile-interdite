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

public class Ingenieur  extends Aventurier{

    public Ingenieur(Tuile tuile) {
        super("Ingénieur", tuile,Color.RED, 3,"L'Ingénieur peut assécher 2 tuiles pour une action. ");
    }
}