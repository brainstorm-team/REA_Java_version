/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package technique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mahdi
 */
//public class DataSource {
//
//    //Properties properties;
//    private String url = "jdbc:mysql://localhost:3306/data";
//    private String login = "root";
//    private String password = "root";
//    private Connection connection;
//    private static DataSource instance;
//
//    private DataSource() {
//        if (connection == null) {
//            //properties = new Properties();
//            try {
//                /*properties.load(new FileInputStream(new File("Configuration.properties")));
//                url = properties.getProperty("url");
//                login = properties.getProperty("utilisateur");
//                password = properties.getProperty("pwd");
//                
//                        */
//                connection = DriverManager.getConnection(url, login, password);
//                System.out.println("Connection established");
//            } catch (SQLException ex) {
//                Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
//            /*} catch (IOException ex) {
//                Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
//            }*/
//        }
//    }
//    }
////    public Connection getConnection() {
////        return connection;
////    }
//
//    public static DataSource getInstance() {
//        if (instance == null) {
//            instance = new DataSource();
//        }
//        return instance;
//    }
//}
public class DataSource {

     private static final  String driver = "com.mysql.jdbc.Driver";
   private static final  String url = "jdbc:mysql://localhost:3306/data";
   private static final  String login = "root";
   private static final  String pwd = "root";
   private static Connection con;


   private DataSource(){

   }

   public Connection etablirConnection(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,login,pwd);
            System.out.println("Connexion établie");
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur de chargement de driver"+ex.getMessage());
        } catch (SQLException ex){
            System.out.println("probleme d'etablissement de connection"+ex.getMessage());
        }

        return con;
    }
   public static Connection getInstance(){
       if (con==null){
           new DataSource().etablirConnection();
       }
   return con;
   }
}