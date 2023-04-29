/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import arij.MyListener;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import edu.devapps.entity.Categorie;
import edu.devapps.entity.Produit;
import edu.devapps.services.ProduitService;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.imageio.ImageIO;


public class produitviewController implements Initializable {

    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label nom_produit;
    @FXML
    private ImageView fruitImg;
    @FXML
    private Label description;
    @FXML
    private Label prix;
    @FXML
    private Label quantite;
    @FXML
    private Label photo;
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
    private ListView<Produit> listfourni;
     private VBox buttonsBox;

     
    

 Produit currentproduit;
     private Parent fxml;
      private List<Produit> produits = new ArrayList<>();
    private MyListener myListener;
    @FXML
    private TextField filtree;
    @FXML
    private Button searchBut;
    ProduitService PS = new ProduitService();
    @FXML
    private Button excelButt;
    
     private List<Produit> getData() throws SQLException {
      
            List<Produit> produits = new ArrayList<>();
         ProduitService s = new ProduitService();
        Produit prod;

        for (int i = 0; i < s.afficherproduit().size(); i++) {
            Produit get = s.afficherproduit().get(i);
            
            
            prod = new Produit();
            prod.setId_produit(get.getId_produit());
            prod.setNom_produit(get.getNom_produit());
            prod.setDescription(get.getDescription());
            prod.setPrix(get.getPrix());
            prod.setQuantite(get.getQuantite());
            prod.setPhoto(get.getPhoto());
            prod.setId_categorie_id(get.getId_categorie_id());
            prod.setDate(get.getDate());
        
           
            
         
            produits.add(prod);
        }
    

      
        return produits;
    }

    private void setChosenCamping(Produit prod) {
        currentproduit=prod;
     
        
        
        nom_produit.setText(prod.getNom_produit());
        description.setText(""+ prod.getDescription());
       prix.setText(""+prod.getPrix());
       quantite.setText(""+prod.getQuantite());
       photo.setText(""+prod.getPhoto());
      
      
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
               produits.addAll(getData());
        if (produits.size() > 0) {
            setChosenCamping(produits.get(0));
            myListener = new MyListener() {
           

            

             

                
            

                @Override
                public void onClickListener(Categorie Categorie) {
                }

                @Override
                public void onClickListener(Produit Produit) {
                     setChosenCamping(Produit);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < produits.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/edu/devapps/Interface/oneproduitview.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                OneproduitviewController OneproduitviewController = fxmlLoader.getController();
                OneproduitviewController.setData(produits.get(i),myListener);

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
                    }
                


        catch (Exception ex) {
            ex.printStackTrace();
        
    
            
}

    }
     
     
     

    @FXML
    private void modifierproduit(ActionEvent event) throws IOException {
  
     anchorforedit.setVisible(true);
           
                            fxml = FXMLLoader.load(getClass().getResource("/edu/devapps/Interface/modifierproduit.fxml"));
                         FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/modifierproduit.fxml"));
                           Parent root =load.load();
                           ModifierproduitController c2=  load.getController();
                           c2.getinfo(currentproduit);
                          fxml=root;
                            anchorforedit.getChildren().removeAll();
                             anchorforedit.getChildren().setAll(fxml);
                              anchorforedit.setVisible(true);   
    
    
    }

    @FXML
    private void supprimerproduit(ActionEvent event) throws IOException {
    
      ProduitService s = new ProduitService();
        
        Produit r = new Produit();
        r.setId_produit(currentproduit.getId_produit());
        s.supprimerproduit(r);
        Alert a = new Alert(Alert.AlertType.INFORMATION, "Produit supprimé");
                a.show();
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/produitview.fxml"));
                           Parent root =load.load();
                           produitviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
                           
    
    }

    @FXML
    private void gototransport(MouseEvent event) throws IOException {
   
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
    private void stat(ActionEvent event) throws IOException {
        FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/Chart.fxml"));
                           Parent root =load.load();
                           ChartController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
    }

    @FXML
    private void searchproduct(MouseEvent event) {
        String value = filtree.getText().trim();
        
        if(value.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir une valeur de recherche !");
            alert.showAndWait();
            return;
        }
        
        List<Produit> produits = PS.RechercheProduit(value);
                Produit produit = null;

if (!produits.isEmpty()) {
     produit = produits.get(0);
        
        if(produit.getId_produit() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Aucun produit trouvé !");
            alert.showAndWait();
            return;
        }
                        }
        currentproduit=produit;
     
        
        
        nom_produit.setText(produit.getNom_produit());
        description.setText(""+ produit.getDescription());
       prix.setText(""+produit.getPrix());
       quantite.setText(""+produit.getQuantite());
       photo.setText(""+produit.getPhoto());
      
      
        chosenFruitCard.setStyle("-fx-background-color: #FAEBD7;\n" +
                "    -fx-background-radius: 30;");

    }

    @FXML
    private void rechercher(ActionEvent event) {
    }

    @FXML
    private void Excel(ActionEvent event) throws SQLException, IOException {
        Writer writer = null;
                ProduitService sv = new ProduitService();
                ObservableList<Produit> list = sv.getProduitList();
         try {
            //badel path fichier excel
            File file = new File("C:\\arij\\arij\\produits.csv");
            writer = new BufferedWriter(new FileWriter(file));
            
            for (Produit ev : list) {

                String text = ev.getId_produit()+" | " +ev.getNom_produit()+ " | " + ev.getDescription()+ " | "+ev.getPrix()+" | "+ev.getQuantite()+" | "+ev.getPhoto()+" | "+ev.getId_categorie_id()+ "\n";
                System.out.println(text);
                writer.write("id_produit | nom_produit | description | prix | quantite | photo | id_categorie_id \n");
                writer.write(text);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            writer.flush();
             writer.close();
             Alert alert= new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("excel");
        alert.setHeaderText(null);
        alert.setContentText("!!!excel exported!!!");
        alert.showAndWait();
        }
    }

    

    
        
}
    
    
    
 

 
    
  

