/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import edu.devapps.entity.Publicite;
import edu.devapps.entity.Sponsor;
import edu.devapps.services.PubliciteService;
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
public class ModifierpubliciteController implements Initializable {

    @FXML
    private AnchorPane anchorme;
    @FXML
    private TextField nom_pub;
    @FXML
    private TextField description;
   Publicite thispub;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void annulerpublicite(ActionEvent event) throws IOException {
    
     anchorme.setVisible(false);
        
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/publiciteview.fxml"));
                           Parent root =load.load();
                           publiciteviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
    }

    @FXML
    private void modifierpublicite(ActionEvent event) throws IOException {
  
        PubliciteService s = new PubliciteService();
                      if (nom_pub.getText().equals(""))
                 {
                      Alert a = new Alert(Alert.AlertType.INFORMATION, "nom publicite cant be null ");
                        a.show(); 
                 }
                 else if (description.getText().equals(""))
                 {
                       Alert a = new Alert(Alert.AlertType.INFORMATION, "description cant be null ");
                        a.show();
                 }
               
                 else 
                 {
                      s.modifierpublicite(new Publicite(thispub.getId(), nom_pub.getText(), description.getText(),thispub.getImage(),thispub.getId_sponsor_id()));
                        Alert a = new Alert(Alert.AlertType.INFORMATION, "votre publicite est modifier ");
                        a.show();
        
                          anchorme.setVisible(false);
        
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/publiciteview.fxml"));
                           Parent root =load.load();
                           publiciteviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
    }
    }
    
      public void  getinfo (Publicite pub)
    {
        thispub=pub;
  
        nom_pub.setText(pub.getNom_pub());
        
      
        description.setText(pub.getDescription());
       
      
      
        
    }
    
}
