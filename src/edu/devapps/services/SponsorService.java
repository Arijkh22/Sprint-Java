/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.services;

import com.mysql.jdbc.Connection;
import edu.devapps.entity.Sponsor;
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
public class SponsorService {
    
    
    
    
    
      Connection cnx =MaConnexion.getInstance().getCnx();
   

  
    public void ajoutersponsor(Sponsor r) {
        String req ="INSERT INTO `sponsor`( `nom`, `adresse`, `email`,  `num_tel`) VALUES"+ " ('"+r.getNom()+"','"+r.getAdresse()+"','"+r.getEmail()+"',"+r.getNum_tel()+""+")";

          try {
              Statement st = cnx.createStatement();
              st.executeUpdate(req);
              System.out.println("sponsor ajouté");
              
            
              
              
          } catch (SQLException ex) {
              
              System.out.println(ex.getMessage());
          }
              
          }
   
    public List<Sponsor> affichersponsor() {
        //var
        
       
        List<Sponsor> sponsors =new ArrayList<>();
        //requette
        String req ="SELECT * FROM sponsor";
          try {
              Statement st = cnx.createStatement();
              ResultSet rs = st.executeQuery(req);
              while (rs.next()){
                  sponsors.add(new Sponsor(rs.getInt(1), rs.getString(2),rs.getString(3) ,rs.getString(4), rs.getInt(5)));
              }
          } catch (SQLException ex) {
              }
    
        return sponsors;

    
       
    }
    

    public void supprimersponsor( Sponsor r  ) {
 String req="DELETE FROM `sponsor` WHERE id="+r.getId();
 
           try {
             //insert
             Statement st=cnx.createStatement();
             st.executeUpdate(req);
             System.out.println("sponsor supprimer avec succes");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }  
             
          
    }
    
    

 
    public void modifiersponsor( Sponsor r ) {
        
        String req=null;
        if(r.getId()!=0)
        {   req="UPDATE `sponsor` SET nom='"+r.getNom()+"',adresse='"+r.getAdresse()+"',email='"+r.getEmail()+"',num_tel="+r.getNum_tel()+" where id ="+r.getId();
       
            try {
             //insert
             Statement st=cnx.createStatement();
             st.executeUpdate(req);
             System.out.println("sponsor modifier avec succes");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
            
        }
       
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
       public List<Sponsor> rechercher(String s) {
        //var
        
       
        List<Sponsor> sponsors =new ArrayList<>();
        //requette
        String req ="SELECT * FROM sponsor  where nom like '%"+s+"%' OR adresse like  '%"+s+"%' OR email like '%"+s+"%' OR  num_tel like '%"+s+"%'";
          try {
              Statement st = cnx.createStatement();
              ResultSet rs = st.executeQuery(req);
              while (rs.next()){
                  sponsors.add(new Sponsor(rs.getInt(1), rs.getString(2),rs.getString(3) ,rs.getString(4), rs.getInt(5)));
              }
          } catch (SQLException ex) {
              }
    
        return sponsors;

    
       
    }
    }
