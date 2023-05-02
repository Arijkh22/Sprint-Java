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
import edu.devapps.services.UtilisateurService;
import hamma.MyListener;
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
import javafx.scene.control.Button;
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
public class utilisateurviewController implements Initializable {

    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private ImageView fruitImg;
    @FXML
    private Label email;
    @FXML
    private Label adresse;
    @FXML
    private Label username;
    @FXML
    private HBox hboxcamping;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private AnchorPane anchorforedit;
  Utilisateur currentuser;
     private Parent fxml;
      private List<Utilisateur> users = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    @FXML
    private TextField rechercher;
    @FXML
    private Button activeuser;
    
    
    
     private List<Utilisateur> getData() throws SQLException {
      
            List<Utilisateur> users = new ArrayList<>();
         UtilisateurService s = new UtilisateurService();
        Utilisateur user1;

        for (int i = 0; i < s.afficherutilisateur().size(); i++) {
            Utilisateur get = s.afficherutilisateur().get(i);
            
            
            user1 = new Utilisateur();
            user1.setId(get.getId());
            user1.setNom(get.getNom());
            user1.setPrenom(get.getPrenom());
            user1.setPassword(get.getPassword());
            user1.setEmail(get.getEmail());
            user1.setAdresse(get.getAdresse());
            user1.setRole(get.getRole());
            user1.setAge(get.getAge());
            user1.setUsername(get.getUsername());
            user1.setPhoto(get.getPhoto());
           user1.setCode(get.getCode());
           user1.setBloquer(get.getBloquer());
        
           
            
         
            users.add(user1);
        }
    

      
        return users;
    }

     
     
     
      private List<Utilisateur> getDatasearch(String se) throws SQLException {
      
            List<Utilisateur> users = new ArrayList<>();
         UtilisateurService s = new UtilisateurService();
        Utilisateur user1;

        for (int i = 0; i < s.rechercher(se).size(); i++) {
            Utilisateur get = s.rechercher(se).get(i);
            
            
            user1 = new Utilisateur();
            user1.setId(get.getId());
            user1.setNom(get.getNom());
            user1.setPrenom(get.getPrenom());
            user1.setPassword(get.getPassword());
            user1.setEmail(get.getEmail());
            user1.setAdresse(get.getAdresse());
            user1.setRole(get.getRole());
            user1.setAge(get.getAge());
            user1.setUsername(get.getUsername());
            user1.setPhoto(get.getPhoto());
                     user1.setCode(get.getCode());
           user1.setBloquer(get.getBloquer());
        
           
            
         
            users.add(user1);
        }
    

      
        return users;
    }
    private void setChosenCamping(Utilisateur user) {
                
        currentuser=user;
        nom.setText(user.getNom());
        adresse.setText(""+ user.getAdresse());
       email.setText(""+user.getEmail());
       prenom.setText(""+user.getPrenom());
       username.setText(""+user.getUsername());
        System.out.println(user.getBloquer());
       if(user.getBloquer()==0)
                    {
                       activeuser.setText("blocker");
                    }
            else
            {
                 activeuser.setText("deblocker");
            }
      
        chosenFruitCard.setStyle("-fx-background-color: #FAEBD7;\n" +
                "    -fx-background-radius: 30;");
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
               users.addAll(getData());
        if (users.size() > 0) {
            setChosenCamping(users.get(0));
         
            myListener = new MyListener() {
           

            

             

            

                @Override
                public void onClickListener(Utilisateur Utilisateur) {
                      setChosenCamping(Utilisateur);
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
            for (int i = 0; i < users.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/edu/devapps/Interface/oneutilisateurview.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                OneutilisateurviewController oneutilisateurviewController = fxmlLoader.getController();
                oneutilisateurviewController.setData(users.get(i),myListener);

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
    private void ajouterutilisateur(ActionEvent event) throws IOException {
        anchorforedit.setVisible(true);
                fxml = FXMLLoader.load(getClass().getResource("/edu/devapps/Interface/ajouterutilisateur.fxml"));
                         FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/ajouterutilisateur.fxml"));
                           Parent root =load.load();
                           AjouterutilisateurController c2=  load.getController();
                          fxml=root;
                            anchorforedit.getChildren().removeAll();
                             anchorforedit.getChildren().setAll(fxml);
                              anchorforedit.setVisible(true);   
    
    
    }

    @FXML
    private void modifierutilisateur(ActionEvent event) throws IOException {
    
    
      anchorforedit.setVisible(true);
           
                            fxml = FXMLLoader.load(getClass().getResource("/edu/devapps/Interface/modifierutilisateur.fxml"));
                         FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/modifierutilisateur.fxml"));
                           Parent root =load.load();
                           ModifierutilisateurController c2=  load.getController();
                           c2.setData(currentuser);
                          fxml=root;
                            anchorforedit.getChildren().removeAll();
                             anchorforedit.getChildren().setAll(fxml);
                              anchorforedit.setVisible(true);   
    }

    @FXML
    private void supprimerutilisateur(ActionEvent event) throws IOException {
    UtilisateurService s = new UtilisateurService();
        
        Utilisateur r = new Utilisateur();
        r.setId(currentuser.getId());
        s.supprimerUtilisateur(r);
        Alert a = new Alert(Alert.AlertType.INFORMATION, "your user has been deleted");
                a.show();
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/utilisateurview.fxml"));
                           Parent root =load.load();
                           utilisateurviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
    
    
    }

    @FXML
    private void gototransport(MouseEvent event) {
    }

    @FXML
    private void gorechercher(KeyEvent event) throws SQLException {
        users.clear();
        grid.getChildren().clear();
          users.addAll(getDatasearch(rechercher.getText()));
        if (users.size() > 0) {
            setChosenCamping(users.get(0));
            myListener = new MyListener() {
           

            

             

            

                @Override
                public void onClickListener(Utilisateur Utilisateur) {
                      setChosenCamping(Utilisateur);
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
            for (int i = 0; i < users.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/edu/devapps/Interface/oneutilisateurview.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                OneutilisateurviewController oneutilisateurviewController = fxmlLoader.getController();
                oneutilisateurviewController.setData(users.get(i),myListener);

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
    private void banuser(ActionEvent event) throws SQLException, IOException {
        UtilisateurService u = new UtilisateurService();
        if (currentuser.getBloquer()==0)
        {
           u.banuser(currentuser,1);
            Alert a = new Alert(Alert.AlertType.INFORMATION, "your user has been banned");
                a.show();
        }
        else
            
        {
                       u.banuser(currentuser,0);
                        Alert a = new Alert(Alert.AlertType.INFORMATION, "your user has been unbanned");
                a.show();
 
        }

                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/utilisateurview.fxml"));
                           Parent root =load.load();
                           utilisateurviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();        
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
