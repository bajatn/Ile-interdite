/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author ravinelt
 */
public class Plongeur extends Aventurier {

    public Plongeur(Tuile tuile) {
        super("Plongeur", tuile, Color.BLACK, 3,"Le Plongeur peut passer par une ou deux tuiles adjacentes inondées et/ou manquantes pour une action (il doit terminer le tour sur une tuile). ");
    }

    @Override
    public ArrayList<Tuile> deplacer(){
        
        ArrayList<Tuile> choixTuile = new ArrayList<Tuile>();
        ArrayList<Tuile> tuilesEauAccessibles = new ArrayList<Tuile>();
        ArrayList<Tuile> tuilesTemp = new ArrayList<Tuile>();
        ArrayList<Tuile> tuilesTempGeneral = new ArrayList<Tuile>();
        ArrayList<Tuile> collecTuiles = getTuileActu().calculerAdjacent();  
        Tuile tuileDepart = this.getTuileActu();
        
        choixTuile= chercheSolProcheEau(this.getTuileActu());
        tuilesEauAccessibles= chercheEauProcheEau(this.getTuileActu());
        
        boolean modif = true;
        // Tant qu'on modifies tuilesEauAccessibles

        while (modif == true) {
            modif = false;
            // On parcours tuilesEauAccessibles
            for (Tuile tuileEau: tuilesEauAccessibles){

                tuilesTemp = chercheEauProcheEau(tuileEau);
                for (Tuile tuile: tuilesTemp){


                    if(tuilesTempGeneral.contains(tuile) == false){
                        tuilesTempGeneral.add(tuile);
                    }   
                }                
            }
            
        for (Tuile tuile : tuilesTempGeneral){
        }
            
            for (Tuile tuile: tuilesTempGeneral){
                    if(tuilesEauAccessibles.contains(tuile) == false){
                        tuilesEauAccessibles.add(tuile);
                        modif = true;
                    }   
            }  
        tuilesTempGeneral.clear();
        }
        for (Tuile tuile : tuilesEauAccessibles){
            tuilesTemp = chercheSolProcheEau(tuile);
            for (Tuile tuileSol : tuilesTemp){
                if(tuilesEauAccessibles.contains(tuileSol) == false){
                    choixTuile.add(tuileSol);
                } 
            }
        }

        choixTuile.remove(tuileDepart);
  


        return choixTuile;
         
        
    } 
    private ArrayList<Tuile> chercheEauProcheEau(Tuile tuile){
        ArrayList<Tuile> listeCaseProcheEau= tuile.calculerAdjacent();
        ArrayList<Tuile> listeCaseEauProcheEau= new ArrayList();
        for(Tuile tuileCourante : listeCaseProcheEau){
            if(tuileCourante.getEtat() == Etat.Submerge || tuileCourante.getEtat() == Etat.Inonde){
                listeCaseEauProcheEau.add(tuileCourante);
            }
        }
        return listeCaseEauProcheEau;
    }
    
    private ArrayList<Tuile> chercheSolProcheEau(Tuile tuile){
        ArrayList<Tuile> listeCaseProcheEau= tuile.calculerAdjacent();
        ArrayList<Tuile> listeCaseSolProcheEau= new ArrayList();
        for(Tuile tuileCourante : listeCaseProcheEau){
            if(tuileCourante.getEtat() == Etat.Asseche || tuileCourante.getEtat() == Etat.Inonde){
                listeCaseSolProcheEau.add(tuileCourante);
            }
        }
        return listeCaseSolProcheEau;
    }
}
