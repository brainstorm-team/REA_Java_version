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
public class Admin extends Utilisateur{

    public Admin(String nom, String prenom, String email, int cin, String login, String password) {
        super(nom, prenom, email, cin, login, password);
    }
    
    
}
