 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.classes;

import DAO.interfaces.IOffreDAO;
import entities.Offre;
import entities.Util;
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
import technique.DataSource;

/**
 *
 * @author jemacom
 */
public class OffreDAO implements IOffreDAO {

    
    /*********Singleton*********/
    private static OffreDAO instance;

    public static OffreDAO getInstance() {
        if (instance == null) {
            instance = new OffreDAO();
        }
        return instance;
    }
    
    private Connection connection;


    private OffreDAO() {
        connection = DataSource.getInstance();
    }
    /*******************************/

    /**
     * 
     * J'ai ajouté une colonne date_insertion de type TIMESTAMP 
     * qui prend par défault la date now() de système  CURRENT_TIMESTAMP
     */
    
    
    
    
    @Override
    public void insertOffre(Offre offre) {

        String AJOUT_OFFRE = "insert into offre (titre , type , categorie ,ville, prix , surface , description , validation , Id_user ) values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(AJOUT_OFFRE);
            ps.setString(1, offre.getTitre());
            ps.setString(2, offre.getType());
            ps.setString(3, offre.getCategorie());
            ps.setString(4, offre.getVille());
            ps.setDouble(5, offre.getPrix());
            //ps.setString(4, offre.getDate().toString());  //a remplacer avec offre.getDate().toString()
            ps.setInt(6, offre.getSurface());
            ps.setString(7, offre.getDescription());
            ps.setBoolean(8, offre.isValidation());
            ps.setInt(9 , Util.id_agent_connecte);
            
            ps.executeUpdate();
            System.out.println("Insertion ........");
        } catch (SQLException ex) {
            Logger.getLogger(OffreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Insertion avec success");
    }

    
    
    
    
    
    @Override
    public void updateOffre(Offre offre) {

        String UPDATE_OFFRE = "update offre set (titre = ? , type = ? ,categorie = ? , prix =? , surface = ? , description = ?) where Id = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_OFFRE);
            ps.setString(1, offre.getTitre());
            ps.setString(2, offre.getType());
            ps.setString(3, offre.getCategorie());
            ps.setDouble(4, offre.getPrix());
            ps.setInt(5, offre.getSurface());
            ps.setString(6, offre.getDescription());
            ps.setInt(7, offre.getId());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
    
    
    
    
    
    

    @Override
    public void deleteOffre(int id) {
        String DELETE_OFFRE = "delete from offre where Id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_OFFRE);
            ps.setInt(1, id);
            ps.executeUpdate();
            
            System.out.println("Offre supprimée ! \n");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
    
    
    
    
    
    

    public Offre findOffreById(int id) {
        Offre offre = new Offre();
        String requete = "select * from offre where Id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                
                offre.setId(resultat.getInt(1));
                offre.setTitre(resultat.getString(2));
                offre.setType(resultat.getString(3));
                offre.setCategorie(resultat.getString(4));
                offre.setVille(resultat.getString(5));
                offre.setPrix(resultat.getDouble(6));
                offre.setSurface(resultat.getInt(7));
                offre.setDescription(resultat.getString(8));
                offre.setValidation(resultat.getBoolean(9));
                offre.setIdClient(resultat.getInt(10));

            }
            return offre;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du l'offre .. " + ex.getMessage());
            return null;
        }
    }

    
    
    
    
    
    
    
    @Override
    public List<Offre> DisplayAllOffre() {

        List<Offre> listeOffres = new ArrayList<>();

        String requete = "select * from offre order by date_insertion desc";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

             while (resultat.next()) {
                Offre offre = new Offre();

                offre.setId(resultat.getInt(1));
                offre.setTitre(resultat.getString(2));
                offre.setType(resultat.getString(3));
                offre.setCategorie(resultat.getString(4));
                offre.setVille(resultat.getString(5));
                offre.setPrix(resultat.getDouble(6));
                offre.setSurface(resultat.getInt(7));
                offre.setDescription(resultat.getString(8));
                offre.setValidation(resultat.getBoolean(9));
                offre.setIdClient(resultat.getInt(10));
                offre.setIdGerant(resultat.getInt(11));

                listeOffres.add(offre);
            }

            return listeOffres;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());

            return null;
        }
    }

    
    
    
    
    
    
    
    
    @Override
    public List<Offre> getAllValidatedOffers() {
        List<Offre> listeOffres = new ArrayList<>();

        String requete = "SELECT * FROM offre where validation=1 ORDER BY date_insertion DESC";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            System.out.println("Selection des offres validés.........");
            while (resultat.next()) {
                Offre offre = new Offre();

                offre.setId(resultat.getInt(1));
                offre.setTitre(resultat.getString(2));
                offre.setType(resultat.getString(3));
                offre.setCategorie(resultat.getString(4));
                offre.setVille(resultat.getString(5));
                offre.setPrix(resultat.getDouble(6));
                offre.setSurface(resultat.getInt(7));
                offre.setDescription(resultat.getString(8));
                offre.setValidation(resultat.getBoolean(9));
                offre.setIdClient(resultat.getInt(10));
                offre.setIdGerant(resultat.getInt(11));
                
                System.out.println(offre.getId());

                listeOffres.add(offre);
            }

            return listeOffres;
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());

            return null;
        }
    }      
    
    
    
    
    
    
    
    
    
    
    @Override
    public List<Offre> getClientMesOffres(){
    List<Offre> listeOffres = new ArrayList<>();
    String requete = "SELECT * FROM offre where Id_user=? order by date_insertion desc";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, Util.id_agent_connecte);
            ResultSet resultat =  ps.executeQuery();
            while (resultat.next()) {
                Offre offre = new Offre();

                offre.setId(resultat.getInt(1));
                offre.setTitre(resultat.getString(2));
                offre.setType(resultat.getString(3));
                offre.setCategorie(resultat.getString(4));
                offre.setVille(resultat.getString(5));
                offre.setPrix(resultat.getDouble(6));
                offre.setSurface(resultat.getInt(7));
                offre.setDescription(resultat.getString(8));
                offre.setValidation(resultat.getBoolean(9));
                offre.setIdClient(resultat.getInt(10));
                offre.setIdGerant(resultat.getInt(11));
                System.out.println(offre.getId());

                listeOffres.add(offre);
            }

            return listeOffres;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des offres " + ex.getMessage());

            return null;
        }
    }


    
    
    
    
    
    
    
    
    
    @Override
    public List<Offre> recherche() {
        
    
        List<Offre> listeOffres = new ArrayList<>();

        String requete = "select * from offre where ( type like  ? ) and (categorie like ? )and ( ville like ? )and  (prix > ? ) and (prix < ?) and (surface > ?) and (surface < ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(requete); 
            
            ps.setString(1, "%"+Util.typeR+"%");
            ps.setString(2, "%"+Util.categorieR+"%");
            ps.setString(3, "%"+Util.villeR+"%");
            
            ps.setDouble(4, Util.prixMin);
            ps.setDouble(5, Util.prixMax);
            ps.setInt(6, Util.surfaceMin);
            ps.setInt(7, Util.surfaceMax);
            
            
            ResultSet resultat = ps.executeQuery();
            
            System.out.println("Recherche des offres demandées.........");
            while (resultat.next()) {
                
                Offre offreR = new Offre();

                offreR.setId(resultat.getInt(1));
                offreR.setTitre(resultat.getString(2));
                offreR.setType(resultat.getString(3));
                offreR.setCategorie(resultat.getString(4));
                offreR.setVille(resultat.getString(5));
                offreR.setPrix(resultat.getDouble(6));
                offreR.setSurface(resultat.getInt(7));
                offreR.setDescription(resultat.getString(8));
                offreR.setValidation(resultat.getBoolean(9));
                offreR.setIdClient(resultat.getInt(10));
                offreR.setIdGerant(resultat.getInt(11));
                
                

                listeOffres.add(offreR);
            }

            return listeOffres;
            
        } catch (SQLException ex) {
            
            System.out.println("erreur lors du chargement des offres " + ex.getMessage());
        }
    return null;
    }
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public List<Offre> getAllUnValidatedOffers() {
        
        List<Offre> listeOffres = new ArrayList<>();

        String requete = "SELECT * FROM offre where validation=0 order by date_insertion desc";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            System.out.println("Selection des offres non validés...........");
            while (resultat.next()) {
                Offre offre = new Offre();

                offre.setId(resultat.getInt(1));
                offre.setTitre(resultat.getString(2));
                offre.setType(resultat.getString(3));
                offre.setCategorie(resultat.getString(4));
                offre.setVille(resultat.getString(5));
                offre.setPrix(resultat.getDouble(6));
                offre.setSurface(resultat.getInt(7));
                offre.setDescription(resultat.getString(8));
                offre.setValidation(resultat.getBoolean(9));
                offre.setIdClient(resultat.getInt(10));
                offre.setIdGerant(resultat.getInt(11));
                System.out.println(offre.getId());

                listeOffres.add(offre);
            }

            return listeOffres;
        } catch (SQLException ex) {
            
            System.out.println("erreur lors du chargement des offres " + ex.getMessage());

            return null;
        }
    }

    @Override
    public List<Offre> getGerantMesOffres() {
        List<Offre> listeOffres = new ArrayList<>();
    String requete = "SELECT * FROM offre where Id_user=?";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1 , Util.id_agent_connecte);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Offre offre = new Offre();

                offre.setId(resultat.getInt(1));
                offre.setTitre(resultat.getString(2));
                offre.setType(resultat.getString(3));
                offre.setCategorie(resultat.getString(4));
                offre.setVille(resultat.getString(5));
                offre.setPrix(resultat.getDouble(6));
                offre.setSurface(resultat.getInt(7));
                offre.setDescription(resultat.getString(8));
                offre.setValidation(resultat.getBoolean(9));
                offre.setIdClient(resultat.getInt(10));
                offre.setIdGerant(resultat.getInt(11));
                System.out.println(offre.getId());

                listeOffres.add(offre);
            }

            return listeOffres;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des offres " + ex.getMessage());

            return null;
        }
    }

    @Override
    public void validerOffre(int id) {
        String requete = "update offre set validation = 1 where Id= ?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OffreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}   

