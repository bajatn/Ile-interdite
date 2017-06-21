package ile_interdite;
import static ile_interdite.Etat.*;
import java.awt.Color;
import java.util.*;
import static ile_interdite.Lieu.*;
import static ile_interdite.Type_Tresor.*;

/**
 *
 * @author ravinelt
 */
public abstract class Aventurier {
    private String role;
    private Tuile tuileActu;
    private Color couleur;
    private int nbAction;
    private ArrayList<Type_Tresor> tresor;
    private ArrayList<Carte_Tresor> main;
    private String description;

    public Aventurier(String role, Tuile tuile, Color couleur, int nbAction,String description) {
        this.role = role;
        this.tuileActu = tuile;
        this.couleur = couleur;
        this.main = new ArrayList<>();
        this.tresor = new ArrayList<>();
        this.nbAction = nbAction;
        this.description = description;
        tuile.addAventurier(this);
    }

    public String getDescription() {
        return description;
    }

    public Color getCouleur() {
        return couleur;
    }

    public Tuile getTuileActu() {
        return tuileActu;
    }
    public int getPositionX() {
        return tuileActu.getX();
    }
    public String getRole() {
        return role;
    }
    public int getPositionY() {
        return tuileActu.getY();
    }
    public int getNbAction() {
        return nbAction;
    }
    
    
    public void setPosition(Tuile tuile) {
        this.tuileActu = tuile;
    }

    public void setTuileActu(Tuile tuileActu) {
        this.tuileActu = tuileActu;
    }
    
    public void addCarte(Carte_Tresor carte) {
        this.main.add(carte);
    }
    
    public ArrayList<Tuile> deplacer(){
        ArrayList<Tuile> choixTuile = new ArrayList<Tuile>();
        ArrayList<Tuile> collecTuiles = getTuileActu().calculerAdjacent();
        for (Tuile tuile: collecTuiles){
            if (tuile.getEtat() == Etat.Asseche || tuile.getEtat() == Etat.Inonde){
              choixTuile.add(tuile);
            }
        }
        return choixTuile;        
    }
    
    public ArrayList<Tuile> assecher(){
        ArrayList<Tuile> choixTuile = new ArrayList<Tuile>();
        ArrayList<Tuile> collecTuiles = getTuileActu().calculerAdjacent();
        for (Tuile tuile: collecTuiles){
            if (tuile.getEtat() == Etat.Inonde){
              choixTuile.add(tuile);
            }
        }
        return choixTuile;
    }
    
    public void deplacerVersTuile(int x, int y){
        Tuile tuileVisee = null;
        this.tuileActu.removeAventurier(this);
        tuileVisee = this.getTuileActu().getGrille().getTuile(x, y);
        setTuileActu(tuileVisee);
        this.tuileActu.addAventurier(this);
        System.out.println("Votre Aventurier s'est déplacé en " + x + "-" + y);System.out.println("");
    }  

    
    public void setAVole(boolean b) {
    }
    
    public void piocheCarteTresor(Pile_de_Cartes_Tresor pileT, Pile_de_Cartes_Inondation pileI, Niveau_Eau niv){
        Carte carte = pileT.pioche();
        Carte_Tresor carte_t = (Carte_Tresor) carte;
        
        if (carte_t.getType() == "Montee_des_eaux"){
            pileI.ChangerPile();
            niv.monteNiveau();
            pileT.defausseCarte(carte_t);
            
        } else {
            this.main.add(carte_t);
        }
    }

    public void defausseCarteMain(Carte carte, Pile_de_Cartes_Tresor pileT){
        this.main.remove(carte);
        pileT.defausseCarte(carte);
    }
    
    public void prendreTresor(){
        int a = 0;
        Type_Tresor tresor = getTuileActu().getTresor();
        for (Carte_Tresor elem : main){
            if (elem.getType() == "Partie_Tresor" ){
                Partie_Tresor elem2 = (Partie_Tresor) elem;
                if (elem2.getTresor() == tresor){
                   a++;
                }
            }
        }
        if (a>=4) {
            this.tresor.add(getTuileActu().getTresor());
            for (Tuile tuile : getTuileActu().getGrille().getTuiles()){
                if (tuile.getTresor() == this.getTuileActu().getTresor()){
                   tuile.setTresor(null);
                }
            }
            int i = 0;
            while (i < 4) {
                Carte_Tresor elem = this.main.get(i);
                if (elem.getType() == "Partie_Tresor" ){
                    Partie_Tresor elem2 = (Partie_Tresor) elem;
                    if (elem2.getTresor() == tresor){
                       this.main.remove(elem2);
                       i++;
                    }
                }
            }
        }
    }

    public ArrayList<Aventurier> donnerCarte(){
        ArrayList<Aventurier> choixAventuriers = new ArrayList<Aventurier>();
        ArrayList<Tuile> collecTuiles = getTuileActu().calculerAdjacent();
        for (Tuile tuile: collecTuiles){
            if (!(tuile.getAventuriers().isEmpty())){
                for (Aventurier elem : tuile.getAventuriers()){
                    choixAventuriers.add(elem); 
                }
            }
        }
        return choixAventuriers;   
    }
    
    public void transfererCarte(Aventurier aventurier, Carte_Tresor carte){
        this.main.remove(carte);
        aventurier.addCarte(carte);
    }  

    public ArrayList<Carte_Tresor> getMain() {
        return main;
    }





}
