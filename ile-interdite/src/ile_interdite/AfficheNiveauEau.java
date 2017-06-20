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
    private JSlider niveauEau;

    public AfficheNiveauEau() {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        niveauEau = new JSlider(SwingConstants.VERTICAL,0,10,0);
        niveauEau.setMinorTickSpacing(1);
        niveauEau.setMajorTickSpacing(5);
        niveauEau.setPreferredSize(new Dimension(30,650));
        niveauEau.setBackground(Color.blue);
        niveauEau.setEnabled(false);

        

        niveauEau.setPaintTicks(true);
        this.setBackground(Color.blue);
        this.add(niveauEau);
        
        
        
    }
    
}
