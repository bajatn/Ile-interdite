/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import static ile_interdite.Type_Tresor.*;
import java.awt.Color;
import java.awt.Dimension;
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
        super(carte.getType());
        this.setPreferredSize(new Dimension(180, 0));
        if (carte.getType() == "Partie_Tresor"){
            Partie_Tresor carteT = (Partie_Tresor) carte;
            if (carteT.getTresor() == la_statue_du_zephyr){
                this.setText("La statue du zephyr");
            } else if (carteT.getTresor() == le_cristal_ardent){
                this.setText("Le cristal ardent");
            } else if (carteT.getTresor() == le_calice_de_l_onde){
                this.setText("Le calice de l'onde");
            } else if (carteT.getTresor() == la_pierre_sacree){
                this.setText("La pierre sacrée");
            }
        } else {
            if (carte.getType() == "Sac_de_sable"){
                this.setText("Sac de sable");
            }
        }
        this.carte = carte;
        this.observateur = observateur;
        this.setBackground(Color.red);
        this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("//// click Carte ////");
                    Message m = new Message();
                    m.setType(TypeMessage.CARTE);
                    m.setCarte(carte);
                    observateur.traiterMessage(m);
                }
        });
    }
    
    public void setObservateur(Observateur observateur) {
        this.observateur = observateur;
    }
}
