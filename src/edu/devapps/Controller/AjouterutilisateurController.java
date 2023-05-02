/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import edu.devapps.entity.Utilisateur;
import edu.devapps.services.UtilisateurService;
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
public class AjouterutilisateurController implements Initializable {

    @FXML
    private AnchorPane anchorme;
    @FXML
    private TextField nom;
    @FXML
    private TextField password;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField adresse;
    @FXML
    private TextField username;
    @FXML
    private TextField age;
    @FXML
    private TextField photo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void annulerutilisateur(ActionEvent event) throws IOException {
        
         anchorme.setVisible(false);
        
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/utilisateurview.fxml"));
                           Parent root =load.load();
                           utilisateurviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
    }

    @FXML
    private void ajouterutilisateur(ActionEvent event) throws IOException {
        
        UtilisateurService c = new UtilisateurService();
            Date d = new Date(19991010);
            if (nom.getText().equals(""))
            {
                             Alert a = new Alert(Alert.AlertType.INFORMATION, "nom cant be null");
                a.show();
            }
            else if (prenom.getText().equals(""))
            {
                             Alert a = new Alert(Alert.AlertType.INFORMATION, "prenom cant be null");
                a.show();
            }
            else if (password.getText().equals(""))
            {
                             Alert a = new Alert(Alert.AlertType.INFORMATION, "password cant be null");
                a.show();
            }
            else if (email.getText().equals(""))
            {
                           Alert a = new Alert(Alert.AlertType.INFORMATION, "email cant be null");
                a.show();  
            }
            else if (adresse.getText().equals(""))
            {
                             Alert a = new Alert(Alert.AlertType.INFORMATION, "adresse cant be null");
                a.show();
            }
            else if (username.getText().equals(""))
            {
                             Alert a = new Alert(Alert.AlertType.INFORMATION, "username cant be null");
                a.show();
            }
            else if (photo.getText().equals(""))
            {
                      Alert a = new Alert(Alert.AlertType.INFORMATION, "photo cant be null");
                a.show();
            }
            else 
            {
                
         
            c.ajouterutilisateur(new Utilisateur(1,nom.getText(), prenom.getText(), password.getText(), email.getText(),adresse.getText(),"ROLE_USER",d,username.getText(),photo.getText(),0,0));
                Alert a = new Alert(Alert.AlertType.INFORMATION, "utilisateur ajouter avec  success");
                a.show();
                            anchorme.setVisible(false);
        
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/utilisateurview.fxml"));
                           Parent root =load.load();
                          utilisateurviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
    
    }
       }
}
