

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
    
    public VueAventurier (String nomJoueur, String nomAventurier, Color couleur){
        this.window = new JFrame();
        window.setSize(350, 200);

        window.setTitle(nomJoueur);
        mainPanel = new JPanel(new BorderLayout());
        this.window.add(mainPanel);
        
        mainPanel.setBackground(new Color(230, 230, 230));
        mainPanel.setBorder(BorderFactory.createLineBorder(couleur, 2)) ;

        // =================================================================================
        // NORD : le titre = nom de l'aventurier + nom du joueur sur la couleurActive du pion

        this.panelAventurier = new JPanel();
        panelAventurier.setBackground(couleur);
        panelAventurier.add(new JLabel(nomAventurier,SwingConstants.CENTER));
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
        

        btnDeplacer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.setType(DEPLACER);
                    observateur.traiterMessage(m);
                }
     });
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
                Message m = new Message();
                m.setType(DEPLACER);
                observateur.traiterMessage(m);
            }
        });
           btnChoixTuile.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    if(m.getType() == DEPLACER){
                        m.setType(DEPLACER_CHOIX_TUILE);
                        observateur.traiterMessage(m);
                    }else if(m.getType() == ASSECHER){
                        m.setType(ASSECHER_CHOIX_TUILE);
                        observateur.traiterMessage(m);
                    }
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
           position.addActionListener()
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
 

    
    /* public static void main(String [] args) {
        // Instanciation de la fenÃªtre 
        Grille grille = new Grille();
        for (Tuile tuile: grille.getTuiles()){
            
            switch (tuile.getNom()) {
                case La_Porte_de_Bronze:
                    Ingenieur inge = new Ingenieur("Ingenieur", tuile);
                    break;
                case La_Porte_de_Cuivre:
                    Explorateur explo = new Explorateur("Explorateur", tuile);
                    break;
                case Heliport:
                    Pilote pilote = new Pilote("Pilote", tuile);
                    break;
                case La_Porte_de_Fer:
                    Plongeur plongeur = new Plongeur("Plongeur", tuile);
                    break;
                case La_Porte_d_Argent:
                    Messager messager = new Messager("Messager", tuile);
                    break;
                default:
                    break;
            }
        }
    
    }*/
}

 
