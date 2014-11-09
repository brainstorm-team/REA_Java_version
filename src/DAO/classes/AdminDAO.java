/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.classes;

import DAO.interfaces.IAdminDAO;
import com.sun.jndi.ldap.Connection;
import entities.Admin;
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
public class AdminDAO implements IAdminDAO{
    
    /*********Singleton*********/
    private static AdminDAO instance;

    public static AdminDAO getInstance() {
        if (instance == null) {
            instance = new AdminDAO();
        }
        return instance;
    }
    
    private java.sql.Connection connection;


    public AdminDAO() {
        connection = DataSource.getInstance();
    }
    /*******************************/

    @Override
    public List<Admin> SelectAdmin() {
        String requete = "select * from administrateur";
        try{    
        PreparedStatement ps;
            ps = connection.prepareStatement(requete);
            ResultSet result = ps.executeQuery();
            
            ArrayList<Admin> tadmin = new ArrayList<>();
            
            while (result.next()) {
               Admin admin = new Admin();
               
                admin.setId(result.getInt(1));
                admin.setPrenom(result.getString(3));
                admin.setNom(result.getString(2));
                admin.setEmail(result.getString(4));
          
                admin.setTelephone(result.getInt(5));
                admin.setAdresse(result.getString(6));
                admin.setLogin(result.getString(7));
                admin.setPass(result.getString(8));
              
                tadmin.add(admin);
                
                  System.out.println("admin "+admin.getLogin());
            }
            return tadmin;
        } catch (Exception ee) {
            System.out.println("erreur dans select administrateur " + ee.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<String> SelectLogin(String pattern) {
        //Authentification 
        try {
            String requete = "select login from administrateur where login like'" + pattern + "%'";
            PreparedStatement ps;
            ps = connection.prepareStatement(requete);
            ResultSet result = ps.executeQuery();
            Admin admin = new   Admin();
            ArrayList<String> tadmin = new ArrayList<>();
            while (result.next()) {
                tadmin.add(result.getString(1));
            }
            return tadmin;
        } catch (Exception ee) {
            System.out.println("erreur dans select administrateur " + ee.getMessage());
        }
        return null;
    }

    @Override
    public void insertAdmin(Admin admin) {
        try {
            String requete = "INSERT INTO `administrateur`(`Id`, `prenom`, `nom`, `email`, `telephone`, `adresse`, `login`, `pass`) VALUES (null,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, admin.getPrenom());
            ps.setString(2, admin.getNom());
            ps.setString(3, admin.getEmail());
         
            ps.setInt(4, admin.getTelephone());
            ps.setString(5, admin.getAdresse());
            ps.setString(6, admin.getLogin());
            ps.setString(7, admin.getPass());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("erreur dans la methode ajout administrateur " + e.getMessage() + " " + e.getLocalizedMessage());
        }
    }

    @Override
    public void updateAdmin(String login, String password) {
        //apdate selon login et pass
        String requete = "UPDATE administrateur SET pass=? WHERE login=?";
        try {
            PreparedStatement ps =  connection.prepareStatement(requete);
            ps.setString(1, password);
            ps.setString(2, login);
           
            ps.executeUpdate();
            System.out.println("admin update");
        } catch (SQLException ex) {
            System.out.println("erreur lors de modification  Admin" + ex.getMessage());
        }
    }

    @Override
    public void deleteAdmin(String login) {
        String requete = "delete from administrateur where login=?";
        try {
            PreparedStatement ps =connection.prepareStatement(requete);
            ps.setString(1, login);
            ps.execute();
            System.out.println("administrateur supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression administrateur" + ex.getMessage());
        }
    }

    @Override
    public Admin findAdministrateurByLogin(String login) {
        // return admin par id
      Admin admin =null;
        String requete = "select * from administrateur where login='"+login+"'";
        try {
           Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
               admin = new Admin();
               admin.setId(1);
               admin.setLogin(resultat.getString(7));
               admin.setPass(resultat.getString(8));
            }
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des administrateurs "+ex.getMessage());
        }
        return admin;
//         public void refrech(){
//         
//         }
        
        
    }

    @Override
    public Admin findById(int id) {
        String SQL_FIND =  "SELECT * FROM administrateur WHERE id=?";
       Admin found = null;
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;       
        
        try{
            
            pstmt = connection.prepareStatement(SQL_FIND);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                int userId = rs.getInt("id");
                String userprenom = rs.getString("prenom");
                String usernom = rs.getString("nom");
                String useremail = rs.getString("email");
                int usertelephone = rs.getInt("telephone");
                String useradresse = rs.getString("adresse");
                String userlogin = rs.getString("login");
                 String userpass = rs.getString("pass");
                
                 found = new Admin(userId,usernom,userprenom,useremail,usertelephone,useradresse,userlogin, userpass);      
            }

                
        }catch(SQLException  ex){
           Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, "find failed", ex);
        }
        return found;
    }

    @Override
    public void update(Admin user) {
        if(findById(user.getId())!= null){
            PreparedStatement pstmt = null;
            String SQL_UPDATE =  "UPDATE administrateur SET prenom=?, nom=?, email=?,  telephone=?,adresse=?,login=?,pass=? WHERE id=?";
            try {
                pstmt = connection.prepareStatement(SQL_UPDATE);
                pstmt.setString(1, user.getPrenom());
                pstmt.setString(2, user.getNom());
                pstmt.setString(3, user.getEmail());
                pstmt.setInt(5, user.getTelephone());
                pstmt.setString(4, user.getAdresse());
                pstmt.setString(6, user.getLogin());
                pstmt.setString(7, user.getPass());
                pstmt.setInt(8, user.getId());
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, "update failed", ex);
            }
        }
    }
    
}
    

