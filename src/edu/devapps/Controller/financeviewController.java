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
import edu.devapps.services.FinanceService;
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

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class financeviewController implements Initializable {

    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label taxe;
    @FXML
    private ImageView fruitImg;
    @FXML
    private Label tva;
    @FXML
    private Label etat;
    @FXML
    private HBox hboxcamping;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private AnchorPane anchorforedit;

    
       Finance currentfinance;
     private Parent fxml;
      private List<Finance> finances = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    @FXML
    private TextField rechercher;
    /**
     * Initializes the controller class.
     */
    
    
    
       private List<Finance> getDatasearch(String rechercher) throws SQLException {
      
            List<Finance> finances = new ArrayList<>();
           FinanceService s = new FinanceService();
        Finance fin1;

        for (int i = 0; i < s.rechercher(rechercher).size(); i++) {
            Finance get = s.rechercher(rechercher).get(i);
            
            
            fin1 = new Finance();
            fin1.setTaxe(get.getTaxe());
            fin1.setTva(get.getTva());
            fin1.setPhoto(get.getPhoto());
            fin1.setPrix(get.getPrix());
            fin1.setEtat(get.getEtat());
            fin1.setDate(get.getDate());
            fin1.setId_facture(get.getId_facture());
            fin1.setId(get.getId());
        
           
            
         
            finances.add(fin1);
        }
    

      
        return finances;
    }
    
    
    
    
    
    
       private List<Finance> getData() throws SQLException {
      
            List<Finance> finances = new ArrayList<>();
           FinanceService s = new FinanceService();
        Finance fin1;

        for (int i = 0; i < s.afficherFinance().size(); i++) {
            Finance get = s.afficherFinance().get(i);
            
            
            fin1 = new Finance();
            fin1.setTaxe(get.getTaxe());
            fin1.setTva(get.getTva());
            fin1.setPhoto(get.getPhoto());
            fin1.setPrix(get.getPrix());
            fin1.setEtat(get.getEtat());
            fin1.setDate(get.getDate());
            fin1.setId_facture(get.getId_facture());
            fin1.setId(get.getId());
        
           
            
         
            finances.add(fin1);
        }
    

      
        return finances;
    }

    private void setChosenCamping(Finance fin) {
        currentfinance=fin;
        taxe.setText(""+fin.getTaxe());
        tva.setText(""+ fin.getTva());
       etat.setText(""+fin.getEtat());
      
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
               finances.addAll(getData());
        if (finances.size() > 0) {
            setChosenCamping(finances.get(0));
            myListener = new MyListener() {
           

            

              

                @Override
                public void onClickListener(Facture Facture) {
                           }

                @Override
                public void onClickListener(Finance Finance) {
                  setChosenCamping(Finance);        
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
            for (int i = 0; i < finances.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/edu/devapps/Interface/onefinanceview.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                OnefinanceviewController OnefinanceviewController = fxmlLoader.getController();
                OnefinanceviewController.setData(finances.get(i),myListener);

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
    private void modifierfinance(ActionEvent event) throws IOException {
    
      anchorforedit.setVisible(true);
           
                            fxml = FXMLLoader.load(getClass().getResource("/edu/devapps/Interface/modifierfinance.fxml"));
                         FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/modifierfinance.fxml"));
                           Parent root =load.load();
                           ModifierfinanceController c2=  load.getController();
                           c2.getinfo(currentfinance);
                          fxml=root;
                            anchorforedit.getChildren().removeAll();
                             anchorforedit.getChildren().setAll(fxml);
                              anchorforedit.setVisible(true);   
    
    
    
    }

    @FXML
    private void supprimerfinance(ActionEvent event) throws IOException {
    FinanceService s = new FinanceService();
        
        Finance r = new Finance();
        r.setId(currentfinance.getId());
        s.supprimerfinance(r);
        Alert a = new Alert(Alert.AlertType.INFORMATION, "your finance has been deleted");
                a.show();
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
    private void gototransport(MouseEvent event) throws IOException {
    
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
    private void search(KeyEvent event) throws SQLException {
        
         finances.clear();
         grid.getChildren().clear();
            finances.addAll(getDatasearch(rechercher.getText()));
        if (finances.size() > 0) {
            setChosenCamping(finances.get(0));
            myListener = new MyListener() {
           

            

              

                @Override
                public void onClickListener(Facture Facture) {
                           }

                @Override
                public void onClickListener(Finance Finance) {
                  setChosenCamping(Finance);        
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
            for (int i = 0; i < finances.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/edu/devapps/Interface/onefinanceview.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                OnefinanceviewController OnefinanceviewController = fxmlLoader.getController();
                OnefinanceviewController.setData(finances.get(i),myListener);

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
