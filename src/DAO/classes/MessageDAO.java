/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.classes;

import DAO.interfaces.IMessageDAO;
import entities.Message;
import entities.Util;
import technique.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class MessageDAO implements IMessageDAO {

    private Connection connection;

    public MessageDAO() {
        connection = DataSource.getInstance();
    }

    public void insertMessage(Message message) {
        String requete = "insert into message (message,sujet,reponse,Id_client) values (?,?,?,?)";
       try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, message.getMessage());
            ps.setInt(4,Util.id_agent_connecte);

            ps.setString(2, message.getSujet());
            ps.setString(3, message.getReponsemsg());
       
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Ajout effectuée");
        
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    public void updateMessage(Message message) {
        String requete = "update message set message=?,sujet=?,reponse=? ,Id_client=? ,Id_gerant = ? where Id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, message.getMessage());
            ps.setString(2, message.getSujet());
            ps.setString(3, message.getReponsemsg());
            ps.setInt(4,message.getId_client());
            ps.setInt(5, Util.id_agent_connecte);
            ps.setInt(6, message.getIdmessage());

            ps.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Message envoyer " );

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    public void deleteMessage(int id) {
        String requete = "delete from message where Id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Message supprimée");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    public Message findMessageById(int id) {
        Message message = new Message();
        String requete = "select * from message where Id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                message.setIdMessage(resultat.getInt(1));
                message.setMessage(resultat.getString(2));
            }
            return message;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du message " + ex.getMessage());
            return null;
        }
    }

    //
    public Message findMessageByAdresse(String adr) {
        Message message = new Message();
        String requete = "select * from message where message=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, adr);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                message.setIdMessage(resultat.getInt(1));
                message.setMessage(resultat.getString(2));
            }
            return message;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du message " + ex.getMessage());
            return null;
        }
    }

    public List<Message> DisplayAllMessages() {

        List<Message> listemessages = new ArrayList<Message>();

        String requete = "select * from message";
        try {
            Statement statement = connection .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Message message = new Message();
                message.setIdMessage(resultat.getInt(1));
                message.setMessage(resultat.getString(2));
                 message.setSujet(resultat.getString(3));
                message.setReponsemsg(resultat.getString(4));

                listemessages.add(message);
            }
            return listemessages;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des messages " + ex.getMessage());
            return null;
        }
    }
    private static IMessageDAO iMessageDAO;

    public static IMessageDAO getInstance() {
        if (iMessageDAO == null) {
            iMessageDAO = new MessageDAO();
        }
        return iMessageDAO;
    }

    
   
 
}