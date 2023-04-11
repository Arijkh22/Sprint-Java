/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.services;

import com.mysql.jdbc.Connection;
import edu.devapps.entity.Categorie;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utilities.MaConnexion;


public class CategorieService {
    
    
    
    
    
    
      Connection cnx =MaConnexion.getInstance().getCnx();
   

  
    public void ajoutercategorie(Categorie r) {
        String req ="INSERT INTO `categorie`( `nom`) VALUES"+ " ('"+r.getNom()+"')";

          try {
              Statement st = cnx.createStatement();
              st.executeUpdate(req);
              System.out.println("categorie ajouté");
              
            
              
              
          } catch (SQLException ex) {
              
              System.out.println(ex.getMessage());
          }
              
          }
    
    
    
   
    public List<Categorie> affichercategorie() {
        //var
        
       
        List<Categorie> categories =new ArrayList<>();
        //requette
        String req ="SELECT * FROM categorie";
          try {
              Statement st = cnx.createStatement();
              ResultSet rs = st.executeQuery(req);
              while (rs.next()){
                  categories.add(new Categorie(rs.getInt(1), rs.getString(2)));
              }
          } catch (SQLException ex) {
              }
    
        return categories;

    
       
    }
    

    public void supprimercategorie( Categorie r  ) {
 String req="DELETE FROM `categorie` WHERE id="+r.getId();
 
           try {
             //insert
             Statement st=cnx.createStatement();
             st.executeUpdate(req);
             System.out.println("categorie supprimer avec succes");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }  
             
    }
    
    
    
     public void modifiercategorie( Categorie r ) {
        
        String req=null;
        if(r.getId()!=0)
        {   req="UPDATE `categorie` SET nom='"+r.getNom()+"' where id ="+r.getId();
       
            try {
             //insert
             Statement st=cnx.createStatement();
             st.executeUpdate(req);
             System.out.println("categorie modifier avec succes");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
            
        }
       
}
    
}
