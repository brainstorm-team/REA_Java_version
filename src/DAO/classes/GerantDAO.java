/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.classes;

import DAO.interfaces.IGerantDAO;
import entities.Gerant;
import entities.Utilisateur;
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
public class GerantDAO implements IGerantDAO {

    /**
     * *******Singleton********
     */
    private static GerantDAO instance;

    public static GerantDAO getInstance() {
        if (instance == null) {
            instance = new GerantDAO();
        }
        return instance;
    }

    private java.sql.Connection connection;

    public GerantDAO() {
        connection = DataSource.getInstance();
    }

    /**
     * ****************************
     */
    public List<Gerant> DisplayStat() {
            
        List<Gerant> listeRes= new ArrayList<Gerant>();

        String requete = "SELECT nom, COUNT( * ) \n" +
"FROM user res, offre r\n" +
"WHERE res.role =  'gerant'\n" +
"AND res.Id = r.`Id_gerant` \n" +
"AND  `validation` =1\n" +
"GROUP BY res.nom";
        try {
                    Statement statement = DataSource.getInstance()
                   .createStatement();
            ResultSet nb = statement.executeQuery(requete);

            while(nb.next()){
                Gerant of =new Gerant ();
                of.setNom(nb.getString(1));
                of.setNbre(nb.getInt(2));
                listeRes.add(of);
              }
            return listeRes;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }
    @Override
    public ArrayList<Gerant> SelectGerant() {
        try {

            String requete = "select * from user where role='gerant'";
            PreparedStatement ps;
            ps = connection.prepareStatement(requete);
            ResultSet result = ps.executeQuery();
            ArrayList<Gerant> gerants = new ArrayList<>();
            while (result.next()) {
                Gerant gerant = new Gerant();
                gerant.setId(result.getInt(1));
                gerant.setPrenom(result.getString(2));
                gerant.setNom(result.getString(3));
                gerant.setEmail(result.getString(4));

                gerant.setTelephone(result.getString(5));
                gerant.setAdresse(result.getString(6));
                gerant.setLogin(result.getString(7));
                gerant.setPass(result.getString(8));

                gerants.add(gerant);

                System.out.println("Gerant " + gerant.getLogin());
            }
            return gerants;
        } catch (Exception ee) {
            System.out.println("erreur dan select gerants " + ee.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<String> SelectLogin(String pattern) {
        try {
            String requete = "select login from user where login like'" + pattern + "%' and role='gerant'";
            PreparedStatement ps;
            ps = connection.prepareStatement(requete);
            ResultSet result = ps.executeQuery();
            Gerant gerant = new Gerant();
            ArrayList<String> tgerant = new ArrayList<>();
            while (result.next()) {
                tgerant.add(result.getString(1));
            }
            return tgerant;
        } catch (Exception ee) {
            System.out.println("erreur dan select gerant " + ee.getMessage());
        }
        return null;
    }

    @Override
    public void ajoutGerant(Gerant gerant) {
        try {
            String requete = "INSERT INTO `user`(`prenom`, `nom`, `email`,`telephone`, `adresse`, `login`, `pass` , role)VALUES (?,?,?,?,?,?,?,'gerant') ";
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, gerant.getPrenom());
            ps.setString(2, gerant.getNom());
            ps.setString(3, gerant.getEmail());

            ps.setString(4, gerant.getTelephone());
            ps.setString(5, gerant.getAdresse());
            ps.setString(6, gerant.getLogin());
            ps.setString(7, gerant.getPass());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("erreur dans la methode ajout gerant " + e.getMessage() + " " + e.getLocalizedMessage());
        }
    }

    @Override
    public void deleteGerant(String login) {
        String requete = "delete from user where login=? and role='gerant'";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, login);
            ps.executeUpdate();
            System.out.println("gerantsupprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression gerant" + ex.getMessage());
        }
    }

    @Override
    public void updateGerant(String login, String password) {
        String requete = "delete from user where login=? and role='gerant'";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, login);
            ps.executeUpdate();
            System.out.println("gerantsupprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression gerant" + ex.getMessage());
        }
    }

    @Override
    public Gerant findGerantByLogin(String login) {
        Gerant gerant = null;
        String requete = "select Id , login,pass from user where login='" + login + "' and  and role='gerant'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                gerant = new Gerant();
                gerant.setId(resultat.getInt(1));
                gerant.setLogin(resultat.getString(2));
                gerant.setPass(resultat.getString(3));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des geran " + ex.getMessage());
        }
        return gerant;
    }

    @Override
    public Utilisateur findUserByLogin(String login) {
        Utilisateur gerant = null;
        String requete = "SELECT * FROM `user` where login='" + login + "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                gerant = new Utilisateur();
                gerant.setId(resultat.getInt(1));
                gerant.setPrenom(resultat.getString(2));
                gerant.setNom(resultat.getString(3));
                gerant.setEmail(resultat.getString(4));

                gerant.setTelephone(resultat.getString(5));
                gerant.setAdresse(resultat.getString(6));
                gerant.setLogin(resultat.getString(7));
                gerant.setPass(resultat.getString(8));
                gerant.setRole(resultat.getString(9));

            }
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des administrateurs " + ex.getMessage());
        }
        return gerant;
//         public void refrech(){
//         
//         }

    }

    @Override
    public int nombreGerant() {
        String n = null;
        try {
            String requete = "SELECT COUNT(*) from user where `role`='gerant'";

            Statement statement = DataSource.getInstance().createStatement();
            ResultSet nb = statement.executeQuery(requete);

            while (nb.next()) {

                n = nb.getString("COUNT(*)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Integer.parseInt(n);
    }
}
