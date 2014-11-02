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
public class Utilisateur {
    protected String nom;
    protected String prenom;
    protected String email;
    protected int cin; 
    protected String login; 
    protected String password;

    public Utilisateur(String nom, String prenom, String email, int cin, String login, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.cin = cin;
        this.login = login;
        this.password = password;
    } 
    
    
    public String toString(){
        return "Nom : "+nom+"Prenom : "+prenom+"Email : "+email+"CIN : "+cin+"\n";
        //On affiche PAS le login et password  
    }
    
    
}
    

