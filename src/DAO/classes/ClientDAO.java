/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.classes;

import DAO.interfaces.IClientDAO;
import entities.Client;
import entities.Offre;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import technique.DataSource;


/**
 *
 * @author jemacom
 */
public class ClientDAO implements IClientDAO{

      /*********Singleton*********/
    private static ClientDAO instance;

    public static ClientDAO getInstance() {
        if (instance == null) {
            instance = new ClientDAO();
        }
        return instance;
    }
    
    private java.sql.Connection connection;


    public ClientDAO() {
        connection = DataSource.getInstance();
    }
    /*******************************/
    
    
    @Override
    public ArrayList<Client> SelectClient() {
                try {
        
            String requete = "select * from user where role='client'";
            PreparedStatement ps;
            ps = connection.prepareStatement(requete);
            ResultSet result = ps.executeQuery();
            ArrayList<Client> clients = new ArrayList<>();
            while (result.next()) {
               Client client = new Client();
                client.setId(result.getInt(1));
                client.setPrenom(result.getString(3));
                client.setNom(result.getString(2));
                client.setEmail(result.getString(4));
               
                client.setTelephone(result.getString(5));
                client.setAdresse(result.getString(6));
                client.setLogin(result.getString(7));
                client.setPass(result.getString(8));
              
                clients.add(client);
                
                  System.out.println("clients "+client.getLogin());
            }
            return clients;
        } catch (Exception ee) {
            System.out.println("erreur dan select clients " + ee.getMessage());
        }
        return null;
    }
    

    @Override
    public ArrayList<String> SelectLogin(String pattern) {//authentification
        try {
            String requete = "select login from user where login like'" + pattern + "%' and role='client'";
            PreparedStatement ps;
            ps = connection.prepareStatement(requete);
            ResultSet result = ps.executeQuery();
            Client client = new Client();
            ArrayList<String> tclient= new ArrayList<>();
            while (result.next()) {
                tclient.add(result.getString(1));
            }
            return tclient;
        } catch (Exception ee) {
            System.out.println("erreur dan select client " + ee.getMessage());
        }
        return null;
    }

    @Override
    public void ajoutClient(Client client) {
          try {
            String requete = "INSERT INTO `user` (`Id`, `prenom`, `nom`, `email`, `telephone`, `adresse`, `login`, `pass`)VALUES (null,?,?,?,?,?,?,?) where role='client'";
             PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(2, client.getPrenom());
            ps.setString(1, client.getNom());
                 ps.setString(3, client.getEmail());
          
            ps.setString(4, client.getTelephone());
            ps.setString(5, client.getAdresse());
            ps.setString(6, client.getLogin());
            ps.setString(7, client.getPass());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("erreur dans la methode ajout client " + e.getMessage() + " " + e.getLocalizedMessage());
        }
    }

    @Override
    public void deleteClient(String login) {
        String requete = "delete from user where login=? and role='client'";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, login);
            ps.executeUpdate();
            System.out.println("client supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression client" + ex.getMessage());
        }
    }

    @Override
    public void updateClient(String login, String password) {
        String requete = "UPDATE user SET pass=? WHERE login=? and role='client' ";
        try {
            PreparedStatement ps =  connection.prepareStatement(requete);
            ps.setString(1, password);
            ps.setString(2, login);
           
            ps.executeUpdate();
            System.out.println("client update");
        } catch (SQLException ex) {
            System.out.println("erreur lors de modification  client" + ex.getMessage());
        }
    }

    @Override
    public Client findClientByLogin(String login) {
        Client client =null;
        String requete = "select * from user where login='"+login+"'  and role='client'";
        try {
           Statement statement =  connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
               client  = new  Client();
               client.setId(resultat.getInt(1)) ;
               client.setLogin(resultat.getString(7));
               client.setPass(resultat.getString(8));
            }
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des client "+ex.getMessage());
        }
        return client;
        
    }
    @Override
     public   List<Client> DiplayAllClient(){
         List<Client> listeClient = new ArrayList<>();

        String requete = "select * from user role='client'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

             while (resultat.next()) {
                Client client = new Client();

                client.setId(resultat.getInt(1));
                client.setNom(resultat.getString(2));
                client.setPrenom(resultat.getString(3));
                client.setEmail(resultat.getString(4));
                client.setTelephone(resultat.getString(5));
                client.setAdresse(resultat.getString(6));
                client.setLogin(resultat.getString(7));
                client.setPass(resultat.getString(8));
                

                listeClient.add(client);
            }

            return listeClient;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());

            return null;
        }
     }
}
