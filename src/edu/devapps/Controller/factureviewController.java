/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import edu.devapps.Interface.HomeBackController;
import edu.devapps.entity.Categorie;
import hamma.MyListener;
import edu.devapps.entity.Facture;
import edu.devapps.entity.Finance;
import edu.devapps.entity.Produit;
import edu.devapps.entity.Publicite;
import edu.devapps.entity.Reclamation;
import edu.devapps.entity.Reponse_rec;
import edu.devapps.entity.Sponsor;
import edu.devapps.entity.Utilisateur;
import edu.devapps.services.FactureService;
import edu.devapps.services.Pdfgenerator;
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

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class factureviewController implements Initializable {

    @FXML
    private VBox chosenFruitCard;
    @FXML
    private ImageView fruitImg;
    @FXML
    private Label prix;
    @FXML
    private Label etat;
    @FXML
    private Label date;
    @FXML
    private HBox hboxcamping;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private AnchorPane anchorforedit;
    @FXML
    private Label numero;
    @FXML
    private Label nom;
           Facture currentfacture;
     private Parent fxml;
      private List<Facture> factures = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    /**
     * Initializes the controller class.
     */
    
    
    private List<Facture> getData() throws SQLException {
      
            List<Facture> factures = new ArrayList<>();
        FactureService s = new FactureService();
        Facture fac1;

        for (int i = 0; i < s.afficherFacture().size(); i++) {
            Facture get = s.afficherFacture().get(i);
            
            
            fac1 = new Facture();
            fac1.setId_facture(get.getId_facture());
            fac1.setNumero(get.getNumero());
            fac1.setNom(get.getNom());
            fac1.setPrix(get.getPrix());
            fac1.setEtat(get.getEtat());
            fac1.setDescription(get.getDescription());
            fac1.setImage(get.getImage());
            fac1.setId_utilisateur(get.getId_utilisateur());
        
           
            
         
            factures.add(fac1);
        }
    

      
        return factures;
    }

    private void setChosenCamping(Facture fac) {
        currentfacture=fac;
        numero.setText(""+fac.getNumero());
        nom.setText(""+ fac.getNom());
       prix.setText(""+fac.getPrix());
       date.setText(""+fac.getDate());
       etat.setText(""+fac.getEtat());
      
        chosenFruitCard.setStyle("-fx-background-color: #FAEBD7;\n" +
                "    -fx-background-radius: 30;");
    }
    
    
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
               factures.addAll(getData());
        if (factures.size() > 0) {
            setChosenCamping(factures.get(0));
            myListener = new MyListener() {
           

            

              

                @Override
                public void onClickListener(Facture Facture) {
                     setChosenCamping(Facture);                }

                @Override
                public void onClickListener(Finance Finance) {
                }

                @Override
                public void onClickListener(Utilisateur Utilisateur) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void onClickListener(Reclamation Reclamation) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void onClickListener(Reponse_rec Reponse_rec) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void onClickListener(Sponsor Sponsor) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void onClickListener(Publicite Publicite) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void onClickListener(Categorie Categorie) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void onClickListener(Produit Produit) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < factures.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/edu/devapps/Interface/onefactureview.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                OnefactureviewController OnefactureviewController = fxmlLoader.getController();
                OnefactureviewController.setData(factures.get(i),myListener);

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
    private void ajouterfacture(ActionEvent event) throws IOException {
   
        anchorforedit.setVisible(true);
           
                fxml = FXMLLoader.load(getClass().getResource("/edu/devapps/Interface/ajouterfacture.fxml"));
                         FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/ajouterfacture.fxml"));
                           Parent root =load.load();
                           AjouterfactureController c2=  load.getController();
                          fxml=root;
                            anchorforedit.getChildren().removeAll();
                             anchorforedit.getChildren().setAll(fxml);
                              anchorforedit.setVisible(true);   
    
    }

    @FXML
    private void modifierfacture(ActionEvent event) throws IOException {
    
       anchorforedit.setVisible(true);
           
                            fxml = FXMLLoader.load(getClass().getResource("/edu/devapps/Interface/modifierfacture.fxml"));
                         FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/modifierfacture.fxml"));
                           Parent root =load.load();
                           ModifierfactureController c2=  load.getController();
                           c2.getinfo(currentfacture);
                          fxml=root;
                            anchorforedit.getChildren().removeAll();
                             anchorforedit.getChildren().setAll(fxml);
                              anchorforedit.setVisible(true);   
    
    }

    @FXML
    private void supprimerfacture(ActionEvent event) throws IOException {
    
      FactureService s = new FactureService();
        
        Facture r = new Facture();
        r.setId_facture(currentfacture.getId_facture());
        s.supprimerfacture(r);
        Alert a = new Alert(Alert.AlertType.INFORMATION, "your facture has been deleted");
                a.show();
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/factureview.fxml"));
                           Parent root =load.load();
                           factureviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
    
    }

    @FXML
    private void ajouterfinance(ActionEvent event) throws IOException {
   anchorforedit.setVisible(true);
           
                fxml = FXMLLoader.load(getClass().getResource("/edu/devapps/Interface/ajouterfinance.fxml"));
                         FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/ajouterfinance.fxml"));
                           Parent root =load.load();
                           AjouterfinanceController c2=  load.getController();
                           c2.getinfo(currentfacture);
                          fxml=root;
                            anchorforedit.getChildren().removeAll();
                             anchorforedit.getChildren().setAll(fxml);
                              anchorforedit.setVisible(true);   
    
    
    
    
    }

    @FXML
    private void gototransport(MouseEvent event) throws IOException {
  
     FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/financeview.fxml"));
                           Parent root =load.load();
                           financeviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
    
    }

    @FXML
    private void genererpdf(ActionEvent event) {
        Pdfgenerator d = new Pdfgenerator();
        d.generatePdfe();
    }

    @FXML
    private void generateexel(ActionEvent event) {
         Pdfgenerator d = new Pdfgenerator();
        d.generateExcel();
    }

    @FXML
    private void GoToHomeBack(ActionEvent event) throws IOException {
           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/HomeBack.fxml"));
                           Parent root =load.load();
                           HomeBackController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
    }
    
}
