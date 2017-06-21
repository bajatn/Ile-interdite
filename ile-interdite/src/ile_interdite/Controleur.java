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
    private int actionUtilise = 0;
    private int compteurTour = 0;
    private Aventurier joueurCourant;
// Action Selectionnée -> 0 pour deplacer, 1 pour assecher, 2 pour donner, 3 pour carte helico, 4 pour carte sable
    private int actionSelect = -1;
// defausse = 0 >> Normal
// defausse = 1 >> Le joueur doit se defausser de certaines cartes
    private int defausse = 0;
    private Pile_de_Cartes_Tresor pileTresor;
    private Pile_de_Cartes_Inondation pileInondation;
    private Niveau_Eau niv;
    
    public Controleur() {
        this.pileTresor = new Pile_de_Cartes_Tresor();
        this.pileInondation = new Pile_de_Cartes_Inondation();
        this.grille = new Grille(pileInondation);
        this.aventuriers = new ArrayList<>();
        aventuriers.add(new Pilote(grille.getTuile(4,3)));
        this.niv = new Niveau_Eau(1);
        aventuriers.add(new Explorateur(grille.getTuile(5,3)));
        aventuriers.add(new Ingenieur(grille.getTuile(4,1)));
        aventuriers.add(new Plongeur(grille.getTuile(3,4)));
        aventuriers.add(new Messager(grille.getTuile(3,2)));
        aventuriers.add(new Navigateur(grille.getTuile(4,2)));
        this.joueurCourant = aventuriers.get(1);
        this.vue = new FenetreIHM(this,grille);
        vue.setObservateur(this);
        joueurCourant.piocheCarteTresor(pileTresor, pileInondation, niv);
        joueurCourant.piocheCarteTresor(pileTresor, pileInondation, niv);
        
    }
    
    @Override
    public void traiterMessage(Message message){
        
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
                    actionUtilise++;  
                    
                    // Assecher (ingenieur)
                } else if (joueurCourant.getRole()=="Ingénieur" && actionSelect==1 && aDejaAsseche==true) {
                    grille.assécherTuile(message.getX(),message.getY());
                    actionUtilise++;  
                } else if (joueurCourant.getRole()=="Ingénieur" && actionSelect==1 && aDejaAsseche==false){
                    grille.assécherTuile(message.getX(),message.getY());  
                    this.aDejaAsseche=true;     
                    
                    // Assecher
                } else if (actionSelect == 1){
                    grille.assécherTuile(message.getX(),message.getY());
                    this.aDejaAsseche = false;
                    actionUtilise++;  
                    
                    // Donner carte
                } else if (actionSelect == 2){
                    joueurCourant.transfererCarte(message.getAventurier(), message.getCarte());
                    actionUtilise++;  

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
                actionUtilise = 10;
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
                // J'ai oublier de verifier que les aventuriers possèdent bien les quatres tresors !!  
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
            
            
        if(actionUtilise >= joueurCourant.getNbAction()){
            if (joueurCourant.getRole() == "Pilote"){
                joueurCourant.setAVole(false);
            }
            compteurTour++;
            joueurCourant = aventuriers.get(compteurTour%6);
            actionUtilise = 0;
            System.out.println("C'est maintenant le tour du "+joueurCourant.getRole()); 
            joueurCourant.piocheCarteTresor(pileTresor, pileInondation, niv);
            joueurCourant.piocheCarteTresor(pileTresor, pileInondation, niv);
            grille.Inondation(pileInondation, niv);
            vue.getAfficherCases().MettreAjourCases(this, grille);
            
            if (joueurCourant.getMain().size()>4) {
                defausse = 1;
            }
            vue.setAfficheJoueur(joueurCourant.getDescription(),joueurCourant.getCouleur());
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
