/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import edu.devapps.entity.Sponsor;
import edu.devapps.services.SponsorService;
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
public class AjoutersponsorController implements Initializable {

    @FXML
    private AnchorPane anchorme;
    @FXML
    private TextField nom;
    @FXML
    private TextField email;
    @FXML
    private TextField adresse;
    @FXML
    private TextField num_tel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void annulersponsor(ActionEvent event) throws IOException {
   
     anchorme.setVisible(false);
        
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/sponsorview.fxml"));
                           Parent root =load.load();
                           SponsorviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
    
    }

    @FXML
    private void ajoutersponsor(ActionEvent event) throws IOException {
   
        SponsorService c = new SponsorService();
        if (nom.getText().equals(""))
        {
             Alert a = new Alert(Alert.AlertType.INFORMATION, "nom cant be null");
                a.show();
        }
        else if (adresse.getText().equals(""))
        {
             Alert a = new Alert(Alert.AlertType.INFORMATION, "adresse cant be null");
                a.show();
        }
        else if (email.getText().equals(""))
        {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "email cant be null");
                a.show(); 
        }
        else if (num_tel.getText().equals(""))
        {
             Alert a = new Alert(Alert.AlertType.INFORMATION, "num tel cant be 0");
                a.show();
        }
        else 
        {
            
       
               int num = Integer.valueOf(num_tel.getText());
               
               if (num==0)
               {
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "num tel cant be 0");
                a.show();
               }
               else
               {
                   
              
            c.ajoutersponsor(new Sponsor(1,nom.getText(), adresse.getText(), email.getText(), num));
                Alert a = new Alert(Alert.AlertType.INFORMATION, "sponsor ajouter avec  success");
                a.show();
                            anchorme.setVisible(false);
        
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/sponsorview.fxml"));
                           Parent root =load.load();
                          SponsorviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
     }
    } }
    
}
