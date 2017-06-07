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
    private int actionRestantes = 3;
    private int compteurTour = 0;
    
    
    public void traiterMessage (Message message){
        
        if (null != message.getType()) switch (message.getType()) {
            case DEPLACER:
                message.getAventurier().deplacer();
                actionRestantes--;
                break;
            case ASSECHER:
                message.getAventurier().assecher();
                actionRestantes--;
                break;
            case DEPLACER_CHOIX_TUILE:
                message.getAventurier().deplacerVersTuile(message.getX(),message.getY());
                actionRestantes--;
                break;
            case ASSECHER_CHOIX_TUILE:
                grille.assécherTuile(message.getX(),message.getY());
                actionRestantes--;
                break;
            default:
                break;
        }
            if(actionRestantes < 1){
                compteurTour++;
                aventuriers.get(compteurTour%4);
                        }
            }
    }
    
    

    
    
    
    

