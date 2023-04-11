/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrew
 */
public class MyDB {

    String url = "jdbc:mysql://localhost:3306/devappsfinal";
    String login = "root";
    String pwd = "root";
    
    Connection con;
    
    public static MyDB instance;
    private MyDB() {
        try {
            System.out.println("connexion en cours");
            con = DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
            
            System.out.println("Err "+ ex.getMessage());
        }
        
        
    }
    
    public static MyDB getInstance(){
        if(instance == null ){
            instance = new MyDB();
        }
        return instance;
        
    }
    
    public Connection getcon(){
        return con;
    }
    
    
    
    
    
    
    
    
    private static String HOST = "127.0.0.1";
        private static int PORT = 3306;
        private static String DB_NAME = "devappsfinal";
        private static String USERNAME = "root";
        private static String PASSWORD = "root";
        private static Connection connection ;
        
    
    public static Connection getConnect (){
        try {
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST,PORT,DB_NAME),USERNAME,PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(MyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return  connection;
        }
    
    
}
