/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import edu.devapps.entity.Facture;
import edu.devapps.services.FactureService;
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

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class AjouterfactureController implements Initializable {

    @FXML
    private AnchorPane anchorme;
    @FXML
    private TextField numero;
    @FXML
    private TextField prix;
    @FXML
    private TextField nom;
    @FXML
    private TextField date;
    @FXML
    private TextField etat;
    @FXML
    private TextField description;
    @FXML
    private TextField image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void annulerfacture(ActionEvent event) throws IOException {
   
       anchorme.setVisible(false);
        
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/factureview.fxml"));
                           Parent root =load.load();
                           factureviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
    }

    @FXML
    private void ajouterfacture(ActionEvent event) throws IOException {
    
        FactureService c = new FactureService();
            Date d = new Date(1999, 10, 30);
            
            if( nom.getText().equals(""))
            {
                  Alert a = new Alert(Alert.AlertType.INFORMATION, "nom cant be null");
                a.show();
            }
            else if (etat.getText().equals(""))
            {
                  Alert a = new Alert(Alert.AlertType.INFORMATION, "etat cant be null");
                a.show();
            }
            else if (description.getText().equals(""))
            {
                  Alert a = new Alert(Alert.AlertType.INFORMATION, "description cant be null");
                a.show();
            }
            else if (image.getText().equals(""))
            {
                  Alert a = new Alert(Alert.AlertType.INFORMATION, "image cant be null");
                a.show();
            }
            else if (prix.getText().equals(""))
            {
                  Alert a = new Alert(Alert.AlertType.INFORMATION, "prix cant be 0");
                a.show();
            }
            else if (numero.getText().equals(""))
            {
                 Alert a = new Alert(Alert.AlertType.INFORMATION, "numero cant be 0");
                a.show(); 
            }
            else
            {
                
           
            
            
                 int  p = Integer.valueOf(prix.getText());
                 int n = Integer.valueOf(numero.getText());
                 
                 
                 if (p==0)
                 {
                      Alert a = new Alert(Alert.AlertType.INFORMATION, "prix cant be 0");
                a.show(); 
                 }
                 else if (n==0)
                 {
                       Alert a = new Alert(Alert.AlertType.INFORMATION, "numero cant be 0");
                a.show();
                 }
                 else
                 {
                     
                
            c.ajouterFacture(new Facture(1,n, nom.getText(),p,d, etat.getText(),description.getText(),image.getText(),1));
                Alert a = new Alert(Alert.AlertType.INFORMATION, "reclamation ajouter avec  success");
                a.show();
                            anchorme.setVisible(false);
        
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/factureview.fxml"));
                           Parent root =load.load();
                          factureviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
                            }
     }
    }
    
}
