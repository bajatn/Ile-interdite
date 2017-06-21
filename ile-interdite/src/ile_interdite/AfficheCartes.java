/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author baratinm
 */
class AfficheCartes extends JPanel {
    private Observateur observateur;
    private int decalage;
    
    private ArrayList<Carte_Tresor> cartes;
    
    private JPanel panelCartes;
   
    private JPanel panelCommande;
    
    private JButton partieSuiv;
    private JButton partiePrec;
    private JButton joueur1;
    private JButton joueur2;
    private JButton joueur3;
    private JButton joueur4;
    private JButton joueur5;
    private JButton joueur6;
    
    

    

    public AfficheCartes(ArrayList<Carte_Tresor> cartes, Observateur observateur) {
        this.setLayout(new BorderLayout());
        panelCartes = new JPanel(new GridLayout(5,1));
        
                
        for(int i=0;i<5;i++){
            System.out.println(i);
            System.out.println(cartes.size());
            if (cartes.isEmpty()){
                panelCartes.add(new JButton());
            }
            else{
                BoutonCarte carte = new BoutonCarte(cartes.get(i),observateur);
                System.out.println(i);
                panelCartes.add(carte);
            }
        }
        panelCommande = new JPanel(new GridLayout(10,1));
        panelCommande.setBorder(BorderFactory.createLineBorder(Color.black));
        
        partieSuiv = new JButton(">");
        panelCommande.add(partieSuiv);
        
        partiePrec = new JButton("<");
        panelCommande.add(partiePrec);
        
        panelCommande.add(new JPanel());
        panelCommande.add(new JPanel());
        
        joueur1 = new JButton("P");
        joueur1.setBackground(Color.blue);
        joueur1.setForeground(Color.white);
        panelCommande.add(joueur1);
        
        joueur2 = new JButton("E");
        joueur2.setBackground(Color.green);
        joueur2.setForeground(Color.white);
        panelCommande.add(joueur2);
        
        joueur3 = new JButton("I");
        joueur3.setBackground(Color.red);
        joueur3.setForeground(Color.white);
        panelCommande.add(joueur3);
        
        joueur4 = new JButton("Pl");
        joueur4.setBackground(Color.black);
        joueur4.setForeground(Color.white);
        panelCommande.add(joueur4);
        
        joueur5 = new JButton("M");
        joueur5.setBackground(Color.lightGray);
        panelCommande.add(joueur5);
        
        joueur6 = new JButton("N");
        joueur6.setBackground(Color.yellow);
        joueur6.setForeground(Color.black);
        panelCommande.add(joueur6);

        
        
        
        this.add(panelCartes, BorderLayout.CENTER);
        this.add(panelCommande, BorderLayout.EAST);
    }
    
    public void setObservateur(Observateur observateur){
        this.observateur = observateur;
    }
    
    public void mettreAJourCartes(ArrayList<Carte_Tresor> cartes){
        decalage = 0;        
        this.panelCartes.removeAll();
        for(int i=0;i<5;i++){
            BoutonCarte carte = new BoutonCarte(cartes.get(i),observateur);
            panelCartes.add(carte);    
        }
    }
    
    public void cartesSuivantes(){
        decalage++;
        this.panelCartes.removeAll();
        for(int i=0;i<5;i++){
            BoutonCarte carte = new BoutonCarte(cartes.get(i+decalage),observateur);
            panelCartes.add(carte);    
        }    
    }
    
    public void cartesPrecedentes(){
        decalage--;
        this.panelCartes.removeAll();
        for(int i=0;i<5;i++){
            BoutonCarte carte = new BoutonCarte(cartes.get(i+decalage),observateur);
            panelCartes.add(carte);    
        }    
    }
}
