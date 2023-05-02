/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import hamma.MyListener;
import com.mysql.jdbc.Connection;
import edu.devapps.entity.Produit;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Scale;
import utilities.MaConnexion;


public class OneproduitviewController implements Initializable {

    @FXML
    private Label nom_produit;
    @FXML
    private Label description;
    @FXML
    private Label prix;
    @FXML
    private Label quantite;
    @FXML
    private Label photo;
    
 private Produit prod;
    private MyListener myListener;
    @FXML
    private Label date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    

    @FXML
    private void onclick(MouseEvent event) {
         myListener.onClickListener(prod);
    }
    
    
    
     public void setData(Produit produit, MyListener myListener) {
        this.prod = produit;
        this.myListener = myListener;
        nom_produit.setText(produit.getNom_produit());
        description.setText(produit.getDescription());
        prix.setText(""+produit.getPrix());
        quantite.setText(""+produit.getQuantite());
        photo.setText(""+produit.getPhoto());
       date.setText(""+produit.getDate());
      
          
        
    }/*
     public void enregistrerNote(Produit produit, MyListener myListener) {
        this.prod = produit;
        this.myListener = myListener;
    float note = (float) rating.getRating();
    int idProduit = produit.getId_produit(); // remplacez par l'identifiant du produit actuel
    String url = "jdbc:mysql://localhost:3306/devappsfinal";
    String utilisateur = "root";
    String motDePasse = "";
    try {
        Connection conn = (Connection) DriverManager.getConnection(url, utilisateur, motDePasse);
        String sql = "UPDATE produit SET rating = ? WHERE id_produit = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setFloat(1, note);
        stmt.setInt(2, idProduit);
        stmt.executeUpdate();
        conn.close();
        System.out.println("Note enregistrée avec succès.");
    } catch (SQLException e) {
        System.err.println("Erreur lors de l'enregistrement de la note : " + e.getMessage());
    }
}

public void afficherNote() {
    int idProduit = 1; // remplacez par l'identifiant du produit actuel
    String url = "jdbc:mysql://localhost:3306/devappsfinal";
    String utilisateur = "root";
    String motDePasse = "";
    try {
        Connection conn = (Connection) DriverManager.getConnection(url, utilisateur, motDePasse);
        String sql = "SELECT AVG(rate) AS moyenne FROM produit WHERE id_produit = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idProduit);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            float moyenne = rs.getFloat("moyenne");
            rating.setRating(moyenne);
// afficher la moyenne avec 2 décimales
        }
        conn.close();
    } catch (SQLException e) {
        System.err.println("Erreur lors de la récupération de la note : " + e.getMessage());
    }
}*/
}
