/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author baratinm
 */
class AfficherCases extends JPanel {
    private Observateur observateur;

    public AfficherCases() {
        this.setLayout(new GridLayout(6,6,10,10));
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        //this.setBackground(Color.GREEN);
        
        for (int i=0;i<6;i++){
            for (int y=0;y<6;y++){
                BoutonCase bouton = new BoutonCase(y,i);
                bouton.setObservateur(observateur);

                
                if (i==0||i==5){
                    if (y==2||y==3){              
                        this.add(bouton);
                    }
                    else{
                        this.add(new JLabel());
                    }   
                }
                if (i==1||i==4){
                    if(y==0||y==5){
                        this.add(new JLabel());
                    }
                    else{
                        this.add(bouton);
                    }
                }
                if (i==2||i==3){
                    this.add(bouton);
                }
            }        
        }
        
           
            //Ligne 1
            
//            this.add(new JLabel("trésor HG"));
//            this.add(new JPanel());
//            this.add(new JButton());
//            this.add(new JButton());
//            this.add(new JPanel());
//            this.add(new JLabel("trésor HD"));
//            //Ligne 2
//            this.add(new JPanel());
//            this.add(new JButton());
//            this.add(new JButton());
//            this.add(new JButton());
//            this.add(new JButton());
//            this.add(new JPanel()); 
//            //Ligne 3 et 4 
//            for (int i=0;i<12;i++){
//                this.add(new JButton());                
//            }
//            //Ligne 5
//            this.add(new JPanel());
//            this.add(new JButton());
//            this.add(new JButton());
//            this.add(new JButton());
//            this.add(new JButton());
//            this.add(new JPanel()); 
//            //Ligne 6
//            this.add(new JLabel("trésor BG"));
//            this.add(new JPanel());
//            this.add(new JButton());
//            this.add(new JButton());
//            this.add(new JPanel());
//            this.add(new JLabel("trésor BD"));           
    }
    
    public void setObservateur(Observateur observateur){
        this.observateur = observateur;        
    }
    
    
    
}
