/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package technique;

import DAO.classes.ClientDAO;

import entities.Client;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author anwer
 */
public class TableClient extends AbstractTableModel {

    List<Client> listclient = new ArrayList<Client>();
    String[] header = {"id", "prenom", "nom", "email", "telephone", "adresse", "login", "pass"};

    public TableClient() {

        listclient = new ClientDAO().SelectClient();
    }

    @Override
    public String getColumnName(int column) {//recupere nom de tableaux
        return header[column];
    }

    @Override
    public int getRowCount() {// taile de tableaux
        return listclient.size();
    }

    @Override
    public int getColumnCount() {// nb colune
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {//indice ligne indice columne
        switch (columnIndex) {// parcour par colonne

            case 0:
                return listclient.get(rowIndex).getId();
            case 1:
                return listclient.get(rowIndex).getPrenom();
            case 2:
                return listclient.get(rowIndex).getNom();
            case 3:
                return listclient.get(rowIndex).getEmail();
            case 4:
                return listclient.get(rowIndex).getTelephone();
            case 5:
                return listclient.get(rowIndex).getAdresse();
            case 6:
                return listclient.get(rowIndex).getLogin();
            case 7:
                return listclient.get(rowIndex).getPass();
        }

        return null;
    }
}
