/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

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


public class ModifierproduitController implements Initializable {

    @FXML
    private AnchorPane anchorme;
    @FXML
    private TextField nom_produit;
    @FXML
    private TextField description;
    @FXML
    private TextField prix;
    @FXML
    private TextField quantite;
   Produit thisprod;

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
        
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/produitview.fxml"));
                           Parent root =load.load();
                           produitviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
    }

    @FXML
    private void modifierproduit(ActionEvent event) throws IOException {
    
        ProduitService s = new ProduitService();
        
          if (nom_produit.getText().equals(""))
                         {
                          System.out.println("nom produit cant be null");
                           Alert a = new Alert(Alert.AlertType.INFORMATION,"nom produit cant be null");
                           a.show();
                             
                         }
                         else if (description.getText().equals(""))
                         {
                           System.out.println("description produit cant be null");
                             Alert a = new Alert(Alert.AlertType.INFORMATION,"description cant be null");
                           a.show();

                         }
                  
                         
                         else if (prix.getText().equals(""))
                         {
                             System.out.println("prix cant be 0");
                                           Alert a = new Alert(Alert.AlertType.INFORMATION,"prix cant be null");
                           a.show();
                         }
                         else if (quantite.getText().equals(""))
                         {
                             System.out.println("quantite cant be 0");
                                                Alert a = new Alert(Alert.AlertType.INFORMATION,"quantite cant be null");
                           a.show();
                         }
                         
                     else
                         {
                             
                     float p  = Float.valueOf(prix.getText());
                     int q = Integer.valueOf(quantite.getText());
                     Date d = new Date(19993010);
                         if (p==0)
                         {
                             System.out.println("prix cant be 0"); 
                            Alert a = new Alert(Alert.AlertType.INFORMATION,"prix cant be null");
                           a.show();
                         }
                         else
                             if (q==0)
                             {
                                 System.out.println("quantite cant be 0");  
                                      Alert a = new Alert(Alert.AlertType.INFORMATION,"quantite cant be null");
                           a.show();
                             }
                         else
                             {
                                 
                         

                      s.modifierproduit(new Produit(thisprod.getId_produit(), nom_produit.getText(), description.getText(),p,q,thisprod.getPhoto(),d,thisprod.getId_categorie_id()));
                        Alert a = new Alert(Alert.AlertType.INFORMATION, "votre produit est modifier ");
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
    
    }}}
    
    
    
     public void  getinfo (Produit prod)
    {
        thisprod=prod;
  
        nom_produit.setText(prod.getNom_produit());
        description.setText(prod.getDescription());
        prix.setText(""+prod.getPrix());
        quantite.setText(""+prod.getQuantite());
       
      
      
        
    }
    
}
