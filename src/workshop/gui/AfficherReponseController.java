/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.gui;

import edu.devapps.Interface.HomeBackController;
import edu.devapps.entity.Reponse;
import edu.devapps.services.ServiceReponse;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author omaim
 */
public class AfficherReponseController implements Initializable {
    
     @FXML
    private TableView<Reponse> table;
     
   

    @FXML
    private TableColumn<Reponse, String> colBudget;

    @FXML
    private TableColumn <Reponse, String> colDate;

    @FXML
    private TableColumn<Reponse, String> colEtat;


    @FXML
    private TableColumn<Reponse, String> colNom;

    
    @FXML
    private Button btnModifier;

    @FXML
    private Button btnSupprimer;
   
    
    
    private ArrayList<Reponse> reponse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        
        // Récupérer les données de la base de données
        ServiceReponse sp = new ServiceReponse();
        ArrayList<Reponse> reponse = sp.afficherreponse();
    
        // Créer l'ObservableList à partir des données récupérées
        ObservableList<Reponse> observableList = FXCollections.observableArrayList(reponse);
    
        // Associer l'ObservableList à la TableView
        table.setItems(observableList);
    
        // Associer chaque propriété de Reponse à une colonne de TableView
       // colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        colBudget.setCellValueFactory(new PropertyValueFactory<>("Budget"));
        colEtat.setCellValueFactory(new PropertyValueFactory<>("Etat"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
       // colIdOffre.setCellValueFactory(new PropertyValueFactory<>("IdOffre"));
    
    }    
    
    @FXML
    void btnModifier(ActionEvent event) throws IOException {
        
        // Création d'une nouvelle scène pour la page de modification
    
        
        FXMLLoader load = new FXMLLoader(getClass().getResource("ModifierReponse.fxml"));
                           Parent root =load.load();
                           ModifierReponseController c2=  load.getController();
                           c2.setPersonne(table.getSelectionModel().getSelectedItem());
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();

    }

    @FXML
    void btnSupprimer(ActionEvent event) throws IOException {
        
        // Récupérer la liste des items sélectionnés
        ObservableList<Reponse> selectedItems = table.getSelectionModel().getSelectedItems();

        // Supprimer les items sélectionnés de la TableView
        //table.getItems().removeAll(selectedItems);

        // Supprimer les items sélectionnés de la base de données en utilisant la méthode supprimer() de la couche de CRUD
        for (Reponse item : selectedItems) {
        ServiceReponse p = new ServiceReponse();
        p.suprrimerReponse(item);
        }
    
        // Supprimer les items sélectionnés de la TableView
        table.getItems().removeAll(selectedItems);

    }

    @FXML
    void handleMouseClicked(MouseEvent event) {
        
        // Récupération de la ligne sélectionnée
        
            try{
                Reponse selectedReponse = table.getSelectionModel().getSelectedItem();
        // Sélection de la ligne correspondante dans la table view
        table.getSelectionModel().select(selectedReponse);
        if (selectedReponse == null) {
            // si aucune ligne n'est sélectionnée, ne rien faire
            return;
        }
        
                }catch(Exception e){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur lors du chargement de la vue ");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
                }

    }

    @FXML
    private void GoToHomeBack1(ActionEvent event) throws IOException {
         FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/homeback.fxml"));
                           Parent root =load.load();
                           HomeBackController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
        
    }
    
    
}
    

