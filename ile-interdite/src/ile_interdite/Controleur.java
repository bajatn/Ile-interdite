package ile_interdite;
import static ile_interdite.Etat.*;
import static ile_interdite.TypeMessage.*;
import java.util.ArrayList;

/**
 *
 * @author ravinelt
 */
public class Controleur implements Observateur{
    boolean aDejaAsseche = false;
    private Grille grille;
    private ArrayList<Aventurier> aventuriers;
    private VueAventurier vue;
    private int actionRestantes = 3;
    private int compteurTour = 0;
    private Aventurier joueurCourant;
    private int actionSelect = -1; // Action Selectionnée -> 0 pour deplacer, 1 pour assecher 

    public Controleur() {
        this.grille = new Grille();
        this.aventuriers = new ArrayList<>();
        aventuriers.add(new Pilote(grille.getTuile(4,3)));
        aventuriers.add(new Explorateur(grille.getTuile(5,3)));
        aventuriers.add(new Ingenieur(grille.getTuile(4,1)));
        aventuriers.add(new Plongeur(grille.getTuile(3,2)));
        this.joueurCourant = aventuriers.get(0);
        this.vue = new VueAventurier("Nom",joueurCourant.getRole(),joueurCourant.getCouleur());
        vue.setObservateur(this);        
    }
    
    @Override
    public void traiterMessage (Message message){
        
        if (null != message.getType()) switch (message.getType()) {
            case DEPLACER:
                Afficher(joueurCourant.deplacer());
                actionSelect = 0;
                break;
                
            case ASSECHER:
                Afficher(joueurCourant.assecher());
                actionSelect = 1;
                break;
                
            case CHOIX_TUILE:
                if (actionSelect == 0){
                    joueurCourant.deplacerVersTuile(message.getX(),message.getY());
                    actionRestantes--;  
                } else if (joueurCourant.getRole()=="Ingénieur" && actionSelect==1 && aDejaAsseche==true) {
                    grille.assécherTuile(message.getX(),message.getY());
                    actionRestantes--;
                } else if (joueurCourant.getRole()=="Ingénieur" && actionSelect==1 && aDejaAsseche==false){
                    grille.assécherTuile(message.getX(),message.getY());  
                    this.aDejaAsseche=true;     
                } else if (actionSelect == 1){
                    grille.assécherTuile(message.getX(),message.getY());
                    this.aDejaAsseche = false;
                    actionRestantes--;
                } else {
                    System.out.println("Action impossible");
                }
                
                
                                
                break;
                
            case TERMINER_TOUR:
                System.out.println("TERMINER_TOUR");
                actionRestantes = 0;
                      
                break;
                
            default:
                break;
        }
            
            
        if(actionRestantes < 1){
            compteurTour++;
            joueurCourant = aventuriers.get(compteurTour%4);
            actionRestantes = 3;
            System.out.println("C'est maintenant le tour du "+joueurCourant.getRole());
            this.vue.mettreAJour("Nom",joueurCourant.getRole(),joueurCourant.getCouleur());

            // Pense a faire en sorte que si le joueur etais un pilote on lui met son attribut "aVole" à false
        }
    }

    private void Afficher(ArrayList<Tuile> tuiles) {
        System.out.println("");
        System.out.println("Tuiles dispos :");
        for (Tuile tuile: tuiles){
            System.out.println("tuile " + tuile.getX() + "-" + tuile.getY());
        }
    }
}
    
    

    
    
    
    


