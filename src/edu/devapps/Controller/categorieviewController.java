/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import arij.MyListener;
import edu.devapps.entity.Categorie;
import edu.devapps.entity.Produit;
import edu.devapps.services.CategorieService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class categorieviewController implements Initializable {

    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label nom;
    @FXML
    private ImageView fruitImg;
    @FXML
    private HBox hboxcamping;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private AnchorPane anchorforedit;
  Categorie currentategorie;
     private Parent fxml;
      private List<Categorie> categories = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    
    
    
    
    
    
     private List<Categorie> getData() throws SQLException {
      
            List<Categorie> categories = new ArrayList<>();
         CategorieService s = new CategorieService();
        Categorie cat;

        for (int i = 0; i < s.affichercategorie().size(); i++) {
            Categorie get = s.affichercategorie().get(i);
            
            
            cat = new Categorie();
            cat.setId(get.getId());
            cat.setNom(get.getNom());
           
           
        
           
            
         
            categories.add(cat);
        }
    

      
        return categories;
    }

    private void setChosenCamping(Categorie cat) {
        currentategorie=cat;
        nom.setText(cat.getNom());
       
      
      
        chosenFruitCard.setStyle("-fx-background-color: #FAEBD7;\n" +
                "    -fx-background-radius: 30;");
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
          hboxcamping.setVisible(false);
        anchorforedit.setVisible(false);
        try {
            // TODO
            afficher();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    
    
    
    
     
     public void afficher() throws SQLException
    {
               categories.addAll(getData());
        if (categories.size() > 0) {
            setChosenCamping(categories.get(0));
            myListener = new MyListener() {
           

            

             

           

                @Override
                public void onClickListener(Categorie Categorie) {
                      setChosenCamping(Categorie);
                }

                @Override
                public void onClickListener(Produit Produit) {
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < categories.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/edu/devapps/Interface/onecategorieview.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                OnecategorieviewController onecategorieviewController = fxmlLoader.getController();
                onecategorieviewController.setData(categories.get(i),myListener);

                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    @FXML
    private void ajoutercategorie(ActionEvent event) throws IOException {
    anchorforedit.setVisible(true);
           
                fxml = FXMLLoader.load(getClass().getResource("/edu/devapps/Interface/ajoutercategorie.fxml"));
                         FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/ajoutercategorie.fxml"));
                           Parent root =load.load();
                           AjoutercategorieController c2=  load.getController();
                          fxml=root;
                            anchorforedit.getChildren().removeAll();
                             anchorforedit.getChildren().setAll(fxml);
                              anchorforedit.setVisible(true);   
    
    
    
    }

    @FXML
    private void modifiercategorie(ActionEvent event) throws IOException {
        
         anchorforedit.setVisible(true);
           
                            fxml = FXMLLoader.load(getClass().getResource("/edu/devapps/Interface/modifiercategorie.fxml"));
                         FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/modifiercategorie.fxml"));
                           Parent root =load.load();
                           ModifiercategorieController c2=  load.getController();
                           c2.getinfo(currentategorie);
                          fxml=root;
                            anchorforedit.getChildren().removeAll();
                             anchorforedit.getChildren().setAll(fxml);
                              anchorforedit.setVisible(true);   
    }

    @FXML
    private void supprimercategorie(ActionEvent event) throws IOException {
    
     CategorieService s = new CategorieService();
        
        Categorie r = new Categorie();
        r.setId(currentategorie.getId());
        s.supprimercategorie(r);
        Alert a = new Alert(Alert.AlertType.INFORMATION, "your categorie has been deleted");
                a.show();
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/categorieview.fxml"));
                           Parent root =load.load();
                           categorieviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
    
    }

    @FXML
    private void ajouterproduit(ActionEvent event) throws IOException {
    
     anchorforedit.setVisible(true);
           
                fxml = FXMLLoader.load(getClass().getResource("/edu/devapps/Interface/ajouterproduit.fxml"));
                         FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/ajouterproduit.fxml"));
                           Parent root =load.load();
                           AjouterproduitController c2=  load.getController();
                           c2.getinfo(currentategorie);
                          fxml=root;
                            anchorforedit.getChildren().removeAll();
                             anchorforedit.getChildren().setAll(fxml);
                              anchorforedit.setVisible(true);   
    
    
    }

    @FXML
    private void gototransport(MouseEvent event) throws IOException {
   
      FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/produitview.fxml"));
                           Parent root =load.load();
                           produitviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
    
    
    }
    
}
