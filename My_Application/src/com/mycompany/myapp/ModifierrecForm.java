/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Services.ReclamationService;
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
import Entities.Reclamation;
import com.codename1.ui.plaf.UIManager;



public class ModifierrecForm extends Form {
        private Resources themes;

    public ModifierrecForm(Resources theme,Reclamation b,int id) {
     
                    
                    
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
           System.out.println(b);
              System.out.println(b);
                    System.out.println(b);      System.out.println(b);      System.out.println(b);
                    
          ReclamationService service= new ReclamationService();
        System.out.println(b.getId_rec());
      
        TextField email = new TextField("", "ref", 20, TextField.ANY) ;
        email.setText(Services.ReclamationService.currentrec.getEmail());
        TextField description = new TextField("", "adresse", 20, TextField.EMAILADDR) ;
        description.setText(b.getDescription());

        TextField sujet = new TextField("", "codepostal", 20, TextField.ANY) ;
        sujet.setText(b.getSujet());

        TextField etat = new TextField("", "capacite", 20, TextField.ANY) ;
       etat.setText(b.getEtat());

        

        email.getAllStyles().setMargin(LEFT, 0);
        description.getAllStyles().setMargin(LEFT, 0);
        sujet.getAllStyles().setMargin(LEFT, 0);
        etat.getAllStyles().setMargin(LEFT, 0);
        
        
        Label emailIcon = new Label("", "TextField");
        Label descriptionIcon = new Label("", "TextField");
        Label sujetIcon = new Label("", "TextField");
        Label etatIcon = new Label("", "TextField");
       
        emailIcon.getAllStyles().setMargin(RIGHT, 0);
        descriptionIcon.getAllStyles().setMargin(RIGHT, 0);
        sujetIcon.getAllStyles().setMargin(RIGHT, 0);
        etatIcon.getAllStyles().setMargin(RIGHT, 0);
        
        
        FontImage.setMaterialIcon(emailIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(descriptionIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(sujetIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        FontImage.setMaterialIcon(etatIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
       
        
        Button registerButton = new Button("modifier reclamation");
        registerButton.setUIID("modifier");
        
        
        
        
               
             Button retour = new Button("retour");
        retour.setUIID("retour");
        retour.addActionListener((evtt) -> {
        
            
            themes = UIManager.initFirstTheme("/theme");
             new  ReclamationsForm(themes).show();
            
             Toolbar.setGlobalToolbar(true);
        });
        registerButton.addActionListener(e -> {
            Toolbar.setGlobalToolbar(false);
          
            Reclamation u = new Reclamation();
            u.setId_rec(b.getId_rec());
            u.setDescription(description.getText());
            u.setEmail(email.getText());
             u.setSujet(sujet.getText());
             u.setEtat(etat.getText());
           u.setId_rec(id);
               themes = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);
        Toolbar.setCenteredDefault(false);
        Services.ReclamationService aa =new ReclamationService();

            aa.update(themes, u);
            Toolbar.setGlobalToolbar(true);
        });
        
       
       
        
  
        // We remove the extra space for low resolution devices so things fit better
     
        
        Container by = BoxLayout.encloseY(

                BorderLayout.center(email).
                        add(BorderLayout.WEST, emailIcon),
                BorderLayout.center(sujet).
                        add(BorderLayout.WEST, sujetIcon),
                BorderLayout.center(description).
                        add(BorderLayout.WEST, descriptionIcon),
                BorderLayout.center(etat).
                        add(BorderLayout.WEST, etatIcon),
                
                registerButton ,retour               
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }
}
