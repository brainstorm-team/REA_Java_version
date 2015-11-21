package technique;

import DAO.classes.AdminDAO;
import entities.Admin;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableAdmin extends AbstractTableModel {
 List<Admin> listAdmin = new ArrayList<Admin>();
  String []header = {"id","prenom","nom","email","telephone","adresse","login","pass"};
   public TableAdmin() {
       
        listAdmin = new AdminDAO().SelectAdmin();
    }
    @Override
    public String getColumnName(int column) {//recupere nom de tableaux
        return header[column];
    }
 @Override
    public int getRowCount() {// taile de tableaux
        return listAdmin.size();
    }

 
 @Override
    public int getColumnCount() {// nb colune
       return header.length;
    }

  
 @Override
    public Object getValueAt(int rowIndex, int columnIndex) {//indice ligne indice columne
        switch (columnIndex) {// parcour par colonne


            case 0:
                return listAdmin.get(rowIndex).getId();
            case 1:
                return listAdmin.get(rowIndex).getPrenom();

            case 2:
                return listAdmin.get(rowIndex).getNom();
            case 3:
                return listAdmin.get(rowIndex).getEmail();
          
              
                case 4:
                return listAdmin.get(rowIndex).getTelephone();
                

                 case 5:
                   return listAdmin.get(rowIndex).getAdresse();
                   case 6:
                   return listAdmin.get(rowIndex).getLogin();
                   case 7:
                  return listAdmin.get(rowIndex).getPass();
        }

                return null;
        }
    }
    


    
    
   
