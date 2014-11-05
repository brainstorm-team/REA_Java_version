/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.classes;

import DAO.interfaces.IOffreDAO;
import entities.Date;
import entities.Offre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import technique.DataSource;

/**
 *
 * @author jemacom
 */
public class OffreDAO implements IOffreDAO{
    
    private static OffreDAO instance;
    public static OffreDAO getInstance() {
        if (instance == null) {
            instance = new OffreDAO();
        }
        return instance;
    }

    public OffreDAO() {
        connection = DataSource.getInstance().getConnection();
    }
    
    
    
    private Connection connection;
    @Override
    public void insertOffre(Offre offre) {
        
        String AJOUT_OFFRE = "insert into offre (titre , type , categorie ,ville, prix , surface , description , validation) values (?,?,?,?,?,?,?,?)" ; 
        try {
            PreparedStatement ps = connection.prepareStatement(AJOUT_OFFRE);
            ps.setString(1, offre.getTitre() );
            ps.setString(2, offre.getType() );
            ps.setString(3, offre.getCategorie());
            ps.setString(4, offre.getVille());
            ps.setDouble(5, offre.getPrix());
            //ps.setString(4, offre.getDate().toString());  //a remplacer avec offre.getDate().toString()
            ps.setInt(6, offre.getSurface());
            ps.setString(7, offre.getDescription());
            ps.setBoolean(8, offre.isValidation());
           
            ps.executeUpdate();
        }
        catch (SQLException ex){
            Logger.getLogger(OffreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Insertion avec success");
    }

    @Override
    public void updateOffre(Offre offre) {
        
        String UPDATE_OFFRE = "update offre set (titre = ? , type = ? ,categorie = ? , prix =? , surface = ? , description = ?) where id = ? ";
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
            
        }catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    @Override
    public void deleteOffre(int id) {
        String DELETE_OFFRE = "delete from offre where id=?";
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
    
    
    public Offre findOffreById (int id )
    
    {
        Offre offre = new Offre();
        String requete = "select * from offre where id_depot=?";
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
    
    public List<Offre> DisplayAllOffre() 
    
    {

        List<Offre> listeOffres = new ArrayList<Offre>();

        String requete = "select * from offre";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Offre offre = new Offre();
                
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

                listeOffres.add(offre);
            }
            
            return listeOffres;
            } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            
            return null;
        }
    }   
}
