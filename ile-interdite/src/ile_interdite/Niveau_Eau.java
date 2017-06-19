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
public class Niveau_Eau {
    private int niveau;
    private int palier;

    public Niveau_Eau(int niveau) {
        this.niveau = niveau;
        setPalier();
    }

    public int getNiveau() {
        return niveau;
    }

    public void monteNiveau() {
        this.niveau = this.niveau++;
    }

    public void setPalier() {
        int palier = 0;
        if (this.niveau < 3){
            palier = 2;
        } else if (this.niveau < 6){
            palier = 3;
        } else if (this.niveau < 8){
            palier = 4;
        } else if (this.niveau < 10){
            palier = 5;
        } else {
            palier = 6;
            //  /!\ C'est perdu /!\
        }
        this.palier = palier;
    }
}
