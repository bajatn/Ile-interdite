/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import java.awt.Color;
import java.awt.Dimension;
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
class AfficherCases extends JPanel {

    public AfficherCases() {
        this.setPreferredSize(new Dimension(500,500));
        this.setLayout(new GridLayout(6,6,10,10));
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        //this.setBackground(Color.GREEN);
        /*
        for (int i=0;i<6;i++){
            System.out.println("i" + i);
            for (int y=0;y<6;y++){
                System.out.println("  y" + y);
                if (i==0||i==5){
                    if (y==2||y==3){
                        System.out.println("    bouton05");
                        JButton bouton = new JButton();
                        bouton.setBackground(Color.blue);
                        this.add(bouton);
                    }
                    else{
                        System.out.println("    panel05");
                        this.add(new JPanel());
                    }   
                }
                if (i==1||i==4){
                    if(y==0||y==5){
                        System.out.println("    panel14");
                        this.add(new JPanel());
                    }
                    else{
                        System.out.println("    bouton14");
                        JButton bouton = new JButton("sd");
                        this.add(bouton);
                    }
                }
                if (i==2||i==3){
                    System.out.println("    bouton23");
                    JButton bouton = new JButton("sd");
                    this.add(bouton);
                }
            }        
        }
        */
           
            //Ligne 1
            
            this.add(new JLabel("trésor HG"));
            this.add(new JPanel());
            this.add(new JButton());
            this.add(new JButton());
            this.add(new JPanel());
            this.add(new JLabel("trésor HD"));
            //Ligne 2
            this.add(new JPanel());
            this.add(new JButton());
            this.add(new JButton());
            this.add(new JButton());
            this.add(new JButton());
            this.add(new JPanel()); 
            //Ligne 3 et 4 
            for (int i=0;i<12;i++){
                this.add(new JButton());                
            }
            //Ligne 5
            this.add(new JPanel());
            this.add(new JButton());
            this.add(new JButton());
            this.add(new JButton());
            this.add(new JButton());
            this.add(new JPanel()); 
            //Ligne 6
            this.add(new JLabel("trésor BG"));
            this.add(new JPanel());
            this.add(new JButton());
            this.add(new JButton());
            this.add(new JPanel());
            this.add(new JLabel("trésor BD"));           

            
        
        this.setVisible(true);
        this.repaint();
    }
    
    
}
