/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author baratinm
 */
class AfficheJoueur extends JPanel {
    private JPanel panelGeneral;
    private JPanel panelImage;
    private JPanel panelDescription;
    private JLabel labelDescription;
    private Observateur observateur;

    
    
    public AfficheJoueur() {
        panelGeneral = new JPanel(new BorderLayout());
        this.add(panelGeneral);
        panelGeneral.setPreferredSize(new Dimension(400,100));

        panelImage = new JPanel();
        panelGeneral.add(panelImage, BorderLayout.EAST);
        
        panelDescription = new JPanel();
        labelDescription = new JLabel("Description de la classe");
        panelDescription.add(labelDescription);
        panelGeneral.add(panelDescription, BorderLayout.CENTER);
    }
    
    public void setObservateur(Observateur observateur){
        this.observateur = observateur;
    }
    
    public void setDescription(String description){
        this.labelDescription.setText(description);
    }
    
}
