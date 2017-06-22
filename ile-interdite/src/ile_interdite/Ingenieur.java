/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import static ile_interdite.Type_Tresor.*;
import java.awt.Color;


/**
 *
 * @author ravinelt
 */

public class Ingenieur  extends Aventurier{

    public Ingenieur(Tuile tuile) {
        super("Ingénieur", tuile,Color.RED, 3,"L'Ingénieur peut assécher 2 tuiles pour une action. ");
        // En enlevant ça pense à aussi enlever la ligne 8 qui importe Type_Tresor
        this.addTresor(la_statue_du_zephyr);
        this.addTresor(le_cristal_ardent);
        this.addTresor(le_calice_de_l_onde);
        this.addTresor(la_pierre_sacree);
    }
}