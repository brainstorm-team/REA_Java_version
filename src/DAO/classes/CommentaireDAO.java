/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.classes;

import DAO.interfaces.ICommentaireDAO;
import entities.Commentaire;
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


public class CommentaireDAO implements ICommentaireDAO {

    private Connection connection;

    public CommentaireDAO() {
        connection = DataSource.getInstance();
    }

    public void insertCommentaire(Commentaire commentaire) {
        String requete = "insert into commentaire (commentaire,reponse) values (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, commentaire.getCommentaire());
            ps.setString(2, commentaire.getReponse());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateCommentaire(Commentaire commentaire) {
        
        
        
        
        String requete = "update commentaire set commentaire=? , reponse=? where Id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, commentaire.getCommentaire());
            ps.setString(2, commentaire.getReponse());
            ps.setInt(3, commentaire.getIdCommentaire());
            ps.executeUpdate();
            
            //JOptionPane.showMessageDialog(null, ps);
            JOptionPane.showMessageDialog(null, "Mise à jour effectuée avec succès");
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    public void deleteCommentaire(int id) {
        String requete = "delete from commentaire where Id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Commentaire supprimée");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    public Commentaire findCommentaireById(int id) {
        Commentaire commentaire = new Commentaire();
        String requete = "select * from commentaire where Id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                commentaire.setIdCommentaire(resultat.getInt(1));
                commentaire.setCommentaire(resultat.getString(2));
            }
            return commentaire;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }

    //
    public Commentaire findCommentaireByAdresse(String adr) {
        Commentaire commentaire = new Commentaire();
        String requete = "select * from commentaire where commentaire=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, adr);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                commentaire.setIdCommentaire(resultat.getInt(1));
                commentaire.setCommentaire(resultat.getString(2));
            }
            return commentaire;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }

    public List<Commentaire> DisplayAllCommentaires() {

        List<Commentaire> listecommentaires = new ArrayList<Commentaire>();

        String requete = "select * from commentaire";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Commentaire commentaire = new Commentaire();
                commentaire.setIdCommentaire(resultat.getInt(1));
                commentaire.setCommentaire(resultat.getString(2));

                listecommentaires.add(commentaire);
            }
            return listecommentaires;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }
    private static ICommentaireDAO iCommentaireDAO;

    public static ICommentaireDAO getInstance() {
        if (iCommentaireDAO == null) {
            iCommentaireDAO = new CommentaireDAO();
        }
        return iCommentaireDAO;
    }

}