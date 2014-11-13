/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author jemacom
 */
public class Gerant extends Utilisateur{
    private int Nbre;// variable pour statistique

    public int getNbre() {
        return Nbre;
    }

    public void setNbre(int Nbre) {
        this.Nbre = Nbre;
    }
    public Gerant(int Id, String nom, String prenom, String email, String telephone, String adresse, String login, String pass) {
        super(Id, nom, prenom, email, telephone, adresse, login, pass , "gerant");
    }

    public Gerant() {
    }
    
    
    
    
}
