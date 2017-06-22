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
    private boolean recepteurChoisi;
    private Carte_Tresor carteAPasser;
    
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
        this.vue = new FenetreIHM(this,grille,aventuriers.get(1).getMain(),this.aventuriers);
        this.recepteurChoisi = false;
        vue.setObservateur(this);
        TourSuiv();
        
    }
    @Override
    public void traiterMessage(Message message){
        
        for (Tuile tuile : grille.getTuiles()){
            tuile.setActive(false);
        }
        
        if (null != message.getType()) switch (message.getType()) {
            case DEPLACER:
                for (Tuile tuile : joueurCourant.deplacer()){
                    tuile.setActive(true);
                }
                actionSelect = 0;
                vue.MettreAJourActions("Choisissez une carte");
                break;
                
            case ASSECHER:
                for (Tuile tuile : joueurCourant.assecher()){
                    tuile.setActive(true);
                }
                actionSelect = 1;
                vue.MettreAJourActions("Choisissez une carte");

                break;
                
            case CHOIX:
              
                    // Deplacer
                if (actionSelect == 0){
                    joueurCourant.deplacerVersTuile(message.getX(),message.getY());
                    actionUtilise++;  
                    vue.MettreAJourActions("Votre aventurier s'est deplacé sur la case: " + joueurCourant.getPositionX() + "-" + joueurCourant.getPositionY() + " : " + joueurCourant.getTuileActu().getNom());

                    // Assecher (ingenieur)
                } else if (joueurCourant.getRole()=="Ingénieur" && actionSelect==1 && aDejaAsseche==true) {
                    grille.assécherTuile(message.getX(),message.getY());
                    actionUtilise++;
                    vue.MettreAJourActions("Votre aventurier a asséché la case" + joueurCourant.getPositionX() + "-" + joueurCourant.getPositionY() + " : " + joueurCourant.getTuileActu().getNom());

                } else if (joueurCourant.getRole()=="Ingénieur" && actionSelect==1 && aDejaAsseche==false){
                    grille.assécherTuile(message.getX(),message.getY()); 
                    this.aDejaAsseche=true;     
                    vue.MettreAJourActions("Votre aventurier a asséché la case" + joueurCourant.getPositionX() + "-" + joueurCourant.getPositionY() + " : " + joueurCourant.getTuileActu().getNom());
                    // Assecher
                } else if (actionSelect == 1){
                    grille.assécherTuile(message.getX(),message.getY());
                    this.aDejaAsseche = false;
                    actionUtilise++;  
                    vue.MettreAJourActions("Votre aventurier a asséché la case" + joueurCourant.getPositionX() + "-" + joueurCourant.getPositionY() + " : " + joueurCourant.getTuileActu().getNom());

                    // Donner carte
                } else if (actionSelect == 3){
                    Tuile tuileVisee = joueurCourant.getTuileActu();
                    for (Aventurier aventurier : aventuriers){
                        if (aventurier.getTuileActu() == tuileVisee){
                            aventurier.deplacerVersTuile(message.getX(), message.getY());
                        }
                    vue.getAfficherCartes().mettreAJourCartes(joueurCourant.getMain());
                    vue.MettreAJourActions("Carte helicoptere utilisée");

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
                    vue.getAfficherCartes().mettreAJourCartes(joueurCourant.getMain());
                    
                    }
                    
                    // Sac de sable
                } else if (actionSelect == 4){
                    grille.assécherTuile(message.getX(),message.getY());
                    // Defausse d'une carte Sac de sable de la main du joueur
                    boolean carteDefausse = false;
                    int i = 0;
                    while (carteDefausse == false){
                        Carte_Tresor carte = joueurCourant.getMain().get(i);
                        if (carte.getType() == "Sac_de_sable"){
                            joueurCourant.defausseCarteMain(carte, pileTresor);
                            carteDefausse = true;
                        }
                    i++;
                    vue.getAfficherCartes().mettreAJourCartes(joueurCourant.getMain());
                    vue.repaint();

                    }
                    
                } else {
                    vue.MettreAJourActions("action impossible");
                }  
                
                
                break;
                
                
                
            case TERMINER_TOUR:
                actionUtilise = 10;
                vue.MettreAJourActions("Fin du tour");
                break;
                
            case DONNER:
                actionSelect = 2;
                vue.getAfficherCartes().activerCartesPartieTresor();
                vue.MettreAJourActions("Vous avez donné une carte");
                break;
                
            case RECUPERER_TRESOR:
                joueurCourant.prendreTresor();
                break;
                
            case CARTE:
                if  (actionSelect == 2){
                    carteAPasser = message.getCarte();
                    recepteurChoisi =true;
                    vue.getAfficherCartes().mettreAJourCartes(joueurCourant.getMain());
                }
                
                else if (defausse == 1){
                    joueurCourant.defausseCarteMain(message.getCarte(), pileTresor);
                    if (joueurCourant.getMain().size()<=5) {
                        defausse = 0;
                        vue.MettreAJourActions("C'est maintenant le tour du "+joueurCourant.getRole());
                        vue.getAfficherCartes().mettreAJourCartes(joueurCourant.getMain());
                        vue.getAfficherActions().setEnabled(true);
                    } else {
                        vue.getAfficherCartes().activerCartes();
                    }
                } else {
                    System.out.println(actionSelect);
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
                    vue.MettreAJourActions("Partie gagnée");

                } else {
                    vue.MettreAJourActions("Partie perdue");
                }
                break;
            case BOUGER_CARTES:
                int cas;
                if (defausse == 1){
                    cas = 2;
                }else if (actionSelect == 2){
                    cas = 1;
                }else {
                    cas = 0;
                }
                if(message.getDeplaceCarte()){
                    vue.getAfficherCartes().cartesSuivantes(cas);
                }
                else{
                    vue.getAfficherCartes().cartesPrecedentes(cas);
                }
                vue.repaint(); 
                break;
                
            case JOUEUR:
                    joueurCourant.transfererCarte(message.getAventurier(), carteAPasser);
                    recepteurChoisi =false;
                    actionUtilise++; 
                    vue.getAfficherCartes().mettreAJourCartes(joueurCourant.getMain());
                
                break;
                    
                
            default:
                break;
        }
            
        vue.getAfficherCases().MettreAjourCases(this, grille);
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
        joueurCourant = aventuriers.get(compteurTour%aventuriers.size());
        actionUtilise = 0;
        vue.MettreAJourActions("C'est maintenant le tour du "+joueurCourant.getRole());
        joueurCourant.piocheCarteTresor(pileTresor, pileInondation, niv);
        joueurCourant.piocheCarteTresor(pileTresor, pileInondation, niv);
        vue.getAfficherNiveauEau().setNiveauEau(niv.getNiveau());
        vue.getAfficherCases().MettreAjourCases(this, grille);
        vue.getAfficherCartes().setDecalage(0);
        vue.setAfficheJoueur(joueurCourant.getDescription(),joueurCourant.getCouleur());
        vue.getAfficherCartes().mettreAJourCartes(joueurCourant.getMain());
        vue.repaint();
        
        if (joueurCourant.getMain().size()>5) {
            vue.MettreAJourActions("Veuillez vous défausser de certaines cartes");
            defausse = 1;
            vue.getAfficherCartes().activerCartes();
            vue.getAfficherActions().setEnabled(false);
        }
    }
}

