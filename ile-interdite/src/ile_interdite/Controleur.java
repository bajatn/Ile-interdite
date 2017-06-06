package ile_interdite;
import static ile_interdite.TypeMessage.*;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ravinelt
 */
public class Controleur {
    
    private Grille grille;
    private ArrayList<Aventurier> aventuriers;
    private VueAventurier vue;
    
    public void tour(){
        
    }
    
    
    public void traiterMessage (Message message){
        if (message.getType() == DEPLACER) {
            message.getAventurier().deplacer();
        }
        if (message.getType() == ASSECHER) {
            message.getAventurier().assecher();
        }
        if (message.getType() == DEPLACER_CHOIX_TUILE) {
            message.getAventurier().deplacerVersTuile(message.getX(),message.getY());
        }
        if (message.getType() == ASSECHER_CHOIX_TUILE) {
            grille.assécherTuile(message.getX(),message.getY());
        }
    }
    
    

    
    
    
    
}
