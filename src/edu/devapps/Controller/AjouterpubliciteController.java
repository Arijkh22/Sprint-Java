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
import java.io.File;
import java.io.IOException;e
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class AjouterpubliciteController implements Initializable {

    @FXML
    private AnchorPane anchorme;
    @FXML
    private TextField nom_pub;
    @FXML
    private TextField description;
    @FXML
    private TextField image;
Sponsor thissponsor;
    FileChooser fileChooser = new FileChooser();

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
    private void ajouterpublicite(ActionEvent event) throws IOException {
   
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
                 else if (image.getText().equals(""))
                 {
                      Alert a = new Alert(Alert.AlertType.INFORMATION, "image cant be null ");
                        a.show();
                 }
                 else 
                 {
                     
                 

                      s.ajouterpublicite(new Publicite(1, nom_pub.getText(), description.getText(),image.getText(),thissponsor.getId()));
                        Alert a = new Alert(Alert.AlertType.INFORMATION, "votre reponse est modifier ");
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
    }
    }
    
    
       public void  getinfo (Sponsor spons)
    {
        thissponsor=spons;
  
   
        
    }

    @FXML
    private void addimage(ActionEvent event) {
        
         FileChooser.ExtensionFilter fileExtensions = new FileChooser.ExtensionFilter("image", new String[]{"*.png"});
        this.fileChooser.getExtensionFilters().add(fileExtensions);
        File file = this.fileChooser.showOpenDialog(new Stage());
        System.out.println(file.toURI().toString());
        this.image.setText(file.getName());
    }
    
}
