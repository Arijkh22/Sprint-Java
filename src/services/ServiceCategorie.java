/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Categorie;
import entities.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.Jdbc_connection;
import utils.Log;

 
public class ServiceCategorie{
    
    
    Connection cnx;
    public ServiceCategorie() {
        cnx = Jdbc_connection.getInstance();
    }
  
    //Ajouter produit
    public void add_categorie(Categorie categorie) {
    try {
        String sqlCheck = "select count(*) from Categorie where nom=?";
        PreparedStatement stmtCheck = cnx.prepareStatement(sqlCheck);
        stmtCheck.setString(1, categorie.getNom());
        ResultSet rs = stmtCheck.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        if (count > 0) {
            System.out.println("Une catégorie avec le même nom existe déjà !");
            return;
        }

        String sql = "insert into Categorie(nom) values (?)";
        PreparedStatement ste = cnx.prepareStatement(sql);
        ste.setString(1, categorie.getNom());
        ste.executeUpdate();
        System.out.println("Categorie ajoutee");
    } catch (SQLException ex) {
        System.out.println("Erreur: " + ex.getLocalizedMessage());
    }
}

    //Modifier produit
    public void update( Categorie categorie) {
    String sql = "update Categorie set nom=? where id=? ";
    try {
      PreparedStatement stmt = cnx.prepareStatement(sql);
      stmt.setString(1, categorie.getNom());
      stmt.setInt(2, categorie.getId());
      stmt.executeUpdate();

    } catch (Exception e) {
      Log.file(e.getMessage());
    }
  }
    
     // GetAllCategories
    public List<Categorie> get_all() {
        List<Categorie> categories = new ArrayList<>();
  try {
        String sql = "select * from Categorie";
        Statement ste = cnx.createStatement();
        ResultSet result = ste.executeQuery(sql);
               while (result.next()) {
                Categorie new_categorie = new Categorie(
                result.getInt(1), 
                result.getString(2)) ;

                        categories.add(new_categorie);

            }
        } catch (SQLException ex) {
            Log.file(ex.getMessage());
        }
        return categories;
    }

   //Get category by ID
public Categorie get_by_id(int id) {
    try {
        String sql = "select * from Categorie where id=?";
        PreparedStatement stmt = cnx.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet result = stmt.executeQuery();
        if (result.next()) {
            Categorie categorie = new Categorie(result.getInt(1), result.getString(2));
            return categorie;
        }
    } catch (SQLException ex) {
        Log.file(ex.getMessage());
    }
    return null;
}

    
     //UPDATE
    public void modifierProduit(Produit produit) throws SQLException {
        String requete = "UPDATE produit SET nom_produit = ?, description = ?, quantite = ?, prix = ?, photo = ?, id_categorie_id = ? WHERE id_produit = ?";
        PreparedStatement pst = cnx.prepareStatement(requete);
        pst.setString(1, produit.getNom_produit());
        pst.setString(2, produit.getDescription());
        pst.setInt(3, produit.getQuantite());
        pst.setFloat(4, produit.getPrix());
        pst.setString(5, produit.getPhoto());
        pst.setInt(6, produit.getId_categorie_id());
        pst.setInt(7, produit.getId_produit());
        pst.executeUpdate();
        System.out.println("Produit modifié avec succès !");
    }
    
//Delete
public void delete_categorie(Categorie categorie) {
    try {
        String sqlCheck = "select count(*) from Categorie where id=?";
        PreparedStatement stmtCheck = cnx.prepareStatement(sqlCheck);
        stmtCheck.setInt(1, categorie.getId());
        ResultSet rs = stmtCheck.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        if (count == 0) {
            System.out.println("La catégorie n'existe pas !");
            return;
        }

        String sql = "delete from Categorie where id=?";
        PreparedStatement ste = cnx.prepareStatement(sql);
        ste.setInt(1, categorie.getId());
        ste.executeUpdate();
        System.out.println("Categorie supprimee");
    } catch (SQLException ex) {
        System.out.println("Erreur: " + ex.getLocalizedMessage());
    }
}

}
