/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Services.FinanceServices;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
 
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import Entities.Finance;
import Services.FactureService;
import com.codename1.components.ToastBar;
import com.codename1.ui.ComboBox;
import com.codename1.ui.plaf.UIManager;

/**
 *
 * @author Ahmed
 */
public class AddFinanceForm extends Form {
        private Resources themes;

    public AddFinanceForm(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        FactureService ddd = new FactureService();
         ComboBox<String> comboBox = new ComboBox<String>();
       
  for (int  i=0;i<ddd.getAllUsers().size();i++ )
      {
          
           comboBox.addItem(""+ddd.getAllUsers().get(i).getId_facture());
          
      }
  String oldSelectede =comboBox.getSelectedItem();

      
        TextField taxe = new TextField("0", "taxe", 20, TextField.ANY) ;
        TextField tva = new TextField("0", "tva", 20, TextField.EMAILADDR) ;
        TextField photo = new TextField("", "photo", 20, TextField.ANY) ;
        TextField prix = new TextField("0", "prix", 20, TextField.ANY) ;
        TextField etat = new TextField("", "etat", 20, TextField.ANY) ;
        
        Finance u = new Finance();
        taxe.getAllStyles().setMargin(LEFT, 0);
        tva.getAllStyles().setMargin(LEFT, 0);
        photo.getAllStyles().setMargin(LEFT, 0);
        prix.getAllStyles().setMargin(LEFT, 0);
        etat.getAllStyles().setMargin(LEFT, 0);
        
        Label taxeIcon = new Label("", "TextField");
        Label tvaIcon = new Label("", "TextField");
        Label photoIcon = new Label("", "TextField");
        Label prixIcon = new Label("", "TextField");
        Label etatIcon = new Label("", "TextField");
        taxeIcon.getAllStyles().setMargin(RIGHT, 0);
        tvaIcon.getAllStyles().setMargin(RIGHT, 0);
        photoIcon.getAllStyles().setMargin(RIGHT, 0);
        prixIcon.getAllStyles().setMargin(RIGHT, 0);
        etatIcon.getAllStyles().setMargin(RIGHT, 0);
        comboBox.getAllStyles().setMargin(RIGHT, 0);
        FontImage.setMaterialIcon(taxeIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(tvaIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(photoIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        FontImage.setMaterialIcon(prixIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(etatIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
          u.setId_facture(Integer.parseInt((String)comboBox.getSelectedItem()) );
          comboBox.addActionListener(evt -> {
    String selectedItem = (String)comboBox.getSelectedItem();
    System.out.println("Selected item: " + selectedItem);
    u.setId_facture(Integer.parseInt(selectedItem) );
});
        Button registerButton = new Button("add finance");
        registerButton.setUIID("Addfinance");
            Button retour = new Button("retour");
        retour.setUIID("retour");
        retour.addActionListener((evtt) -> {
        
            themes = UIManager.initFirstTheme("/theme");
                     new  FinancesForm(themes).show();
                        Toolbar.setGlobalToolbar(true);
        });
        registerButton.addActionListener(e -> {
            
            
            Toolbar.setGlobalToolbar(false);
            FinanceServices service= new FinanceServices();
            
            
            u.setPhoto(photo.getText());
            u.setEtat(etat.getText());
            
            int tvaa = Integer.parseInt(tva.getText());
            u.setTva(tvaa);
            
                        Float taxee = Float.parseFloat(taxe.getText());
            u.setTaxe(taxee);
            
                         Float prixe = Float.parseFloat(prix.getText());
            u.setPrix(prixe);
            
               themes = UIManager.initFirstTheme("/theme");
                  ToastBar.Status status = ToastBar.getInstance().createStatus();
                    
              if((prixe<1))
              {
                  status.setShowProgressIndicator(true);
                     
                    status.setMessage("prix must be > 1");
                    status.setExpires(2000);
                    status.show();
              }
              else if(tvaa<2)
              {
                  status.setMessage("prix must be > 2");
                    status.setExpires(2000);
                    status.show();
              }
              else if(photo.getText().equals(""))
              {
                  status.setMessage("photo cant be null");
                    status.setExpires(2000);
                    status.show();
              }
              else if(etat.getText().equals(""))
              {
                   status.setMessage("etat cant be null");
                    status.setExpires(2000);
                    status.show();
              }
              else
                  
              {
                  
              
                  
        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);
        Toolbar.setCenteredDefault(false);
        Services.FinanceServices aa =new FinanceServices();
        System.out.println(aa.getAllUsers());

            service.register(themes, u);
            Toolbar.setGlobalToolbar(true);
     }   });
        
       
       
        
  
        // We remove the extra space for low resolution devices so things fit better
     
        
        Container by = BoxLayout.encloseY(

                BorderLayout.center(taxe).
                        add(BorderLayout.WEST, taxeIcon),
                BorderLayout.center(tva).
                        add(BorderLayout.WEST, tvaIcon),
                BorderLayout.center(photo).
                        add(BorderLayout.WEST, photoIcon),
                BorderLayout.center(etat).
                        add(BorderLayout.WEST, etatIcon),
                   BorderLayout.center(prix).
                        add(BorderLayout.WEST, prixIcon),
                    BorderLayout.center(comboBox),
                registerButton  ,retour              
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }
}
