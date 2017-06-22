/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import static ile_interdite.TypeMessage.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

/**
 *
 * @author baratinm
 */
class AfficheActions extends JPanel {
    private Observateur observateur;
    private JButton assecher;
    private JButton attendre;
    private JButton deplacer;
    private JButton donner;
    private JButton tresor;
    private JButton quitter;

    public AfficheActions() {
        
        this.setLayout(new GridLayout(2,3,10,10));
        this.setBorder(new CompoundBorder(
            BorderFactory.createLineBorder(Color.black),    
            BorderFactory.createEmptyBorder(10,10,10,10)
        ));
        deplacer = new JButton("Deplacer");
        deplacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.setType(DEPLACER);
                observateur.traiterMessage(m);
            }

        });
        this.add(deplacer);
                
        assecher = new JButton("Assecher");
        assecher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.setType(ASSECHER);
                observateur.traiterMessage(m);
            }
        });  
        this.add(assecher);
        
        attendre = new JButton("Fin de tour");
        attendre.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.setType(TERMINER_TOUR);
                    observateur.traiterMessage(m);
            }
        });        
        this.add(attendre);
        
        donner = new JButton("Donner");
        donner.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.setType(DONNER);
                    observateur.traiterMessage(m);
            }
        });        
        this.add(donner);
        
        tresor = new JButton("Prendre Tresor");
        tresor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.setType(RECUPERER_TRESOR);
                    observateur.traiterMessage(m);
            }
        });        
        this.add(tresor);
        
        quitter = new JButton("Quitter/Décoller");
        quitter.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.setType(TERMINER_JEU);
                    observateur.traiterMessage(m);
            }
        }); 
        this.add(quitter);    
    }
    public void setObservateur(Observateur observateur){
        this.observateur = observateur;
    }
    public void setEnabled(boolean bool){
        this.assecher.setEnabled(bool);
        this.attendre.setEnabled(bool);
        this.deplacer.setEnabled(bool);
        this.donner.setEnabled(bool);
        this.tresor.setEnabled(bool);
        this.quitter.setEnabled(bool);
    }
}
