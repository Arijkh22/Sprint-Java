/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import edu.devapps.entity.Categorie;
import edu.devapps.entity.Produit;
import edu.devapps.services.ProduitService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class AjouterproduitController implements Initializable {

    @FXML
    private AnchorPane anchorme;
    @FXML
    private TextField nom_produit;
    @FXML
    private TextField prix;
    @FXML
    private TextField description;
    @FXML
    private TextField quantite;
    @FXML
    private TextField photo;
Categorie thiscat;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void annulerproduit(ActionEvent event) throws IOException {
   
      anchorme.setVisible(false);
        
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/categorieview.fxml"));
                           Parent root =load.load();
                           categorieviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
    
    
    }

    @FXML
    private void ajouterproduit(ActionEvent event) throws IOException {
   
                
                    
                        
                    if (nom_produit.getText().equals(""))
                         {
                          System.out.println("nom du produit obligatoire");
                           Alert a = new Alert(Alert.AlertType.INFORMATION,"nom du produit obligatoire");
                           a.show();
                             
                         }
                         else if (description.getText().length() < 8) {
                           System.out.println("Description doit avoir au minimum 8 caractères");
                               Alert a = new Alert(Alert.AlertType.INFORMATION,"Description doit avoir au minimum 8 caractères");
                           a.show();
                        }

                         else if (photo.getText().equals(""))
                         {
                           System.out.println("photo produit obligatoire");
                               Alert a = new Alert(Alert.AlertType.INFORMATION,"photo obligatoire");
                           a.show();
                             
                         }
                         
                         else if (!prix.getText().matches("\\d+(\\.\\d+)?") || Float.parseFloat(prix.getText()) <= 0) {
                           System.out.println("Le prix doit être un nombre positif");
                               Alert a = new Alert(Alert.AlertType.INFORMATION, "Le prix doit être un nombre positif");
                           a.show();} 
                         else if (!quantite.getText().matches("\\d+") || Integer.parseInt(quantite.getText()) <= 0) {
                            System.out.println("La quantité doit être un entier positif");
                               Alert a = new Alert(Alert.AlertType.INFORMATION, "La quantité doit être un entier positif");
                           a.show();
                        }

                         
                     else
                         {
                             
                     float p  = Float.valueOf(prix.getText());
                     int q = Integer.valueOf(quantite.getText());
                     Date d = new Date(19993010);
                         if (p==0)
                         {
                             System.out.println("prix ne peut pas etre 0"); 
                            Alert a = new Alert(Alert.AlertType.INFORMATION,"prix ne peut pas etre 0");
                           a.show();
                         }
                         else
                             if (q==0)
                             {
                                 System.out.println("quantite ne peut pas etre 0");  
                                      Alert a = new Alert(Alert.AlertType.INFORMATION,"quantite ne peut pas etre 0");
                           a.show();
                             }
                         else
                             {
                                 
                             
                         
                             ProduitService s = new ProduitService();

                      s.ajouterproduit(new Produit(1, nom_produit.getText(), description.getText(),p,q,photo.getText(),d,thiscat.getId()));
                        Alert a = new Alert(Alert.AlertType.INFORMATION, "votre produit est ajouter ");
                        a.show();
        
                          anchorme.setVisible(false);
        
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/produitview.fxml"));
                           Parent root =load.load();
                            produitviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
                          }}
    }
    
    
    
       public void  getinfo (Categorie cat)
    {
        thiscat=cat;
  
   
        
    }
}
