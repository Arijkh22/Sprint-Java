/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.gui;

import Mailing.EmailSender;
import edu.devapps.entity.Personne;
import edu.devapps.entity.Reponse;
import edu.devapps.services.ServiceReponse;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.mail.*;
import javax.mail.internet.*;

/**
 * FXML Controller class
 *
 * @author omaim
 */
public class AjouterReponseController implements Initializable {
    
    @FXML
    private TextField Nom;
    @FXML
    private TextField Budget;
    @FXML
    private TextField Etat;
    @FXML
    private TextField Date;
    private TextField idOffre;
    
    @FXML
    private Button btnReponse;
    @FXML
    private Button btnRetour;
    
    
    private Personne p;
    private ArrayList<Reponse> reponses;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setPersonne(Personne selectedItem) {
    
        this.p = selectedItem;
        
        System.out.println(selectedItem);
        
        
        Nom.setText(p.getNom());
        Nom.setEditable(false);
  
        Date.setText(p.getDate());
        Date.setEditable(false);
    
    }
    
   
    
    
    @FXML
    private void btnRetour(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherPersonne.fxml"));
        Parent page2Parent = loader.load();
        Scene page2Scene = new Scene(page2Parent);
    
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    
        window.setScene(page2Scene);
        window.show();
    }
    
    
    
    @FXML
    private void btnReponse(ActionEvent event){
        
        
        
        
        // Vérification de la validité des champs de saisie
            
            if (Nom.getText().isEmpty() ||  Budget.getText().isEmpty() ||  Etat.getText().isEmpty() || Date.getText().isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Tous les champs sont obligatoires");
            alert.showAndWait();
        return;
    }
    if (Nom.getText().isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Le champ nom doit contenir uniquement des lettres");
            alert.showAndWait();
        return;
    }
    
    if (Budget.getText().isEmpty() || !Budget.getText().matches("\\d+")) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText("Le champ Budget doit être des nombres");
            alert.showAndWait();
            return;
    }
        
        
        
        String nom = Nom.getText();
        String budget = Budget.getText();
        String etat = Etat.getText();
        String date = Date.getText();
       
        
        System.out.println(p.getId());
        Reponse p1 = new Reponse(nom, budget, etat, date, p.getId());
        
        ServiceReponse sp = new ServiceReponse();
        sp.AjouterReponse(p1);
        // Afficher un message de succès
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succès");
        alert.setContentText("Reponse ajoutée avec succès");
        alert.showAndWait();
        
        // Effacer les champs de texte après avoir ajouté la personne
        Nom.clear();
        Budget.clear();
        Etat.clear();
        Date.clear();
        
        try{
            // affichage de la deuxième page avec les personnes existantes
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherReponse.fxml"));
            Parent page2Parent = loader.load();
            Scene page2Scene = new Scene(page2Parent);
    
    
            // obtenir la scène actuelle et la changer
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(page2Scene);
            window.show();
        }catch(IOException e) {
            e.printStackTrace();
        }
        

        
        try {
            EmailSender.sendMailWithMailtrap("oumaima.najar@esprit.tn", "Nouvelle réponse à l'appel d'offre", "Bonjour, une nouvelle réponse à l'appel d'offre a été ajoutée.");
            System.out.println("E-mail envoyé avec succès !");
        } catch (Exception ex) {
            System.out.println("Erreur lors de l'envoi de l'e-mail : " + ex.getMessage());
        }
    }

    
    
}
