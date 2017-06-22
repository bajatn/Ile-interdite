/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import static ile_interdite.Type_Tresor.*;
import java.util.ArrayList;

/**
 *
 * @author bajatn
 */
public class Pile_de_Cartes_Tresor extends Pile_de_Cartes {
    
    
    public Pile_de_Cartes_Tresor(){
        super();    
        for (int i=1; i<=27; i++){
            if (i <= 2){
                this.getCartes().add(new Montee_des_eaux());
            } else if (i <= 4){
                this.getCartes().add(new Sac_de_sable());
            } else if (i <= 7){
                this.getCartes().add(new Helicoptere());
            } else if (i <= 12){
                this.getCartes().add(new Partie_Tresor(la_statue_du_zephyr));
            } else if (i <= 17){
                this.getCartes().add(new Partie_Tresor(le_cristal_ardent));
            } else if (i <= 22){
                this.getCartes().add(new Partie_Tresor(le_calice_de_l_onde));
            } else {
                this.getCartes().add(new Partie_Tresor(la_pierre_sacree));
            } 
        }
        setCarte_dessus();
    }
}