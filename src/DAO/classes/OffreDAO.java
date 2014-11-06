/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.classes;

import DAO.interfaces.IOffreDAO;
import entities.Date;
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


    public OffreDAO() {
        connection = DataSource.getInstance().getConnection();
    }
    /*******************************/

    
    
    
    
    
    @Override
    public void insertOffre(Offre offre) {

        String AJOUT_OFFRE = "insert into offre (titre , type , categorie ,ville, prix , surface , description , validation) values (?,?,?,?,?,?,?,?)";
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
//            ps.setString(4, offre.getDate().toString());
            ps.setString(6, offre.getDescription());
            ps.setInt(7, offre.getId());

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
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
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
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
                offre.setDescription(resultat.getString(3));
//                Date d = new Date();
//                d.setJour(03);
//                d.setMois(11);
//                d.setAnnee(2014);
//                offre.setDate(d);
                offre.setPrix(resultat.getDouble(5));
                offre.setType(resultat.getString(6));

            }
            return offre;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }

    
    
    
    
    
    
    
    public List<Offre> DisplayAllOffre() {

        List<Offre> listeOffres = new ArrayList<>();

        String requete = "select * from offre";
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
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());

            return null;
        }
    }

    
    
    
    
    
    
    
    
    @Override
    public List<Offre> getAllValidatedOffers() {
        List<Offre> listeOffres = new ArrayList<>();

        String requete = "SELECT * FROM offre where validation=1";

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
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());

            return null;
        }
    }
    
    //String titre, String type, String categorie,String ville, Double prix ,int surface
   
    
    
    
    
    
    
    
    
    
    
    
    public List<Offre> getMesOffres(){
    List<Offre> listeOffres = new ArrayList<>();
//    Util.client.setId(5);
    String requete = "SELECT * FROM offre where Id_client=5";

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
                System.out.println(offre.getId());

                listeOffres.add(offre);
            }

            return listeOffres;
        } catch (SQLException ex) {
            //Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des offres " + ex.getMessage());

            return null;
        }
    }


    
    
    
    
    
    
    
    
    
    @Override
    public List<Offre> recherche() {
        
    
        List<Offre> listeOffres = new ArrayList<>();

        String requete = "select * from offre where (titre like ? )and ( type like  ? ) and (categorie like ? )and ( ville like ? )and  (prix > ? ) and (prix < ?) and (surface > ?) and (surface < ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(requete); 
            
            /*if (Util.offreRecherchee.getTitre() != null){
               ps.setString(1, Util.offreRecherchee.getTitre());              
            }else{
                ps.setString(1, "");               
            }
            
            
            if (Util.offreRecherchee.getType() != null){
                ps.setString(2, Util.offreRecherchee.getType());
            }else{
                ps.setString(2, "");
            }
            
            
            if (Util.offreRecherchee.getCategorie() != null){
            ps.setString(3, Util.offreRecherchee.getCategorie());
            }else{
                ps.setString(3, "");
            }
            
            
            if (Util.offreRecherchee.getVille() != null){
                ps.setString(4, Util.offreRecherchee.getVille());
            }else{
                ps.setString(4, "");
            }*/
            ps.setString(1, "%"+Util.titreR+"%");
            ps.setString(2, "%"+Util.typeR+"%");
            ps.setString(3, "%"+Util.categorieR+"%");
            ps.setString(4, "%"+Util.villeR+"%");
            
            ps.setDouble(5, Util.prixMin);
            ps.setDouble(6, Util.prixMax);
            ps.setInt(7, Util.surfaceMin);
            ps.setInt(8, Util.surfaceMax);
            
            
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
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des offres " + ex.getMessage());
        }
    return null;
    }
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public List<Offre> getAllUnValidatedOffers() {
        
        List<Offre> listeOffres = new ArrayList<>();

        String requete = "SELECT * FROM offre where validation=0";

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
            //Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des offres " + ex.getMessage());

            return null;
        }
    }
}   

