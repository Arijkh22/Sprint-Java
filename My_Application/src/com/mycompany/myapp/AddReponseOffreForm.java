/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Services.ReponseOffreService;
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
import Entities.ReponseOffre;
import Services.AppelOffreService;
import com.codename1.components.ToastBar;
import com.codename1.ui.ComboBox;
import com.codename1.ui.plaf.UIManager;


public class AddReponseOffreForm extends Form {
        private Resources themes;

    public AddReponseOffreForm(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
          ReponseOffre u = new ReponseOffre();
                ComboBox<String> comboBoxoffre = new ComboBox<String>();

                AppelOffreService ee= new AppelOffreService();
                
                for (int i=0;i<ee.getAllOffres().size();i++)
                {
                    comboBoxoffre.addItem(""+ee.getAllOffres().get(i).getId());
                }
                u.setIdOffre(Integer.parseInt((String) comboBoxoffre.getSelectedItem()));
                
                
        TextField nomProduit = new TextField("", "nomProduit", 20, TextField.ANY) ;
        TextField budget = new TextField("0", "budget", 20, TextField.ANY) ;
        TextField etat = new TextField("", "etat", 20, TextField.ANY) ;
       
        nomProduit.getAllStyles().setMargin(LEFT, 0);
        budget.getAllStyles().setMargin(LEFT, 0);
        etat.getAllStyles().setMargin(LEFT, 0);
        comboBoxoffre.getAllStyles().setMargin(LEFT, 0);
    
        
        Label nomProduitIcon = new Label("", "TextField");
        Label budgetIcon = new Label("", "TextField");
        Label etatIcon = new Label("", "TextField");
       
        nomProduitIcon.getAllStyles().setMargin(RIGHT, 0);
        budgetIcon.getAllStyles().setMargin(RIGHT, 0);
        etatIcon.getAllStyles().setMargin(RIGHT, 0);
       
        
        FontImage.setMaterialIcon(nomProduitIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(budgetIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(etatIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
    
        comboBoxoffre.addActionListener((evt) -> {
            u.setIdOffre(Integer.parseInt((String) comboBoxoffre.getSelectedItem()));
        });
        
        
        
        
        Button registerButton = new Button("add reponse offre");
        registerButton.setUIID("AddReponseOffre");
        
        
        
         Button returnButton = new Button("retour");
        returnButton.setUIID("retour");
        returnButton.addActionListener((evtt) -> {
    themes = UIManager.initFirstTheme("/theme");
            Services.AppelOffreService s = new AppelOffreService();
             new  ReponseOffreForm(themes).show();
           Toolbar.setGlobalToolbar(true);
        
        });
        registerButton.addActionListener(e -> {
            Toolbar.setGlobalToolbar(false);
            ReponseOffreService service= new ReponseOffreService();
          
            
            u.setNom_produit(nomProduit.getText());
            u.setBudget(Float.parseFloat(budget.getText()));
            u.setEtat(etat.getText());
             ToastBar.Status status = ToastBar.getInstance().createStatus();
   
            if (nomProduit.getText().equals(""))
            {
                         status.setShowProgressIndicator(true);
            status.setMessage("nom cant be null");
            status.show();
            }
            else if (u.getBudget()<1)
            {
                         status.setShowProgressIndicator(true);
            status.setMessage("budget must be more than 1");
            status.show();
            }
            else if (u.getEtat().equals(""))
            {
                         status.setShowProgressIndicator(true);
            status.setMessage("etat cant be null");
            status.show();
            }
            else
            {
                
          
            themes = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);
        Toolbar.setCenteredDefault(false);
        Services.ReponseOffreService aa =new ReponseOffreService();
 

            service.register(themes, u);
            Toolbar.setGlobalToolbar(true);
        }  });
        
       
       
        
  
        // We remove the extra space for low resolution devices so things fit better
     
        
        Container by = BoxLayout.encloseY(

                BorderLayout.center(nomProduit).
                        add(BorderLayout.WEST, nomProduitIcon),
                BorderLayout.center(budget).
                        add(BorderLayout.WEST, budgetIcon),
                BorderLayout.center(etat).
                        add(BorderLayout.WEST, etatIcon),
          BorderLayout.center(comboBoxoffre),
     
                registerButton     ,returnButton           
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }
}
