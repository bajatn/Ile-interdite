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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author baratinm
 */
class AfficheCartes extends JPanel {
    private Observateur observateur;
    
    private JPanel panelCartes;

    private JButton carte1;
    private JButton carte2;
    private JButton carte3;
    private JButton carte4;
    private JButton carte5;
    
    private JPanel panelCommande;
    
    private JButton partieSuiv;
    private JButton partiePrec;
    private JButton joueur1;
    private JButton joueur2;
    private JButton joueur3;
    private JButton joueur4;
    private JButton joueur5;
    private JButton joueur6;
    
    

    

    public AfficheCartes() {
        this.setLayout(new BorderLayout());
        panelCartes = new JPanel(new GridLayout(5,1));
        carte1 = new JButton("carte1");
        panelCartes.add(carte1);
        carte2 = new JButton("carte2");
        panelCartes.add(carte2);
        carte3 = new JButton("carte3");
        panelCartes.add(carte3);
        carte4 = new JButton("carte4");
        panelCartes.add(carte4);
        carte5 = new JButton("carte5");
        panelCartes.add(carte5);
        
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
}
