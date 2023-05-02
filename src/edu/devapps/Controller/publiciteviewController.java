/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import edu.devapps.Interface.HomeBackController;
import edu.devapps.entity.Categorie;
import edu.devapps.entity.Facture;
import edu.devapps.entity.Finance;
import edu.devapps.entity.Produit;
import edu.devapps.entity.Publicite;
import edu.devapps.entity.Reclamation;
import edu.devapps.entity.Reponse_rec;
import edu.devapps.entity.Sponsor;
import edu.devapps.entity.Utilisateur;
import edu.devapps.services.PubliciteService;
import edu.devapps.services.SponsorService;
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
import hamma.MyListener;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class publiciteviewController implements Initializable {

    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label nom_pub;
    @FXML
    private ImageView fruitImg;
    @FXML
    private Label description;
    @FXML
    private Label image;
    @FXML
    private HBox hboxcamping;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private AnchorPane anchorforedit;
  Publicite currentpublicite;
     private Parent fxml;
      private List<Publicite> publicites = new ArrayList<>();
    private MyListener myListener;
    
     private List<Publicite> getData() throws SQLException {
      
            List<Publicite> publicites = new ArrayList<>();
         PubliciteService s = new PubliciteService();
        Publicite pubs;

        for (int i = 0; i < s.afficherpublicite().size(); i++) {
            Publicite get = s.afficherpublicite().get(i);
            
            
            pubs = new Publicite();
            pubs.setId(get.getId());
            pubs.setNom_pub(get.getNom_pub());
            pubs.setDescription(get.getDescription());
            pubs.setImage(get.getImage());
            pubs.setId_sponsor_id(get.getId_sponsor_id());
           
        
           
            
         
            publicites.add(pubs);
        }
    

      
        return publicites;
    }

    private void setChosenCamping(Publicite pub) {
        currentpublicite=pub;
        nom_pub.setText(pub.getNom_pub());
        description.setText(""+ pub.getDescription());
       image.setText(""+pub.getImage());
     
      
      
        chosenFruitCard.setStyle("-fx-background-color: #FAEBD7;\n" +
                "    -fx-background-radius: 30;");
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
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
               publicites.addAll(getData());
        if (publicites.size() > 0) {
            setChosenCamping(publicites.get(0));
            myListener = new MyListener() {
           

            

             

                @Override
                public void onClickListener(Sponsor Sponsor) {
                     
                }

                @Override
                public void onClickListener(Publicite Publicite) {
                     setChosenCamping(Publicite);
                }

                @Override
                public void onClickListener(Utilisateur Utilisateur) {
                }

                @Override
                public void onClickListener(Reclamation Reclamation) {
                }

                @Override
                public void onClickListener(Reponse_rec Reponse_rec) {
                }

                @Override
                public void onClickListener(Categorie Categorie) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void onClickListener(Produit Produit) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void onClickListener(Facture Facture) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void onClickListener(Finance Finance) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < publicites.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/edu/devapps/Interface/onepubliciteview.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                OnepubliciteviewController OnepubliciteviewController = fxmlLoader.getController();
                OnepubliciteviewController.setData(publicites.get(i),myListener);

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
    private void modifierpublicite(ActionEvent event) throws IOException {
    anchorforedit.setVisible(true);
           
                            fxml = FXMLLoader.load(getClass().getResource("/edu/devapps/Interface/modifierpublicite.fxml"));
                         FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/modifierpublicite.fxml"));
                           Parent root =load.load();
                           ModifierpubliciteController c2=  load.getController();
                           c2.getinfo(currentpublicite);
                          fxml=root;
                            anchorforedit.getChildren().removeAll();
                             anchorforedit.getChildren().setAll(fxml);
                              anchorforedit.setVisible(true);   
    
    }

    @FXML
    private void supprimerpublicite(ActionEvent event) throws IOException {
         PubliciteService s = new PubliciteService();
        
        Publicite r = new Publicite();
        r.setId(currentpublicite.getId());
        s.supprimerpublicite(r);
        Alert a = new Alert(Alert.AlertType.INFORMATION, "your publicite has been deleted");
                a.show();
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/publiciteview.fxml"));
                           Parent root =load.load();
                           publiciteviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
    
    }

    @FXML
    private void gototransport(MouseEvent event) throws IOException {
    
       FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/sponsorview.fxml"));
                           Parent root =load.load();
                           SponsorviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
    
    }

    @FXML
    private void GoToHomeBack(ActionEvent event) throws IOException {
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
