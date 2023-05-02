/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.services;

import com.mysql.jdbc.Connection;
import edu.devapps.entity.Facture;
import edu.devapps.entity.Finance;
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
public class FinanceService {
    
    
    
          Connection cnx =MaConnexion.getInstance().getCnx();
   

  
    public void ajouterFinance(Finance f) {
        String req ="INSERT INTO `finance`( `taxe`, `tva`, `photo`,  `prix`,   `etat`, `date`, `id_facture` ) VALUES"+ " ("+f.getTaxe()+","+f.getTva()+",'"+f.getPhoto()+"',"+f.getPrix()+",'"+f.getEtat()+"','"+f.getDate()+"',"+f.getId_facture()+")";

          try {
              Statement st = cnx.createStatement();
              st.executeUpdate(req);
              System.out.println("finance ajouté");
              
            
              
              
          } catch (SQLException ex) {
              
              System.out.println(ex.getMessage());
          }
              
          }
   
    public List<Finance> afficherFinance() {
        //var
        
       
        List<Finance> finances =new ArrayList<>();
        //requette
        String req ="SELECT * FROM finance";
          try {
              Statement st = cnx.createStatement();
              ResultSet rs = st.executeQuery(req);
              while (rs.next()){
                  finances.add(new Finance(rs.getInt(1), rs.getFloat(2),rs.getInt(3) ,rs.getString(4), rs.getFloat(5), rs.getString(6), rs.getDate(7), rs.getInt(8)));
              }
          } catch (SQLException ex) {
              }
    
        return finances;

    
       
    }
    

    public void supprimerfinance( Finance f  ) {
 String req="DELETE FROM `finance` WHERE id ="+f.getId();
 
           try {
             //insert
             Statement st=cnx.createStatement();
             st.executeUpdate(req);
             System.out.println("finance supprimer avec succes");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }  
             
          
    }
    
    

 
    public void modifierfinance( Finance f ) {
        
        String req=null;
        if(f.getId()!=0)
        {   req="UPDATE `finance` SET taxe="+f.getTaxe()+",tva="+f.getTva()+",prix="+f.getPrix()+",etat='"+f.getEtat()+"' where id ="+f.getId();
       
            try {
             //insert
             Statement st=cnx.createStatement();
             st.executeUpdate(req);
             System.out.println("finance modifier avec succes");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
            
        }
       
    }
    
    
     public List<Finance> rechercher(String s) {
        //var
        
       
        List<Finance> finances =new ArrayList<>();
        //requette
        String req ="SELECT * FROM finance where taxe like '%"+s+"%' OR  tva like '%"+s+"%' OR photo like '%"+s+"%' OR prix like '%"+s+"%' OR etat like '%"+s+"%' or id_facture like '%"+s+"%'";
          try {
              Statement st = cnx.createStatement();
              ResultSet rs = st.executeQuery(req);
              while (rs.next()){
                  finances.add(new Finance(rs.getInt(1), rs.getFloat(2),rs.getInt(3) ,rs.getString(4), rs.getFloat(5), rs.getString(6), rs.getDate(7), rs.getInt(8)));
              }
          } catch (SQLException ex) {
              }
    
        return finances;

    
       
    }
    
   
}
