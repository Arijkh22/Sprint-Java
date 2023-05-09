/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Services.SponsorService;
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
import Entities.Sponsor;
import com.codename1.components.ToastBar;
import com.codename1.ui.plaf.UIManager;


public class AddSponsorForm extends Form {
        private Resources themes;

    public AddSponsorForm(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        
        
  
      
        TextField nom = new TextField("", "nom", 20, TextField.ANY) ;
        TextField adresse = new TextField("", "adresse", 20, TextField.EMAILADDR) ;
        TextField email = new TextField("", "email", 20, TextField.ANY) ;
        TextField num_tel = new TextField("0", "num_tel", 20, TextField.ANY) ;
       
        nom.getAllStyles().setMargin(LEFT, 0);
        adresse.getAllStyles().setMargin(LEFT, 0);
        email.getAllStyles().setMargin(LEFT, 0);
        num_tel.getAllStyles().setMargin(LEFT, 0);
       
        
        Label nomIcon = new Label("", "TextField");
        Label adresseIcon = new Label("", "TextField");
        Label emailIcon = new Label("", "TextField");
        Label num_telIcon = new Label("", "TextField");
       
        nomIcon.getAllStyles().setMargin(RIGHT, 0);
        adresseIcon.getAllStyles().setMargin(RIGHT, 0);
        emailIcon.getAllStyles().setMargin(RIGHT, 0);
        num_telIcon.getAllStyles().setMargin(RIGHT, 0);
       
        
        FontImage.setMaterialIcon(nomIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(adresseIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(emailIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(num_telIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        
        Button registerButton = new Button("add sponsor");
        registerButton.setUIID("Addsponsor");
        
          Button retour = new Button("retour");
        retour.setUIID("retour");
        
        retour.addActionListener((evtt) -> {
       
              themes = UIManager.initFirstTheme("/theme");
                new  SponsorForm(themes).show();
             Toolbar.setGlobalToolbar(true);
        });
        registerButton.addActionListener(e -> {
            Toolbar.setGlobalToolbar(false);
            SponsorService service= new SponsorService();
            Sponsor u = new Sponsor();
            
            u.setAdresse(adresse.getText());
            u.setEmail(email.getText());
            u.setNom(nom.getText());
          
            
            
            int num_tel1 = Integer.parseInt(num_tel.getText());
            u.setNum_tel(num_tel1);
      ToastBar.Status status = ToastBar.getInstance().createStatus();        
            
           if (adresse.getText().equals(""))
             {
                     status.setShowProgressIndicator(true);
                     
                    status.setMessage("adresse cant be null");
                    status.setExpires(2000);
                    status.show();  
             }
         else  if (email.getText().equals(""))
             {
                 status.setShowProgressIndicator(true);
                     
                    status.setMessage("email cant be null");
                    status.setExpires(2000);
                    status.show();  
             }
          else   if (nom.getText().equals(""))
             {
                      status.setShowProgressIndicator(true);
                     
                    status.setMessage("nom cant be null");
                    status.setExpires(2000);
                    status.show();  
             }  
            else   if (num_tel1 < 1)
             {
                      status.setShowProgressIndicator(true);
                     
                    status.setMessage("num_tel1 cant be null");
                    status.setExpires(2000);
                    status.show();  
             }
           else
            {
                
            
            
            
            
               themes = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);
        Toolbar.setCenteredDefault(false);
        Services.SponsorService aa =new SponsorService();
        System.out.println(aa.getAllUsers());

            service.register(themes, u);
            Toolbar.setGlobalToolbar(true);
       } });
        
       
       
        
  
        // We remove the extra space for low resolution devices so things fit better
     
        
        Container by = BoxLayout.encloseY(

                BorderLayout.center(nom).
                        add(BorderLayout.WEST, nomIcon),
                BorderLayout.center(email).
                        add(BorderLayout.WEST, emailIcon),
                BorderLayout.center(adresse).
                        add(BorderLayout.WEST, adresseIcon),
                BorderLayout.center(num_tel).
                        add(BorderLayout.WEST, num_telIcon),
                 
                registerButton  ,retour              
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }
}
