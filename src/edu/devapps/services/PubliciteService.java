/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.services;

import com.mysql.jdbc.Connection;
import edu.devapps.entity.Publicite;
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
public class PubliciteService {
    
    
    
      Connection cnx =MaConnexion.getInstance().getCnx();
   

  
    public void ajouterpublicite(Publicite r) {
        String req ="INSERT INTO `publicite`( `nom_pub`, `description`, `image`, `id_sponsor_id` ) VALUES"+ " ('"+r.getNom_pub()+"','"+r.getDescription()+"','"+r.getImage()+"',"+r.getId_sponsor_id()+")";

          try {
              Statement st = cnx.createStatement();
              st.executeUpdate(req);
              System.out.println("publicite ajouté");
              
            
              
              
          } catch (SQLException ex) {
              
              System.out.println(ex.getMessage());
          }
              
          }
   
    public List<Publicite> afficherpublicite() {
        //var
        
       
        List<Publicite> pubs =new ArrayList<>();
        //requette
        String req ="SELECT * FROM publicite";
          try {
              Statement st = cnx.createStatement();
              ResultSet rs = st.executeQuery(req);
              while (rs.next()){
                  pubs.add(new Publicite(rs.getInt(1), rs.getString(2),rs.getString(3) ,rs.getString(4), rs.getInt(5)));
              }
          } catch (SQLException ex) {
              }
    
        return pubs;

    
       
    }
    

    public void supprimerpublicite( Publicite r  ) {
 String req="DELETE FROM `publicite` WHERE id="+r.getId();
 
           try {
             //insert
             Statement st=cnx.createStatement();
             st.executeUpdate(req);
             System.out.println("publicite supprimer avec succes");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }  
             
          
    }
    
    

 
    public void modifierpublicite( Publicite r ) {
        
        String req=null;
        if(r.getId()!=0)
        {   req="UPDATE `publicite` SET nom_pub='"+r.getNom_pub()+"',description='"+r.getDescription()+"',image='"+r.getImage()+"' where id ="+r.getId();
       
            try {
             //insert
             Statement st=cnx.createStatement();
             st.executeUpdate(req);
             System.out.println("publicite modifier avec succes");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
            
        }
       
}
}
