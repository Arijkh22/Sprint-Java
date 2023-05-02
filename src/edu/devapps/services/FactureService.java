/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.services;

import com.mysql.jdbc.Connection;
import edu.devapps.entity.Facture;
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
public class FactureService {
    
    
      Connection cnx =MaConnexion.getInstance().getCnx();
   

  
    public void ajouterFacture(Facture f) {
        String req ="INSERT INTO `facture`( `numero`, `nom`, `prix`,  `date`,   `etat`, `description`, `image`, `id_utilisateur` ) VALUES"+ " ("+f.getNumero()+",'"+f.getNom()+"',"+f.getPrix()+",'"+f.getDate()+"','"+f.getEtat()+"','"+f.getDescription()+"','"+f.getImage()+"',"+f.getId_utilisateur()+")";

          try {
              Statement st = cnx.createStatement();
              st.executeUpdate(req);
              System.out.println("facture ajouté");
              
            
              
              
          } catch (SQLException ex) {
              
              System.out.println(ex.getMessage());
          }
              
          }
   
    public List<Facture> afficherFacture() {
        //var
        
       
        List<Facture> factures =new ArrayList<>();
        //requette
        String req ="SELECT * FROM facture";
          try {
              Statement st = cnx.createStatement();
              ResultSet rs = st.executeQuery(req);
              while (rs.next()){
                  factures.add(new Facture(rs.getInt(1), rs.getInt(2),rs.getString(3) ,rs.getFloat(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
              }
          } catch (SQLException ex) {
              System.out.println(ex.getMessage());
          }
    
        return factures;

    
       
    }
    

    public void supprimerfacture( Facture f  ) {
 String req="DELETE FROM `facture` WHERE id_facture ="+f.getId_facture();
 
           try {
             //insert
             Statement st=cnx.createStatement();
             st.executeUpdate(req);
             System.out.println("facture supprimer avec succes");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }  
             
          
    }
    
    

 
    public void modifierFacture( Facture f ) {
        
        String req=null;
        if(f.getId_facture()!=0)
        {   req="UPDATE `facture` SET numero="+f.getNumero()+",nom='"+f.getNom()+"',prix="+f.getPrix()+",etat='"+f.getEtat()+"',description='"+f.getDescription()+"' where id_facture ="+f.getId_facture();
       
            try {
             //insert
             Statement st=cnx.createStatement();
             st.executeUpdate(req);
             System.out.println("film modifier avec succes");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
            
        }
       
    }
    
    
    
    
   

    


    
    
    
}
