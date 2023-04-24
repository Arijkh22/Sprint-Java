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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import workshop.entities.Personne;
import workshop.services.ServicePersonne;

/**
 * FXML Controller class
 *
 * @author omaim
 */
public class RecherchePersonneController implements Initializable {
    @FXML
    private TableView<Personne> table;
    @FXML
    private TableColumn<Personne, String> colBudget;

    @FXML
    private TableColumn<Personne, String> colDate;

    @FXML
    private TableColumn<Personne, String> colDescription;

    @FXML
    private TableColumn<Personne, String> colNom;

    @FXML
    private TableColumn<Personne, String> colQuantite;

    
    private ArrayList<Personne> personnes;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        
    }    
@FXML
    void setSearchResults(ArrayList<Personne> searchResults) {
        
        TableView<Personne> searchResultsTableView;
        
        
    
        // Créer l'ObservableList à partir des données récupérées
        ObservableList<Personne> observableList = FXCollections.observableArrayList(searchResults);
    
        // Associer l'ObservableList à la TableView
        table.setItems(observableList);
        //liaison des colonnes avec les attributs de personne
        colNom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        colQuantite.setCellValueFactory(new PropertyValueFactory<>("Quantite"));
        colBudget.setCellValueFactory(new PropertyValueFactory<>("Budget"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        
    }
    
   
    
}
