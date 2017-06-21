/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author baratinm
 */
public class BoutonCarte extends JButton{
    private Carte_Tresor carte;
    private Observateur observateur;

    public BoutonCarte(Carte_Tresor carte,Observateur observateur) {
        super();
        this.carte = carte;
        this.observateur = observateur;
        this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.setType(TypeMessage.CARTE);
                    m.setCarte(carte);
                    observateur.traiterMessage(m);

                }
        });
    }
    
    
    
}
