/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import static entities.Util.client;

/**
 *
 * @author jemacom
 */


/*
Cette classe contient des infos qu'on a besoin de les transmettent entre les fenetres
*/
public class Util {
    /*Au moment de l'authentification cet attribut contient les infos de client connecté*/
    public static Client client; 
    public static Offre offreRecherchee;
    public static int UN = 1;
    
    public static int getId(){
       return client.getId();
    }   
    public static void setId(int UN ){
        client.Id = UN;
    }
 }
