/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Interface;

import edu.devapps.Controller.ReclamationviewController;
import edu.devapps.Controller.SponsorviewController;
import edu.devapps.Controller.financeviewController;
import edu.devapps.Controller.produitviewController;
import edu.devapps.Controller.utilisateurviewController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import static javafx.fxml.FXMLLoader.load;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import workshop.gui.AfficherPersonneController;

/**
 * FXML Controller class
 *
 * @author user
 */
public class HomeBackController implements Initializable {

         private Parent fxml;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void GoToUser(ActionEvent event) throws IOException {
        FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/utilisateurview.fxml"));
                           Parent root =load.load();
                           utilisateurviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
    }

    @FXML
    private void GoToReclamation(ActionEvent event) throws IOException {
        FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/reclamationview.fxml"));
                           Parent root =load.load();
                           ReclamationviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
    }

    @FXML
    private void GoToProduit(ActionEvent event) throws IOException {
                    FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/produitview.fxml"));

                           Parent root =load.load();
                           produitviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
    }

    @FXML
    private void GoToAppeldoffre(ActionEvent event) throws IOException {
        FXMLLoader load = new FXMLLoader(getClass().getResource("/workshop/gui/AfficherPersonne.fxml"));

                           Parent root =load.load();
                           AfficherPersonneController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
        
    }

    @FXML
    private void GoToPub(ActionEvent event) throws IOException {
         FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/sponsorview.fxml"));
                           Parent root =load.load();
                           SponsorviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
        
    }

    @FXML
    private void GoToFinance(ActionEvent event) throws IOException {
            FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/financeview.fxml"));
                           Parent root =load.load();
                           financeviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/com/xemacscode/Main.fxml"));                       
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
    }
    
}
