/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import edu.devapps.entity.Categorie;
import edu.devapps.services.CategorieService;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class AjoutercategorieController implements Initializable {

    @FXML
    private AnchorPane anchorme;
    @FXML
    private TextField nom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void annulercategorie(ActionEvent event) throws IOException {
  
    
         anchorme.setVisible(false);
        
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/categorieview.fxml"));
                           Parent root =load.load();
                           categorieviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
    
        
    }

    @FXML
    private void ajoutercategorie(ActionEvent event) throws IOException {
   
        CategorieService c = new CategorieService();
        if (nom.getText().equals(""))
        {
            Alert a = new Alert(Alert.AlertType.INFORMATION,"nom obligatoire");
            a.show();
        }
        else
            
        {
            
       
            c.ajoutercategorie(new Categorie(1,nom.getText()));
                Alert a = new Alert(Alert.AlertType.INFORMATION, "categorie  ajouter avec  success");
                a.show();
                            anchorme.setVisible(false);
        
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/categorieview.fxml"));
                           Parent root =load.load();
                          categorieviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
                            }
    }
    
}
