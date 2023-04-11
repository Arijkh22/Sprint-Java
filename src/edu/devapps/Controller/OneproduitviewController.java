/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import arij.MyListener;
import edu.devapps.entity.Produit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


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
      
        
    }
}
