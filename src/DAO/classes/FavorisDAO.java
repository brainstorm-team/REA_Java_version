/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.classes;

import DAO.interfaces.IFavorisDAO;
import entities.Offre;
import entities.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import technique.DataSource;

/**
 *
 * @author jemacom
 */
public class FavorisDAO implements IFavorisDAO{
    
    /*********Singleton*********/
    private static FavorisDAO instance;

    public static FavorisDAO getInstance() {
        if (instance == null) {
            instance = new FavorisDAO();
        }
        return instance;
    }
    
    private Connection connection;


    public FavorisDAO() {
        connection = DataSource.getInstance();
    }
    /*******************************/
    
    /**
     *
     * @param id
     */
    @Override
    public void insertFavoris(int id) {
        String requete = "insert into favoris (Id_client , Id_offre) values (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, Util.id_agent_connecte);
            ps.setInt(2 , id); //id de l'offre selectionnee
            ps.executeUpdate();
            
            System.out.println("offre ajouté aux favoris ... ! \n");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la l'ajout aux favoris " + ex.getMessage());
        }
    }

    @Override
    public List<Offre> DisplayAllFavoris() {
        List<Offre> listeFavoris = new ArrayList<>();
        List<Integer> listeIdOffres = new ArrayList<>();
        String requete ="select * from favoris where Id_client= ? ";
        try{
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, Util.id_agent_connecte);
            
            ResultSet resultat = ps.executeQuery();
            System.out.println("Extraction des (id) des offres en favoris......\n");
            
            //Ajout des Id extracté dans d'une liste
            while (resultat.next()){
                listeIdOffres.add(resultat.getInt(3));
            } 
            
            //parcours des id, extraction de l'offre et ajout dans listeFavoris
            int i=0;
            while (i<listeIdOffres.size()){
                listeFavoris.add(OffreDAO.getInstance().findOffreById(listeIdOffres.get(i)));
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FavorisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listeFavoris;
    }

    @Override
    public void deleteFavoris(int id) {
        String requete = "delete from favoris where Id_offre =?";
        try {
            
            PreparedStatement ps = connection.prepareStatement(requete);  
            ps.setInt(1 , id); //id de l'offre selectionne
            ps.executeUpdate();
            System.out.println("offre supprimé des favoris ... ! \n");
            
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression aux favoris " + ex.getMessage());
        }
    }

    @Override
    public boolean rechercherFavoris(int ID) {
        String requete  = "select * from favoris where Id_client = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1 , Util.id_agent_connecte);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()){
                int Id_offre = resultat.getInt(3);
                if (ID == Id_offre){
                    return true;
                }
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(FavorisDAO.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }
    }

    @Override
    public String evaluationFavoris(int ID) {
        if (rechercherFavoris(ID)){
            return "*";
        }
        else 
            return "";
    }
}


