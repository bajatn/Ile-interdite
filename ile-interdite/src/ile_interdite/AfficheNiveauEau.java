/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

/**
 *
 * @author baratinm
 */
class AfficheNiveauEau extends JPanel {
    private Observateur observateur;
    
    private JSlider niveauEau;
    private int valeurNiveauEau;
    public AfficheNiveauEau() {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        valeurNiveauEau = 0;
        niveauEau = new JSlider(SwingConstants.VERTICAL,valeurNiveauEau,10,0);
        niveauEau.setMinorTickSpacing(1);
        niveauEau.setMajorTickSpacing(5);
        niveauEau.setPreferredSize(new Dimension(30,650));
        niveauEau.setBackground(Color.blue);
        niveauEau.setEnabled(false);
        niveauEau.setPaintTicks(true);
        this.setBackground(Color.blue);
        this.add(niveauEau);
    }
    
    public void setObservateur(Observateur observateur){
        this.observateur = observateur;
    }
    
    public void augmenterNiveauEau(){
        valeurNiveauEau++;
        niveauEau.setValue(valeurNiveauEau);
    }
    
    public void setNiveauEau(int niv){
        niveauEau.setValue(niv);
    }
    
}
