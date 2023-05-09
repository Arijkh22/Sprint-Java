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
import Entities.Utilisateur;
import Services.Mail;
import com.codename1.components.ToastBar;
import com.codename1.ui.plaf.UIManager;







public class Addreclamationform extends Form {
        private Resources themes;

    public Addreclamationform(Resources theme,Utilisateur r) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        
        
  
      
        TextField email = new TextField("", "email", 20, TextField.ANY) ;
        TextField sujet = new TextField("", "sujet", 20, TextField.ANY) ;
        TextField description = new TextField("", "description", 20, TextField.ANY) ;
        TextField etat = new TextField("", "etat", 20, TextField.ANY) ;

        email.getAllStyles().setMargin(LEFT, 0);
        sujet.getAllStyles().setMargin(LEFT, 0);
        description.getAllStyles().setMargin(LEFT, 0);
        etat.getAllStyles().setMargin(LEFT, 0);
        
        
        Label emailIcon = new Label("", "TextField");
        Label sujetIcon = new Label("", "TextField");
        Label descriptionIcon = new Label("", "TextField");
        Label etatIcon = new Label("", "TextField");
        
        emailIcon.getAllStyles().setMargin(RIGHT, 0);
        sujetIcon.getAllStyles().setMargin(RIGHT, 0);
        descriptionIcon.getAllStyles().setMargin(RIGHT, 0);
        etatIcon.getAllStyles().setMargin(RIGHT, 0);
       
        
        FontImage.setMaterialIcon(emailIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(sujetIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(descriptionIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        FontImage.setMaterialIcon(etatIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        
        
        Button registerButton = new Button("add reclamation");
        registerButton.setUIID("addrec");
        
        
        
             Button retour = new Button("retour");
        retour.setUIID("retour");
        retour.addActionListener((evtt) -> {
        
            
            themes = UIManager.initFirstTheme("/theme");
             new  ReclamationsForm(themes).show();
            
             Toolbar.setGlobalToolbar(true);
        });
        registerButton.addActionListener(e -> {
            Toolbar.setGlobalToolbar(false);
            ReclamationService service= new ReclamationService();
            Reclamation u = new Reclamation();
            
            
            
            u.setEtat(email.getText());
            u.setSujet(sujet.getText());
            u.setDescription(description.getText());
            u.setEtat(etat.getText());
      
         
            u.setId_utilisateur_id(r);
    
               themes = UIManager.initFirstTheme("/theme");

        
 ToastBar.Status status = ToastBar.getInstance().createStatus();
                   
        if(email.getText().equals(""))
        {
             status.setShowProgressIndicator(true);
                     
                    status.setMessage("email cant be null");
                    status.setExpires(2000);
                    status.show();
        }
        else if(sujet.getText().equals(""))
        {
             status.setShowProgressIndicator(true);
                     
                    status.setMessage("sujet cant be null");
                    status.setExpires(2000);
                    status.show();
        }
          else if(description.getText().equals(""))
        {
             status.setShowProgressIndicator(true);
                     
                   status.setMessage("description cant be null");
                    status.setExpires(2000);
                    status.show();
        }
          else if(etat.getText().equals(""))
        {
             status.setShowProgressIndicator(true);
                     
                    status.setMessage("etat cant be null");
                    status.setExpires(2000);
                    status.show();
        }
        else
          {
              
              
                  try {
                    Mail.sendMail("yassine.boulares@esprit.tn", 0);
                } catch (Exception ex) {
                    
                }
// Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);
        Toolbar.setCenteredDefault(false);
        Services.ReclamationService aa =new ReclamationService();
        System.out.println(aa.getAllReclamation());

            service.register(themes, u);
            Toolbar.setGlobalToolbar(true);
    }    });
        
       
       
        
  
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
                registerButton    ,retour            
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }
}
