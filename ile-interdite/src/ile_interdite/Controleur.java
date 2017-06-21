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
    boolean aDejaVole = false;
    private Grille grille;
    private ArrayList<Aventurier> aventuriers;
    private FenetreIHM vue;
    private int actionRestantes = 3;
    private int compteurTour = 0;
    private Aventurier joueurCourant;
// Action Selectionnée -> 0 pour deplacer, 1 pour assecher, 2 pour donner, 3 pour carte helico, 4 pour carte sable
    private int actionSelect = -1;
// defausse = 0 >> Normal
// defausse = 1 >> Le joueur doit se defausser de certaines cartes
    private int defausse = 0;
    private Pile_de_Cartes_Tresor pileTresor;
    private Pile_de_Cartes_Inondation pileInnondation;
    private Niveau_Eau niv;
    
    public Controleur() {
        this.grille = new Grille();
        this.aventuriers = new ArrayList<>();
        this.pileTresor = new Pile_de_Cartes_Tresor();
        this.pileInnondation = new Pile_de_Cartes_Inondation();
        aventuriers.add(new Pilote(grille.getTuile(4,3)));
        aventuriers.add(new Explorateur(grille.getTuile(5,3)));
        aventuriers.add(new Ingenieur(grille.getTuile(4,1)));
        aventuriers.add(new Plongeur(grille.getTuile(3,4)));
        aventuriers.add(new Messager(grille.getTuile(3,2)));
        aventuriers.add(new Navigateur(grille.getTuile(4,2)));
        this.joueurCourant = aventuriers.get(0);
        this.vue = new FenetreIHM();
        vue.setObservateur(this);
        
    }
    
    @Override
    public void traiterMessage(Message message){
        
        if (joueurCourant.getRole()=="Navigateur"){
            actionRestantes = 4;
        }
        
        if (null != message.getType()) switch (message.getType()) {
            case DEPLACER:
                Afficher(joueurCourant.deplacer());
                actionSelect = 0;
                break;
                
            case ASSECHER:
                Afficher(joueurCourant.assecher());
                actionSelect = 1;
                break;
                
            case CHOIX:
                
                    // Deplacer
                if (actionSelect == 0){
                    joueurCourant.deplacerVersTuile(message.getX(),message.getY());
                    actionRestantes--;  
                    
                    // Assecher (ingenieur)
                } else if (joueurCourant.getRole()=="Ingénieur" && actionSelect==1 && aDejaAsseche==true) {
                    grille.assécherTuile(message.getX(),message.getY());
                    actionRestantes--;
                } else if (joueurCourant.getRole()=="Ingénieur" && actionSelect==1 && aDejaAsseche==false){
                    grille.assécherTuile(message.getX(),message.getY());  
                    this.aDejaAsseche=true;     
                    
                    // Assecher
                } else if (actionSelect == 1){
                    grille.assécherTuile(message.getX(),message.getY());
                    this.aDejaAsseche = false;
                    actionRestantes--;
                    
                    // Donner carte
                } else if (actionSelect == 2){
                    joueurCourant.transfererCarte(message.getAventurier(), message.getCarte());
                    actionRestantes--;

                    // Helico
                } else if (actionSelect == 3){
                    for (Aventurier aventurier : aventuriers){
                        if (aventurier.getTuileActu() == joueurCourant.getTuileActu()){
                            aventurier.deplacerVersTuile(message.getX(), message.getY());
                        }
                    }
                    joueurCourant.deplacerVersTuile(message.getX(),message.getY());
                    
                    // Sac de sable
                } else if (actionSelect == 4){
                    grille.assécherTuile(message.getX(),message.getY());
                    
                } else {
                    System.out.println("Action impossible");
                }            
                break;
                
                
                
            case TERMINER_TOUR:
                System.out.println("TERMINER_TOUR");
                actionRestantes = 0;
                break;
                
            case DONNER:
                Afficher2(joueurCourant.donnerCarte());
                actionSelect = 2;
                break;
                
            case RECUPERER_TRESOR:
                joueurCourant.prendreTresor();
                break;
                
            case CARTE:
                if (defausse == 1){
                    joueurCourant.defausseCarteMain(message.getCarte(), pileTresor);
                    if (joueurCourant.getMain().size()<=4) {
                        defausse = 0;
                    }

                } else {
                    Afficher(message.getCarte().utiliserCarte(grille));
                    if (message.getCarte().getType() == "Helicoptere"){
                        actionSelect = 3;
                    } else if (message.getCarte().getType() == "Sac_de_sable"){
                        actionSelect = 4;
                    }
                }
                break;
                
             case TERMINER_JEU:
                int aventurierPresent = 0;
                for (Aventurier aventurier: aventuriers){
                    if(aventurier.getTuileActu() == grille.getTuile(Lieu.Heliport)){
                        aventurierPresent = aventurierPresent++;
                    }
                }
                if (aventurierPresent == aventuriers.size()){
                    boolean carteHelico = false;
                    for (Aventurier aventurier: aventuriers){
                        for (Carte_Tresor carte: aventurier.getMain()){
                            if(carte.getType()=="Helicoptere"){
                                carteHelico = true;
                            }
                        }
                    }
                    if (carteHelico == true){
                        // GAGNE !
                        System.out.println("Partie gagnée, felicitation !");
                    } else {
                        // PERDU !
                        System.out.println("Partie perdue !");
                    }
                }
                break;
                
            default:
                break;
        }
            
            
        if(actionRestantes < 1){
            
            if (joueurCourant.getRole() == "Pilote"){
                joueurCourant.setAVole(false);
            }
            compteurTour++;
            joueurCourant = aventuriers.get(compteurTour%6);
            actionRestantes = 3;
            System.out.println("C'est maintenant le tour du "+joueurCourant.getRole());
            // PLUS LA BONNE VUE this.vue.mettreAJour("Nom",joueurCourant.getRole(),joueurCourant.getCouleur());
            
            joueurCourant.piocheCarteTresor(pileTresor, pileInnondation, niv);
            joueurCourant.piocheCarteTresor(pileTresor, pileInnondation, niv);
            grille.Inondation(pileInnondation, niv);
            
            if (joueurCourant.getMain().size()>4) {
                defausse = 1;
            }
        }
    }

    private void Afficher(ArrayList<Tuile> tuiles) {
        System.out.println("");
        System.out.println("Vous etes sur la case: " + joueurCourant.getPositionX() + "-" + joueurCourant.getPositionY() + " : " + joueurCourant.getTuileActu().getNom());
        System.out.println("");
        System.out.println("Tuiles dispos :");
        for (Tuile tuile: tuiles){
            System.out.println("tuile " + tuile.getX() + "-" + tuile.getY() + " : " + tuile.getNom());
        }
    }
    
    private void Afficher2(ArrayList<Aventurier> aventuriers) {
        System.out.println("");
        System.out.println("Vous etes sur la case: " + joueurCourant.getPositionX() + "-" + joueurCourant.getPositionY() + " : " + joueurCourant.getTuileActu().getNom());
        System.out.println("");
        System.out.println("aventuriers dispos :");
        for (Aventurier aventurier: aventuriers){
            System.out.println("- " + aventurier.getRole());
        }
    }
}
    
    

    
    
    
    


