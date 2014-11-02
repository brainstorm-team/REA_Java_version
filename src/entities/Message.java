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
public class Message {
    private int id ; 
    private String type; 
    private String contenu; 

    public Message(int id, String type, String contenu) {
        this.id = id;
        this.type = type;
        this.contenu = contenu;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getContenu() {
        return contenu;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    
    
    
    
}
