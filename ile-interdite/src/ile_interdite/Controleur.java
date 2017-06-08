package ile_interdite;
import static ile_interdite.TypeMessage.*;
import java.util.ArrayList;

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
    private Aventurier joueurCourant;

    public Controleur() {
        this.grille = new Grille();
        this.aventuriers = new ArrayList<>();
        aventuriers.add(new Pilote(grille.getTuile(4,3)));
        aventuriers.add(new Explorateur(grille.getTuile(5,3)));
        aventuriers.add(new Ingenieur(grille.getTuile(4,1)));
        aventuriers.add(new Plongeur(grille.getTuile(3,2)));
        this.vue = new VueAventurier();
        this.joueurCourant = new Aventurier();
    }
    
    public void traiterMessage (Message message){
        
        if (null != message.getType()) switch (message.getType()) {
            case DEPLACER:
                message.getAventurier().deplacer();
                break;
            case ASSECHER:
                message.getAventurier().assecher();
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
            joueurCourant = aventuriers.get(compteurTour%4);
        }
    }
}
    
    

    
    
    
    

