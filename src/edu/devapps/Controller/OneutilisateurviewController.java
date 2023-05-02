/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import edu.devapps.entity.Utilisateur;
import hamma.MyListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class OneutilisateurviewController implements Initializable {

    @FXML
    private Label nom;
    @FXML
    private Label adresse;
  
    @FXML
    private Label email;
 private Utilisateur user;
    private MyListener myListener;
    @FXML
    private Label prenom;
    @FXML
    private Label username;
    @FXML
    private Label age;
    @FXML
    private ImageView imgv;
 Image image ;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onclick(MouseEvent event) {
                              myListener.onClickListener(user);

    }
    
    
         public void setData(Utilisateur utilisateur, MyListener myListener) {
        this.user = utilisateur;
        this.myListener = myListener;
        nom.setText(utilisateur.getNom());
        adresse.setText(utilisateur.getAdresse());
        prenom.setText(""+utilisateur.getPrenom());
        email.setText(""+utilisateur.getEmail());
        username.setText(""+utilisateur.getUsername());
        age.setText(""+utilisateur.getAge());
       
           
            
                      image = new Image(getClass().getResourceAsStream("/utilities/"+utilisateur.getPhoto()));
         
            imgv.setImage(image);
            
           
        
    }
    
}
