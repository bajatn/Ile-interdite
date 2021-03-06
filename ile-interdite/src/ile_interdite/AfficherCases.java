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
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author baratinm
 */
class AfficherCases extends JPanel {
    private Observateur observateur;
    
    public AfficherCases(Observateur observateur, Grille grille){
        this.setObservateur(observateur);
        this.setLayout(new GridLayout(6,6,10,10));
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        for (int i=0;i<6;i++){
            for (int y=0;y<6;y++){
                PanelCase panelCase = new PanelCase(observateur, y+1, i+1, grille.getTuile(y+1,i+1));
                if (i==0||i==5){
                    if (y==2||y==3){
                        this.add(panelCase);
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
                        this.add(panelCase);
                    }
                }
                if (i==2||i==3){
                    this.add(panelCase);
                }
            }        
        }       
    }
    
    public void setObservateur(Observateur observateur){
        this.observateur = observateur;        
    }
    
    public void MettreAjourCases(Observateur observateur, Grille grille){
        this.removeAll();
        this.setLayout(new GridLayout(6,6,10,10));
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
             
        for (int i=0;i<6;i++){
            for (int y=0;y<6;y++){
                PanelCase panelCase = new PanelCase(observateur, y+1, i+1, grille.getTuile(y+1,i+1));
                if (i==0||i==5){
                    if (y==2||y==3){
                        this.add(panelCase);
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
                        this.add(panelCase);
                    }
                }
                if (i==2||i==3){
                    this.add(panelCase);
                }
            }        
        }
        this.revalidate();
        
    }
}
