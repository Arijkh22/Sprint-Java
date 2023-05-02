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
public class ModifiersponsorController implements Initializable {

    @FXML
    private AnchorPane anchorme;
    @FXML
    private TextField nom;
    @FXML
    private TextField adresse;
    @FXML
    private TextField email;
    @FXML
    private TextField num_tel;
   Sponsor thisspobs;
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
    private void modifiersponsor(ActionEvent event) throws IOException {
  
        SponsorService s = new SponsorService();
                      Date d = new Date(19993010);
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
                   
                      s.modifiersponsor(new Sponsor(thisspobs.getId(), nom.getText(), adresse.getText(),email.getText(),num));
                        Alert a = new Alert(Alert.AlertType.INFORMATION, "votre sponsor est modifier ");
                        a.show();
        
                          anchorme.setVisible(false);
        
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/sponsorview.fxml"));
                           Parent root =load.load();
                           SponsorviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
    
    
    }}}
    
    
    
         public void  getinfo (Sponsor spons)
    {
        thisspobs=spons;
  
        nom.setText(spons.getNom());
        
      
        adresse.setText(spons.getEmail());
        email.setText(spons.getEmail());
        num_tel.setText(""+spons.getNum_tel());
      
      
        
    }
}
