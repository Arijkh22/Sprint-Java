/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemacscode;


import edu.devapps.entity.Utilisateur;
import  edu.devapps.services.UtilisateurService;
import java.io.File;
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
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField firstname1;
    @FXML
    private TextField lastname1;
    @FXML
    private TextField username1;
    @FXML
    private DatePicker datepick1;

    @FXML
    private TextField email1;
    @FXML
    private TextField password1;
    @FXML
    private VBox newvbox77;
    @FXML
    private TextField adresse1;
    
    FileChooser fileChooser = new FileChooser();
    @FXML
    private TextField photouser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    

    @FXML
    private void signmeup(ActionEvent event) throws SQLException {
        
        UtilisateurService us = new UtilisateurService();
        Utilisateur u = new Utilisateur();
           Date d= new Date(datepick1.getValue().getYear(), datepick1.getValue().getMonthValue(), datepick1.getValue().getDayOfMonth());


        us.ajouterutilisateur(new Utilisateur(1,firstname1.getText(),lastname1.getText(),u.encrypt(password1.getText()), email1.getText(), adresse1.getText(),"ROLE_USER", d,username1.getText(), photouser.getText(),0,0));
        
        
   FXMLLoader load = new FXMLLoader(getClass().getResource("SignIn.fxml"));

      TranslateTransition t = new TranslateTransition(Duration.seconds(1), newvbox77);
        t.setToX(newvbox77.getLayoutX() * 20);
        t.play();
        t.setOnFinished((e) ->{
            try{
                Parent root =load.load();
                   SignInController c2=  load.getController();
                 
                      
                newvbox77.getChildren().removeAll();
                newvbox77.getChildren().setAll(root);
            }catch(IOException ex){
                
            }
        });
        
        
        
        
        
        
        
        
                }

    @FXML
    private void uploadimge(ActionEvent event) {
     FileChooser.ExtensionFilter fileExtensions = new FileChooser.ExtensionFilter("image", new String[]{"*.jpg"});
        this.fileChooser.getExtensionFilters().add(fileExtensions);
        File file = this.fileChooser.showOpenDialog(new Stage());
        System.out.println(file.toURI().toString());
        this.photouser.setText(file.getName());
    
    }
}








