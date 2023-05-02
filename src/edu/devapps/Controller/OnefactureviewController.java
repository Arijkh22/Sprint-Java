/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import hamma.MyListener;
import edu.devapps.entity.Facture;
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
public class OnefactureviewController implements Initializable {

    @FXML
    private Label numero;
    @FXML
    private Label nom;
    @FXML
    private Label date;
    @FXML
    private Label descriptionrec;
    @FXML
    private Label prix;
    @FXML
    private Label etat;
    @FXML
    private Label image;
 private Facture fac;
    private MyListener myListener;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
      public void setData(Facture fac, MyListener myListener) {
        this.fac = fac;
        this.myListener = myListener;
        numero.setText(""+fac.getNumero());
        nom.setText(fac.getNom());
        date.setText(""+fac.getDate());
        descriptionrec.setText(""+fac.getDescription());
        prix.setText(""+fac.getPrix());
        etat.setText(""+fac.getEtat());
        image.setText(""+fac.getImage());
        
    }
    
    
    
    @FXML
    private void onclick(MouseEvent event) {
                      myListener.onClickListener(fac);

    }
    
}
