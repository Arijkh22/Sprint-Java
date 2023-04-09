/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Categorie;
import entities.Produit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import utils.Jdbc_connection;
import utils.Log;

/**
 *
 * @author Khedhira Arij
 */
public class ServiceProduit {
    
      Connection cnx;
    public ServiceProduit() {
        cnx = Jdbc_connection.getInstance();
    }
   
    
public void add_produit(Produit produit ) {
    try {
        String imagePath = "C:\\Projet_pidev\\public\\" + produit.getPhoto();

        // Génération d'un nom de fichier unique pour l'image
        String imageFileName = UUID.randomUUID().toString() + ".jpg";

        // Création du fichier de destination avec le nom de fichier unique
        Path destinationPath = Paths.get("C:\\Projet_pidev\\public", imageFileName);

        // Copie du fichier d'origine vers le fichier de destination avec le nom de fichier unique
        Files.copy(Paths.get(imagePath), destinationPath, StandardCopyOption.REPLACE_EXISTING);

        // Mise à jour du nom de fichier de l'image dans l'objet Produit avec le nom de fichier unique
        produit.setPhoto(imageFileName);

        String sqlCheck = "select count(*) from Produit where nom_produit=?";
        PreparedStatement stmtCheck = cnx.prepareStatement(sqlCheck);
        stmtCheck.setString(1, produit.getNom_produit());
        ResultSet rs = stmtCheck.executeQuery();
        rs.next();

        String sql = "insert into Produit(id_produit,nom_produit,description,prix,quantite,photo,id_categorie_id)"
                    + "values (?,?,?,?,?,?,?)";
        PreparedStatement ste = cnx.prepareStatement(sql);
        ste.setInt(1, produit.getId_produit());
        ste.setString(2, produit.getNom_produit());
        ste.setString(3, produit.getDescription());
        ste.setFloat(4, produit.getPrix());
        ste.setInt(5, produit.getQuantite());
        ste.setString(6, produit.getPhoto());
        ste.setInt(7, produit.getId_categorie_id());
        ste.executeUpdate();
        System.out.println("Produit ajouté avec succès");
    } catch (IOException | SQLException ex) {
        System.out.println("Erreur lors de l'ajout du produit: " + ex.getMessage());
    }
}


 
 public Produit getProduitById(int id) {
    try {
        String sql = "select * from Produit where id_produit=?";
        PreparedStatement stmt = cnx.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Produit produit = new Produit();
            produit.setId_produit(rs.getInt("id_produit"));
            produit.setNom_produit(rs.getString("nom_produit"));
            produit.setDescription(rs.getString("description"));
            produit.setQuantite(rs.getInt("quantite"));
            produit.setPrix(rs.getFloat("prix"));
            produit.setPhoto(rs.getString("photo"));
            produit.setId_categorie_id(rs.getInt("id_categorie_id"));
            return produit;
        }
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la récupération du produit : " + ex.getMessage());
    }
    return null;
}

public List<Produit> getAllProduits() {
    List<Produit> produits = new ArrayList<>();
    try {
        String sql = "select * from Produit";
        PreparedStatement stmt = cnx.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Produit produit = new Produit();
            produit.setId_produit(rs.getInt("id_produit"));
            produit.setNom_produit(rs.getString("nom_produit"));
            produit.setDescription(rs.getString("description"));
            produit.setQuantite(rs.getInt("quantite"));
            produit.setPrix(rs.getFloat("prix"));
            produit.setPhoto(rs.getString("photo"));
            produit.setId_categorie_id(rs.getInt("id_categorie_id"));
            produits.add(produit);
        }
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la récupération des produits : " + ex.getMessage());
    }
    return produits;
}

public void updateProduit(Produit produit) {
    try {
        String sqlCheck = "select count(*) from Produit where  id_produit!=?";
        PreparedStatement stmtCheck = cnx.prepareStatement(sqlCheck);
        stmtCheck.setInt(1, produit.getId_produit());
        ResultSet rs = stmtCheck.executeQuery();
        rs.next();

       
            String sql = "update Produit set nom_produit=?, description=?, quantite=?, prix=?, photo=?, id_categorie_id=? where id_produit=?";
            PreparedStatement stmt = cnx.prepareStatement(sql);
            stmt.setString(1, produit.getNom_produit());
            stmt.setString(2, produit.getDescription());
            stmt.setInt(3, produit.getQuantite());
            stmt.setFloat(4, produit.getPrix());
            stmt.setString(5, produit.getPhoto());
            stmt.setInt(6, produit.getId_categorie_id());
            stmt.setInt(7, produit.getId_produit());
            stmt.executeUpdate();
            System.out.println("Produit modifié avec succès");
        
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la modification du produit : " + ex.getMessage());
    }
}

public void deleteProduit(int id) {
    try {
        String sql = "delete from Produit where id_produit=?";
        PreparedStatement stmt = cnx.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        System.out.println("Produit supprimé avec succès");
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la suppression du produit : " + ex.getMessage());
    }
}

}
