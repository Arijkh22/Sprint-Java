/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Interface;

import com.xemacscode.ProfilController;
import edu.devapps.Controller.AjouterreclamationController;
import edu.devapps.Controller.CategorieFrontFXController;
import edu.devapps.Controller.SponsorviewController;
import edu.devapps.entity.Utilisateur;
import edu.devapps.services.UtilisateurService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class HomeFrontController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private String usernamelab;
    private String firstnamelab;
    private String lastnamelab;
    private String emaillab;
    private LocalDate datepicklab;
    private String numtellab;
    private String passwordlab;
    UtilisateurService us = new UtilisateurService();
    Utilisateur ue = new Utilisateur();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void GoToUser(ActionEvent event) throws IOException, SQLException {
             
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/com/xemacscode/profil.fxml"));
                           Parent root =load.load();
                           
                           ProfilController c2=  load.getController();
                           c2.getinfo(ue.getUsername(), ue.getPrenom(), ue.getNom(), ue.getEmail(), ue.getAge().toLocalDate(),"", ue.getPassword());
                           System.out.println(ue);
                          c2.setUe(ue);
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
                           
                       
                     
    }

    @FXML
    private void GoToReclamation(ActionEvent event) throws IOException, SQLException {
        FXMLLoader load = new FXMLLoader(getClass().getResource("ajouterreclamation.fxml"));
                   Parent root =load.load();
                   AjouterreclamationController c2=  load.getController();
                 //  c2.getinfo(u.getUsername(), u.getNom(),u.getPrenom(), u.getEmail(), u.getAge().toLocalDate(), "", u.getPassword());
                   c2.setUe(ue);
                   Scene ss= new Scene(root);
                   Stage se= new Stage();
                   se=(Stage)((Node)event.getSource()).getScene().getWindow();
                      se.setScene(ss);
                      se.show();
    }

    @FXML
    private void GoToProduit(ActionEvent event) throws IOException {
        
        FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/categorieFrontFX.fxml"));
                           Parent root =load.load();
                           
                           CategorieFrontFXController c2=  load.getController();
                           System.out.println(ue);
                           c2.setUe(ue);
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
    }



    @FXML
    private void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/xemacscode/Main.fxml"));                       
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
    }

    public void getinfo(String usernamelab,String firstnamelab,String lastnamelab,String emaillab,LocalDate datepicklab,String numtellab,String passwordlab) {
       this.usernamelab=usernamelab;
       this.passwordlab=passwordlab;

        this.emaillab=emaillab;
        this.datepicklab=datepicklab;
        this.firstnamelab=firstnamelab;
        this.lastnamelab=lastnamelab;
        
        this.numtellab=numtellab;
        
        
    }
    
    
    public Utilisateur getUe() {
        return ue;
    }

    public void setUe(Utilisateur ue) {
        this.ue = ue;
    }
    
}
