/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import DAO.classes.OffreDAO;
import DAO.interfaces.IOffreDAO;
import entities.Offre;
import entities.Util;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jemacom
 */
public class ListMesOffres extends AbstractTableModel {
    String [] header={"Titre","Type", "Catégorie", "Ville", "Prix", "Surface"};
    List<Offre> offres=new ArrayList<Offre>();
    

    
     public ListMesOffres() {
        IOffreDAO offreDAO=OffreDAO.getInstance();
        offres=offreDAO.getClientMesOffres();
     }
    @Override
       public String getColumnName(int column) {
        return header[column];
    }
    @Override
    public int getRowCount() {
        return offres.size();
    }

    @Override
    public int getColumnCount() {
        return header.length ;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         switch(columnIndex){
            
            case 0: 
                return offres.get(rowIndex).getTitre();
            case 1: 
                return offres.get(rowIndex).getType();
            case 2: 
                return offres.get(rowIndex).getCategorie();
            case 3: 
                return offres.get(rowIndex).getVille();
            case 4: 
                return offres.get(rowIndex).getPrix();
            case 5: 
                return offres.get(rowIndex).getSurface();
            
            //Pour pouvoir recuperer l'id de l'offre dans le table 
            case 10:
                return offres.get(rowIndex).getId();
                
             /*******/
            default:
                return null;
    }
    
    } 
}
