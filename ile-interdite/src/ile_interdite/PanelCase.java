/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author bajatn
 */
class PanelCase extends JPanel{
    
    private Observateur observateur;
    
    public PanelCase(Observateur observateur, int x, int y, Tuile tuile){
        this.setObservateur(observateur);
        this.setLayout(new BorderLayout());
        BoutonCase bouton = new BoutonCase(x, y, tuile);
        bouton.setObservateur(observateur);
        this.add(bouton);
        JPanel panel = new JPanel(new GridLayout(1,tuile.getAventuriers().size()));
        for (Aventurier elem : tuile.getAventuriers()){
            JPanel panelNew = new JPanel();
            panelNew.setBackground(elem.getCouleur());
            panel.add(panelNew, BorderLayout.SOUTH);
        }
        this.add(panel, BorderLayout.SOUTH);
    }
    
    public void setObservateur(Observateur observateur){
        this.observateur = observateur;        
    }
    
}
