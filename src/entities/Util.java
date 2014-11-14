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


/*
Cette classe contient des infos qu'on a besoin de les transmettent entre les fenetres
*/
public class Util { 
    
    /*Au moment de l'authentification ces attributs contient les infos de client connecté*/
    public static String nom_agent_connecte; 
    public static String prenom_agent_connecte; 
    public static String email_agent_connecte; 
    public static String adresse_agent_connecte; 
    public static String login_agent_connecte; 
    public static String telephone_agent_connecte;
    
    public static int id_agent_connecte;
    public static String role_agent_connecte;
    public static int idR;
    public static String typeR;
    public static String categorieR;
    public static String villeR;
    
    public static Double prixMin ;
    public static Double prixMax ; 
    public static int surfaceMin ;
    public static int surfaceMax ; 
    public static int IdMessageAR;       //Id message à répondre
    public static int idOffreASupprimer;
    public static int Id_Offre_commentaire;
    public static int Id_client_commentaire;
    
 }
