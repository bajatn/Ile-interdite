

package ile_interdite;

import static ile_interdite.Lieu.*;
import static ile_interdite.TypeMessage.*;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.MatteBorder;

 
public class VueAventurier  {
     
    private final JPanel panelBoutons ;
    private final JPanel panelCentre ;
    private final JFrame window;
    private final JPanel panelAventurier;
    private final JPanel mainPanel;
    private final JButton btnDeplacer  ;
    private final JButton btnAssecher;
    private final JButton btnChoixTuile;
    private final JButton btnTerminerTour;
    private final JTextField position;
    private Observateur observateur;
    private JLabel nomAventurier;
    
    public VueAventurier (String nomJoueur, String nomAventurier, Color couleur){
        this.window = new JFrame();
        window.setSize(350, 200);
        
        window.setTitle(nomJoueur);
        mainPanel = new JPanel(new BorderLayout());
        this.window.add(mainPanel);
        
        mainPanel.setBackground(new Color(230, 230, 230));
        mainPanel.setBorder(BorderFactory.createLineBorder(couleur, 2));

        // =================================================================================
        // NORD : le titre = nom de l'aventurier + nom du joueur sur la couleurActive du pion

        this.panelAventurier = new JPanel();
        panelAventurier.setBackground(couleur);
        this.nomAventurier =new JLabel(nomAventurier,SwingConstants.CENTER);
        panelAventurier.add(this.nomAventurier);
        mainPanel.add(panelAventurier, BorderLayout.NORTH);
   
        // =================================================================================
        // CENTRE : 1 ligne pour position courante
        this.panelCentre = new JPanel(new GridLayout(2, 1));
        this.panelCentre.setOpaque(false);
        this.panelCentre.setBorder(new MatteBorder(0, 0, 2, 0, couleur));
        mainPanel.add(this.panelCentre, BorderLayout.CENTER);
        
        panelCentre.add(new JLabel ("Position", SwingConstants.CENTER));
        position = new  JTextField(30); 
        position.setHorizontalAlignment(CENTER);
        panelCentre.add(position);


        // =================================================================================
        // SUD : les boutons
        this.panelBoutons = new JPanel(new GridLayout(2,2));
        this.panelBoutons.setOpaque(false);
        mainPanel.add(this.panelBoutons, BorderLayout.SOUTH);

        this.btnDeplacer = new JButton("Aller") ;
        this.btnAssecher = new JButton( "Assecher");
        this.btnChoixTuile = new JButton("ChoixTuile") ;
        this.btnTerminerTour = new JButton("Terminer Tour") ;
        
        this.panelBoutons.add(btnDeplacer);
        this.panelBoutons.add(btnAssecher);
        this.panelBoutons.add(btnChoixTuile);
        this.panelBoutons.add(btnTerminerTour);

        this.window.setVisible(true);
        mainPanel.repaint();
        

      
        btnAssecher.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.setType(ASSECHER);
                    
                    observateur.traiterMessage(m);
                   
                }
     });
        btnDeplacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String stringPosition;
                Message m = new Message();
                m.setType(DEPLACER);
                observateur.traiterMessage(m);
            }
        });
           btnChoixTuile.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.setType(CHOIX);
                    int x = Integer.parseInt(Character.toString(position.getText().charAt(0)));
                    int y = Integer.parseInt(Character.toString(position.getText().charAt(2)));
                    m.setCoordonees(x, y);
                    observateur.traiterMessage(m);
                }
        });
           btnTerminerTour.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.setType(TERMINER_TOUR);
                    observateur.traiterMessage(m);
            }
        });
    
    }
     public void setObservateur(Observateur observateur) {
        this.observateur = observateur;
    }
     public JButton getBtnAutreAction() {
        return btnChoixTuile;
    }

    public void setPosition(String pos) {
        this.position.setText(pos);
    }

    public JButton getBtnAller() {
        return btnDeplacer;
    }
    
    public JButton getBtnAssecher() {
        return btnAssecher;
    }

    public JButton getBtnTerminerTour() {
        return btnTerminerTour;
    }
    
    public void mettreAJour(String nomJoueur, String nomAventurier, Color couleur){
        window.setTitle(nomJoueur);
        mainPanel.setBorder(BorderFactory.createLineBorder(couleur, 2));
        this.panelCentre.setBorder(new MatteBorder(0, 0, 2, 0, couleur));
        panelAventurier.setBackground(couleur);
        this.nomAventurier.setText(nomAventurier);
        panelAventurier.add(this.nomAventurier);
        mainPanel.add(panelAventurier, BorderLayout.NORTH);
        window.repaint();
    }
}

 
