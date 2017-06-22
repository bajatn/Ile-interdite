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
import static java.lang.Integer.min;
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
    
    

    

    public AfficheCartes(ArrayList<Carte_Tresor> cartes, Observateur observateur,ArrayList<Aventurier> aventuriers) {
        this.observateur = observateur;
        this.setLayout(new BorderLayout());
        panelCartes = new JPanel(new GridLayout(5,1));
        for(int i=0;i<min(cartes.size(), 5);i++){
             if (cartes.isEmpty()){
                panelCartes.add(new JButton());
            }
            else{
                BoutonCarte carte = new BoutonCarte(cartes.get(i),observateur,0);
                panelCartes.add(carte);

            }
        }
        panelCommande = new JPanel(new GridLayout(10,1));
        panelCommande.setBorder(BorderFactory.createLineBorder(Color.black));
        
        partieSuiv = new JButton(">");
        partieSuiv.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.setType(TypeMessage.BOUGER_CARTES);
                    m.setDeplaceCarte(Boolean.TRUE);
                    observateur.traiterMessage(m);
                }
        });
        panelCommande.add(partieSuiv);
        
        partiePrec = new JButton("<");
        partiePrec.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.setType(TypeMessage.BOUGER_CARTES);
                    m.setDeplaceCarte(Boolean.FALSE);
                    observateur.traiterMessage(m);
                }
        });
        panelCommande.add(partiePrec);
        
        panelCommande.add(new JPanel());
        panelCommande.add(new JPanel());
        
        joueur1 = new JButton("P");
        joueur1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.setType(TypeMessage.JOUEUR);
                    m.setAventurier(aventuriers.get(0));
                    observateur.traiterMessage(m);
                }
        });
        joueur1.setBackground(Color.blue);
        joueur1.setForeground(Color.white);
        panelCommande.add(joueur1);
        
        joueur2 = new JButton("E");
        joueur2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.setType(TypeMessage.JOUEUR);
                    m.setAventurier(aventuriers.get(1));
                    observateur.traiterMessage(m);
                }
        });
        joueur2.setBackground(Color.green);
        joueur2.setForeground(Color.white);
        panelCommande.add(joueur2);
        
        joueur3 = new JButton("I");
        joueur3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.setType(TypeMessage.JOUEUR);
                    m.setAventurier(aventuriers.get(2));
                    observateur.traiterMessage(m);
                }
        });
        joueur3.setBackground(Color.red);
        joueur3.setForeground(Color.white);
        panelCommande.add(joueur3);
        
        joueur4 = new JButton("Pl");
        joueur4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.setType(TypeMessage.JOUEUR);
                    m.setAventurier(aventuriers.get(3));
                    observateur.traiterMessage(m);
                }
        });
        joueur4.setBackground(Color.black);
        joueur4.setForeground(Color.white);
        panelCommande.add(joueur4);
        
        joueur5 = new JButton("M");
        joueur5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.setType(TypeMessage.JOUEUR);
                    m.setAventurier(aventuriers.get(4));
                    observateur.traiterMessage(m);
                }
        });
        joueur5.setBackground(Color.lightGray);
        panelCommande.add(joueur5);
        
        joueur6 = new JButton("N");
        joueur6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.setType(TypeMessage.JOUEUR);
                    m.setAventurier(aventuriers.get(5));
                    observateur.traiterMessage(m);
                }
        });
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
        this.cartes = cartes;
        this.panelCartes.removeAll();
        for(int i=0;i<min(cartes.size(), 5);i++){
            if ((cartes.get(i+decalage)==null)){
                panelCartes.add(new JButton());
            }
            else{
                BoutonCarte carte = new BoutonCarte(cartes.get(i+decalage),observateur,0);
                panelCartes.add(carte);
            }
            this.revalidate();
        }
    }
    public void cartesSuivantes(int cas){
        decalage++;
        this.panelCartes.removeAll();
        for(int i=0;i<min(cartes.size()-decalage, 5);i++){
            if (cartes.isEmpty()){
                panelCartes.add(new JButton());
                System.out.println("JButton");
            }
            else{
                BoutonCarte carte = new BoutonCarte(cartes.get(i+decalage),observateur,cas);
                panelCartes.add(carte);
                System.out.println("BoutonCarte");
 
                
            }
            this.revalidate();
        }
        
    }
    
    public void cartesPrecedentes(int cas){
        if (decalage>0){
            decalage--;
        }
        this.panelCartes.removeAll();
        for(int i=0;i<min(cartes.size()-decalage, 5);i++){
            if (cartes.isEmpty()){
                panelCartes.add(new JButton());
                System.out.println("JButton");
               
            }
            else{
                BoutonCarte carte = new BoutonCarte(cartes.get(i+decalage),observateur,cas);
                panelCartes.add(carte);
                System.out.println("BoutonCarte");            
            }
        }
        this.revalidate();
        
        
    }

    public void setDecalage(int decalage) {
        this.decalage = decalage;
    }
    
    public void activerCartesPartieTresor(){
        this.panelCartes.removeAll();
        for(int i=0;i<min(cartes.size()-decalage, 5);i++){
            if (cartes.isEmpty()){
                panelCartes.add(new JButton());
            }
            else{
                BoutonCarte carte = new BoutonCarte(cartes.get(i+decalage),observateur,1);
                panelCartes.add(carte);
            }
            this.revalidate();
        }
                
    }
    
    public void activerCartes(){
        this.panelCartes.removeAll();
        for(int i=0;i<min(cartes.size()-decalage, 5);i++){
            if (cartes.isEmpty()){
                panelCartes.add(new JButton());
            }
            else{
                BoutonCarte carte = new BoutonCarte(cartes.get(i+decalage),observateur,2);
                panelCartes.add(carte);
            }
            this.revalidate();
        }
                
    }
}
