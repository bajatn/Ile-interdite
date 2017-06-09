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
        super("Plongeur", tuile, Color.BLACK);
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
            //System.out.println(" nouvelle boucle while");
            modif = false;
            // On parcours tuilesEauAccessibles
            for (Tuile tuileEau: tuilesEauAccessibles){
                //System.out.println("tuilesEauAccessibles " + tuileEau.getX() + "-" + tuileEau.getY());

                tuilesTemp = chercheEauProcheEau(tuileEau);
                for (Tuile tuile: tuilesTemp){
                    //System.out.println("tuileTemp " + tuile.getX() + "-" + tuile.getY());


                    if(tuilesTempGeneral.contains(tuile) == false){
                        tuilesTempGeneral.add(tuile);
                    }   
                }                
            }
            
            //System.out.println("tuilesTempGeneral");
        for (Tuile tuile : tuilesTempGeneral){
            //System.out.println("");
            //System.out.println("tuile " + tuile.getX() + "-" + tuile.getY());
        }
            
            for (Tuile tuile: tuilesTempGeneral){
                    if(tuilesEauAccessibles.contains(tuile) == false){
                        tuilesEauAccessibles.add(tuile);
                        //System.out.println("tuiles eau accessibles gagne un membre");
                        modif = true;
                    }   
            }  
        //System.out.println(modif);
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

        // Enleve la tuile sur laquelle est le joueur
        choixTuile.remove(tuileDepart);
  

       /* System.out.println("tuilesEauAccessibles");
        for (Tuile tuile : tuilesEauAccessibles){
            System.out.println("");
            System.out.println("tuile " + tuile.getX() + "-" + tuile.getY());
        }
        System.out.println("choixTuiles");
        for (Tuile tuile : choixTuile){
            System.out.println("");
            System.out.println("tuile " + tuile.getX() + "-" + tuile.getY());
        }
*/
        
        //retourne des trucs en double
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
