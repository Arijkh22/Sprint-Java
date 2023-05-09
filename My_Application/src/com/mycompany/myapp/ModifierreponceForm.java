/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Entities.ReponseReclamation;
import Services.ReponceService;
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
import com.codename1.ui.plaf.UIManager;


public class ModifierreponceForm extends Form {
        private Resources themes;

    public ModifierreponceForm(Resources theme,ReponseReclamation b) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
          
        System.out.println(b.getId_reponse());
  
      
        TextField sujet = new TextField("", "sujet", 20, TextField.ANY) ;
        sujet.setText(b.getSujet());
        TextField etat = new TextField("", "etat", 20, TextField.EMAILADDR) ;
       etat.setText(b.getEtat());

       
        sujet.getAllStyles().setMargin(LEFT, 0);
        etat.getAllStyles().setMargin(LEFT, 0);
       
        
        Label sujetIcon = new Label("", "TextField");
        Label etatIcon = new Label("", "TextField");
        
       sujetIcon.getAllStyles().setMargin(RIGHT, 0);
        etatIcon.getAllStyles().setMargin(RIGHT, 0);
       
        
        FontImage.setMaterialIcon( sujetIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(etatIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        
        Button registerButton = new Button("modifier bac");
        registerButton.setUIID("modifier");
        
        
        
        
               
             Button retour = new Button("retour");
        retour.setUIID("retour");
        retour.addActionListener((evtt) -> {
        
            
            themes = UIManager.initFirstTheme("/theme");
             new  ReponceForm(themes).show();
            
             Toolbar.setGlobalToolbar(true);
        });
        registerButton.addActionListener(e -> {
            Toolbar.setGlobalToolbar(false);
            ReponceService service= new ReponceService();
            ReponseReclamation u = new ReponseReclamation();
            u.setId_reponse(b.getId_reponse());
             u.setId_reclamation(b.getId_reclamation());
           
             
             u.setSujet(sujet.getText());
            u.setEtat(etat.getText());
            
           
               themes = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);
        Toolbar.setCenteredDefault(false);
        Services.ReponceService aa =new ReponceService();

            aa.update(themes, u);
            Toolbar.setGlobalToolbar(true);
        });
        
       
       
        
  
        // We remove the extra space for low resolution devices so things fit better
     
        
        Container by = BoxLayout.encloseY(

                BorderLayout.center(sujet).
                        add(BorderLayout.WEST, sujetIcon),
                BorderLayout.center(etat).
                        add(BorderLayout.WEST, etatIcon),
                
                registerButton   ,retour             
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
           }
}
