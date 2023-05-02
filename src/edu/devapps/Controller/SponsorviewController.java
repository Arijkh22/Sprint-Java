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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
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
public class SponsorviewController implements Initializable {

    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label nom;
    @FXML
    private Label adresse;
    @FXML
    private ImageView fruitImg;
    @FXML
    private Label email;
    @FXML
    private Label num_tel;
    @FXML
    private HBox hboxcamping;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private AnchorPane anchorforedit;
  Sponsor currentsponsor;
     private Parent fxml;
      private List<Sponsor> sponsors = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    @FXML
    private TextField rechercher;
    
    
     private List<Sponsor> getDatasearch(String rechercher) throws SQLException {
      
            List<Sponsor> sponsors = new ArrayList<>();
         SponsorService s = new SponsorService();
        Sponsor spons;

        for (int i = 0; i < s.rechercher(rechercher).size(); i++) {
            Sponsor get = s.rechercher(rechercher).get(i);
            
            
            spons = new Sponsor();
            spons.setId(get.getId());
            spons.setNom(get.getNom());
            spons.setEmail(get.getEmail());
            spons.setAdresse(get.getAdresse());
            spons.setNum_tel(get.getNum_tel());
           
        
           
            
         
            sponsors.add(spons);
        }
    

      
        return sponsors;
    }
    
    
    
    
    
     private List<Sponsor> getData() throws SQLException {
      
            List<Sponsor> sponsors = new ArrayList<>();
         SponsorService s = new SponsorService();
        Sponsor spons;

        for (int i = 0; i < s.affichersponsor().size(); i++) {
            Sponsor get = s.affichersponsor().get(i);
            
            
            spons = new Sponsor();
            spons.setId(get.getId());
            spons.setNom(get.getNom());
            spons.setEmail(get.getEmail());
            spons.setAdresse(get.getAdresse());
            spons.setNum_tel(get.getNum_tel());
           
        
           
            
         
            sponsors.add(spons);
        }
    

      
        return sponsors;
    }

    private void setChosenCamping(Sponsor spons) {
        currentsponsor=spons;
        nom.setText(spons.getNom());
        adresse.setText(""+ spons.getAdresse());
       email.setText(""+spons.getEmail());
       num_tel.setText(""+spons.getNum_tel());
      
      
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
               sponsors.addAll(getData());
        if (sponsors.size() > 0) {
            setChosenCamping(sponsors.get(0));
            myListener = new MyListener() {
           

            

             

                @Override
                public void onClickListener(Sponsor Sponsor) {
                      setChosenCamping(Sponsor);
                }

                @Override
                public void onClickListener(Publicite Publicite) {
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
            for (int i = 0; i < sponsors.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/edu/devapps/Interface/onesponsorview.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                OnesponsorviewController OnesponsorviewController = fxmlLoader.getController();
                OnesponsorviewController.setData(sponsors.get(i),myListener);

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
    private void ajoutersponsor(ActionEvent event) throws IOException {
   
         anchorforedit.setVisible(true);
           
                fxml = FXMLLoader.load(getClass().getResource("/edu/devapps/Interface/ajoutersponsor.fxml"));
                         FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/ajoutersponsor.fxml"));
                           Parent root =load.load();
                           AjoutersponsorController c2=  load.getController();
                          fxml=root;
                            anchorforedit.getChildren().removeAll();
                             anchorforedit.getChildren().setAll(fxml);
                              anchorforedit.setVisible(true);   
    
    }

    @FXML
    private void modifiersponsor(ActionEvent event) throws IOException {
   
     anchorforedit.setVisible(true);
           
                            fxml = FXMLLoader.load(getClass().getResource("/edu/devapps/Interface/modifiersponsor.fxml"));
                         FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/modifiersponsor.fxml"));
                           Parent root =load.load();
                           ModifiersponsorController c2=  load.getController();
                           c2.getinfo(currentsponsor);
                          fxml=root;
                            anchorforedit.getChildren().removeAll();
                             anchorforedit.getChildren().setAll(fxml);
                              anchorforedit.setVisible(true);   
    
    }

    @FXML
    private void supprimersponsor(ActionEvent event) throws IOException {
   
     SponsorService s = new SponsorService();
        
        Sponsor r = new Sponsor();
        r.setId(currentsponsor.getId());
        s.supprimersponsor(r);
        Alert a = new Alert(Alert.AlertType.INFORMATION, "your sponsor has been deleted");
                a.show();
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
    private void ajouterpub(ActionEvent event) throws IOException {
  
     anchorforedit.setVisible(true);
           
                fxml = FXMLLoader.load(getClass().getResource("/edu/devapps/Interface/ajouterpublicite.fxml"));
                         FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/ajouterpublicite.fxml"));
                           Parent root =load.load();
                           AjouterpubliciteController c2=  load.getController();
                           c2.getinfo(currentsponsor);
                          fxml=root;
                            anchorforedit.getChildren().removeAll();
                             anchorforedit.getChildren().setAll(fxml);
                              anchorforedit.setVisible(true);   
    
    
    }

    @FXML
    private void gototransport(MouseEvent event) throws IOException {
        
        
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
    private void search(KeyEvent event) throws SQLException {
        sponsors.clear();
        grid.getChildren().clear();
        
        
        
              sponsors.addAll(getDatasearch(rechercher.getText()));
        if (sponsors.size() > 0) {
            setChosenCamping(sponsors.get(0));
            myListener = new MyListener() {
           

            

             

                @Override
                public void onClickListener(Sponsor Sponsor) {
                      setChosenCamping(Sponsor);
                }

                @Override
                public void onClickListener(Publicite Publicite) {
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
            for (int i = 0; i < sponsors.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/edu/devapps/Interface/onesponsorview.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                OnesponsorviewController OnesponsorviewController = fxmlLoader.getController();
                OnesponsorviewController.setData(sponsors.get(i),myListener);

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
