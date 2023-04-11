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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.LoadException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import workshop.entities.Personne;
import workshop.entities.Reponse;
import workshop.services.ServicePersonne;
import workshop.utils.MyDB;

/**
 * FXML Controller class
 *
 * @author omaim
 */
public class AfficherPersonneController implements Initializable {
    
    
    @FXML
    private TableView<Personne> table;
 
    @FXML
    private TableColumn<Personne, String> colId;
    @FXML
    private TableColumn<Personne, String> colNom;
    @FXML
    private TableColumn<Personne, String> colQuantite;
    @FXML
    private TableColumn<Personne, String> colBudget;
    @FXML
    private TableColumn<Personne, String> colDescription;
    @FXML
    private TableColumn<Personne, String> colDate;
    @FXML
    private TableColumn<Personne, String> colIdUtilisateur;
    @FXML
    private TableColumn<Personne, String> colIDCategorie;
    
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnAjouterRep;
    @FXML
    private Button btnAjouter;
    
    
   
    private ArrayList<Personne> personnes;

    
    
    
    /**
     * Initializes the controller class.
     */
    
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

     
  
     
     // Récupérer les données de la base de données
    ServicePersonne sp = new ServicePersonne();
    ArrayList<Personne> personnes = sp.afficherpersonne();
    
    // Créer l'ObservableList à partir des données récupérées
    ObservableList<Personne> observableList = FXCollections.observableArrayList(personnes);
    
    // Associer l'ObservableList à la TableView
    table.setItems(observableList);
    
    // Associer chaque propriété de Personne à une colonne de TableView
   // colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
    colNom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
    colQuantite.setCellValueFactory(new PropertyValueFactory<>("Quantite"));
    colBudget.setCellValueFactory(new PropertyValueFactory<>("Budget"));
    colDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
    colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
  //  colIdUtilisateur.setCellValueFactory(new PropertyValueFactory<>("IdUtilisateur"));
  //  colIDCategorie.setCellValueFactory(new PropertyValueFactory<>("IdCategorie"));
   
    
    
   
   
    
}



   
    
    
    
    @FXML
    private void btnAjouter(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterPersonneFXML.fxml"));
        Parent page2Parent = loader.load();
        Scene page2Scene = new Scene(page2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(page2Scene);
        window.show();
    }
    
    
    @FXML
    public void btnModifier(ActionEvent event) throws IOException {
     
        
        // Création d'une nouvelle scène pour la page de modification
    
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierPersonne.fxml"));
                           Parent root =loader.load();
                           ModifierPersonneController c2=  loader.getController();
                           c2.setPersonne(table.getSelectionModel().getSelectedItem());
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();

           
    }
    
    
    
    
    @FXML
    private void btnSupprimer(ActionEvent event) throws IOException{
        // Récupérer la liste des items sélectionnés
        ObservableList<Personne> selectedItems = table.getSelectionModel().getSelectedItems();

        // Supprimer les items sélectionnés de la TableView
        //table.getItems().removeAll(selectedItems);

        // Supprimer les items sélectionnés de la base de données en utilisant la méthode supprimer() de la couche de CRUD
        for (Personne item : selectedItems) {
        ServicePersonne p = new ServicePersonne();
        p.suprrimerPersonne(item);
        }
    
        // Supprimer les items sélectionnés de la TableView
        table.getItems().removeAll(selectedItems);
        
        
    }
    
    
    
    
    
    
@FXML
private void handleMouseClicked(MouseEvent event) throws IOException {
   
    // Récupération de la ligne sélectionnée
        
            try{
                Personne selectedPersonne = table.getSelectionModel().getSelectedItem();
        // Sélection de la ligne correspondante dans la table view
        table.getSelectionModel().select(selectedPersonne);
        if (selectedPersonne == null) {
            // si aucune ligne n'est sélectionnée, ne rien faire
            return;
        }
        
                }catch(Exception e){
                    Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur lors du chargement de la vue ");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
                }
        
}




@FXML
public void btnAjouterRep(ActionEvent event) throws IOException {
     
        
        
        FXMLLoader load = new FXMLLoader(getClass().getResource("AjouterReponse.fxml"));
                           Parent root =load.load();
                           AjouterReponseController c2=  load.getController();
                           c2.setPersonne(table.getSelectionModel().getSelectedItem());
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();

}
    
    
    

}

    

