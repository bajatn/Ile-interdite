/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
    private JPanel afficherCases;
    private JPanel afficherNiveauEau;
    private JPanel afficherCartes;
    private JPanel panelSud;
    private JPanel afficherActions;
    private JPanel afficherJoueur;

    public FenetreIHM(){
            //Création et initialisation de la fenetre
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
        this.afficherCases = new AfficherCases();
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
        panelSud.add(afficherActions);
        this.afficherJoueur = new AfficheJoueur();
        afficherJoueur.setBorder(BorderFactory.createLineBorder(Color.black));
        panelSud.add(afficherJoueur);
        
        this.window.setVisible(true);
        panelMain.repaint();
        
        
    }
}
