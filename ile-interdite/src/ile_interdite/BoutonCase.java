/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import static ile_interdite.Etat.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author baratinm
 */
public class BoutonCase extends JButton{
    
    private int x;
    private int y;
    private Observateur observateur;
    private Tuile tuile;

    public BoutonCase(int x, int y, Tuile tuile) {
        super();
        this.x = x;
        this.y = y;
        this.tuile = tuile;
        this.setEnabled(tuile.isActive());
        if (this.tuile.getNom()!=null){
            this.setText(this.tuile.getNom().toString());
            //this.setFont(new Font("TimesRoman", Font.PLAIN, 10));
        }
        this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.setCoordonees(getPosX(), getPosY());
                    m.setType(TypeMessage.CHOIX);
                    observateur.traiterMessage(m);

                }
        });
        if (this.tuile.getEtat()== Asseche){
            this.setBackground(Color.ORANGE);
        }
        else if (this.tuile.getEtat()== Inonde){
            this.setBackground(Color.CYAN);
        }
        else if (this.tuile.getEtat()==Submerge){
            this.setBackground(Color.BLUE);
            this.setEnabled(false);
        }
    }

    public int getPosX() {
        return x;
    }

    public int getPosY() {
        return y;
    }

    public void setObservateur(Observateur observateur) {
        this.observateur = observateur;
    }
    
    
    
    
}
