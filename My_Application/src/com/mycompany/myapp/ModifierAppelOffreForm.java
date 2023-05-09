/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Services.AppelOffreService;
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
import Entities.AppelOffre;
import com.codename1.ui.plaf.UIManager;


public class ModifierAppelOffreForm extends Form {
        private Resources themes;

        
    public ModifierAppelOffreForm(Resources theme,AppelOffre b) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        
        System.out.println(b.getId());
  
      
        TextField nom = new TextField("", "nom", 20, TextField.ANY) ;
        nom.setText(b.getNom());
        TextField quantite = new TextField("", "quantite", 20, TextField.EMAILADDR) ;
        quantite.setText(b.getQuantite());

        TextField budget = new TextField("", "budget", 20, TextField.ANY) ;
        budget.setText( String.valueOf(b.getBudget()));

        TextField description = new TextField("", "description", 20, TextField.ANY) ;
        description.setText(String.valueOf(b.getDescription()));

    

        nom.getAllStyles().setMargin(LEFT, 0);
        quantite.getAllStyles().setMargin(LEFT, 0);
        budget.getAllStyles().setMargin(LEFT, 0);
        description.getAllStyles().setMargin(LEFT, 0);
     
      
        
        Label nomIcon = new Label("", "TextField");
        Label quantiteIcon = new Label("", "TextField");
        Label budgetIcon = new Label("", "TextField");
        Label descriptionIcon = new Label("", "TextField");
        
        
        
        nomIcon.getAllStyles().setMargin(RIGHT, 0);
        quantiteIcon.getAllStyles().setMargin(RIGHT, 0);
        budgetIcon.getAllStyles().setMargin(RIGHT, 0);
        descriptionIcon.getAllStyles().setMargin(RIGHT, 0);
        
        
        FontImage.setMaterialIcon(nomIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(quantiteIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(budgetIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        FontImage.setMaterialIcon(descriptionIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
      
        
        Button registerButton = new Button("modifier appel offre");
        registerButton.setUIID("modifier");
        
         Button returnButton = new Button("retour");
        returnButton.setUIID("retour");
        returnButton.addActionListener((evtt) -> {
    themes = UIManager.initFirstTheme("/theme");
            Services.AppelOffreService s = new AppelOffreService();
             new  AppelOffreForm(themes).show();
           Toolbar.setGlobalToolbar(true);
        
        });
        registerButton.addActionListener(e -> {
            Toolbar.setGlobalToolbar(false);
            AppelOffreService service= new AppelOffreService();
            AppelOffre u = new AppelOffre();
            u.setId(b.getId());
            u.setNom(nom.getText());
            u.setQuantite(quantite.getText());
            u.setBudget(Float.parseFloat(budget.getText()));
            u.setDescription(description.getText());
            u.setIdCategorie(b.getIdCategorie());
            u.setIdUtilisateur(b.getIdUtilisateur());
            themes = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);
        Toolbar.setCenteredDefault(false);
        Services.AppelOffreService aa =new AppelOffreService();
        aa.update(themes, u);
        Toolbar.setGlobalToolbar(true);
        });
       
        // We remove the extra space for low resolution devices so things fit better
     
        
        Container by = BoxLayout.encloseY(

                BorderLayout.center(nom).
                        add(BorderLayout.WEST, nomIcon),
                BorderLayout.center(quantite).
                        add(BorderLayout.WEST, quantiteIcon),
                BorderLayout.center(budget).
                        add(BorderLayout.WEST, budgetIcon),
                BorderLayout.center(description).
                        add(BorderLayout.WEST, descriptionIcon),
               
                registerButton   ,returnButton             
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }
}
