/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import DAO.classes.FavorisDAO;
import DAO.interfaces.IFavorisDAO;
import entities.Offre;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jemacom
 */
public class ListFavoris extends AbstractTableModel{
    String[] header = {"Titre" , "Type" , "Catégorie" , "Ville" , "Prix" , "Surface"};
    List<Offre> list_favoris = new ArrayList<>();
    
    public ListFavoris (){
        IFavorisDAO favorisDAO = FavorisDAO.getInstance();
        list_favoris = favorisDAO.DisplayAllFavoris();
    }
    
     @Override
       public String getColumnName(int column) {
        return header[column];
    }
    @Override
    public int getRowCount() {
        return list_favoris.size();
    }

    @Override
    public int getColumnCount() {
        return header.length ;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
             switch(columnIndex){
            
            case 0: 
                return list_favoris.get(rowIndex).getTitre();
            case 1: 
                return list_favoris.get(rowIndex).getType();
            case 2: 
                return list_favoris.get(rowIndex).getCategorie();
            case 3: 
                return list_favoris.get(rowIndex).getVille();
            case 4: 
                return list_favoris.get(rowIndex).getPrix();
            case 5: 
                return list_favoris.get(rowIndex).getSurface();
            //Pour pouvoir recuperer l'id de l'offre dans le table 
            case 10:
                return list_favoris.get(rowIndex).getId();
                
             /*******/
            default:
                return null;
    }
    }
}
