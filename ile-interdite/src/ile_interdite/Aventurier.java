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
    private ArrayList<Type_Tresor> tresors;
    private ArrayList<Carte_Tresor> main;
    private String description;

    public Aventurier(String role, Tuile tuile, Color couleur, int nbAction,String description) {
        this.role = role;
        this.tuileActu = tuile;
        this.couleur = couleur;
        this.main = new ArrayList<>();
        this.tresors = new ArrayList<>();
        this.nbAction = nbAction;
        this.description = description;
        tuile.addAventurier(this);
    }

    public ArrayList<Type_Tresor> getTresors() {
        return tresors;
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
    
    public void addTresor(Type_Tresor tresor) {
        this.tresors.add(tresor);
    }
    
    public ArrayList<Tuile> deplacer(){
        ArrayList<Tuile> choixTuile = new ArrayList<Tuile>();
        ArrayList<Tuile> collecTuiles = getTuileActu().calculerAdjacent();
        for (Tuile tuile: collecTuiles){
            if (tuile.getEtat() == Etat.Asseche || tuile.getEtat() == Etat.Inonde){
                choixTuile.add(tuile);
                tuile.setActive(true);
            }
        }
        return choixTuile;        
    }
    
    public ArrayList<Tuile> assecher(){
        ArrayList<Tuile> choixTuile = new ArrayList<Tuile>();
        ArrayList<Tuile> collecTuiles = getTuileActu().calculerAdjacent();
        collecTuiles.add(this.getTuileActu());
        for (Tuile tuile: collecTuiles){
            if (tuile.getEtat() == Etat.Inonde){
              choixTuile.add(tuile);
              tuile.setActive(true);
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
            this.addTresor(getTuileActu().getTresor());
            for (Tuile tuile : getTuileActu().getGrille().getTuiles()){
                if (tuile.getTresor() == this.getTuileActu().getTresor()){
                   tuile.setTresor(null);
                }
            }
            
            int nbBoucle = main.size();
            for (int i=nbBoucle;i>0; i--) {    
                Carte_Tresor elem = main.get(i-1);
                if (elem.getType() == "Partie_Tresor" ){
                    Partie_Tresor elem2 = (Partie_Tresor) elem;
                    if (elem2.getTresor() == tresor){
                       this.main.remove(elem2);
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
