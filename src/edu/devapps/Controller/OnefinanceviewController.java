/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import hamma.MyListener;
import edu.devapps.entity.Facture;
import edu.devapps.entity.Finance;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class OnefinanceviewController implements Initializable {

    @FXML
    private Label taxe;
    private Label etatrec;
    @FXML
    private Label tva;
    @FXML
    private Label photo;
    @FXML
    private Label prix;
    @FXML
    private Label etat;
    @FXML
    private Label date;
 private Finance fac;
    private MyListener myListener;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
          public void setData(Finance fac, MyListener myListener) {
        this.fac = fac;
        this.myListener = myListener;
        taxe.setText(""+fac.getTaxe());
        etat.setText(fac.getEtat());
        date.setText(""+fac.getDate());
        tva.setText(""+fac.getTva());
        prix.setText(""+fac.getPrix());
        photo.setText(""+fac.getPhoto());
        
    }
    

    @FXML
    private void onclick(MouseEvent event) {
                              myListener.onClickListener(fac);

    }
    
}
