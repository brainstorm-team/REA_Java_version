/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import DAO.classes.ClientDAO;
import DAO.classes.FavorisDAO;
import DAO.interfaces.IClientDAO;
import DAO.interfaces.IFavorisDAO;
import entities.Client;
import entities.Offre;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jemacom
 */
public class ListComptesClients extends AbstractTableModel{
    String[] header = {"Nom" , "Prenom" , "Email" , "Telephone" , "Adresse" , "Login" , "Pass"};
    List<Client> list_clients = new ArrayList<>();

    public ListComptesClients() {
        IClientDAO clientDAO = ClientDAO.getInstance();
        list_clients = clientDAO.DiplayAllClient();
    }
     @Override
       public String getColumnName(int column) {
        return header[column];
    }
    
    @Override
    public int getRowCount() {
        return list_clients.size();
    }


    @Override
    public int getColumnCount() {
        return header.length ;
    }

        @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
             switch(columnIndex){
            
            case 0: 
                return list_clients.get(rowIndex).getNom();
            case 1: 
                return list_clients.get(rowIndex).getPrenom();
            case 2: 
                return list_clients.get(rowIndex).getEmail();
            case 3: 
                return list_clients.get(rowIndex).getTelephone();
            case 4: 
                return list_clients.get(rowIndex).getLogin();
            case 5: 
                return list_clients.get(rowIndex).getPass();
            //Pour pouvoir recuperer l'id de l'offre dans le table 
            case 10:
                return list_clients.get(rowIndex).getId();
                
             /*******/
            default:
                return null;
    }
    
    }
    
}
