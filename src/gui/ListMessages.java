/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import DAO.classes.MessageDAO;
import DAO.interfaces.IMessageDAO;
import entities.Message;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author WIEM
 */
public class ListMessages extends AbstractTableModel{

    String [] tab={"Id", "message","sujet","reponsemsg"};
    List<Message> messages=new ArrayList<Message>();
    
    public ListMessages() {
        IMessageDAO imessage=MessageDAO.getInstance();
        messages=imessage.DisplayAllMessages();
    
    }

    @Override
    public String getColumnName(int column) {
        return tab[column];
    }
    
    
    
    @Override
    public int getRowCount() {
        return messages.size();
    }

    @Override
    public int getColumnCount() {
        return tab.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            case 0: 
                return messages.get(rowIndex).getIdmessage();
            case 1: 
                return messages.get(rowIndex).getMessage();
                case 2: 
                return messages.get(rowIndex).getSujet();
                    case 3: 
                return messages.get(rowIndex).getReponsemsg();
                    
           
            default:
                return null;
        }
    }
    
}