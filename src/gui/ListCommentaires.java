/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import DAO.classes.CommentaireDAO;
import DAO.interfaces.ICommentaireDAO;
import entities.Commentaire;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author WIEM
 */
public class ListCommentaires extends AbstractTableModel{

    String [] tab={"Id", "Commentaire" , "Id offre" , "Id client"};
    List<Commentaire> commentaires=new ArrayList<Commentaire>();
    
    public ListCommentaires() {
        ICommentaireDAO icommentaire=CommentaireDAO.getInstance();
        commentaires=icommentaire.DisplayAllCommentaires();
    
    }

    @Override
    public String getColumnName(int column) {
        return tab[column];
    }
    
    
    
    @Override
    public int getRowCount() {
        return commentaires.size();
    }

    @Override
    public int getColumnCount() {
        return tab.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            case 0: 
                return commentaires.get(rowIndex).getIdCommentaire();
            case 1: 
                return commentaires.get(rowIndex).getCommentaire();
            case 2:
                return commentaires.get(rowIndex).getId_offre();
            case 3:
                return commentaires.get(rowIndex).getId_client();
            default:
                return null;
        }
    }
    
}