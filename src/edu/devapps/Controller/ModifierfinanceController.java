/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import edu.devapps.entity.Facture;
import edu.devapps.entity.Finance;
import edu.devapps.services.FactureService;
import edu.devapps.services.FinanceService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class ModifierfinanceController implements Initializable {

    @FXML
    private AnchorPane anchorme;
    @FXML
    private TextField taxe;
    @FXML
    private TextField tva;
    @FXML
    private TextField prix;
    @FXML
    private TextField etat;
   Finance thisfinance;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void annulerreponse(ActionEvent event) throws IOException {
   
       anchorme.setVisible(false);
        
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
    private void modifierreponse(ActionEvent event) throws IOException {
 
   
        FinanceService c = new FinanceService();
            Date d = new Date(1999, 10, 30);
         
             if (etat.getText().equals(""))
            {
                        Alert a = new Alert(Alert.AlertType.INFORMATION, "etat cant be null");
                a.show();
            }
            else if (prix.getText().equals(""))
            {
                        Alert a = new Alert(Alert.AlertType.INFORMATION, "prix cant be 0");
                a.show();
            }
            else if (tva.getText().equals(""))
            {
                        Alert a = new Alert(Alert.AlertType.INFORMATION, "tva cant be 0");
                a.show();
            }
            else if (taxe.getText().equals(""))
            {
                        Alert a = new Alert(Alert.AlertType.INFORMATION, "taxe cant be 0");
                a.show();
            }
            else
            {
                
          
                 int  p = Integer.valueOf(prix.getText());
                 int tva1 = Integer.valueOf(tva.getText());
                 float taxe1 = Float.valueOf(taxe.getText());
                 if (p==0)
                 {
                             Alert a = new Alert(Alert.AlertType.INFORMATION, "prix cant be 0");
                a.show();
                 }
                 else if (tva1==0)
                 {
                             Alert a = new Alert(Alert.AlertType.INFORMATION, "tva cant be 0");
                a.show();
                 }
                 else if (taxe1==0)
                 {
                        Alert a = new Alert(Alert.AlertType.INFORMATION, "taxe cant be 0");
                a.show();
                 }
                 else
                 {
                     
                 
            c.modifierfinance(new Finance(thisfinance.getId(),taxe1, tva1,thisfinance.getPhoto(),p, etat.getText(),d,thisfinance.getId_facture()));
                Alert a = new Alert(Alert.AlertType.INFORMATION, "facture ajouter avec  success");
                a.show();
                            anchorme.setVisible(false);
        
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/financeview.fxml"));
                           Parent root =load.load();
                          financeviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
    
                 }}
    }
       public void  getinfo (Finance finance)
    {
        thisfinance=finance;
  
        taxe.setText(""+thisfinance.getTaxe());
        
      
        tva.setText(""+thisfinance.getTva());
        prix.setText(""+thisfinance.getPrix());
        etat.setText(""+thisfinance.getEtat());
        
      
        
    }
}
