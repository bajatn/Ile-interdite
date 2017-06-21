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
public class BoutonCase extends JButton{
    
    private int x;
    private int y;
    private Observateur observateur;

    public BoutonCase(int x, int y) {
        super();
        
        this.x = x;
        this.y = y;
        this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.setCoordonees(getPosX(), getPosY());
                    m.setType(TypeMessage.CHOIX);
                    observateur.traiterMessage(m);

                }
        });
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
