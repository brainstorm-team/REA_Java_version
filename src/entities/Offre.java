/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.logging.Logger;

/**
 *
 * @author jemacom
 */
public class Offre {
    private int id;
    private String titre;  
    private String type;
    private String categorie;
    private String ville; 
    private Double prix;
    private int surface;
    private String description;
    private boolean validation; //l'etat de l'offre s'il est validé ou pas 
    private int idClient;
    private int idGerant;
    //private Date date;   //A changer le type par java.sql.date

    public Offre(int id, String titre, String type, String categorie, String ville, Double prix, int surface, String description, boolean validation, int idClient, int idGerant) {
        this.id = id;
        this.titre = titre;
        this.type = type;
        this.categorie = categorie;
        this.ville = ville;
        this.prix = prix;
        this.surface = surface;
        this.description = description;
        this.validation = validation;
        this.idClient = idClient;
        this.idGerant = idGerant;
    }

    public Offre() {
        
    }

    @Override
    public String toString() {
        return "Offre{" + "id=" + id + ", titre=" + titre + ", type=" + type + ", categorie=" + categorie + ", ville=" + ville + ", prix=" + prix + ", surface=" + surface + ", description=" + description + ", validation=" + validation + ", idClient=" + idClient + ", idGerant=" + idGerant + '}';
    }
    
    /**
     * 
     * Les getters 
     */
    

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getType() {
        return type;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getVille() {
        return ville;
    }

    public Double getPrix() {
        return prix;
    }

    public int getSurface() {
        return surface;
    }

    public String getDescription() {
        return description;
    }

    public boolean isValidation() {
        return validation;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getIdGerant() {
        return idGerant;
    }
    
     /*************************************/
    
    
    
    /**
     * 
     * Les Setters 
     */

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setIdGerant(int idGerant) {
        this.idGerant = idGerant;
    }
   
   
    
    /***********************************/
    
    
        
}
