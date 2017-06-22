/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

/**
 *
 * @author bajatn
 */
public class Partie_Tresor extends Carte_Tresor {
    
    private Type_Tresor tresor;
    
    public Partie_Tresor(Type_Tresor tresor) {
        super("Partie_Tresor");
        this.tresor = tresor;
    }

    public Type_Tresor getTresor() {
        return tresor;
    }
    
    
    
}
