/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import DAO.classes.OffreDAO;
import DAO.interfaces.IOffreDAO;
import entities.Offre;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jemacom
 */
public class ListOffreNonValide extends AbstractTableModel{
    
    String [] header={"id","Titre","Type", "Catégorie", "Ville", "Prix", "Surface","Id client"};
    List<Offre> offres=new ArrayList<>();
    
    public ListOffreNonValide() {
        IOffreDAO offreDAO=OffreDAO.getInstance();
        offres=offreDAO.getAllValidatedOffers();
    
    }
    @Override
    public int getRowCount() {
        return offres.size();
    }

    @Override
    public int getColumnCount() {
    return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    switch(columnIndex){
            case 0:
                return offres.get(rowIndex).getId();
            case 1: 
                return offres.get(rowIndex).getTitre();
            case 2: 
                return offres.get(rowIndex).getType();
            case 3: 
                return offres.get(rowIndex).getCategorie();
            case 4: 
                return offres.get(rowIndex).getVille();
            case 5: 
                return offres.get(rowIndex).getPrix();
            case 6: 
                return offres.get(rowIndex).getSurface();
            case 7: 
                return offres.get(rowIndex).getIdClient();
            default:
                return null;
    }
    
    
}
    
    @Override
    public String getColumnName(int column) {
        return header[column];
    }
}
