/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import edu.devapps.entity.Sponsor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import hamma.MyListener;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class OnesponsorviewController implements Initializable {

    @FXML
    private Label nom;
    @FXML
    private Label adresse;
    @FXML
    private Label num_tel;
    @FXML
    private Label email;
 private Sponsor spons;
    private MyListener myListener;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onclick(MouseEvent event) {
                      myListener.onClickListener(spons);

    }
    
    
     public void setData(Sponsor spons, MyListener myListener) {
        this.spons = spons;
        this.myListener = myListener;
        nom.setText(spons.getNom());
        adresse.setText(spons.getAdresse());
        num_tel.setText(""+spons.getNum_tel());
        email.setText(""+spons.getEmail());
      
        
    }
    
}
