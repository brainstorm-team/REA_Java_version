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
    
    /*Au moment de l'authentification ces attributs contient les infos de client connecté*/
    public static Client client; 
    public static Offre offreRecherchee;
    public static Double prixMin ;
    public static Double prixMax ; 
    public static int surfaceMin ;
    public static int surfaceMax ; 
    
    
    public static int idR;
    public static String titreR;
    public static String typeR;
    public static String categorieR;
    public static String villeR;
 
    
    
 }
