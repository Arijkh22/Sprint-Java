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
import com.codename1.ui.plaf.UIManager;


public class ModifierReponseOffreForm extends Form {
        private Resources themes;

    public ModifierReponseOffreForm(Resources theme,ReponseOffre b) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        
        System.out.println(b.getId());
  
      
        TextField nomProduit = new TextField("", "nomProduit", 20, TextField.ANY) ;
        nomProduit.setText(b.getNom_produit());
        TextField budget = new TextField("", "budget", 20, TextField.ANY) ;
        budget.setText(String.valueOf(b.getBudget()));

        TextField etat = new TextField("", "etat", 20, TextField.ANY) ;
        etat.setText( String.valueOf(b.getEtat()));

       
        nomProduit.getAllStyles().setMargin(LEFT, 0);
        budget.getAllStyles().setMargin(LEFT, 0);
        etat.getAllStyles().setMargin(LEFT, 0);
      
        
        Label nomProduitIcon = new Label("", "TextField");
        Label budgetIcon = new Label("", "TextField");
        Label etatIcon = new Label("", "TextField");
       
        nomProduitIcon.getAllStyles().setMargin(RIGHT, 0);
        budgetIcon.getAllStyles().setMargin(RIGHT, 0);
        etatIcon.getAllStyles().setMargin(RIGHT, 0);
      
        
        FontImage.setMaterialIcon(nomProduitIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(budgetIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(etatIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
       
        
        Button registerButton = new Button("modifier reponse offre");
        registerButton.setUIID("modifier");
        
        
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
            ReponseOffre u = new ReponseOffre();
            u.setId(b.getId());
            u.setNom_produit(nomProduit.getText());
            u.setBudget(Float.parseFloat(budget.getText()));
            u.setEtat(etat.getText());
         
           
            
            themes = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);
        Toolbar.setCenteredDefault(false);
        Services.ReponseOffreService aa =new ReponseOffreService();

            aa.update(themes, u);
            Toolbar.setGlobalToolbar(true);
        });
        
       
       
        
  
        // We remove the extra space for low resolution devices so things fit better
     
        
        Container by = BoxLayout.encloseY(

                BorderLayout.center(nomProduit).
                        add(BorderLayout.WEST, nomProduitIcon),
                BorderLayout.center(budget).
                        add(BorderLayout.WEST, budgetIcon),
                BorderLayout.center(etat).
                        add(BorderLayout.WEST, etatIcon),
               
                registerButton    ,returnButton            
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
        
    }
}
