/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.services;

import com.mysql.jdbc.Connection;
import edu.devapps.entity.Rating;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utilities.MaConnexion;

/**
 *
 * @author THEOLDISBACK
 */
public class RatingService {
    
    
    
    
      Connection cnx =MaConnexion.getInstance().getCnx();
   

  
    public void ajouterrating(Rating r) {
        String req ="INSERT INTO `rating`( `rate`, `iduser`, `idpub`) VALUES"+ " ("+r.getRate()+","+r.getIduser()+","+r.getIdpub()+""+")";

          try {
              Statement st = cnx.createStatement();
              st.executeUpdate(req);
              System.out.println("rating ajouté");
              
            
              
              
          } catch (SQLException ex) {
              
              System.out.println(ex.getMessage());
          }
              
          }
   
    public List<Rating> afficherRate() {
        //var
        
       
        List<Rating> ratings =new ArrayList<>();
        //requette
        String req ="SELECT * FROM rating";
          try {
              Statement st = cnx.createStatement();
              ResultSet rs = st.executeQuery(req);
              while (rs.next()){
                  ratings.add(new Rating(rs.getInt(1), rs.getInt(2),rs.getInt(3) ,rs.getInt(4)));
              }
          } catch (SQLException ex) {
              }
    
        return ratings;

    
       
    }
    

    public void supprimerrating( Rating r  ) {
 String req="DELETE FROM `rating` WHERE id="+r.getId();
 
           try {
             //insert
             Statement st=cnx.createStatement();
             st.executeUpdate(req);
             System.out.println(" supprimer avec rating");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }  
             
          
    }
    
  
    
}
