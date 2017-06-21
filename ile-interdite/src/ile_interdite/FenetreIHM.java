/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

/**
 *
 * @author baratinm
 */



public class FenetreIHM {
    
    private JFrame window;
    private JPanel panelMain;
    
    private JPanel panelCentral;
    private JPanel panelLabel;
    private JLabel labelCentral;
    private AfficherCases afficherCases;
    
    private AfficheNiveauEau afficherNiveauEau;
    private AfficheCartes afficherCartes;
    
    private JPanel panelSud;
    private AfficheActions afficherActions;
    private AfficheJoueur afficherJoueur;
    
    private Observateur observateur;
    public FenetreIHM(Observateur observateur, Grille grille){
            //Création et initialisation de la fenetre
        this.setObservateur(observateur);
        this.window = new JFrame();
        window.setSize(1000,1000);
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        //window.setDefaultCloseOperation();
        
            //Ajout et initialisation de panelMain a window
        this.panelMain = new JPanel(new BorderLayout());
        window.add(panelMain);
        
            //Ajout et initialisation de panelCentral au centre de panelMain
        this.panelCentral = new JPanel(new BorderLayout());
        panelMain.add(panelCentral, BorderLayout.CENTER);
        
            //Ajout de labelCentral au nord de panelCentral
        this.panelLabel = new JPanel();
        this.labelCentral = new JLabel("Bienvenue sur l'ile interdite !");
        panelLabel.add(labelCentral);
        panelCentral.add(panelLabel, BorderLayout.NORTH);
       
            //Ajout et initialisation de afficherCases au sud de panelCentral
        this.afficherCases = new AfficherCases(observateur, grille);
        panelCentral.add(afficherCases, BorderLayout.CENTER);       
            
            //Ajout et initialisation de afficherNiveauEau a l'est de PanelMain
        this.afficherNiveauEau = new AfficheNiveauEau();
        panelMain.add(afficherNiveauEau, BorderLayout.EAST);
        
            //Ajout et initialisation de afficherCartes a l'ouest de PanelMain
        this.afficherCartes = new AfficheCartes();
        panelMain.add(afficherCartes, BorderLayout.WEST);
        
            //Ajout et initialisation de panelSud au sud de PanelMain
        this.panelSud = new JPanel(new GridLayout(1,2));
        panelMain.add(panelSud, BorderLayout.SOUTH);
        
            //Ajout et initialisation de afficherActions et AfficherJoueur a panelSud
        this.afficherActions = new AfficheActions();
        this.afficherActions.setObservateur(observateur);
        panelSud.add(afficherActions);
        this.afficherJoueur = new AfficheJoueur();
        afficherJoueur.setBorder(BorderFactory.createLineBorder(Color.black));
        panelSud.add(afficherJoueur);
        
        this.window.setVisible(true);
        panelMain.repaint();
    }
    
    public void setObservateur(Observateur observateur) {
            this.observateur = observateur;
//            this.afficherCartes.setObservateur(observateur);
//            this.afficherJoueur.setObservateur(observateur);
//            this.afficherNiveauEau.setObservateur(observateur);
//            this.afficherCases.setObservateur(observateur);

        }
    
    void setAfficheJoueur(String description, Color couleur) {
        this.afficherJoueur.setCouleur(couleur);
        this.afficherJoueur.setDescription(description);
        
    } 

    public AfficherCases getAfficherCases() {
        return afficherCases;
    }

    public AfficheNiveauEau getAfficherNiveauEau() {
        return afficherNiveauEau;
    }

    public AfficheCartes getAfficherCartes() {
        return afficherCartes;
    }

    public AfficheActions getAfficherActions() {
        return afficherActions;
    }

    public AfficheJoueur getAfficherJoueur() {
        return afficherJoueur;
    }
    
    
}
