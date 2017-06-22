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
    private int actionUtilise = 10;
    private int compteurTour = -1;
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
        this.niv = new Niveau_Eau(1);
        aventuriers.add(new Pilote(grille.getTuile(4,3)));
        aventuriers.add(new Explorateur(grille.getTuile(5,3)));
        aventuriers.add(new Ingenieur(grille.getTuile(4,1)));
        aventuriers.add(new Plongeur(grille.getTuile(3,4)));
        aventuriers.add(new Messager(grille.getTuile(3,2)));
        aventuriers.add(new Navigateur(grille.getTuile(4,2)));
        this.joueurCourant = aventuriers.get(0);
        this.vue = new FenetreIHM(this,grille,aventuriers.get(1).getMain());
        vue.setObservateur(this);
        TourSuiv();
        
    }
//////////////////////////////////////////////////////////////////////////
    @Override
    public void traiterMessage(Message message){
        
        for (Tuile tuile : grille.getTuiles()){
            tuile.setActive(false);
        }
        
        if (null != message.getType()) switch (message.getType()) {
            case DEPLACER:
            //  Afficher(joueurCourant.deplacer());
                for (Tuile tuile : joueurCourant.deplacer()){
                    tuile.setActive(true);
                }
                actionSelect = 0;
                break;
                
            case ASSECHER:
            //  Afficher(joueurCourant.assecher());
                for (Tuile tuile : joueurCourant.assecher()){
                    tuile.setActive(true);
                }
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
                    Tuile tuileVisee = joueurCourant.getTuileActu();
                    for (Aventurier aventurier : aventuriers){
                        if (aventurier.getTuileActu() == tuileVisee){
                            aventurier.deplacerVersTuile(message.getX(), message.getY());
                        }
                    }
                    // Defausse d'une carte Helico de la main du joueur
                    boolean carteDefausse = false;
                    int i = 0;
                    while (carteDefausse == false){
                        Carte_Tresor carte = joueurCourant.getMain().get(i);
                        if (carte.getType() == "Helicoptere"){
                            joueurCourant.defausseCarteMain(carte, pileTresor);
                            carteDefausse = true;
                        }
                        i++;
                    }
                    
                    // Sac de sable
                } else if (actionSelect == 4){
                    grille.assécherTuile(message.getX(),message.getY());
                    // Defausse d'une carte Sac de sable de la main du joueur
                    boolean carteDefausse = false;
                    int i = 0;
                    while (carteDefausse == false){
                        Carte_Tresor carte = joueurCourant.getMain().get(i);
                        if (carte.getType() == "Sac_de_Sable"){
                            joueurCourant.defausseCarteMain(carte, pileTresor);
                            carteDefausse = true;
                        }
                        i++;
                    }
                    
                } else {
                    System.out.println("Action impossible");
                }  
                
               // for (Tuile tuile : grille.getTuiles()){
               //     tuile.setActive(false);
               // }
                
                break;
                
                
                
            case TERMINER_TOUR:
                System.out.println("TERMINER_TOUR");
                actionUtilise = 10;
                break;
                
            case DONNER:
            //  Afficher2(joueurCourant.donnerCarte());
                actionSelect = 2;
                break;
                
            case RECUPERER_TRESOR:
                joueurCourant.prendreTresor();
                break;
                
            case CARTE:
                System.out.println("Entree traiterMessage CARTE");
                if (defausse == 1){
                    joueurCourant.defausseCarteMain(message.getCarte(), pileTresor);
                    if (joueurCourant.getMain().size()<=4) {
                        defausse = 0;
                    }
                } else {
                    
                    
                //  Afficher(message.getCarte().utiliserCarte(grille));
                    for (Tuile tuile : message.getCarte().utiliserCarte(grille)){
                        tuile.setActive(true);
                    }
                    
                    if (message.getCarte().getType() == "Helicoptere"){
                        actionSelect = 3;
                    } else if (message.getCarte().getType() == "Sac_de_sable"){
                        actionSelect = 4;
                    }
                }
                break;
                
            case TERMINER_JEU:
                int aventurierPresent = 0;
                int nbTresors = 0;
                boolean carteHelico = false;
                
                for (Aventurier aventurier: aventuriers){
                    // ils sont tous sur l'heliport ?
                    if(aventurier.getTuileActu() == grille.getTuile(Lieu.Heliport)){
                        aventurierPresent++;
                    }
                    // ils ont les tresors ?
                    nbTresors = nbTresors + aventurier.getTresors().size();
                    // ils ont une carte helicoptere ?
                    for (Carte_Tresor carte: aventurier.getMain()){
                        if(carte.getType()=="Helicoptere"){
                            carteHelico = true;
                        }
                    }
                }
                if ((aventurierPresent == aventuriers.size()) && (nbTresors >= 4) && (carteHelico == true)){
                    System.out.println();
                    System.out.println("///////////////");
                    System.out.println(" Partie gagnée");
                    System.out.println("///////////////");
                } else {
                    System.out.println();
                    System.out.println("///////////////");
                    System.out.println(" Partie perdue");
                    System.out.println("///////////////");
                }
                break;
            case BOUGER_CARTES:
                if(message.getDeplaceCarte()){
                    vue.getAfficherCartes().cartesSuivantes();
                }
                else{
                    vue.getAfficherCartes().cartesPrecedentes();

                }
                    
                
            default:
                break;
        }
            
        vue.getAfficherCases().MettreAjourCases(this, grille);
        vue.getAfficherCartes().mettreAJourCartes(joueurCourant.getMain());
        vue.repaint();   
        if(actionUtilise >= joueurCourant.getNbAction()){
            grille.Inondation(pileInondation, niv);
            TourSuiv();
        }
    }

    private void TourSuiv(){
        if (joueurCourant.getRole() == "Pilote"){
            joueurCourant.setAVole(false);
        }
        compteurTour++;
        joueurCourant = aventuriers.get(compteurTour%6);
        actionUtilise = 0;
        System.out.println("C'est maintenant le tour du "+joueurCourant.getRole()); 
        joueurCourant.piocheCarteTresor(pileTresor, pileInondation, niv);
        joueurCourant.piocheCarteTresor(pileTresor, pileInondation, niv);
        vue.getAfficherNiveauEau().setNiveauEau(niv.getNiveau());
        vue.getAfficherCases().MettreAjourCases(this, grille);
        if (joueurCourant.getMain().size()>4) {
            System.out.println("Veuillez vous défausser de certaines cartes");
            defausse = 1;
            
        }
        vue.setAfficheJoueur(joueurCourant.getDescription(),joueurCourant.getCouleur());
        vue.getAfficherCartes().mettreAJourCartes(joueurCourant.getMain());
    }
    /*
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
    */
}
