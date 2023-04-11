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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import workshop.entities.Personne;
import workshop.services.ServicePersonne;

/**
 * FXML Controller class
 *
 * @author omaim
 */
public class ModifierPersonneController implements Initializable {
    
    


    private ArrayList<Personne> personnes;
    private Personne personne;
    

    @FXML
    private Button btnModifier;
    @FXML
    private TextField budget;
    @FXML
    private Button btnAnnuler;
    @FXML
    private TextField nom;
    @FXML
    private TextField quantite;
    @FXML
    private TextField description;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    
    @FXML
    private void btnModifier(ActionEvent event) throws IOException{
        
   
        ServicePersonne s = new ServicePersonne();
        Personne p = new Personne();
        p.setBudget(budget.getText());
         p.setNom(nom.getText());
         p.setQuantite(quantite.getText());
         p.setDescrition(description.getText());
       
         p.setId(personne.getId());
         s.modifierPersonne(p);
        
        Alert a = new Alert(Alert.AlertType.INFORMATION, " offre modifier avec success");
        a.show();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherPersonne.fxml"));
        Parent page2Parent = loader.load();
        Scene page2Scene = new Scene(page2Parent);
    
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    
        window.setScene(page2Scene);
        window.show();
    }
    
    
    @FXML
    private void btnAnnuler(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherPersonne.fxml"));
        Parent page2Parent = loader.load();
        Scene page2Scene = new Scene(page2Parent);
    
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    
        window.setScene(page2Scene);
        window.show();
    }
    

    void setPersonne(Personne selectedPersonne) {
        
        this.personne = selectedPersonne;
        // Mettre à jour les champs de texte avec les valeurs de la personne sélectionnée
        System.out.println(selectedPersonne);
        budget.setText(selectedPersonne.getBudget());
        nom.setText(selectedPersonne.getNom());
        quantite.setText(selectedPersonne.getQuantite());
        description.setText(selectedPersonne.getDescrition());
  
        ObservableList<Personne> listePersonnes = FXCollections.observableArrayList(selectedPersonne);
  
    }
    
    
    
}
