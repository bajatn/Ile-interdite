/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import java.awt.Color;
import java.awt.GridLayout;
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

    public AfficheActions() {
        
        this.setLayout(new GridLayout(2,3,10,10));
        this.setBorder(new CompoundBorder(
            BorderFactory.createLineBorder(Color.black),    
            BorderFactory.createEmptyBorder(10,10,10,10)
        ));
      
        this.add(new JButton("deplacer"));
        this.add(new JButton("assécher"));
        this.add(new JPanel());
        this.add(new JButton("attendre"));
        this.add(new JButton("donner"));
        this.add(new JButton("tresor")); 
        this.add(new JButton("action spé"));
        this.add(new JButton("quitter/décoller"));        
    }
    
}
