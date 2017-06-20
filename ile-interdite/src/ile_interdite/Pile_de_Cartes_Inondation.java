/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import static ile_interdite.Lieu.*;
import java.util.ArrayList;
/**
 *
 * @author bajatn
 */
public class Pile_de_Cartes_Inondation extends Pile_de_Cartes{
    
    
    public Pile_de_Cartes_Inondation(){
        super();  
        this.getCartes().add(new Carte_Inondation(Le_Pont_des_Abimes));
        this.getCartes().add(new Carte_Inondation(La_Porte_de_Bronze));
        this.getCartes().add(new Carte_Inondation(La_Caverne_des_Ombres));
        this.getCartes().add(new Carte_Inondation(La_Porte_de_Fer));
        this.getCartes().add(new Carte_Inondation(La_Porte_d_Or));
        this.getCartes().add(new Carte_Inondation(Les_Falaises_de_l_Oubli));
        this.getCartes().add(new Carte_Inondation(Le_Palais_de_Corail));
        this.getCartes().add(new Carte_Inondation(La_Porte_d_Argent));
        this.getCartes().add(new Carte_Inondation(Les_Dunes_de_l_Illusion));
        this.getCartes().add(new Carte_Inondation(Heliport));
        this.getCartes().add(new Carte_Inondation(La_Porte_de_Cuivre));
        this.getCartes().add(new Carte_Inondation(Le_Jardin_des_Hurlements));
        this.getCartes().add(new Carte_Inondation(La_Foret_Pourpre));
        this.getCartes().add(new Carte_Inondation(Le_Lagon_Perdu));
        this.getCartes().add(new Carte_Inondation(Le_Marais_Brumeux));
        this.getCartes().add(new Carte_Inondation(Observatoire));
        this.getCartes().add(new Carte_Inondation(Le_Rocher_Fantome));
        this.getCartes().add(new Carte_Inondation(La_Caverne_du_Brasier));
        this.getCartes().add(new Carte_Inondation(Le_Temple_du_Soleil));
        this.getCartes().add(new Carte_Inondation(Le_Temple_de_La_Lune));
        this.getCartes().add(new Carte_Inondation(Le_Palais_des_Marees));
        this.getCartes().add(new Carte_Inondation(Le_Val_du_Crepuscule));
        this.getCartes().add(new Carte_Inondation(La_Tour_du_Guet));
        this.getCartes().add(new Carte_Inondation(Le_Jardin_des_Murmures));
        setCarte_dessus();
    }
        
    
    
    
}