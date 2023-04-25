/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import edu.devapps.entity.Publicite;
import edu.devapps.entity.Sponsor;
import edu.devapps.services.RatingService;
import edu.devapps.services.TrayIconDemo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import jihed.MyListener;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class OnepubliciteviewController implements Initializable {

    @FXML
    private Label nom_pub;
    @FXML
    private Label description;
 private Publicite pub;
    private MyListener myListener;
    @FXML
    private Rating ratingval;
    @FXML
    private ImageView imgv;
    
    Image image;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onclick(MouseEvent event) {
   
                          myListener.onClickListener(pub);

    }
    
     public void setData(Publicite pube, MyListener myListener) {
        this.pub = pube;
        this.myListener = myListener;
        nom_pub.setText(pube.getNom_pub());
        description.setText(pube.getDescription());
       
        image = new Image(getClass().getResourceAsStream("/utilities/"+pube.getImage()));
         
            imgv.setImage(image);
            
        
    }

    @FXML
    private void ratethis(MouseEvent event) throws IOException {
       
        
         Alert a = new Alert(Alert.AlertType.CONFIRMATION, "your rate will be added");
      a.showAndWait();
         if( a.getResult()== ButtonType.OK)
         {
             RatingService s = new RatingService();
             s.ajouterrating(new edu.devapps.entity.Rating(1,(int) ratingval.getRating(), 1, pub.getId()));
             TrayIconDemo t = new TrayIconDemo();
             t.notifnewrate(pub.getNom_pub());
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
    
}
