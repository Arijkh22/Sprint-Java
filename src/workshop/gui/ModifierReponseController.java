/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.gui;

import java.io.IOException;
import java.net.URL;
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
import workshop.entities.Personne;
import workshop.entities.Reponse;
import workshop.services.ServicePersonne;
import workshop.services.ServiceReponse;

/**
 * FXML Controller class
 *
 * @author omaim
 */
public class ModifierReponseController implements Initializable {
    
    
    private ArrayList<Reponse> reponses;
    private Reponse reponse;
    

    @FXML
    private Button btnModifier;
    @FXML
    private TextField Budget;
    @FXML
    private Button btnAnnuler;
    @FXML
    private TextField Nom;
    @FXML
    private TextField Etat;
    @FXML
    private TextField Date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   @FXML
    private void btnModifier(ActionEvent event) throws IOException{
        
   
        ServiceReponse s = new ServiceReponse();
        Reponse p = new Reponse();
        p.setBudget(Budget.getText());
        p.setNom(Nom.getText());
        p.setEtat(Etat.getText());
        p.setDate(Date.getText());
       
        p.setId(reponse.getId());
        s.modifierReponse(p);
        
        Alert a = new Alert(Alert.AlertType.INFORMATION, " reponse modifier avec success");
        a.show();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherReponse.fxml"));
        Parent page2Parent = loader.load();
        Scene page2Scene = new Scene(page2Parent);
    
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    
        window.setScene(page2Scene);
        window.show();
    }
    
    
    private void btnRetour(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherReponse.fxml"));
        Parent page2Parent = loader.load();
        Scene page2Scene = new Scene(page2Parent);
    
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    
        window.setScene(page2Scene);
        window.show();
    }
    

    void setPersonne(Reponse selectedReponse) {
        
        this.reponse = selectedReponse;
        // Mettre à jour les champs de texte avec les valeurs de la personne sélectionnée
        System.out.println(selectedReponse);
        Budget.setText(selectedReponse.getBudget());
        Nom.setText(selectedReponse.getNom());
        Etat.setText(selectedReponse.getEtat());
        Date.setText(selectedReponse.getDate());
  
        ObservableList<Reponse> listeReponses = FXCollections.observableArrayList(selectedReponse);
  
    }
    
    
}
