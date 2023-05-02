/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemacscode;



import edu.devapps.entity.Utilisateur;
import edu.devapps.services.UtilisateurService;
import com.sun.deploy.util.FXLoader;
import com.sun.javafx.scene.control.skin.ButtonSkin;
import edu.devapps.Controller.utilisateurviewController;
import edu.devapps.Interface.HomeBackController;
import edu.devapps.Interface.HomeFrontController;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class SignInController implements Initializable {

    @FXML
    private VBox newvbox1;
     private Parent fxml;
    @FXML
    private TextField emmail;
    @FXML
    private TextField password3;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    



    @FXML
    private void signmein(ActionEvent event) throws SQLException, IOException {
        UtilisateurService us = new UtilisateurService();
       Utilisateur ue = new Utilisateur();
        System.out.println( us.login(ue.encrypt(emmail.getText()) , password3.getText()));
        if ( us.login(emmail.getText(), ue.encrypt(password3.getText())).size()==1)
        {
            
            if ( us.login(emmail.getText(), ue.encrypt(password3.getText())).get(0).getBloquer()==1)
            {
                  Alert a =new Alert(Alert.AlertType.INFORMATION, "your account is banned");
             a.show();
            }
            else
            {
                
            
             Alert a =new Alert(Alert.AlertType.INFORMATION, "log in  avec success");
             a.show();
                 if ( us.login(emmail.getText(), ue.encrypt(password3.getText())).get(0).getRole().equals("ROLE_ADMIN"))
                 {
                     
                     
                      FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/HomeBack.fxml"));
                           Parent root =load.load();
                           HomeBackController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
                 }
                 else
                 {
                     
                   
                      FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/HomeFront.fxml"));
                           Parent root =load.load();
                           ue =us.login(emmail.getText(), ue.encrypt(password3.getText())).get(0);
                           HomeFrontController c2=  load.getController();
                           c2.getinfo(ue.getUsername(), ue.getNom(), ue.getPrenom(), ue.getEmail(), ue.getAge().toLocalDate(),"", ue.getPassword());
                        c2.setUe(ue);
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
                     
                     
                     
                 }
                   
        }}
        else
        {
              Alert a =new Alert(Alert.AlertType.ERROR, "username or password incorrect");
             a.show();
            
        }
       
    }

    @FXML
    private void forgetpassword(ActionEvent event) {
        
        
         TranslateTransition t = new TranslateTransition(Duration.seconds(1), newvbox1);
        t.setToX(newvbox1.getLayoutX() * 20);
        t.play();
        t.setOnFinished((e) ->{
            try{
                fxml = FXMLLoader.load(getClass().getResource("/com/xemacscode/forgetpassword.fxml"));
                newvbox1.getChildren().removeAll();
                newvbox1.getChildren().setAll(fxml);
            }catch(IOException ex){
                ex.getMessage();
                
            }
        });
    }
    
}
