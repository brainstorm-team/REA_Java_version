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
    private String titre; 
    private int id; 
    private String description; 
    private Date date;
    private double prix;

    
   
    public Offre(String titre, int reference, String description, Date date, double prix) {
        this.titre = titre;
        this.id = reference;
        this.description = description;
        this.date = date;
        this.prix = prix;
    }

    /**
     * 
     * Les getters 
     */
    
    public String getTitre() {
        return titre;
    }

    public int getReference() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public double getPrix() {
        return prix;
    }
    /*************************************/
    
    
    
    /**
     * 
     * Les Setters 
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setReference(int reference) {
        this.id = reference;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    /***********************************/
    
    
        
}
