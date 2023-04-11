/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import workshop.entities.Personne;
import workshop.services.ServicePersonne;

/**
 * FXML Controller class
 *
 * @author Andrew
 */
public class AjouterPersonneFXMLController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfquantite;
    @FXML
    private TextField tfbudget;
    @FXML
    private TextField tfdescription;
    @FXML
    private TextField tfdate;
    @FXML
    private TextField tfidUtilisateur;
    @FXML
    private TextField tfidCategorie;
    @FXML
    private Label afficherlabel;
    
    @FXML
    private Button btnReponse;
    
    
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
    public static boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        double d = Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
}
    
    
    
    
    
    
    @FXML
    private void btnAjouter(ActionEvent event) {
        try{
            
            // Vérification de la validité des champs de saisie
            
            if (tfnom.getText().isEmpty() || tfquantite.getText().isEmpty() || tfbudget.getText().isEmpty() ||  tfdescription.getText().isEmpty() || tfdate.getText().isEmpty() || tfidUtilisateur.getText().isEmpty()   || tfidCategorie.getText().isEmpty()) {
        Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Tous les champs sont obligatoires");
            alert.showAndWait();
        return;
    }
    if (tfnom.getText().isEmpty() || !tfnom.getText().matches("[a-zA-Z]+")) {
        Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Le champ nom doit contenir uniquement des lettres");
            alert.showAndWait();
        return;
    }
    if (tfdescription.getText().isEmpty() || tfdate.getText().isEmpty() || tfidUtilisateur.getText().isEmpty()   || tfidCategorie.getText().isEmpty()) {
        Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Tous les champs sont obligatoires");
            alert.showAndWait();
        return;
    }
    if (tfquantite.getText().isEmpty() || !tfquantite.getText().matches("\\d+")) {
        Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText("Le champ Quantité doit être des nombres");
            alert.showAndWait();
            return;
        
    }
    if (tfbudget.getText().isEmpty() || !tfbudget.getText().matches("\\d+")) {
        Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText("Le champ Budget doit être des nombres");
            alert.showAndWait();
            return;
    }
    
    
    // Convertir les champs d'ID utilisateur et de catégorie en entiers
        int idUtilisateur = Integer.parseInt(tfidUtilisateur.getText());
        int idCategorie = Integer.parseInt(tfidCategorie.getText());
            
            
        // Si tous les champs sont valides, on ajoute les données dans la liste
        String nom = tfnom.getText();
        String quantite = tfquantite.getText();
        String budget = tfbudget.getText();
        String description = tfdescription.getText();
        String date = tfdate.getText();
        
        
        
        Personne p1 = new Personne(tfnom.getText(), tfquantite.getText(),tfbudget.getText(),tfdescription.getText(),tfdate.getText(),Integer.parseInt(tfidUtilisateur.getText()), Integer.parseInt(tfidCategorie.getText()));
        
        ServicePersonne sp = new ServicePersonne();
        sp.AjouterPersonne(p1);
        // Afficher un message de succès
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succès");
        alert.setContentText("Appel d'offre ajoutée avec succès");
        alert.showAndWait();
        
        // Effacer les champs de texte après avoir ajouté la personne
        tfnom.clear();
        tfquantite.clear();
        tfbudget.clear();
        tfdescription.clear();
        tfdate.clear();
        tfidUtilisateur.clear();
        tfidCategorie.clear();
    } catch (NumberFormatException e) {
        // Afficher un message d'erreur si les champs d'ID utilisateur ou de catégorie ne contiennent pas des valeurs numériques valides
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setContentText("Les champs d'ID utilisateur et de catégorie doivent contenir des valeurs numériques valides");
        alert.showAndWait();
    }
        
        try{
            
             
        // affichage de la deuxième page avec les personnes existantes
    FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherPersonne.fxml"));
    Parent page2Parent = loader.load();
    Scene page2Scene = new Scene(page2Parent);
    
    
    // obtenir la scène actuelle et la changer
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(page2Scene);
    window.show();
        }catch(IOException e) {
    e.printStackTrace();
}
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
  
}
