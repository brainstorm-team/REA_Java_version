/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.classes;

import DAO.interfaces.IImagesDAO;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import technique.DataSource;

/**
 *
 * @author jemacom
 */
public class ImagesDAO implements IImagesDAO{

    /*********Singleton*********/
    private static ImagesDAO instance;

    public static ImagesDAO getInstance() {
        if (instance == null) {
            instance = new ImagesDAO();
        }
        return instance;
    }
    
    private java.sql.Connection connection;


    public ImagesDAO() {
        connection = DataSource.getInstance();
    }
    /*******************************/
    @Override
    public void insertImage(FileInputStream fin, int len) {
        String requete = "insert into images (images) values (?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setBinaryStream(1, fin, len);
            
            int status = ps.executeUpdate();
            if (status > 0){
                System.out.println("Image inserer avec success ;)");
            }else{
                System.out.println("Image NON inserer :/ ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImagesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
