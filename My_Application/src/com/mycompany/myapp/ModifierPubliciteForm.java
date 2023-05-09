/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Entities.Publicite;
import Services.PubliciteService;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;


public class ModifierPubliciteForm extends Form{
     private Resources themes;
     public ModifierPubliciteForm(Resources theme,Publicite b) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        
       
        System.out.println(b.getId());
  
      
        TextField Nom_pub = new TextField("", "Nom_pub", 20, TextField.ANY) ;
        Nom_pub.setText(b.getNom_pub());
        TextField Description = new TextField("", "Description", 20, TextField.EMAILADDR) ;
        Description.setText(b.getDescription());

        TextField Image = new TextField("", "Image", 20, TextField.ANY) ;
        Image.setText( b.getImage());

       

        Nom_pub.getAllStyles().setMargin(LEFT, 0);
        Description.getAllStyles().setMargin(LEFT, 0);
        Image.getAllStyles().setMargin(LEFT, 0);
       
        
        Label Nom_pubIcon = new Label("", "TextField");
        Label DescriptionIcon = new Label("", "TextField");
        Label ImageIcon = new Label("", "TextField");
        
        Nom_pubIcon.getAllStyles().setMargin(RIGHT, 0);
        DescriptionIcon.getAllStyles().setMargin(RIGHT, 0);
        ImageIcon.getAllStyles().setMargin(RIGHT, 0);
       
        
        FontImage.setMaterialIcon(Nom_pubIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(DescriptionIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(ImageIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        
        
        Button registerButton = new Button("modifier pub");
        registerButton.setUIID("modifier");
        
          Button retour = new Button("retour");
        retour.setUIID("retour");
        
        retour.addActionListener((evtt) -> {
       
              themes = UIManager.initFirstTheme("/theme");
                new  PubliciteForm(themes).show();
             Toolbar.setGlobalToolbar(true);
        });
        registerButton.addActionListener(e -> {
            Toolbar.setGlobalToolbar(false);
            PubliciteService service= new PubliciteService();
            Publicite u = new Publicite();
            u.setId(b.getId());
            u.setNom_pub(Nom_pub.getText());
            u.setImage(Image.getText());
            u.setDescription(Description.getText());
            u.setId_sponsor(b.getId_sponsor());
       
               themes = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);
        Toolbar.setCenteredDefault(false);
        Services.PubliciteService aa =new PubliciteService();

            aa.update(themes, u);
            Toolbar.setGlobalToolbar(true);
        });
        
       
       
        
  
        // We remove the extra space for low resolution devices so things fit better
     
        
        Container by = BoxLayout.encloseY(

                BorderLayout.center(Nom_pub).
                        add(BorderLayout.WEST, Nom_pubIcon),
                BorderLayout.center(Image).
                        add(BorderLayout.WEST, ImageIcon),
                BorderLayout.center(Description).
                        add(BorderLayout.WEST, DescriptionIcon),
                
                registerButton  ,retour              
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
   
    }
}
