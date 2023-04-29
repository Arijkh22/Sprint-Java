/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import edu.devapps.entity.Categorie;
import edu.devapps.entity.Produit;
import edu.devapps.services.ProduitService;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;


public class FrontController implements Initializable {
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private AnchorPane anchorforedit;
    @FXML
    private Label categorieLabel;
    @FXML
    private Button retourButton;
    @FXML
    private TableView<Produit> tableView;
    @FXML
    private TableColumn<Produit, Integer> idProduitColumn;
    @FXML
    private TableColumn<Produit, String> nomProduitColumn;
    @FXML
    private TableColumn<Produit, String> descriptionColumn;
    @FXML
    private TableColumn<Produit, Float> prixColumn;
    @FXML
    private TableColumn<Produit, Integer> quantiteColumn;
    private int idCategorie;
    
   ProduitService ps=new ProduitService();
    /**-
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
        categorieLabel.setText("Catégorie: " + idCategorie);
        loadProduits();
    }
     private void loadProduits() {
        List<Produit> produits =ps.getProd(idCategorie);
    List<Produit> l = new ArrayList<>();
    l = (ArrayList<Produit>) ps.getProd(idCategorie);
    ObservableList<Produit> data = FXCollections.observableArrayList(l);
    FilteredList<Produit> fle = new FilteredList(data, e -> true);
    idProduitColumn.setCellValueFactory(new PropertyValueFactory<>("id_produit"));
    nomProduitColumn.setCellValueFactory(new PropertyValueFactory<>("nom_produit"));
    descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
    prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
    quantiteColumn.setCellValueFactory(new PropertyValueFactory<>("quantite"));

    tableView.setItems(fle);
    }
    
    

    void setIdCategorie(Categorie selectedCategory) {
this.idCategorie = idCategorie; // stockage des données passées en paramètre
        categorieLabel.setText("Catégorie " + idCategorie); // affichage des données dans la vue    }
}

   

    void SetcategorieLabel(int a) {
categorieLabel.setText(String.valueOf(a));
    }
}
