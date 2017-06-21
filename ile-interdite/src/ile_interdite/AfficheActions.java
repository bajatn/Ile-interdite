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

    public AfficheActions() {
        
        this.setLayout(new GridLayout(2,3,10,10));
        this.setBorder(new CompoundBorder(
            BorderFactory.createLineBorder(Color.black),    
            BorderFactory.createEmptyBorder(10,10,10,10)
        ));
        JButton deplacer = new JButton("Deplacer");
        deplacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.setType(DEPLACER);
                observateur.traiterMessage(m);
            }

        });
        this.add(deplacer);
                
        JButton assecher = new JButton("Assecher");
        
        assecher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.setType(ASSECHER);
                observateur.traiterMessage(m);
            }
        });  
        this.add(assecher);
        
        JButton attendre = new JButton("Fin de tour");
        attendre.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.setType(TERMINER_TOUR);
                    observateur.traiterMessage(m);
            }
        });        
        this.add(attendre);
        
        JButton donner = new JButton("Donner");
        donner.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.setType(DONNER);
                    observateur.traiterMessage(m);
            }
        });        
        this.add(donner);
        
        JButton tresor = new JButton("Tresor");
        donner.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.setType(RECUPERER_TRESOR);
                    observateur.traiterMessage(m);
            }
        });        
        this.add(tresor);
        
        this.add(new JButton("Quitter/Décoller"));        
    }
    public void setObservateur(Observateur observateur){
        this.observateur = observateur;
    }
    
}
