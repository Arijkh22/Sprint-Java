/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Services.FactureService;
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
import Entities.Facture;
import Services.Mail;
import com.codename1.components.ToastBar;
import com.codename1.ui.ComboBox;
import com.codename1.ui.plaf.UIManager;


/**
 *
 * @author Ahmed
 */
public class AddFactureForm extends Form {
        private Resources themes;

    public AddFactureForm(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        
        
  
     
      
      

        TextField numero = new TextField("", "numero", 20, TextField.ANY) ;
        TextField nom = new TextField("", "nom", 20, TextField.ANY) ;
        TextField prix = new TextField("", "prix", 20, TextField.ANY) ;
        TextField etat = new TextField("", "etat", 20, TextField.ANY) ;
        TextField description = new TextField("", "description", 20, TextField.ANY) ;
        TextField image = new TextField("", "image", 20, TextField.ANY) ;
        numero.getAllStyles().setMargin(LEFT, 0);
        nom.getAllStyles().setMargin(LEFT, 0);
        prix.getAllStyles().setMargin(LEFT, 0);
        etat.getAllStyles().setMargin(LEFT, 0);
        description.getAllStyles().setMargin(LEFT, 0);
        image.getAllStyles().setMargin(LEFT, 0);
        
        Label numeroIcon = new Label("", "TextField");
        Label nomIcon = new Label("", "TextField");
        Label prixIcon = new Label("", "TextField");
        Label etatIcon = new Label("", "TextField");
        Label descriptionIcon = new Label("", "TextField");
        Label imageIcon = new Label("", "TextField");
        numeroIcon.getAllStyles().setMargin(RIGHT, 0);
        nomIcon.getAllStyles().setMargin(RIGHT, 0);
        prixIcon.getAllStyles().setMargin(RIGHT, 0);
        etatIcon.getAllStyles().setMargin(RIGHT, 0);
        descriptionIcon.getAllStyles().setMargin(RIGHT, 0);
        imageIcon.getAllStyles().setMargin(RIGHT, 0);
        
        FontImage.setMaterialIcon(numeroIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(nomIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(prixIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        FontImage.setMaterialIcon(etatIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(descriptionIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(imageIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        
        Button registerButton = new Button("add facture");
        registerButton.setUIID("AddFacture");
        
        Button retour = new Button("retour");
        retour.setUIID("retour");
        retour.addActionListener((evtt) -> {
        
            themes = UIManager.initFirstTheme("/theme");
                     new  FactureForm(themes).show();
                        Toolbar.setGlobalToolbar(true);
        });
        registerButton.addActionListener(e -> {
            Toolbar.setGlobalToolbar(false);
            FactureService service= new FactureService();
            Facture u = new Facture();
            
            u.setNom(nom.getText());
            u.setDescription(description.getText());
            u.setImage(image.getText());
             u.setEtat(etat.getText());
            
            int numero1 = Integer.parseInt(numero.getText());
            u.setNumero(numero1);
            
              float prix1 = Float.parseFloat(prix.getText());
             u.setPrix(prix1);
            
            
               themes = UIManager.initFirstTheme("/theme");
                  ToastBar.Status status = ToastBar.getInstance().createStatus();
                    
              if((prix1<1))
              {
                  status.setShowProgressIndicator(true);
                     
                    status.setMessage("prix must be > 1");
                    status.setExpires(2000);
                    status.show();
              }
              else if(numero1<1)
              {
                  status.setMessage("numero must be > 1");
                    status.setExpires(2000);
                    status.show();
              }
              else if(image.getText().equals(""))
              {
                  status.setMessage("image cant be null");
                    status.setExpires(2000);
                    status.show();
              }
              else if(etat.getText().equals(""))
              {
                   status.setMessage("etat cant be null");
                    status.setExpires(2000);
                    status.show();
              }
              else if(description.getText().equals(""))
              {
                   status.setMessage("description cant be null");
                    status.setExpires(2000);
                    status.show();
              }
              else if(nom.getText().equals(""))
              {
                   status.setMessage("nom cant be null");
                    status.setExpires(2000);
                    status.show();
              }
              else
                  
              { 
                try {
                    Mail.sendMail("sanai.ammar@esprit.tn",0);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);
        Toolbar.setCenteredDefault(false);
        Services.FactureService aa =new FactureService();
        System.out.println(aa.getAllUsers());

            service.register(themes, u);
            Toolbar.setGlobalToolbar(true);
            
              }});
        
       
       
        
  
        // We remove the extra space for low resolution devices so things fit better
     
        
        Container by = BoxLayout.encloseY(

                BorderLayout.center(nom).
                        add(BorderLayout.WEST, nomIcon),
                BorderLayout.center(numero).
                        add(BorderLayout.WEST, numeroIcon),
                BorderLayout.center(prix).
                        add(BorderLayout.WEST, prixIcon),
                BorderLayout.center(etat).
                        add(BorderLayout.WEST, etatIcon),
                   BorderLayout.center(description).
                        add(BorderLayout.WEST, descriptionIcon),
                         BorderLayout.center(image).
                        add(BorderLayout.WEST, imageIcon),
                registerButton   ,retour             
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }
}
