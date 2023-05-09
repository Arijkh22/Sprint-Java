/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Entities.Publicite;
import Services.Mail;
import Services.PubliciteService;
import Services.SponsorService;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
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



public class AddPubliciteForm extends Form {
       private Resources themes;

    public AddPubliciteForm(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
          Publicite u = new Publicite();
       ComboBox<String> comboBoxsponsor = new ComboBox<String>();
        SponsorService s= new SponsorService();
        
       for (int i=0;i<s.getAllUsers().size();i++)
       {
          comboBoxsponsor.addItem(""+ s.getAllUsers().get(i).getId());
           
       }
       u.setId_sponsor(Integer.parseInt((String) comboBoxsponsor.getSelectedItem()));
     
       
       
      
        TextField Nom = new TextField("", "Nom", 20, TextField.ANY) ;
        TextField Description = new TextField("", "Description", 20, TextField.ANY) ;
        TextField Image = new TextField("", "Image", 20, TextField.ANY) ;
      
        Nom.getAllStyles().setMargin(LEFT, 0);
        Description.getAllStyles().setMargin(LEFT, 0);
        Image.getAllStyles().setMargin(LEFT, 0);
        comboBoxsponsor.getAllStyles().setMargin(LEFT, 0);
        
        
        Label NomIcon = new Label("", "TextField");
        Label DescriptionIcon = new Label("", "TextField");
        Label ImageIcon = new Label("", "TextField");
        
        NomIcon.getAllStyles().setMargin(RIGHT, 0);
        DescriptionIcon.getAllStyles().setMargin(RIGHT, 0);
        ImageIcon.getAllStyles().setMargin(RIGHT, 0);
        
        
        FontImage.setMaterialIcon(NomIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(DescriptionIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(ImageIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        
        
        comboBoxsponsor.addActionListener((evt) -> {
           u.setId_sponsor(Integer.parseInt((String) comboBoxsponsor.getSelectedItem()));
        });
        
        Button registerButton = new Button("add pub");
        registerButton.setUIID("addpub");
        
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
          
            
            u.setDescription(Description.getText());
            u.setNom_pub(Nom.getText());
            
           ToastBar.Status status = ToastBar.getInstance().createStatus();
              
            u.setImage(Image.getText());
            
             if (Nom.getText().equals(""))
             {
                     status.setShowProgressIndicator(true);
                     
                    status.setMessage("nom cant be null");
                    status.setExpires(2000);
                    status.show();  
             }
         else  if (Description.getText().equals(""))
             {
                 status.setShowProgressIndicator(true);
                     
                    status.setMessage("description cant be null");
                    status.setExpires(2000);
                    status.show();  
             }
          else   if (Image.getText().equals(""))
             {
                      status.setShowProgressIndicator(true);
                     
                    status.setMessage("image cant be null");
                    status.setExpires(2000);
                    status.show();  
             }
             else
          {
              
                try {
                    Mail.sendMail("gharsallah.jihed@esprit.tn", 0);
                } catch (Exception ex) {
                }
                      
               themes = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);
        Toolbar.setCenteredDefault(false);
        Services.PubliciteService aa =new PubliciteService();
        

            service.register(themes, u);
            Toolbar.setGlobalToolbar(true);
     }   });
        
       
       
        
  
        // We remove the extra space for low resolution devices so things fit better
     
        
        Container by = BoxLayout.encloseY(

                BorderLayout.center(Nom).
                        add(BorderLayout.WEST, NomIcon),
                BorderLayout.center(Description).
                        add(BorderLayout.WEST, DescriptionIcon),
                BorderLayout.center(Image).
                        add(BorderLayout.WEST, ImageIcon),
               BorderLayout.center(comboBoxsponsor),
                registerButton  ,retour              
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }
}
