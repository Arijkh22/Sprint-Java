package edu.devapps.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.devapps.entity.Categorie;
import edu.devapps.services.CategorieService;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class CategorieFrontFXController implements Initializable {
    @FXML
    private ListView<Categorie> categoriesList;
    @FXML
    private AnchorPane anchorforedit;
CategorieService cs = new CategorieService();
    @FXML
    private Button categbutt;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         List<Categorie> categories = cs.affichercategorie();
        ObservableList<Categorie> observableList = FXCollections.observableArrayList(categories);
        categoriesList.setItems(observableList);
     
    }    

    @FXML
    private void senddata(ActionEvent event) throws Exception{
      Categorie selectedCategory = categoriesList.getSelectionModel().getSelectedItem();

  FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/Front.fxml"));
  Parent root = loader.load();
  FrontController fc= loader.getController();
  fc.SetcategorieLabel(selectedCategory.getId());
  fc.setIdCategorie(selectedCategory.getId());
  Stage stage = new Stage();
  stage.setScene(new Scene(root));
  stage.show();
    }

    
    
    
    
    
}
