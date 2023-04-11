/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import arij.MyListener;
import edu.devapps.entity.Categorie;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


public class OnecategorieviewController implements Initializable {

    @FXML
    private Label nom;
 private Categorie cat;
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
                              myListener.onClickListener(cat);

    }
    
    
    
     public void setData(Categorie categ, MyListener myListener) {
        this.cat = categ;
        this.myListener = myListener;
        nom.setText(categ.getNom());
       
      
        
    }
    
}
