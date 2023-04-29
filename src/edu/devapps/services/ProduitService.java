/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.services;

import com.mysql.jdbc.Connection;
import edu.devapps.entity.Produit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utilities.MaConnexion;


public class ProduitService {
    
    
     Connection cnx =MaConnexion.getInstance().getCnx();
   

  
    public void ajouterproduit(Produit r) {
        String req ="INSERT INTO `produit`( `nom_produit`, `description`, `prix`, `quantite`, `photo`, `id_categorie_id` ) VALUES"+ " ('"+r.getNom_produit()+"','"+r.getDescription()+"',"+r.getPrix()+","+r.getQuantite()+",'"+r.getPhoto()+"',"+r.getId_categorie_id()+")";

          try {
              Statement st = cnx.createStatement();
              st.executeUpdate(req);
              System.out.println("produit ajouté");
              
            
              
              
          } catch (SQLException ex) {
              
              System.out.println(ex.getMessage());
          }
              
          }
   
    public List<Produit> afficherproduit() {
        //var
        
       
        List<Produit> produits =new ArrayList<>();
        //requette
        String req ="SELECT * FROM produit";
          try {
              Statement st = cnx.createStatement();
              ResultSet rs = st.executeQuery(req);
              while (rs.next()){
                  produits.add(new Produit(rs.getInt(1), rs.getString(2),rs.getString(3) ,rs.getFloat(4), rs.getInt(5),rs.getString(6),rs.getDate(7),rs.getInt(8)));
              }
          } catch (SQLException ex) {
              }
    
        return produits;

    
       
    }
    

    public void supprimerproduit( Produit r  ) {
 String req="DELETE FROM `produit` WHERE id_produit="+r.getId_produit();
 
           try {
             //insert
             Statement st=cnx.createStatement();
             st.executeUpdate(req);
             System.out.println("produit supprimer avec succes");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }  
             
          
    }
    
    

 
    public void modifierproduit( Produit r ) {
        
        String req=null;
        if(r.getId_produit()!=0)
        {   req="UPDATE `produit` SET nom_produit='"+r.getNom_produit()+"',description='"+r.getDescription()+"',prix="+r.getPrix()+",quantite="+r.getQuantite()+" where id_produit  ="+r.getId_produit();
       
            try {
             //insert
             Statement st=cnx.createStatement();
             st.executeUpdate(req);
             System.out.println("produit modifier avec succes");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
            
        }
       
}
   
 public List<Produit> getProd(int idCatg) {
        List<Produit> produits = new ArrayList<>();
        try {
            String query = "SELECT * FROM Produit WHERE id_categorie_id='"+idCatg+"' ";
            PreparedStatement statement = cnx.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Produit produit = new Produit();
                produit.setId_produit(resultSet.getInt("id_produit"));
                produit.setNom_produit(resultSet.getString("nom_produit"));
                produit.setDescription(resultSet.getString("description"));
                produit.setPrix(resultSet.getFloat("prix"));
                produit.setQuantite(resultSet.getInt("quantite"));
                produit.setPhoto(resultSet.getString("photo"));
                produit.setDate(resultSet.getDate("date"));
                produit.setId_categorie_id(resultSet.getInt("id_categorie_id"));
                produits.add(produit);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return produits;
    }
    
    
 public List<Produit> RechercheProduit(String keyword) {
        List<Produit> produits = new ArrayList<>();
        try {
            String query = "SELECT * FROM Produit WHERE nom_produit LIKE ? OR description LIKE ? OR prix LIKE ? OR quantite LIKE ?";
            PreparedStatement statement = cnx.prepareStatement(query);
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");
            statement.setString(3, "%" + keyword + "%");
            statement.setString(4, "%" + keyword + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Produit produit = new Produit();
                produit.setId_produit(resultSet.getInt("id_produit"));
                produit.setNom_produit(resultSet.getString("nom_produit"));
                produit.setDescription(resultSet.getString("description"));
                produit.setPrix(resultSet.getFloat("prix"));
                produit.setQuantite(resultSet.getInt("quantite"));
                produit.setPhoto(resultSet.getString("photo"));
                produit.setDate(resultSet.getDate("date"));
                produit.setId_categorie_id(resultSet.getInt("id_categorie_id"));
                produits.add(produit);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return produits;
    }
    public ObservableList<Produit> getProduitList() throws SQLException
    {
        ObservableList<Produit> produitlist = FXCollections.observableArrayList();
        
       Statement ps=cnx.createStatement();
        String sql = "select id_produit,nom_produit, description, prix,quantite,photo,date,id_categorie_id from produit";
        ResultSet rs;
        rs = ps.executeQuery(sql);
        Produit produit;
        while (rs.next()) {
                  produit=new Produit(rs.getInt("id_produit"), rs.getString("nom_produit"),rs.getString("description") ,rs.getFloat("prix"), rs.getInt("quantite"),rs.getString("photo"),rs.getDate("date"),rs.getInt("id_categorie_id"));
            //System.out.println(events);
            produitlist.add(produit);

        }
         return produitlist;    
    }
    
    
}
