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
import Services.CategorieService;
import Services.Mail;
import Services.UtilisateurService;
import com.codename1.components.ToastBar;
import com.codename1.ui.ComboBox;
import com.codename1.ui.plaf.UIManager;



public class AddAppelOffreForm extends Form {
        private Resources themes;

    public AddAppelOffreForm(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
          AppelOffre u = new AppelOffre();
        ComboBox<String> comboBoxcat = new ComboBox<String>();
        
        ComboBox<String> comboBoxuser = new ComboBox<String>();
        UtilisateurService  uu = new UtilisateurService();
          CategorieService  cc = new CategorieService();
        
          for (int i=0;i<uu.getAllUsers().size();i++)
          {
              comboBoxuser.addItem(""+uu.getAllUsers().get(i).getId());
          }
          u.setIdUtilisateur(Integer.parseInt((String) comboBoxuser.getSelectedItem()));
          for (int i=0;i<cc.getAllCategories().size();i++)
          {
              comboBoxcat.addItem(""+cc.getAllCategories().get(i).getId());
          }
           u.setIdCategorie(Integer.parseInt((String) comboBoxcat.getSelectedItem()));
        
        
        
        TextField nom = new TextField("", "nom", 20, TextField.ANY) ;
        TextField quantite = new TextField("0", "quantite", 20, TextField.EMAILADDR) ;
        TextField budget = new TextField("0", "budget", 20, TextField.ANY) ;
        TextField description = new TextField("", "description", 20, TextField.ANY) ;
     
    
        nom.getAllStyles().setMargin(LEFT, 0);
        quantite.getAllStyles().setMargin(LEFT, 0);
        budget.getAllStyles().setMargin(LEFT, 0);
        description.getAllStyles().setMargin(LEFT, 0);
      comboBoxcat.getAllStyles().setMargin(LEFT, 0);
     comboBoxuser.getAllStyles().setMargin(LEFT, 0);
        
        
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
      

        comboBoxcat.addActionListener((evt) -> {
        u.setIdCategorie((Integer.parseInt((String) comboBoxcat.getSelectedItem())));
        });
        comboBoxuser.addActionListener((evte) -> {
            u.setIdUtilisateur(Integer.parseInt((String) comboBoxuser.getSelectedItem()));
        });
        
        
        Button registerButton = new Button("Ajouter");
        Button returnButton = new Button("retour");
        returnButton.setUIID("retour");
        returnButton.addActionListener((evtt) -> {
    themes = UIManager.initFirstTheme("/theme");
            Services.AppelOffreService s = new AppelOffreService();
             new  AppelOffreForm(themes).show();
           Toolbar.setGlobalToolbar(true);
        
        });
        
        registerButton.setUIID("Ajouter");
        registerButton.addActionListener(e -> {
            Toolbar.setGlobalToolbar(false);
            AppelOffreService service= new AppelOffreService();
           
            
            u.setNom(nom.getText());
            u.setQuantite(quantite.getText());
            u.setBudget(Float.parseFloat(budget.getText()));
            u.setDescription(description.getText());
       ToastBar.Status status = ToastBar.getInstance().createStatus();
      
   if (nom.getText().equals(""))
   {
            status.setShowProgressIndicator(true);
            status.setMessage("nom cant be null");
            status.show(); 
   }
   else if ((Integer.parseInt(quantite.getText())<1))
   {
        status.setShowProgressIndicator(true);
            status.setMessage("quantite must be > 0");
            status.show(); 
   }
   else if((Integer.parseInt(budget.getText())<1))
   {
            status.setShowProgressIndicator(true);
            status.setMessage("budget must be > 0");
            status.show(); 
   }
   else if (description.getText().equals(""))
   {
              status.setShowProgressIndicator(true);
            status.setMessage("description cant be null");
            status.show(); 
   }
   else
   {
                try {
                    Mail.sendMail("oumaima.najar@esprit.tn", 0);
                } catch (Exception ex) {
                    
                }
            themes = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);
        Toolbar.setCenteredDefault(false);
        Services.AppelOffreService aa =new AppelOffreService();
        System.out.println(aa.getAllOffres());

        service.register(themes, u);
        Toolbar.setGlobalToolbar(true);
       }  });
        
       
      
        Container by = BoxLayout.encloseY(

                BorderLayout.center(nom).
                        add(BorderLayout.WEST, nomIcon),
                BorderLayout.center(quantite).
                        add(BorderLayout.WEST, quantiteIcon),
                BorderLayout.center(budget).
                        add(BorderLayout.WEST, budgetIcon),
                BorderLayout.center(description).
                        add(BorderLayout.WEST, descriptionIcon),
          BorderLayout.center(comboBoxcat),
           BorderLayout.center(comboBoxuser),

                registerButton ,returnButton               
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }
}
